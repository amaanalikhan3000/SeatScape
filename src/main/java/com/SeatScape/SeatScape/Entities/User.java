package com.SeatScape.SeatScape.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String password;

    @Column(columnDefinition = "json")
    private Map<String, Object> profileDetails; // JSON field to store details

}