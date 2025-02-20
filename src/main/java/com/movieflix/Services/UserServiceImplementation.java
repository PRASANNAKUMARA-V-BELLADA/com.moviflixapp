package com.movieflix.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.Entities.ForgotPassword;
import com.movieflix.Entities.User;
import com.movieflix.Entities.UserUpdate;
import com.movieflix.Repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository urepo;

	@Override
	public String addUser(User u) {
		urepo.save(u);
		return "User is added Successfully";
	}

	@Override
	public boolean emailExist(String email) {
		User usr=urepo.findByEmail(email);
		if(usr==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkLoginEmail(String email, String password) {
		User usr=urepo.findByEmail(email);
		if(usr!=null&&(usr.getPassword()).equals(password)) {
			return true;
		}
		else {
		   return false;
		}
	}

	@Override
	public List<User> viewUser() {
		List<User> ulist=urepo.findAll();
		return ulist;
	}

	@Override
	public User getUser(String email) {
		User usr=urepo.findByEmail(email);
		return usr;
	}

	@Override
	public void updateUser(User user) {
		urepo.save(user);
	}
	
	@Override
	public void updateUser(UserUpdate upd) {
		   System.out.println(upd.getName());
		   User user=urepo.findByName(upd.getName());
	       user.setEmail(upd.getEmail());
           user.setPhone(upd.getPhone());
           user.setAddress(upd.getAddress());
           urepo.save(user);  // Save updated user details to DB
	       
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		urepo.deleteById(id);
	}

	@Override
	public boolean forgotPassword(ForgotPassword fg) {
		User usr=urepo.findByEmail(fg.getEmail());
		if(usr!=null) {
		String password=usr.getPassword();
		String newPass=fg.getPassword1();
	    if(!password.equals(newPass)) {
	    	System.out.println(password);
	    	System.out.println(newPass);
	    	usr.setPassword(newPass);
	    	urepo.save(usr);
	    	return true;
	    }
	    else {
	    	return false;
	    }
		}
		else {
			return false;
		}
		
	}


	
}

