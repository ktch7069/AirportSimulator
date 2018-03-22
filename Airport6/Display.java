/**
 * SOFT1001 Assignment 1 - Display class
 * 
 * @author Jianxi Li SID306005638
 * This class is created for actual display of airport runways with planes taking off and landing.
 */
import java.util.*;

public class Display
{
	//constructor has nothing as it does not manipulate any instant variable.
	public Display()
	{
	}
	
	//this method is for displaying a single runway status which is set as parameter.
	//the runway is shown as a line composed of "-".
	//the running plane is symbolized as its size(S for small, M for medium, L for large).
	public void displayRunway(Runway runway)
	{
		//it reads every position in runway.
		for(int i=0;i<runway.getlength();i++)
		{
			/*if the position is where the Plane locates,prints a capical letter
			 which stands for the plane according to their size.*/
			if(i==runway.getPlanePosition())
			{
				Plane p = runway.getinusedPlane();
				if(p== null) {
					System.out.print("-");
				}
				else{
					switch (p.getsize())
					{
						case 1:
							System.out.print("S");
							break;
						case 2:
							System.out.print("M");
							break;
						case 3:
							System.out.print("L");
							break;
					}
				}
			}
			//if the position is not where the plane locates, prints a "-" to represent the space.
			else
			{
				System.out.print("-");
			}
			
		}
		System.out.println("");
		System.out.println("Size: "+runway.getsize()+"  Length: "+runway.getlength()+"  Plane position: "+runway.getPlanePosition()+" Status: "+runway.getStatus());
		System.out.println("");
		System.out.println("");
	}
	
	//this method displays the planes in sky.
	public void displaySky(Sky sky)
	{
		ArrayList<Plane> SkyQueue=sky.getSkyQueue();
		System.out.println("Sky data scanning...");
		//System.out.print("(Sky)Size="+SkyQueue.size()+"  ");
		Plane a = null;
		for(int i = 0; i < SkyQueue.size();++i)
		{
			a = SkyQueue.get(i);
			//use a X to stand for a crashed plane whose fuel is lower than 0
			if(a.getamtFuel()<0)
			{
				System.out.print("X    ");
				continue;
			}
			switch (a.getsize())
			{
				case 1:
					System.out.print("S"+"("+a.getamtFuel()+")  ");
					break;
				case 2:
					System.out.print("M"+"("+a.getamtFuel()+")  ");
					break;
				case 3:
					System.out.print("L"+"("+a.getamtFuel()+")  ");
					break;
			}
		}
		System.out.println("");
		System.out.println("");
	}
	
	//this method displays the planes on ground.
	public void displayGround(Ground ground)
	{
		ArrayList<Plane> GroundQueue=ground.getGroundQueue();
		System.out.println("Ground data scanning...");
		
		//System.out.print("Size="+GroundQueue.size()+"  ");
		Plane a= null;
		for(int i = 0; i < GroundQueue.size();++i)
		{
			a = GroundQueue.get(i);

			switch (a.getsize())
			{
				case 1:
					System.out.print("S"+"("+a.getamtFuel()+")  ");
					break;
				case 2:
					System.out.print("M"+"("+a.getamtFuel()+")  ");
					break;
				case 3:
					System.out.print("L"+"("+a.getamtFuel()+")  ");
					break;
			}
		}
		System.out.println("");
		System.out.println("");
	}
	
	//this method displays the whole airport with all the runways and sky and ground.
	public void displayAirport(Airport airport)
	{	
		ArrayList<Runway> x=airport.getRunways();
		System.out.println("Runways display:");
		System.out.println();
		for(Runway r : x)
		{
			displayRunway(r);
		}
		
		displaySky(airport.getSky());
		displayGround(airport.getGround());
	}
	
	
}
