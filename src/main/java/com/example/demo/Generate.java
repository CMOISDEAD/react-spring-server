package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;

public class Generate {
  // Data
  ArrayList<UUID> allArtistID = new ArrayList<>();
  ArrayList<UUID> allAlbumsID = new ArrayList<>();
  ArrayList<UUID> allSongsID = new ArrayList<>();
  ArrayList<Artist> artists = new ArrayList<>();
  ArrayList<Album> albums = new ArrayList<>();
  ArrayList<Song> songs = new ArrayList<>();

  // Populate all data
  public Generate() {
    populate();
  }

  // Getter and Setters
  public ArrayList<Artist> getArtists() {
    return artists;
  }

  public ArrayList<Album> getAlbums() {
    return albums;
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }

  public ArrayList<UUID> getAllArtist() {
    return allArtistID;
  }

  public ArrayList<UUID> getAllAlbums() {
    return allAlbumsID;
  }

  public ArrayList<UUID> getAllSongs() {
    return allSongsID;
  }

  // Methods
  public Song searchSong(String id) {
    for (Song song : songs) {
      String one = song.id.toString();
      if (one.equals(id)) {
        return song;
      }
    }
    return null;
  }

  public Album searchAlbum(String id) {
    for (Album album : albums) {
      String one = album.id.toString();
      if (one.equals(id)) {
        return album;
      }
    }
    return null;
  }

  // Populate all data
  public void populate() {
    // Artists
    Artist kendrick = new Artist("https://i.scdn.co/image/ab6761610000e5eb437b9e2a82505b3d93ff1022", "Kendrick Lamar",
        false, "US");
    Artist eminem = new Artist("https://i.scdn.co/image/ab6761610000e5eba00b11c129b27a88fc72f36b", "Eminem", false,
        "US");
    Artist nas = new Artist("https://i.scdn.co/image/ab67616d00001e02d0673d1dd6938dad8530823b", "Nas", false, "US");
    Artist ice = new Artist("https://i.scdn.co/image/ab6761610000e5eb650e79afafd00492e33d7b8c", "Ice Cube", false,
        "US");
    Artist mfdoom = new Artist("https://i.scdn.co/image/ab67616d0000b27374dc897ea75402db37ef239a", "MF Doom", false,
        "US");

    // Albums
    Album morale = new Album("https://i.scdn.co/image/ab67616d0000b2732e02117d76426a08ac7c174f",
        "Mr.Morale and the Bigsteppers", kendrick.name, 100);
    Album mtmb = new Album("https://i.scdn.co/image/ab67616d0000b2732f44aec83b20e40f3baef73c", "Music to be Murder by",
        eminem.name, 100);
    Album illmatic = new Album("https://i.scdn.co/image/ab67616d0000b273045fc920ecf4f8094888ec26", "Illmatic", nas.name,
        100);
    Album tamw = new Album("https://i.scdn.co/image/ab67616d0000b2737579fb3388d72153c49375e9",
        "The American Most Wanted", ice.name, 100);

    // Songs
    Song crown = new Song(morale.image, "Crown", morale.name, kendrick.name, "Hip Hop", 2022, 10,
        "https://www.youtube.com/watch?v=eL1L287YbkQ");
    Song gnat = new Song(mtmb.image, "GNAT", mtmb.name, eminem.name, "Hip Hop", 2020, 10, "yt url");
    Song ether = new Song(illmatic.image, "Ether", illmatic.name, nas.name, "Hip Hop", 2006, 10,
        "https://www.youtube.com/watch?v=EosMazKaPbU");
    Song novaseline = new Song(tamw.image, "No Vaseline", tamw.name, ice.name, "Hip Hop", 2020, 10,
        "https://www.youtube.com/watch?v=c9mMLF2nzkk");
    Song stronger = new Song("https://i.scdn.co/image/ab67616d0000b2739bbd79106e510d13a9a5ec33", "Stronger",
        "Graduation", "Kanye West", "Hip Hop", 2007, 10, "https://www.youtube.com/watch?v=3mwiO5st-us");
    Song sicko = new Song("https://i.scdn.co/image/ab67616d0000b273072e9faef2ef7b6db63834a3", "Sicko Mode",
        "Astro World", "Travis Scott", "Hip Hop", 2020, 10, "https://www.youtube.com/watch?v=d-JBBNg8YKs");

    // Add data
    morale.addSong(crown);
    mtmb.addSong(gnat);
    illmatic.addSong(ether);
    tamw.addSong(novaseline);

    kendrick.addAlbum(morale);
    eminem.addAlbum(mtmb);
    nas.addAlbum(illmatic);
    ice.addAlbum(tamw);

    kendrick.addSong(crown);
    eminem.addSong(gnat);
    nas.addSong(ether);
    ice.addSong(novaseline);

    // Set class data
    ArrayList<Artist> artists = new ArrayList<>();

    artists.add(kendrick);
    artists.add(eminem);
    artists.add(nas);
    artists.add(ice);
    artists.add(mfdoom);

    ArrayList<Album> albums = new ArrayList<>();

    albums.add(morale);
    albums.add(mtmb);
    albums.add(illmatic);
    albums.add(tamw);

    ArrayList<Song> songs = new ArrayList<>();

    songs.add(crown);
    songs.add(gnat);
    songs.add(ether);
    songs.add(novaseline);
    songs.add(stronger);
    songs.add(sicko);

    ArrayList<UUID> allArtistID = new ArrayList<>();

    allArtistID.add(kendrick.id);
    allArtistID.add(eminem.id);
    allArtistID.add(nas.id);
    allArtistID.add(ice.id);
    allArtistID.add(mfdoom.id);

    ArrayList<UUID> allSongsID = new ArrayList<>();

    allSongsID.add(crown.id);
    allSongsID.add(gnat.id);
    allSongsID.add(ether.id);
    allSongsID.add(novaseline.id);
    allSongsID.add(stronger.id);
    allSongsID.add(sicko.id);

    ArrayList<UUID> allAlbumsID = new ArrayList<>();

    allAlbumsID.add(morale.id);
    allAlbumsID.add(mtmb.id);
    allAlbumsID.add(illmatic.id);
    allAlbumsID.add(tamw.id);

    this.artists = artists;
    this.albums = albums;
    this.songs = songs;
    this.allArtistID = allArtistID;
    this.allAlbumsID = allAlbumsID;
    this.allSongsID = allSongsID;
  }
}
