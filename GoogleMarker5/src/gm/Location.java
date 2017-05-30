package gm;
/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - Location
 * */
public class Location {
	private double longitude;
	private double latitude;
	private String category;
	private GoogleMarker gm;
	
	public Location(double la, double lo, String c)
	{
		this.latitude = la;
		this.longitude = lo;	
		this.category = c;
		
		gm = new GoogleMarker(la,lo,c);
	}
	
	public void setLocation(double la, double lo)
	{
		this.latitude = la;
		this.longitude = lo;
	}
	
	
	public void setCategory(String c)
	{
		this.category = c;
	}
	
	public double getLongitude()
	{
		return this.longitude;
	}
	
	public double getLatitude()
	{
		return this.latitude;
	}
	
	
	public String getCategory()
	{
		return this.category;
	}
	
	public String getMarker()
	{
		return gm.toString();
	}
	 
}
