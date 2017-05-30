package gm;
/**
 * Kiana Pugh
 * Project 1
 * 
 * Class - LinkedQueue
 * */
public class LinkedQueue{
	
	//Inner Node Class
	private static class Node
	{
		private Location location;
		private Node next;
		
		//Node Constructor
		public Node(Location l,Node n)
		{
			this.location = l;
			this.next = n;
			
		}
		
		//Getters and Setters
		public Location getLocation()
		{
			return location;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node n)
		{
			next = n;
		}
		
		public void setLocation(Location l)
		{
			location = l;
		}
		

	}
	
	private Node tail;
	private Node head;
	private int size;
	
	//LinkedQueue constructor
	public LinkedQueue()
	{
		this.head = null;
		this.tail = null;
		size = 0;
		
	}
	
	//Add a Location into the List
	public void enqueue(Location l)
	{
		Node n;
		
		//if list is empty make point head and tail to same node
		// else add tail to new node 
		if(size == 0)
		{
			tail = new Node(l, null);
			head = tail;

		}
		else{
			n = new Node(l, null);
			tail.next = n;
			tail = tail.next;
		}
		size++;
	}
	
	//Remove data from List
	public Location dequeue() throws Exception 
	{
		Location l;
		
		//is List is Empty throw exception
		if(size == 0)
		{
			throw new Exception("The List is empty");
		}
		
		//remove from the head of the of the list 
		l = head.location;
		head = head.next;
		size--;
		return l;
	}
	
	
	//Calculates the Average of the latitude
	public double AverageLatitudes()
	{
		//create temp node for the head
		Node temp = head;
		
		double sum = 0;
		double averageLat;
		
		//while temp is not next add the latitudes up
		while(temp != null)
		{
			sum += temp.location.getLatitude();
			temp = temp.next;
		}
		
		//find average of the latitudes
		averageLat = sum / size;
		
		return averageLat;
	}
	
	//Calculates the Average of the Longitude
	public double AverageLongitude()
	{
		Node temp = head;
	
		double sum = 0;
		double averageLon = 0;
		
		//While temp is not null add the longitude sums
		while(temp != null)
		{
		
			sum += temp.location.getLongitude();
			temp = temp.next;
		
		}
		
		//Calculate the average of the sum
		averageLon = sum / this.size;
		
		return averageLon;
	}
	
	public Node getHead()
	{
		return head;
	}
	
	public Node getTail()
	{
		return tail;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	

}
