package com.movieflix.Services;

import java.util.List;

import com.movieflix.Entities.ForgotPassword;
import com.movieflix.Entities.User;
import com.movieflix.Entities.UserUpdate;

public interface UserService {
     public String addUser(User u);
     public boolean emailExist(String email);
     public boolean checkLoginEmail(String email,String password);
     public List<User> viewUser();
	public User getUser(String email);
	public void deleteUser(int id);
	public void updateUser(User user);
	public void updateUser(UserUpdate upd);
	public boolean forgotPassword(ForgotPassword fg);
	
	
}
