package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;

// import org.springframework.http.HttpStatus;

// FIX: Shit methods
public class Generate {
  Initialize init = new Initialize();

  // Data
  ArrayList<UUID> allArtistID = new ArrayList<>();
  ArrayList<UUID> allAlbumsID = new ArrayList<>();
  ArrayList<UUID> allSongsID = new ArrayList<>();
  ArrayList<Artist> artists = new ArrayList<>();
  ArrayList<Album> albums = new ArrayList<>();
  ArrayList<Song> songs = new ArrayList<>();
  ArrayList<User> users = init.readUsers();

  // Populate all data
  public Generate() {
    // populate();
  }

  // Getter and Setters
  public ArrayList<Artist> getArtists() {
    this.artists = init.readArtists();
    return artists;
  }

  public ArrayList<Album> getAlbums() {
    this.albums = init.readAlbums();
    return albums;
  }

  public ArrayList<Song> getSongs() {
    this.songs = init.readSongs();
    return songs;
  }

  public ArrayList<UUID> getAllArtist() {
    for (Artist artist : artists) {
      allArtistID.add(artist.id);
    }
    return allArtistID;
  }

  public ArrayList<UUID> getAllAlbums() {
    for (Album album : albums) {
      allAlbumsID.add(album.id);
    }
    return allAlbumsID;
  }

  public ArrayList<UUID> getAllSongs() {
    for (Song song : songs) {
      allSongsID.add(song.id);
    }
    return allSongsID;
  }

  public ArrayList<User> getAllUsers() {
    ArrayList<User> list = new ArrayList<>();
    for (User user : init.readUsers()) {
      list.add(user);
    }
    return list;
  }

  // Methods
  public void addSong(Song new_song) {
    ArrayList<Artist> artists = init.readArtists();
    ArrayList<Album> albums = init.readAlbums();
    new_song.id = UUID.randomUUID();
    for (Album album : albums) {
      if (album.name.equals(new_song.album)) {
        album.addSong(new_song);
        init.writeAllAlbums(albums);
      }
    }
    for (Artist artist : artists) {
      if (artist.name.equals(new_song.artist)) {
        new_song.artist_id = artist.id;
        artist.addSong(new_song);
        init.writeAllArtist(artists);
        init.writeSongs(new_song);
      }
    }

  }

  public void addArtist(Artist new_artist) {
    new_artist.id = UUID.randomUUID();
    init.writeArtist(new_artist);
  }

  public void addAlbum(Album new_album) {
    ArrayList<Artist> artists = init.readArtists();
    new_album.id = UUID.randomUUID();
    for (Artist artist : artists) {
      if (artist.id.equals(new_album.artist_id)) {
        artist.addAlbum(new_album);
        init.writeAllArtist(artists);
        init.writeAlbums(new_album);
      }
    }
  }

  // TODO: This method is uncompleted
  public void addUserList(User req) {
    for (User user : users) {
      if (user.username.equals(req.username)) {
        user.user_playlist = req.user_playlist;
        init.writeAllUsers(users);
      }
    }
  }

  public User login(User req) {
    for (User user : users) {
      if (user.username.equals(req.username)) {
        if (user.password.equals(req.password)) {
          return user;
        }
      }
    }
    return null;
  }

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

  public Artist searchArtist(String id) {
    for (Artist artist : init.readArtists()) {
      String one = artist.id.toString();
      if (one.equals(id)) {
        return artist;
      }
    }
    return null;
  }

  /*
   * Esta funcion se usa para generar datos en caso se pierdan los serializados.
   */
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
        "Mr.Morale and the Bigsteppers", kendrick.name, kendrick.id, 100);
    Album mtmb = new Album("https://i.scdn.co/image/ab67616d0000b2732f44aec83b20e40f3baef73c", "Music to be Murder by",
        eminem.name, eminem.id, 100);
    Album illmatic = new Album("https://i.scdn.co/image/ab67616d0000b273045fc920ecf4f8094888ec26", "Illmatic", nas.name,
        nas.id,
        100);
    Album tamw = new Album("https://i.scdn.co/image/ab67616d0000b2737579fb3388d72153c49375e9",
        "The American Most Wanted", ice.name, ice.id, 100);

    // Songs
    Song crown = new Song(morale.image, "Crown", morale.name, kendrick.name, kendrick.id, "Hip Hop", 2022, 10,
        "https://www.youtube.com/watch?v=eL1L287YbkQ");
    Song gnat = new Song(mtmb.image, "GNAT", mtmb.name, eminem.name, eminem.id, "Hip Hop", 2020, 10,
        "https://www.youtube.com/watch?v=EosMazKaPbU");
    Song twiy = new Song(illmatic.image, "The World is Yours", illmatic.name, nas.name, nas.id, "Hip Hop", 2006, 10,
        "https://www.youtube.com/watch?v=e5PnuIRnJW8");
    Song novaseline = new Song(tamw.image, "No Vaseline", tamw.name, ice.name, ice.id, "Hip Hop", 2020, 10,
        "https://www.youtube.com/watch?v=c9mMLF2nzkk");
    Song stronger = new Song("https://i.scdn.co/image/ab67616d0000b2739bbd79106e510d13a9a5ec33", "Stronger",
        "Graduation", "Kanye West", null, "Hip Hop", 2007, 10, "https://www.youtube.com/watch?v=3mwiO5st-us");
    Song sicko = new Song("https://i.scdn.co/image/ab67616d0000b273072e9faef2ef7b6db63834a3", "Sicko Mode",
        "Astro World", "Travis Scott", null, "Hip Hop", 2020, 10, "https://www.youtube.com/watch?v=d-JBBNg8YKs");

    // Add data
    morale.addSong(crown);
    mtmb.addSong(gnat);
    illmatic.addSong(twiy);
    tamw.addSong(novaseline);

    kendrick.addAlbum(morale);
    eminem.addAlbum(mtmb);
    nas.addAlbum(illmatic);
    ice.addAlbum(tamw);

    kendrick.addSong(crown);
    eminem.addSong(gnat);
    nas.addSong(twiy);
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
    songs.add(twiy);
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
    allSongsID.add(twiy.id);
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

    init.writeSongs(crown);
    init.writeSongs(gnat);
    init.writeSongs(twiy);
    init.writeSongs(novaseline);
    init.writeSongs(stronger);
    init.writeSongs(sicko);

    init.writeArtist(kendrick);
    init.writeArtist(eminem);
    init.writeArtist(nas);
    init.writeArtist(ice);
    init.writeArtist(mfdoom);

    init.writeAlbums(morale);
    init.writeAlbums(mtmb);
    init.writeAlbums(illmatic);
    init.writeAlbums(tamw);
  }
}
