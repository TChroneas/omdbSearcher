package com.ghuvyi.service;

import com.ghuvyi.model.Login;
import com.ghuvyi.model.UserMovie;
import org.springframework.beans.factory.annotation.Autowired;

import com.ghuvyi.dao.UserDao;
import com.ghuvyi.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    int i=userDao.register(user);
    return i;
  }

  public int bookmark(UserMovie usermovie){
    return userDao.bookmark(usermovie);
  }

  public List<UserMovie> getBookmarks(UserMovie userMovie){
    return userDao.getBookmarks(userMovie);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
