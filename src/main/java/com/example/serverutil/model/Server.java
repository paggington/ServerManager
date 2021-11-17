package com.example.serverutil.model;

import com.example.serverutil.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String serverName;
    @Column(unique = true)
    @NotEmpty(message = "Empty!")
    private String ip;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;

    public Server(Long id, String serverName, String ip, String memory, String type, String imageUrl, Status status) {
        this.id = id;
        this.serverName = serverName;
        this.ip = ip;
        this.memory = memory;
        this.type = type;
        this.imageUrl = imageUrl;
        this.status = status;
    }
}
