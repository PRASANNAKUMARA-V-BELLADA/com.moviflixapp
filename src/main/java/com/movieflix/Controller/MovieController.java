package com.movieflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.Entities.Movie;
import com.movieflix.Services.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService mserv;
	
	@PostMapping("map-addMovies")
	public String addMovies(@ModelAttribute Movie m) {
		if(mserv.movieExist(m.getMname())==true) {
			System.out.println("------------"+m.getMname());
			return "addMovieFail";
		}
		else {
			mserv.addMovies(m);
			return "addMovieSuccess";
		}
	}
	
	@GetMapping("view-movies")
	public String viewMovies(Model model) {
		List<Movie> mlist=mserv.movieList();
		model.addAttribute("movies", mlist);
		return "MovieList";
	}
	
	@GetMapping("viewMovieUser")
	public String viewMovieUser(Model model) {
		List<Movie> mlist=mserv.movieList();
		model.addAttribute("usermovie", mlist);
		return "viewMovieUser";
	}
	  @DeleteMapping("DeleteMovie/{id}")
	    public String deleteRecord(@PathVariable("id") int id) {
	    	mserv.deleteMovie(id);
			return "MovieList";
	    }
	    @GetMapping("search")
	    public String searchMovies(@RequestParam("query") String query, Model model) {
	        // Assume movieService searches movies by name
	    	System.out.println(query);
	        List<Movie> searchResults = mserv.searchMoviesByName(query);
	        model.addAttribute("usermovie", searchResults);
	        return "viewMovieUser"; // the name of your HTML template
	    }

}
