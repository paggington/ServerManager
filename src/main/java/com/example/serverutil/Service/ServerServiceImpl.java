package com.example.serverutil.Service;

import com.example.serverutil.model.Server;
import com.example.serverutil.repos.ServerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerRepoService{
    private final ServerRepo serverRepo;
    @Override
    public void saveServer(Server server) {

    }

    @Override
    public Server ping(String ip) {
        return null;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
