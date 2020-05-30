package com.ghuvyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ghuvyi.model.Login;
import com.ghuvyi.model.User;
import com.ghuvyi.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserService userService;


  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    User user = userService.validateUser(login);

    if (null != user) {
      mav = new ModelAndView("welcome", "firstname", user.getEmail());

    } else {
      mav = new ModelAndView("home");
      mav.addObject("message", "Username or Password is wrong!!");
    }

    return mav;
  }

}
