package com.movieflix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.Entities.User;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

	public User findByName(String name);

	


}
