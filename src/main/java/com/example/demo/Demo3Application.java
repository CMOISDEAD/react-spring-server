package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Demo3Application {
    // Initialize all the process
    Initialize init = new Initialize();

    // Generate provitional data
    Generate generator = new Generate();

    // Main function
    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

    // Routes
    @GetMapping("/artist")
    public ArrayList<Artist> artists() {
        // Instancio un artista
        ArrayList<Artist> list = generator.getArtists();
        return list;
    }

    @GetMapping("/songs")
    public ArrayList<Song> songs() {
        // Instancio un artista
        ArrayList<Song> list = generator.getSongs();
        return list;
    }

    @GetMapping("/albums")
    public ArrayList<Album> albums() {
        // Instancio un artista
        ArrayList<Album> list = generator.getAlbums();
        return list;
    }

    @GetMapping("/allAlbums")
    public ArrayList<UUID> getAllAlbums() {
        // Instancio un artista
        ArrayList<UUID> list = generator.getAllAlbums();
        return list;

    }

    @GetMapping("/allArtist")
    public ArrayList<UUID> getAllArtist() {
        // Instancio un artista
        ArrayList<UUID> list = generator.getAllArtist();
        return list;
    }

    @GetMapping("/allSongs")
    public ArrayList<UUID> getAllSongs() {
        // Instancio un artista
        ArrayList<UUID> list = generator.getAllSongs();
        return list;
    }

    @PostMapping("/login")
    public ResponseEntity<User> getAllUsers(@RequestBody(required = true) User req) {
        return new ResponseEntity<User>(generator.login(req), HttpStatus.OK);
    }

    @PostMapping("/getSong")
    public ResponseEntity<Song> getSong(@RequestBody(required = true) String id) {
        return new ResponseEntity<Song>(generator.searchSong(id.substring(0, id.length() - 1)), HttpStatus.OK);
    }

    @PostMapping("/getAlbum")
    public ResponseEntity<Album> getAlbum(@RequestBody(required = true) String id) {
        return new ResponseEntity<Album>(generator.searchAlbum(id.substring(0, id.length() - 1)), HttpStatus.OK);
    }

    @PostMapping("/getArtist")
    public ResponseEntity<Artist> getArtist(@RequestBody(required = true) String id) {
        return new ResponseEntity<Artist>(generator.searchArtist(id.substring(0, id.length() - 1)), HttpStatus.OK);
    }
}
