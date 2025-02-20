package com.movieflix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.Entities.Movie;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Integer>{
   public Movie findByMname(String mname);

   public List<Movie> findByMnameContainingIgnoreCase(String query); 
}
