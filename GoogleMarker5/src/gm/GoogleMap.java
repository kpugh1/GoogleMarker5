package gm;
/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - GoogleMap
 * */
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
public class GoogleMap {

	Image mapImage;
	double latitudeCenter;
	double longitudeCenter;
	int imageScale;
	int zoomLevel;
	String strURL;
	Category c;
	
	//Constructor for the Map
	GoogleMap() {
		
		//Intialize the variables
		latitudeCenter = 40.730543;
		longitudeCenter = -73.591663;
		imageScale = 1;
		zoomLevel = 7;
		

	
	}

	
	public Image getMap(String Category) throws Exception {
		
		
		//Create an instance of a Category
		Category c = new Category();
		
		//Change latitudeCenter and longitudeCenter to the Average based on the Category
		latitudeCenter = c.getAverageLatitude(Category);
		longitudeCenter = c.getAverageLongitude(Category);
		
		//Based on the Category change zoomLevel
		switch(Category)
		{
			case"Museum":
				zoomLevel = 13;
				break;
			case"Restaurant":
				zoomLevel = 14;
				break;
			case"Movie":
				zoomLevel = 12;
				break;
			case"Amusement":
			case"Gas":
				zoomLevel = 7;
			break;	
		}
		
		// start of url
		strURL = String.format("http://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=1024x1024", latitudeCenter, longitudeCenter, zoomLevel);
		
		
		// concatenate marker strings to strURL
		strURL += c.getMarker(Category);
		
		// finally concatenate the following to strURL
		strURL += "&sensor=false&scale=" + imageScale;

		// leave this print statement to print final url being used
		System.out.println(strURL);

		try {
			URL url = new URL(strURL);
			
			// read back png image data from Google 
			mapImage = ImageIO.read(url); 
		}
		catch (IOException ie) {
		}
		
		return mapImage;
	}
	

}
