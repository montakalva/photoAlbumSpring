package com.example.photoalbumspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String createdAt;
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;

}
