package com.example.demo;

import java.util.UUID;

public class Song {
  public UUID id;
  public String name;
  public String album;
  public UUID artist_id;
  public String artist;
  public String cover;
  public String genre;
  public int year;
  public int duration;
  public String yt_url;

  public Song(String cover, String name, String album, String artist, UUID artist_id, String genre, int year,
      int duration,
      String yt_url) {
    this.id = UUID.randomUUID();
    this.artist_id = artist_id;
    this.cover = cover;
    this.name = name;
    this.album = album;
    this.artist = artist;
    this.genre = genre;
    this.year = year;
    this.duration = duration;
    this.yt_url = yt_url;
  }
}
