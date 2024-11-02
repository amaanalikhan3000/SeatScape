package com.SeatScape.SeatScape.Entities;

import jakarta.persistence.*;
import lombok.Data;



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

    @Embedded
    private ProfileDetails profileDetails;
}

    // @Embedded
    //private Map<String, Object> profileDetails;


 //   private UserEntity.ProfileDetails profileDetails;
 @Embeddable
 @Data
 class ProfileDetails {
     private String address;
     private String phoneNumber;
     private String bio; // Add other specific fields as needed
 }

    // JSON field to store details

