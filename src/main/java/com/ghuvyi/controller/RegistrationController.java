package com.ghuvyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ghuvyi.model.User;
import com.ghuvyi.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;



  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {

     int i=userService.register(user);
     if(i==400){
       ModelAndView mav =new ModelAndView("home", "firstname", user.getEmail());
       response.setStatus(i);
       mav.addObject("userExists", "User Already exists!!");
       return mav;
     }
    return new ModelAndView("welcome", "firstname", user.getEmail());
  }
}
