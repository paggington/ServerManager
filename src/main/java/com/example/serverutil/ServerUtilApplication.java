package com.example.serverutil;

import com.example.serverutil.model.Server;
import com.example.serverutil.model.enums.Status;
import com.example.serverutil.repos.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerUtilApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(ServerRepo serverRepo){
        return args -> {
            serverRepo.save(new Server(null,"Linux","192.168.1.160","16 GB","PC Server","http://localhost:8080/server/image/server1.png",Status.SERVER_UP));
        };
    }
}
