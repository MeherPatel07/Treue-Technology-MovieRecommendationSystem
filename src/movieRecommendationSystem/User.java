package movieRecommendationSystem;

import java.util.HashSet;
import java.util.Set;

public class User 
{
	String name;
	Set<Movie> watchedMovies;
	
	public User(String name) 
	{
		super();
		this.name = name;
		this.watchedMovies = new HashSet<>();
	}

	public void watchedMovie(Movie movie)
	{
		watchedMovies.add(movie);
	}
	
	

}
