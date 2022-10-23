package com.example.demo.Classes;

import java.io.Serializable;
import java.util.LinkedList;

public class User implements Serializable {
  public boolean isAdmin;
  public String username;
  public String password;
  public String email;
  public LinkedList<Song> user_playlist = new LinkedList<Song>();

  public User(boolean isAdmin, String username, String password, String email) {
    this.isAdmin = isAdmin;
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
