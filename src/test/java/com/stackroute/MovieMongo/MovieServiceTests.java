/*package com.stackroute.MovieMongo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.MovieMongo.domain.Movie;
import com.stackroute.MovieMongo.repository.MovieRepository;

@RunWith(SpringRunner.class)
public class MovieServiceTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	public void testSaveMovie() {
		this.entityManager.persist(new Movie(1,"a","b","c","d"));
		Optional<Movie> movie = this.movieRepository.findById(1);
		assertThat(movie.get().getTitle()).isEqualTo("a");
	}
}
*/