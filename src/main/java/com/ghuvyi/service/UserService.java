package com.ghuvyi.service;

import com.ghuvyi.model.Login;
import com.ghuvyi.model.UserMovie;
import com.ghuvyi.model.User;

import java.util.List;

public interface UserService {

  int register(User user);

  User validateUser(Login login);

  int bookmark(UserMovie usermovie);

  List<UserMovie> getBookmarks(UserMovie userMovie);
}
