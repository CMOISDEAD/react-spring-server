package com.example.demo;

import java.util.ArrayList;
import java.io.*;

public class Initialize implements Serializable {
  // final public String ARTISTS_PATH = "/home/camilo/Documents/git/react-spring/backend/src/main/resources/data/aritsts.ser";
  // final public String ALBUMS_PATH = "/home/camilo/Documents/git/react-spring/backend/src/main/resources/data/albums.ser";
  // final public String SONGS_PATH = "/home/camilo/Documents/git/react-spring/backend/src/main/resources/data/songs.ser";
  // final public String USERS_PATH = "/home/camilo/Documents/git/react-spring/backend/src/main/resources/data/users.ser";
  final public String ARTISTS_PATH = "/home/camilo/Documents/git/react-spring-server/src/main/resources/data/aritsts.ser";
  final public String ALBUMS_PATH = "/home/camilo/Documents/git/react-spring-server/src/main/resources/data/albums.ser";
  final public String SONGS_PATH = "/home/camilo/Documents/git/react-spring-server/src/main/resources/data/songs.ser";
  final public String USERS_PATH = "/home/camilo/Documents/git/react-spring-server/src/main/resources/data/users.ser";
  
  public ArrayList<Artist> readArtists() {
    ArrayList<Artist> list = new ArrayList<Artist>();
    try {
      FileInputStream fileIn = new FileInputStream(ARTISTS_PATH);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      list = (ArrayList<Artist>) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return list;
  }

  /*
   * Read albums data
   */
  public ArrayList<Album> readAlbums() {
    ArrayList<Album> list = new ArrayList<>();
    try {
      FileInputStream fileIn = new FileInputStream(ALBUMS_PATH);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      list = (ArrayList<Album>) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return list;
  }

  /*
   * Read songs data
   */
  public ArrayList<Song> readSongs() {
    ArrayList<Song> list = new ArrayList<>();
    try {
      FileInputStream fileIn = new FileInputStream(SONGS_PATH);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      list = (ArrayList<Song>) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return list;
  }

  /*
   * Read users data
   */
  public ArrayList<User> readUsers() {
    ArrayList<User> list = new ArrayList<>();
    try {
      FileInputStream fileIn = new FileInputStream(USERS_PATH);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      list = (ArrayList<User>) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return list;
  }

  /*
   * Write artist data
   */
  public void writeArtist(Artist artist) {
    ArrayList<Artist> artists = readArtists();
    artists.add(artist);
    try {
      FileOutputStream fileOut = new FileOutputStream(ARTISTS_PATH);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(artists);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  /*
   * Write artist data
   */
  public void writeSongs(Song song) {
    ArrayList<Song> songs = readSongs();
    songs.add(song);
    try {
      FileOutputStream fileOut = new FileOutputStream(SONGS_PATH);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(songs);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  /*
   * Write Albums data
   */
  public void writeAlbums(Album album) {
    ArrayList<Album> albums = readAlbums();
    albums.add(album);
    try {
      FileOutputStream fileOut = new FileOutputStream(ALBUMS_PATH);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(albums);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  /*
   * Write Users data
   */
  public void writeUsers(User user) {
    ArrayList<User> users = readUsers();
    users.add(user);
    try {
      FileOutputStream fileOut = new FileOutputStream(USERS_PATH);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(users);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  public void writeAllArtist(ArrayList<Artist> artists) {
    try {
      FileOutputStream fileOut = new FileOutputStream(ARTISTS_PATH);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(artists);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }
}
