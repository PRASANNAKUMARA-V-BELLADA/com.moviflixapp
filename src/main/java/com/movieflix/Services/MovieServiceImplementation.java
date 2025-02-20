package com.movieflix.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.Entities.Movie;
import com.movieflix.Repository.MovieRepository;
@Service
public class MovieServiceImplementation implements MovieService {
  @Autowired
  MovieRepository mrepo;
	@Override
	public String addMovies(Movie m) {
		mrepo.save(m);
		return "Movie saved Successfully";
	}
	@Override
	public boolean movieExist(String mname) {
	   Movie mv= mrepo.findByMname(mname);
	   if(mv!=null) {
		 return true;   
	   }
	   else {
		return false;
	   }
	}
	@Override
	public List<Movie> movieList() {
	    List<Movie> mlist=mrepo.findAll();
		return mlist;
	}
	@Override
	public void deleteMovie(int id) {
		mrepo.deleteById(id);
	}
	@Override
	public List<Movie> searchMoviesByName(String query) {
		
		 return mrepo.findByMnameContainingIgnoreCase(query);
	}

}
