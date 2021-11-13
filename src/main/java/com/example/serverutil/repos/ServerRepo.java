package com.example.serverutil.repos;

import com.example.serverutil.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server,Long> {
    Server findByIp(String ip);
}
