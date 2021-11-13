package com.example.serverutil.Service;

import com.example.serverutil.model.Server;
import com.example.serverutil.repos.ServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ServerRepoService {
    public void saveServer(Server server);
    Server ping(String ip);
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
