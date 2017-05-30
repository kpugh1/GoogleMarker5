package gm;
/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - Category
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Category {
	
	private LinkedQueue[] list;
	
	//Constructor for the List
	Category()
	{
		list = new LinkedQueue[5];
		readLocations();
	}
	
	//Return the list
	public LinkedQueue[] getList()
	{
		return list;
	}
	
	//Get the index for the list based on the category
	private int getIndex(String c)
	{
		int index;
		
		switch(c)
		{
		case"Museum":
			index = 0;
			break;
		case"Amusement":
			index = 1;
			break;
		case"Restaurant":
			index = 2;
			break;
		case"Gas":
			index = 3;
			break;
		case"Movie":
			index = 4;
			break;
			default:
				index = -1;
				break;
		}
		
		return index;
	}
	
	//Input into lost at the index
	private void inputIntoList(String c, double lat, double lon)
	{
		int index;
		Location l = new Location(lat, lon, c);
		
		//get Index
		index = getIndex(c);
		
		//input the location at the index if the index is correct
		if( index != -1)
		{	
			inputIndex(index, l);	
		}
	
		
	}
	
	//Input the location at the index
	private void inputIndex(int index, Location l)
	{
		//if the list is not initialized create new linked queue
		if(list[index] == null)
		{
			list[index] = new LinkedQueue();
			list[index].enqueue(l);
			
		}
		else
		{
			//Input the location at the index
			list[index].enqueue(l);
		}
	}

	//Input the location from the text file
	private void readLocations()
	{
		File input; 
		Scanner scan;
		Scanner lineScan;
		//create a new file
		input = new File("Locations.txt");
		
		try {
			
			//scan the file
			scan = new Scanner(input);

			//while not the end of the file
			while(scan.hasNextLine())
			{
				String line;
				String category;
				
				double latitude;
				double longitude;
				
				//Input the line 
				line = scan.nextLine();
				
				//Scan the line
				lineScan = new Scanner(line);
				
				while(lineScan.hasNext()){
					//Take each input from the line and input into the list
					category = lineScan.next();
					latitude = Double.parseDouble(lineScan.next());
					longitude = Double.parseDouble(lineScan.next());
					inputIntoList(category, latitude, longitude);
				}
			}
		
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
	
	}
	
	//Get the marker for the category
	public String getMarker(String category) throws Exception

	{
		String str = "";
		int index = getIndex(category);
		 
		//if the list is not null
		if(list[index] != null)
		{
			//While the list is not empty
			while(!list[index].isEmpty())
			{
				//Add the marker to the string
				str += list[index].dequeue().getMarker();
				
			}
		}
		
		
		return str;
	}
	
	//get the Average of the latitude  based on category
	public double getAverageLatitude(String category)
	{
		double averageLat = 0;
		int index = getIndex(category);
		
		averageLat = list[index].AverageLatitudes();
		
		return averageLat;
	}
	
	//get the average of the longitude based on category
	public double getAverageLongitude(String category) 
	{
		double averageLon = 0;
		int index = getIndex(category);
		
		
			averageLon = list[index].AverageLongitude();	
		
	
		return averageLon;
	}
	
	
}
