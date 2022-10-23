package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;
import com.example.demo.Classes.*;

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
  LinkedList<Song> songs = new LinkedList<Song>();
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

  public LinkedList<Song> getSongs() {
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

  // TODO: This method is uncompleted...
  public void addUserList(String name, Song song) {
    for (User user : users) {
      if (user.username.equals(name)) {
        user.user_playlist.add(song);
        init.writeAllUsers(users);
      }
    }
  }

  public User login(User req_user) {
    for (User user : users) {
      if (user.username.equals(req_user.username)) {
        if (user.password.equals(req_user.password)) {
          return user;
        }
      }
    }
    return null;
  }

  public boolean register(User req_user) {
    for (User user : users) {
      if (user.username.equals(req_user.username)) {
        return false;
      }
    }
    users.add(req_user);
    init.writeAllUsers(users);
    return true;
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

    // Albums
    Album morale = new Album("https://i.scdn.co/image/ab67616d0000b2732e02117d76426a08ac7c174f",
        "Mr.Morale and the Bigsteppers", kendrick.name, kendrick.id, 100);
    Album mtmb = new Album("https://i.scdn.co/image/ab67616d0000b2732f44aec83b20e40f3baef73c", "Music to be Murder by",
        eminem.name, eminem.id, 100);

    // Songs
    Song crown = new Song(morale.image, "Crown", morale.name, kendrick.name, kendrick.id, "Hip Hop", 2022, 10,
        "https://www.youtube.com/watch?v=eL1L287YbkQ");
    Song gnat = new Song(mtmb.image, "GNAT", mtmb.name, eminem.name, eminem.id, "Hip Hop", 2020, 10,
        "https://www.youtube.com/watch?v=EosMazKaPbU");

    // Add data
    morale.addSong(crown);
    mtmb.addSong(gnat);

    kendrick.addAlbum(morale);
    eminem.addAlbum(mtmb);

    kendrick.addSong(crown);
    eminem.addSong(gnat);

    // Set class data
    ArrayList<Artist> artists = new ArrayList<>();

    artists.add(kendrick);
    artists.add(eminem);

    ArrayList<Album> albums = new ArrayList<>();

    albums.add(morale);
    albums.add(mtmb);

    LinkedList<Song> songs = new LinkedList<Song>();

    songs.add(crown);
    songs.add(gnat);

    ArrayList<UUID> allArtistID = new ArrayList<>();

    allArtistID.add(kendrick.id);
    allArtistID.add(eminem.id);

    ArrayList<UUID> allSongsID = new ArrayList<>();

    allSongsID.add(crown.id);
    allSongsID.add(gnat.id);

    ArrayList<UUID> allAlbumsID = new ArrayList<>();

    allAlbumsID.add(morale.id);
    allAlbumsID.add(mtmb.id);

    this.artists = artists;
    this.albums = albums;
    this.songs = songs;
    this.allArtistID = allArtistID;
    this.allAlbumsID = allAlbumsID;
    this.allSongsID = allSongsID;

    init.writeSongs(crown);
    init.writeSongs(gnat);

    init.writeArtist(kendrick);
    init.writeArtist(eminem);

    init.writeAlbums(morale);
    init.writeAlbums(mtmb);

    // Users
    init.writeUsers(new User(true, "camilo", "password", "camilo@email.com"));
    init.writeUsers(new User(true, "johan", "password", "johan@email.com"));
    init.writeUsers(new User(false, "user", "password", "user@email.com"));
  }
}
