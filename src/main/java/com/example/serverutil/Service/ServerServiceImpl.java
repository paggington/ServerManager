package com.example.serverutil.Service;

import com.example.serverutil.model.Server;
import com.example.serverutil.model.enums.Status;
import com.example.serverutil.repos.ServerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static org.springframework.data.domain.PageRequest.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerRepoService{
    private final ServerRepo serverRepo;

    @Override
    public Server saveServer(Server server) {
        log.info("Saving new server:{}",server.getServerName());
        server.setImageUrl(setSeverImageUrl());
        return serverRepo.save(server);
    }



    @Override
    public Server ping(String ip) throws IOException {
        log.info("Pinging server at:{}",ip);
        Server server=serverRepo.findByIp(ip);
        InetAddress address=InetAddress.getByName(ip);
        server.setStatus(address.isReachable(10000)? Status.SERVER_UP :Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Servers");
        return serverRepo.findAll(of(0,limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching:");
        return serverRepo.getById(id);
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server:{}",server.getServerName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting:{}",serverRepo.getById(id).getServerName());
        serverRepo.deleteById(id);
        return Boolean.TRUE;
    }

    private String setSeverImageUrl() {
        String[] imageNames={"server1.png","server2.png","server3.png","server4.png"};

        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"
                +imageNames[new Random().nextInt(4)]).toUriString();
    }
}
