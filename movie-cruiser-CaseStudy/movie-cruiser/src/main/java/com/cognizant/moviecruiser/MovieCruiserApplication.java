package com.cognizant.moviecruiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

@SpringBootApplication
public class MovieCruiserApplication {
	@Autowired
	private static MovieService movieService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(MovieCruiserApplication.class, args);
		movieService = context.getBean(MovieService.class);
		 testAddMovieItem();
		 testGetMovieListAdmin();
		 testGetMovieListCustomer();
		 testGetMovieList(1);
		 testModifyMovieList();
	}

	private static void testAddMovieItem() {
		Movie movie = new Movie();
		movie.setTitle("War");
	movie.setBoxOffice("$2,787,087");
	movie.setActive(true);
		movie.setDateOfLaunch(DateUtil.convertToDate("26/06/2020"));
		movie.setGenre("Action");
	movie.setHasTeaser(true);
		movieService.modifyMovie(movie);
		
		Movie movie1 = new Movie();
		movie1.setTitle("Spiderman");
		movie1.setBoxOffice("$6,918,988");
		movie1.setActive(true);
		movie1.setDateOfLaunch(DateUtil.convertToDate("15/12/2018"));
		movie1.setGenre("Superhero");
		movie1.setHasTeaser(false);
		movieService.modifyMovie(movie1);
				Movie movie2 = new Movie();
		movie2.setTitle("Titanic");
		movie2.setBoxOffice("$2,187,463,944");
		movie2.setActive(true);
		movie2.setDateOfLaunch(DateUtil.convertToDate("29/08/2015"));
		movie2.setGenre("Romance");
	movie2.setHasTeaser(true);
		movieService.modifyMovie(movie2);
		
		Movie movie3 = new Movie();
		movie3.setTitle("Tabaji");
		movie3.setBoxOffice("$1,671,713,208");
		movie3.setActive(false);
		movie3.setDateOfLaunch(DateUtil.convertToDate("05/06/2019"));
		movie3.setGenre("Historical");
		movie3.setHasTeaser(true);
		movieService.modifyMovie(movie3);
		
		Movie movie4 = new Movie();
	movie4.setTitle("Avengers: End Game");	
	movie4.setBoxOffice("$2,750,760,348");
		movie4.setActive(true);
		movie4.setDateOfLaunch(DateUtil.convertToDate("02/11/2022"));	
		movie4.setGenre("Superhero");
	movie4.setHasTeaser(true);
		movieService.modifyMovie(movie4);

	}

	private static void testModifyMovieList()// use this test to insert or update Movie Object
	{
		Movie movie = movieService.getMovie(1);
		movie.setId(1);
		movie.setTitle("Ek Tha Tiger");
	movie.setBoxOffice("$1,656,394");
		movie.setHasTeaser(true);
		movie.setActive(true);
		movie.setDateOfLaunch(DateUtil.convertToDate("06/05/2016"));
		movie.setGenre("Action");
		movieService.modifyMovie(movie);

	}

	private static void testGetMovieListAdmin() {
		LOGGER.info("Start");
		LOGGER.debug("Movies :: {}", movieService.getMovieListAdmin());
		LOGGER.info("End");
	}

	private static void testGetMovieListCustomer() {
		LOGGER.info("Start");
		LOGGER.debug("Movies for customer :: {}", movieService.getMovieListCustomer());
		LOGGER.info("End");
	}

	private static void testGetMovieList(Integer id) {
		LOGGER.info("Start");
		LOGGER.debug("Item:: {}", movieService.getMovie(id));
		LOGGER.info("End");
	}

}