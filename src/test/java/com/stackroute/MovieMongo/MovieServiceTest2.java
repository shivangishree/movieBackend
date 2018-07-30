/*package com.stackroute.MovieMongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.MovieMongo.domain.Movie;
import com.stackroute.MovieMongo.exception.MovieAlreadyExistsException;
import com.stackroute.MovieMongo.repository.MovieRepository;
import com.stackroute.MovieMongo.service.MovieService;
import com.stackroute.MovieMongo.service.MovieServiceImpl;

public class MovieServiceTest2 {

	@Mock
	MovieRepository movieRepository;
	@InjectMocks
	MovieServiceImpl movieServiceImpl;
	
	Movie movie;
	@Before	
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		movie = new Movie(1,"a","b","c","d");
	}
	
	@Test
	public void testSave() throws MovieAlreadyExistsException {		
		Iterable<Object> movieList = Arrays.asList(movie);
		when(movieRepository.save(movie)).thenReturn(movie);
		Movie m = movieServiceImpl.saveMovie(movie);
		assertEquals(movie, m);
	}
}
*/