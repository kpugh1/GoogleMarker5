package gm;
/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - GoogleMarker
 * */
public class GoogleMarker {
	
	// will need instance variables to store latitude, longitude, color, label (name), category
	private double latitude;
	private double longitude;

	private String color;
	
	private char labelName;
	

	// will need appropriate parameterized constructor, accessors and mutators
	public GoogleMarker(double lat, double longi, String category)
	{
		this.latitude = lat;
		this.longitude = longi;
		setColorAndLable(category);
		
		
	}
	
	//Based on the Category assign the color and label of the marker
	public void setColorAndLable(String c)
	{
		switch(c)
		{
		case"Museum":
			this.color = "red";
			this.labelName = 'M';
			break;
		case"Amusement":
			this.color = "purple";
			this.labelName = 'A';
			break;
		case"Gas":
			this.color = "green";
			this.labelName = 'G';
			break;
		case"Restaurant":
			this.color = "black";
			this.labelName = 'R';
			break;
		case"Movie":
			this.color = "yellow";
			this.labelName = 'T';
			break;
		default:
			this.color = "gray";
			this.labelName = '1';
			break;
		
		}
	}

	
	
	//Outputs the format of the location marker
	public String toString() { 
		String str = String.format("&markers=color:%s%%7Clabel:%c%%7C%.6f,%.6f", color, labelName,latitude,longitude);
		
		return str;
		
	}
	

}
