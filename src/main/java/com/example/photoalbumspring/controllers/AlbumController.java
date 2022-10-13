package com.example.photoalbumspring.controllers;

import com.example.photoalbumspring.entities.Album;
import com.example.photoalbumspring.repositories.AlbumRepository;
import com.example.photoalbumspring.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

    AlbumService albumService;
    AlbumRepository albumRepository;

    @Autowired
    public AlbumController(AlbumService albumService, AlbumRepository albumRepository) {
        this.albumService = albumService;
        this.albumRepository = albumRepository;
    }

    @GetMapping("/archive")
    public String runAlbumMenuPage(){
        return "archive";}

    @PostMapping("/create")
    public String handleCreateNewAlbum(Album album){
        try{
            this.albumService.createAlbum(album);
        } catch (Exception exception){
            exception.getMessage();
        }
        return "album";
    }

    @DeleteMapping("/delete")
    public String handleDeleteAlbum(Integer id){
        try{
            this.albumService.deleteAlbum(id);
        }catch (Exception exception){
            exception.getMessage();
        }
        return "album";
    }

    @GetMapping("/album")
    public String runAlbumPage(Model model){
        ArrayList<Album> actualAlbumList = albumService.getAllActualAlbums();
        model.addAttribute("actualAlbumList", actualAlbumList);
        return "album";
    }
}
