package com.ghuvyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ghuvyi.model.UserMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ghuvyi.service.UserService;

import java.util.List;

@Controller
public class BookmarkController {
    @Autowired
    public UserService userService;

    public final int BAD_REQUEST=400;

    @RequestMapping(value = "/bookmarkProcess", method = RequestMethod.POST)
    public ModelAndView addUserMovie(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("usermovie") UserMovie usermovie) {
        ModelAndView mav =null;
        int i=userService.bookmark(usermovie);

        mav=new ModelAndView("welcome", "firstname", usermovie.getEmail());
        if(i==BAD_REQUEST){
            mav.addObject("message", "Bookmark Already Exists");
            response.setStatus(i);
        }else {
            mav.addObject("message", "Bookmark Created");
        }
        return mav;
    }

    @RequestMapping(value = "/goToBookmarks", method = RequestMethod.GET)
    public ModelAndView goToBookmarks(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") UserMovie usermovie) {
        ModelAndView mav =null;
       List<UserMovie> list= userService.getBookmarks( usermovie);

        mav=new ModelAndView("mybookmarks", "firstname", usermovie.getEmail());
        mav.addObject("titles",list);

        return mav;
    }

}
