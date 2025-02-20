package com.movieflix.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
    @GetMapping("map-sign-up")
    public String register() {
    	return "register";
    }
    
    @GetMapping("map-login")
    public String login() {
    	return "login";
    }
    @GetMapping("map-admin")
    public String adminHome() {
    	return "adminhome";
    }
    
    @GetMapping("add-movies")
    public String addMovies() {
    	return "addMovies";
    }
    @GetMapping("UpdateUser")
    public String updateUser() {
    	return "userUpdate";
    }
    @GetMapping("Forgot")
    public String forgotPassword() {
    	return "forgotPassword";
    }
}
