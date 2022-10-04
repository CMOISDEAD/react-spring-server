package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;

public class Artist {
  public UUID id;
  public String name;
  public String nacionality;
  public String image;
  public ArrayList<Album> albums = new ArrayList<>();
  public ArrayList<Song> songs = new ArrayList<>();
  public boolean isGroup;

  public Artist(String image, String name, boolean isGroup, String nacionality) {
    this.id = UUID.randomUUID();
    this.image = image;
    this.name = name;
    this.isGroup = isGroup;
    this.nacionality = nacionality;
  }

  public void addAlbum(Album album) {
    this.albums.add(album);
  }

  public void addSong(Song song) {
    this.songs.add(song);
  }
}
