package com.example.photoalbumspring.repositories;

import com.example.photoalbumspring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUsernameAndPassword(String username, String password);
    @Override
    List<User>findAll();
}
