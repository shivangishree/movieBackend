package com.stackroute.MovieMongo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MovieMongo.controller.MovieController;
import com.stackroute.MovieMongo.domain.Movie;
import com.stackroute.MovieMongo.exception.MovieNotFoundException;
import com.stackroute.MovieMongo.service.MovieService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTests {
   @Autowired
   private MockMvc movieMockMvc;
   @MockBean
    private MovieService movieService;
   
//   @Autowired
//	private TestRestTemplate restTemplate;
    /*@InjectMocks
    private MovieController movieController = new MovieController(movieService);*/
   @Before
   public void setUp() throws Exception {
       MockitoAnnotations.initMocks(this);
   }
  /* @Test
   public void helloTest() {
	   String body = this.restTemplate.getForObject("/", String.class);
	   assertThat(body).isEqualTo("Hi your service is up and working as expected!!");
   }*/
   @Test
   public void getAllMoviesTest() throws Exception{
       when(movieService.getAllMovies()).thenReturn(null);
       movieMockMvc.perform(get("/getMovies"))
                .andExpect(status().isOk());
   }
   @Test
   public void getMovieByIdPathVariableTests() throws Exception {
	   int id = 1;
	   Movie movie = new Movie(1,"a","b","c","d");
	   Optional<Movie> opt = Optional.of(movie);
	   when(movieService.getMovieById(id)).thenReturn(opt);
	   movieMockMvc.perform(get("/getMovieById/{id}",id))
	  	   .andExpect(status().isOk())
	  	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	  	 .andExpect(jsonPath("$.title", is(movie.getTitle())));
	  
   }
   
   @Test
   public void getMovieByIdRequestParamTest() throws Exception {
	   String id = "1";
	   Movie movie = new Movie(1,"a","b","c","d");
	   Optional<Movie> opt = Optional.of(movie);
	   when(movieService.getMovieById(Integer.parseInt(id))).thenReturn(opt);
	   movieMockMvc.perform(get("/getMovie").param("id",id))
	   .andExpect(status().isOk());
   }
   
   @Test
   public void updateMovieByIdTest() throws Exception {
	   String id = "1";
	   Movie movie = new Movie(1,"a","b","c","d");
	   when(movieService.UpdateMovieById(Integer.parseInt(id),movie)).thenReturn(movie);
	   movieMockMvc.perform(put("/updateMovieById/{id}",id)
	   .contentType(MediaType.APPLICATION_JSON_UTF8)
	   .content(asJsonString(movie)))
	  	  .andExpect(status().isOk());	  
   }
   public static String asJsonString(final Object obj) {
	   try {
	       return new ObjectMapper().writeValueAsString(obj);
	   } catch (Exception e) {
	       throw new RuntimeException(e);
	       }
	   }
}