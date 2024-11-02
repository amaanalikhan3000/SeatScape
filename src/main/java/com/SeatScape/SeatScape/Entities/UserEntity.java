package com.SeatScape.SeatScape.Entities;


import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Getter
@Setter
@Document(collection = "user")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private ProfileDetails profileDetails;

    public static class ProfileDetails {
        private int age;
        private String location;
        private List<String> preferences;
    }
}

