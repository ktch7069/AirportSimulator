import java.util.*;

public class Ground
{
	private ArrayList<Plane> GroundQueue;
	private int maxsize;
	
	public Ground(Configuration c)
	{
		GroundQueue=new ArrayList<Plane>();
		maxsize=c.maxsizeOfGroundQueue;
	}
	
	public ArrayList getGroundQueue()
	{
		return GroundQueue;
	}
	
	public Plane chooseSmallPlane() 
	{
		if(GroundQueue!=null)
		{
			for(Plane p:GroundQueue)
			{
				if(p.getsize()==1)
				{
					return p;
				}
			}
			
			return null;
		}
		
		else
			return null;
	}
	
	public Plane chooseMediumPlane() 
	{
		if(GroundQueue!=null)
		{
			for(Plane p:GroundQueue)
			{
				if(p.getsize()==2)
				{
					return p;
				}
			}
			
			return null;
		}
		
		else
			return null;
	}
	
	public Plane chooseLargePlane() 
	{
		if(GroundQueue!=null)
		{
			for(Plane p:GroundQueue)
			{
				if(p.getsize()==3)
				{
					return p;
				}
			}
			
			return null;
		}
		
		else
			return null;
	}
	
	public void removePlane(Plane plane)
	{
		if(GroundQueue!=null)
			GroundQueue.remove(plane);
	}
	
	public void addPlane(Plane plane)
	{
		if(GroundQueue!=null&&GroundQueue.size()<maxsize)
			GroundQueue.add(plane);
	}
	public int getGroundQueueSize()
	{
		int a=0;
		a=GroundQueue.size();
		return a;
		
	}
}