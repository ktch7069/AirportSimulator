/**
 * SOFT1001 Assignment 1 - AIRPORT CLASS 
 * 
 * @author Kai-Yin Tchung SID9505862
 * This is the airport class, also including is the main method which contains a integration 
 * test
 * 
 */
     
import java.util.*;

public class Airport
{
	//instance variable initialisation
	private ArrayList<Runway> runways;
	private Sky sky;
	private Ground ground;
	private int landed;
	private int takeOff;
	
	//airport constructor
	public Airport(Sky sky, Ground ground)
	{
		runways=new ArrayList<Runway>();
		this.sky = sky;
		this.ground=ground;
		landed=0;
		takeOff=0;
	}
	
	//METHODS
	//getRunwayMethod
	public ArrayList getRunways()
	{
		return runways;
	}
	
	//get sKyMethod
	public Sky getSky()
	{
		return sky;
	}
	
	//getGround method
	public Ground getGround()
	{
		return ground;
	}
	
	//addRunWayToAirport method
	public void addRunwayToAirport(Runway r)
	{
		runways.add(r);
	}
	
	//returnLanded returns the number of planes landed 
	public int returnLanded()
	{
		return landed;
	}
	
	//movePlanes calls moveplane method in runway class
	public void movePlanes()
	{
		for(Runway a:runways)
		{
			a.movePlane();
		}
	}
	
	//returnTakeOff returns the number of planes took off
	public int returnTakeOff()
	{
		return takeOff;
	}
	
	//landSmallPlane method - method gets the small plane with least fuel from sky object
	//and choses a runway of suitable size to land this plane
	public void landSmallPlane()
	{	
		//Extract SkyQueue to local arraylist variable 
		ArrayList<Plane> SkyQueue=sky.getSkyQueue();
		
		if(SkyQueue.size()==0)
		{return;}
		
		//Extract the small plane with least fuel to a local vairable
		Plane p = sky.chooseSmallPlane();
		
		//read out the objects in runway array list
		for(Runway runway : runways)
		{
			
			if (runway.getinusedPlane()==null&&p!=null)
			{
				//Allocating the plane to the first available 
				//runway with suitable size
				if(p.getsize()<=runway.getsize())
				{
					landed++;
					runway.setinusedPlane(p);
					runway.setPlanePosition(0);
					runway.setStatus("Landing");
					SkyQueue.remove(p);
					break;
				}
			}
		}
	}
	
	//landMediumPlane method - method gets the medium plane with least fuel from sky object
	//and choses a runway of suitable size to land this plane
	public void landMediumPlane()
	{	
		//Extract SkyQueue to local arraylist variable 
		ArrayList<Plane> SkyQueue=sky.getSkyQueue();
		
		if(SkyQueue.size()==0)
		{return;}
		
		//Extract the medium plane with least fuel to a local vairable
		Plane p = sky.chooseMediumPlane();
		
		//read out the objects in runway array list
		for(Runway runway : runways)
		{
			
			if (runway.getinusedPlane()==null&&p!=null)
			{
				//Allocating the plane to the first available 
				//runway with suitable size
				if(p.getsize()<=runway.getsize())
				{
					landed++;
					runway.setinusedPlane(p);
					runway.setPlanePosition(0);
					runway.setStatus("Landing");
					SkyQueue.remove(p);
					break;
				}
			}
		}
	}
	
	//landLargePlane method - method gets the large plane with least fuel from sky object
	//and choses a runway of suitable size to land this plane
	public void landLargePlane()
	{	
		//Extract SkyQueue to local arraylist variable 
		ArrayList<Plane> SkyQueue=sky.getSkyQueue();
		
		if(SkyQueue.size()==0)
		{return;}
		
		//Extract the large plane with least fuel to a local vairable
		Plane p = sky.chooseLargePlane();
		
		//read out the objects in runway array list
		for(Runway runway : runways)
		{
			if (runway.getinusedPlane()==null&&p!=null)
			{
				//Allocating the plane to the first available 
				//runway with suitable size
				if(p.getsize()<=runway.getsize())
				{
					landed++;
					runway.setinusedPlane(p);
					runway.setPlanePosition(0);
					runway.setStatus("Landing");
					SkyQueue.remove(p);
					break;
				}
			}
		}
	}
	
	
	
	
	//takeOffSmallPlane method- method returns the first avaiable small plane from ground
	//arraylist
	public void takeOffSmallPlane()
	{
		//Extract GroundQueue to a local arraylist variable
		ArrayList<Plane> GroundQueue=ground.getGroundQueue();
		
		if(GroundQueue.size()==0)
		{return;}
		
		//extract plane object from ground object
		Plane p = ground.chooseSmallPlane();
		
		//read out the objects in runway array list
		for(Runway runway : runways)
		{	
			//if p is not null - when there's still planes on ground to be taken off
			if(runway.getinusedPlane()==null&&p!=null)
			{	
				//Allocating the plane to first available suitable runway 
				if(p.getsize()<=runway.getsize())
				{
					takeOff++;
					runway.setinusedPlane(p);
					runway.setPlanePosition(0);
					runway.setStatus("Taking off");
					GroundQueue.remove(p);
					break;
				}
			}
		}
	}
	
	//takeOffMediumPlane method- method returns the first avaiable medium plane from ground
	//arraylist
	public void takeOffMediumPlane()
	{
		//Extract GroundQueue to a local arraylist variable
		ArrayList<Plane> GroundQueue=ground.getGroundQueue();
		
		if(GroundQueue.size()==0)
		{return;}
		
		//extract plane object from ground object
		Plane p = ground.chooseMediumPlane();
		
		//read out the objects in runway array list
		for(Runway runway : runways)
		{	
			//if p is not null - when there's still planes on ground to be taken off
			if(runway.getinusedPlane()==null&&p!=null)
			{	
				//Allocating the plane to first available suitable runway 
				if(p.getsize()<=runway.getsize())
				{
					takeOff++;
					runway.setinusedPlane(p);
					runway.setPlanePosition(0);
					runway.setStatus("Taking off");
					GroundQueue.remove(p);
					break;
				}
			}
		}
	}
	
	//takeOffLargePlane method- method returns the first avaiable large plane from ground
	//arraylist
	public void takeOffLargePlane()
	{
		//Extract GroundQueue to a local arraylist variable
		ArrayList<Plane> GroundQueue=ground.getGroundQueue();
		
		if(GroundQueue.size()==0)
		{return;}
		
		//extract plane object from ground object
		Plane p = ground.chooseLargePlane();
		
		//read out the objects in runway array list
		for(Runway runway : runways)
		{		
			//if p is not null - when there's still planes on ground to be taken off
			if(runway.getinusedPlane()==null&&p!=null)
			{	
				//Allocating the plane to first available suitable runway 
				if(p.getsize()<=runway.getsize())
				{
					takeOff++;
					runway.setinusedPlane(p);
					runway.setPlanePosition(0);
					runway.setStatus("Taking off");
					GroundQueue.remove(p);
					break;
				}
			}
		}
	}
}


