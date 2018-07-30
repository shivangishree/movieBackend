package com.stackroute.MovieMongo.service;

import java.util.Optional;

import com.stackroute.MovieMongo.domain.Movie;
import com.stackroute.MovieMongo.exception.MovieAlreadyExistsException;
import com.stackroute.MovieMongo.exception.MovieNotFoundException;

public interface MovieService {

	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
	
	 public Iterable<Movie> getAllMovies();
	
	 public Boolean delete(int id) throws MovieNotFoundException;
	
	public Optional<Movie> getMovieById(int id);
	
	 public Movie UpdateMovieById(int id, Movie movie) throws
	 MovieNotFoundException;

	// List<Movie> findMovieByTitle(String title);
}
