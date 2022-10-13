package com.example.photoalbumspring.repositories;

import com.example.photoalbumspring.entities.Album;
import com.example.photoalbumspring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

    @Override
    List<Album>findAll();

    Album findAlbumById(Integer id);
    /*
    *
    User findUserByUsernameAndPassword(String username, String password);
    @Override
    List<User>findAll();
}*/
}
