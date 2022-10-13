package com.example.photoalbumspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String albumName;
    private String picture;
    private String createBy;
    private String createAt;
}
