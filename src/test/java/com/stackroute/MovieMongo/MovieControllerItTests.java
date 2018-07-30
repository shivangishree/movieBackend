package com.stackroute.MovieMongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.MovieMongo.domain.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieMongoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerItTests {
	@LocalServerPort
	private int port;

	Movie movie;

	private TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<Movie> entity;

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Before
	public void setUp() throws Exception {
		movie = new Movie(1, "a", "b", "c", "d");
		entity = new HttpEntity<Movie>(movie, headers);
	}

	@After
	public void tearDown() throws Exception {
		restTemplate.exchange(createURLWithPort("/api/movie/1"), HttpMethod.DELETE, entity, String.class);

	}

	@Test
	public void testSaveNewMovieSuccess() throws Exception {
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/saveMovie"), HttpMethod.POST,
				entity, String.class);

		assertNotNull(response);
		String actual = response.getBody();
		assertNotNull(actual);
		assertEquals(201, response.getStatusCodeValue());

	}
}
