package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
@RestController
public class Demo3Application {
    Generate generator = new Generate();

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/artist").allowedOrigins("http://localhost:3000");
                registry.addMapping("/songs").allowedOrigins("http://localhost:3000");
                registry.addMapping("/albums").allowedOrigins("http://localhost:3000");
                registry.addMapping("/allArtist").allowedOrigins("http://localhost:3000");
                registry.addMapping("/allAlbums").allowedOrigins("http://localhost:3000");
                registry.addMapping("/allSongs").allowedOrigins("http://localhost:3000");
                registry.addMapping("/getSong").allowedOrigins("http://localhost:3000");
                registry.addMapping("/getAlbum").allowedOrigins("http://localhost:3000");
            }
        };
    }

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

    @PostMapping("/getSong")
    public ResponseEntity<Song> getSong(@RequestBody(required = true) String id) {
        return new ResponseEntity<Song>(generator.searchSong(id.substring(0, id.length() - 1)), HttpStatus.OK);
    }

    @PostMapping("/getAlbum")
    public ResponseEntity<Album> getAlbum(@RequestBody(required = true) String id) {
        return new ResponseEntity<Album>(generator.searchAlbum(id.substring(0, id.length() - 1)), HttpStatus.OK);
    }

}
