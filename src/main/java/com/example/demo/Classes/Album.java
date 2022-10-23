package com.example.demo.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Album implements Serializable {
  public UUID id;
  public UUID artist_id;
  public String image;
  public String name;
  public String artist;
  public ArrayList<Song> songs = new ArrayList<>();
  public int duration;

  public Album(String image, String name, String artist, UUID artist_id, int duration) {
    this.id = UUID.randomUUID();
    this.image = image;
    this.name = name;
    this.artist = artist;
    this.artist_id = artist_id;
    this.duration = duration;
  }

  public void addSong(Song song) {
    this.songs.add(song);
  }
}
