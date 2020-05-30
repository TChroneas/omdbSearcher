package com.ghuvyi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.ghuvyi.model.Login;
import com.ghuvyi.model.UserMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ghuvyi.model.User;

public class UserDaoImpl implements UserDao {
  public final int BAD_REQUEST=400;
  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "INSERT INTO `spring_mvc`.`users`" +
            "    values(?,?)";
    int i;
    try{
     i= jdbcTemplate.update(sql, new Object[] { user.getEmail(), user.getPassword() });
    }catch(Exception e){
      i=BAD_REQUEST;

    }

    return i;
  }



  public int bookmark(UserMovie usermovie){
    String sql = "INSERT INTO `spring_mvc`.`usermovie`" +
            "    values(?,?)";

    int i;
    try{
      i= jdbcTemplate.update(sql, new Object[] { usermovie.getEmail(), usermovie.getTitle() });
    }catch(Exception e){
      i=BAD_REQUEST;

    }

    return i;
  }

  public List<UserMovie> getBookmarks(UserMovie userMovie){
    String sql = "select * from `spring_mvc`.`usermovie` where email='" + userMovie.getEmail()+"'";
    List<UserMovie> titles = jdbcTemplate.query(sql,new TitleMapper() );
    return titles;
  }



  public User validateUser(Login login) {
    String sql = "select * from `spring_mvc`.`users` where email='" + login.getEmail() + "' and password='" + login.getPassword()
            + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));


    return user;
  }
}

class TitleMapper implements RowMapper<UserMovie> {
  public UserMovie mapRow(ResultSet rs,int arg1)throws SQLException{
    UserMovie userMovie=new UserMovie();


    userMovie.setEmail(rs.getString("email"));
    userMovie.setTitle(rs.getString("movieTitle"));
    return userMovie;
  }
}