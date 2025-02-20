package com.movieflix.Services;

import java.util.List;

import com.movieflix.Entities.Movie;

public interface MovieService {
	
	public String addMovies(Movie m);
	public boolean movieExist(String mname);
	public List<Movie> movieList();
	public void deleteMovie(int id);
	public List<Movie> searchMoviesByName(String query);

}
