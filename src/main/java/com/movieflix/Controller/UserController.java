package com.movieflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PutExchange;

import com.movieflix.Entities.ForgotPassword;
import com.movieflix.Entities.Movie;
import com.movieflix.Entities.User;
import com.movieflix.Entities.UserUpdate;
import com.movieflix.Services.MovieService;
import com.movieflix.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class UserController {
	@Autowired
	UserService userv;
	
	@Autowired
	MovieService mserv;
	
	@PostMapping("registration")
	public String addUser(@ModelAttribute User u) {
		if(userv.emailExist(u.getEmail())==false) {
			userv.addUser(u);
			return "registrationSuccess";
		}
		else {
			return "registrationfail";
		}
	}
	
	@PostMapping("loginMadu")
	public String checkLogin(@RequestParam String email,@RequestParam String password,HttpSession session) {
		
			if(userv.checkLoginEmail(email, password)==true) {
				session.setAttribute("email",email );
				if(email.equals("admin@gmail.com")) {
					return "adminhome";
				}
				else {
					return "userhome";
				}
			}
			else {
				return "loginfail";
			}
	}
	
	@GetMapping("view-users")
	public String viewUser(Model model){
		List<User> ulist=userv.viewUser();
		model.addAttribute("users", ulist);
		return "viewusers";
	}
    @GetMapping("exploremovies")
    public String exploreMovies(HttpSession session,Model model) {
    	String email=(String) session.getAttribute("email");
    	User usr=userv.getUser(email);
    	if(usr.isPremium()==true) {
    		List<Movie> mlist=mserv.movieList();
    		model.addAttribute("usermovie", mlist);
    		return "viewMovieUser";
    	}else {
    		return "payment";
    	}
    	
    }
    @GetMapping("logout")
    public String logout(HttpSession session) {
    	session.invalidate();
		return "login";
    	
    }
    @PutMapping("UpdateMadu")
    public String userDetailUpdate(@RequestBody UserUpdate upd) {
    	  System.out.println(upd);
			userv.updateUser(upd);
			return "viewusers";
		
    }
    @DeleteMapping("DeleteMadu/{id}")
    public String deleteRecord(@PathVariable("id") int id) {
    	userv.deleteUser(id);
		return "viewusers";
    }
    @PutMapping("ForgotMadu")
    public  ResponseEntity<String> userForgotPassword(@RequestBody ForgotPassword fg) {
    	  System.out.println(fg);
    	   User usr=userv.getUser(fg.getEmail());
    	   if(usr==null) {
    		   return new ResponseEntity<>("User Not Found, Please Enter Again",HttpStatus.NOT_FOUND);
    	   }
			boolean isPasswordSet=userv.forgotPassword(fg);
			System.out.println("------------"+fg.getPassword1());
	        if (!isPasswordSet) {
	            // Return an error message and HTTP status code
	            return new ResponseEntity<>("Password not set, try again.", HttpStatus.BAD_REQUEST);
	        }

	        // Logic to set the new password (if successful)
	        return new ResponseEntity<>("Password successfully updated.", HttpStatus.OK);
		
    }
}
