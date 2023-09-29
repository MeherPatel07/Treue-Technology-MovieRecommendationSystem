package movieRecommendationSystem;

import java.util.Set;

public class Movie 
{
	String title;
	Set<String>genre;
	double averageRatings;
	int totalRatings;
	
	public Movie(String title,Set<String> genres)
	{
		
		this.setTitle(title);
		this.genre=genres;
		this.averageRatings=0.0;
		this.totalRatings=0;
	}
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public void rateMovie(int rating)
	{
		if(rating>=1 && rating<=5)
		{
			totalRatings++;
			averageRatings=((averageRatings * (totalRatings-1))+rating)/totalRatings;
		}
		else 
		{
			System.out.println("Invalid rating , please enter valid ratings between 1 and 5.");
		}
	}
	
	public double getAverageRating()
	{
		return averageRatings;
	}
	
	

}
