package com.example.serverutil.Service;

import com.example.serverutil.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerRepoService {
    public Server saveServer(Server server);
    Server ping(String ip) throws UnknownHostException, IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
