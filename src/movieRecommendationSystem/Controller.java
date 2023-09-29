package movieRecommendationSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Controller {
	Map<String, User> users;
	List<Movie> movies;
	
	public Controller()
	{
		users=new HashMap<>();
	    movies=new ArrayList<>();	
	}
	
	public void addUser(String username)
	{
		users.put(username, new User(username));
		System.out.println("User added");
	}
	
	public <addMovie> void addMovie(String title,Set<String> generes)
	{
		movies.add(new Movie(title, generes));
	}
	
	public  void watchMovie(String username,String movieTitle)
	{
		User user=users.get(username);
		Movie movie=findMovieByTitle(movieTitle);
		
		if(movies != null && movie != null)
		{
			user.watchedMovie(movie);
		}
		else {
			System.out.println("Movie not found");
		}
	}
	
	public List<Movie> getRecommendedMovies(String username)
	{
		User user=users.get(username);
		List<Movie> recommendedMovies=new ArrayList<>();
		
		if(user != null)
		{
			for(Movie movie:movies)
			{
				if(!user.watchedMovies.contains(movie))
				{
					recommendedMovies.add(movie);
				}
			}
		}
		return recommendedMovies;
	}
	private Movie findMovieByTitle(String title)
	{
		for(Movie movie:movies)
		{
			if(movie.title.equalsIgnoreCase(title))
			{
				return movie;
			}
		}
		return null;
	}
	

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		Controller controller=new Controller();
		String username=null;
		
		while(true)
		{
			System.out.println("***************************");
			System.out.println("1.Add user \n2.Add movie \n3.Watch nmovie \n4.Rate movie \n5.Get recommended movies \n6.Exit");
			System.out.println("***************************");
			System.out.println("Enter your choice :");
			
			switch(scanner.nextInt())
			{
			case 1:
			{
				System.out.println("Enter user name :");
				username=scanner.next();
				controller.addUser(username);
				break;
			}
			case 2:
			{
				System.out.println("Enter movie title :");
				String movietitle=scanner.nextLine();
				System.out.println("Enter generes(comma-seperated):");
				String[] genreArray=scanner.nextLine().split(",");
				Set<String>genre=new HashSet<>(Arrays.asList(genreArray));
				controller.addMovie(movietitle, genre);
				break;
			}
			case 3:
			{
				System.out.println("Enter movie title :");
				String movietitle=scanner.nextLine();
				controller.watchMovie(username, movietitle);
				System.out.println("Enjoy Your Movie......");
				break;
			}
			case 4:
			{
				System.out.println("Enter movie title :");
				String movietitle=scanner.nextLine();
				Movie ratedMovie=controller.findMovieByTitle(movietitle);
				if(ratedMovie !=null)
				{
					System.out.println("Enter rating (1 to 5): ");
					ratedMovie.rateMovie(scanner.nextInt());
				}
				else 
				{
					System.out.println("Movie not found.");
				}
				break;
			}
			case 5:
			{
				List<Movie> recommendedMovies=controller.getRecommendedMovies(username);
				System.out.println("Recommended movies for " +username + ":");
				for(Movie movie:recommendedMovies)
				{
					System.out.println(movie.title+"(Average Rating : "+movie.getAverageRating()+")");
				}
				break;
			}
			case 6:
			{
				System.out.println("Thank You.....");
				System.exit(0);
				break;
			}
			default :
			{
				System.out.println("Invalid Choice.Please choose again");
			}
			}
		}
		

	}

}
