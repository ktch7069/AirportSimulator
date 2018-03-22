public class Runway
{
	private int length;
	private int size;
	private Plane inusedPlane;
	private int PlanePosition;
	private String Status;
	
	public Runway(int a, Configuration c)
	{
		size=a;
		inusedPlane=null;
		PlanePosition=0;
		Status="empty";
		switch(a)
		{
			case 1:
				length=c.lengthOfSmallRunways;
				break;
			case 2:
				length=c.lengthOfMediumRunways;
				break;
			case 3:
				length=c.lengthOfLargeRunways;
				break;
		}
		
	}
	
	public int getlength()
	{
		return length;
	}
	
	public int getsize()
	{
		return size;
	}
	
	public Plane getinusedPlane()
	{
		return inusedPlane;
	}
	
	public void setinusedPlane(Plane x)
	{
		inusedPlane=x;
	}
	
	public int getPlanePosition()
	{
		return PlanePosition;
	}
	
	public String getStatus()
	{
		return Status;
	}
	
	public void setPlanePosition(int a)
	{
		PlanePosition=a;
	}
	
	public void setStatus(String s)
	{
		Status=s;
	}
	
	public void movePlane()
	{	
		if(inusedPlane!=null)
		{
			if(PlanePosition<length)	
			{
				PlanePosition+=inusedPlane.getspeedOnRunway();	
			}
			else
			{
				inusedPlane=null;
				Status="empty";
			}
		}
	}
}