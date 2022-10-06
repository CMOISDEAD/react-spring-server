package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
  public boolean isAdmin;
  public String username;
  public String password;
  public String email;
  public ArrayList<Song> user_playlist;

  public User(boolean isAdmin, String username, String password, String email) {
    this.isAdmin = isAdmin;
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
