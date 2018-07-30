package com.stackroute.MovieMongo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.MovieMongo.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	// @Query("FROM com.stackroute.movie.domain.Movie movie where movie.title
	// =:title")
	// List<Movie> findMovieByTitle(@Param("title") String title);
}
