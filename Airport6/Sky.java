import java.util.*;

/*
 *  modifier:   private, public, protected (inheritance)
 *  If a variable or a method is declared as 'private', this method/variable can only 
 *  be accessed from other variables/methods that are within the same class.
 *  
 *  If a variable or a method is declared as 'public', it can be accessed by other class 
 */
public class Sky {
	
	private ArrayList<Plane> skyQueue;
	private int maxsize;
	//creating a counter stores the number of crashed planes
	private int crash=0;
	
	//Sky class constructor
	public Sky(Configuration c)
	{
		skyQueue=new ArrayList<Plane>();
		maxsize=c.maxsizeOfSkyQueue;
	}
	
	public void setSkyQueue(ArrayList<Plane> skyQueue) 
	{
		this.skyQueue = skyQueue;
	}
	
	
	/*
	 *  test case:  
	 *    Get the ArrayList (skyQueue) and loop the list. In the loop,
	 *    retrieve each of the Plane object from the list and print 
	 *    out the plane object information on the screen
	 */
	//method to return SkyQueue arraylist
	public ArrayList<Plane> getSkyQueue()
	{
		return skyQueue;
	}
	
	public int getCrash()
	{
		return crash;
	}
	
	//method to choose a small plane that has least fuel amount
	public Plane chooseSmallPlane() 
	{  	
		if(skyQueue !=null) 
		{	
			//Local varaiable PlaneWithLeastFuel
			Plane PlaneWithLeastFuel=new Plane(2,new Configuration());
			
			//For loop to extract all plane objects in SkyQueue
			for(Plane b : skyQueue) 
			{
				//If the plane object has lesser fuel than PlaneWithLeastFuel 
				if(b.getsize()==1&&b.getamtFuel()<PlaneWithLeastFuel.getamtFuel()&&b.getamtFuel()>0) 
				{
					//Assignment the plane to PlaneWithLeastFuel
					PlaneWithLeastFuel=b;
				}
			}
			
			//return the plane object with appropriate size  
			if(PlaneWithLeastFuel.getsize()==1)
			{return PlaneWithLeastFuel;}
			else
			{return null;}
		}	
		//If SkyQueue is null for some reason, print out error message and return null to the calling object
		else 
		{
			return null; 
		}
	}
	
	//method to choose a medium plane that has least fuel amount
	public Plane chooseMediumPlane() 
	{  	
		if(skyQueue !=null) 
		{	
			//Local varaiable PlaneWithLeastFuel
			Plane PlaneWithLeastFuel=new Plane(3,new Configuration());
			
			//For loop to extract all plane objects in SkyQueue
			for(Plane b : skyQueue) 
			{
				//If the plane object has lesser fuel than PlaneWithLeastFuel 
				if(b.getsize()==2&&b.getamtFuel()<PlaneWithLeastFuel.getamtFuel()&&b.getamtFuel()>0) 
				{
					//Assignment the plane to PlaneWithLeastFuel
					PlaneWithLeastFuel=b;
				}
			}
			
			//return the plane object with appropriate size  
			if(PlaneWithLeastFuel.getsize()==2)
			{return PlaneWithLeastFuel;}
			else
			{return null;}
		}	
		//If SkyQueue is null for some reason, print out error message and return null to the calling object
		else 
		{
			return null; 
		}
	}
	
	//method to choose a large plane that has least fuel amount
	public Plane chooseLargePlane() 
	{  	
		if(skyQueue !=null) 
		{	
			//Local varaiable PlaneWithLeastFuel
			Plane PlaneWithLeastFuel=new Plane(1,new Configuration());
			
			//For loop to extract all plane objects in SkyQueue
			for(Plane b : skyQueue) 
			{
				//skip this plane if it is crashed.
				if(b.getamtFuel()<=0)
				{continue;}
				//If the plane object has lesser fuel than PlaneWithLeastFuel 
				if(b.getsize()==3&&b.getamtFuel()<PlaneWithLeastFuel.getamtFuel()&&b.getamtFuel()>0) 
				{
					//Assignment the plane to PlaneWithLeastFuel
					PlaneWithLeastFuel=b;
				}
			}
			
			//return the plane object with appropriate size  
			if(PlaneWithLeastFuel.getsize()==3)
			{return PlaneWithLeastFuel;}
			else
			{return null;}
		}	
		//If SkyQueue is null for some reason, print out error message and return null to the calling object
		else 
		{
			return null; 
		}
	}
	
	// method to remove plane objects from arraylist
	public void removePlane(Plane plane) {
		if(skyQueue != null)
			skyQueue.remove(plane);
	}
	
	//method to add plane ojbects to arraylist 
	public void addPlane(Plane plane)
	{
		if(skyQueue != null&&skyQueue.size()<maxsize)
			skyQueue.add(plane);
	}
	
	public int getSkyQueueSize()
	{
		int a=0;
		a=skyQueue.size();
		return a;
	}
	
	public void FuelConsumption()
	{
		if(skyQueue.size()>0)
		{
			for(Plane a:skyQueue)
			{
				a.setamtFuel(a.getamtFuel()-a.getrateFuelConsumption());
			}
		}
	}
	
	public void PlaneCrash()
	{
		if(skyQueue.size()>0)
		{
			for(int i=0;i<skyQueue.size();i++)
			{
				Plane b=skyQueue.get(i);
				//clean when the plane has been crashed for 2 loops.
				if(b.getamtFuel()<0-2*b.getrateFuelConsumption())
				{
					skyQueue.remove(b);
					crash+=1;
				}
			}
		}
	}
	
}