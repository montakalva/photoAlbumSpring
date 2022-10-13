package com.example.photoalbumspring.services;

import com.example.photoalbumspring.entities.Album;
import com.example.photoalbumspring.entities.User;
import com.example.photoalbumspring.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlbumService {
    AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void createAlbum(Album album) throws Exception {
        this.albumRepository.save(album);
    }

    public ArrayList<Album> getAllActualAlbums() {
        return (ArrayList<Album>) albumRepository.findAll();
    }

    public void deleteAlbum(Integer id) throws Exception {
        try{
            Album selectedAlbum = albumRepository.findAlbumById(id);
            albumRepository.delete(selectedAlbum);
        } catch (Exception exception){
            exception.getMessage();
        }
    }
    /*
    *   public void deleteVisit(Long id) {
   Entity entity=repository.findById(id).get();
    repository.delete(entity);*/
}
