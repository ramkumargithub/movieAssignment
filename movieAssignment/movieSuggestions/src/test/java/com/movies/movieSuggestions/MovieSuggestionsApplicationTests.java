package com.movies.movieSuggestions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class MovieSuggestionsApplicationTests {


	private MockMvc mockMvc;

	@InjectMocks
	@Autowired
	private MovieRestController movieRestController;

	@Test
	void getAllMovies() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(movieRestController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"movieName\":\"God Father\",\"releaseDate\":\"29-09-1972\",\"genre\":\"Classic\"},{\"id\":2,\"movieName\":\"Finding Nemo\",\"releaseDate\":\"28-11-2003\",\"genre\":\"Animation\"},{\"id\":1,\"movieName\":\"The Shawshank Redemption\",\"releaseDate\":\"24-02-1995\",\"genre\":\"Thriller\"}]"));
	}

	@Test
	void getMoviesByGenre() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(movieRestController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/movies/Thriller"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"movieName\":\"The Shawshank Redemption\",\"releaseDate\":\"24-02-1995\",\"genre\":\"Thriller\"}"));

	}

	@Test
	void contextLoads() {
	}

}
