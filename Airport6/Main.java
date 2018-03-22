import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
	//constructor
	public Main()
	{
	}
	
	//MAIN METHOD - collection of method calls to start the simulation. including 
	//multi-thread user input function to stop the while loop which runs the program
	//continously.
	public static void main(String[] args) 
	{
		//creating new configuration object
		Configuration c=new Configuration();
		//creating new sky object
		Sky sq=new Sky(c);
		
		//creating new ground object
		Ground gr=new Ground(c);
		//creating a new airport object
		Airport airport = new Airport(sq,gr);
		//creating new RandomAddPlanes object
		RandomAddPlanes ranAdd = new RandomAddPlanes(airport,sq,gr,c);
	
		//creating a new display object 
		Display display = new Display();
		
		//initialising buffereader to accept user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		//Welcome message & instructions
		System.out.println("***********************Welcome to Kai & BuildHope's Airport simulator*******************\n");
		System.out.println("This simulator simulates planes landing and take off in a 3 runway airport - \n");
		System.out.println("Small Medium & Large runway whose length  are 10,15, 20 respectively.\n");
		System.out.println("There are 3 different sizes of planes available - Small Medium & Large. Planes are\n");
		System.out.println("added, and their size chosen randomly, according to the parameter laid down by the user,\n");
		System.out.println("in order to model a real-live scenario. Planes are to be landed from the sky, and \n");
		System.out.println("take off from the ground. And when the planes in the sky runs out of fuel, it crashes\n");
		System.out.println("***************************************************************************************\n");
                System.out.println();
               
                //call method for user input
                c.getInput(br);
                
                //creating small runways
		for(int i=0;i<c.NumOfSmallRunways;i++)
		{
			airport.addRunwayToAirport(new Runway(1,c));
		}
		//creating medium runways
		for(int i=0;i<c.NumOfMediumRunways;i++)
		{
			airport.addRunwayToAirport(new Runway(2,c));
		}
		
		//creating large runways
		for(int i=0;i<c.NumOfLargeRunways;i++)
		{
			airport.addRunwayToAirport(new Runway(3,c));
		}
               
		System.out.println("\nSimulation will start in 3 seconds. Press Q-Enter within console to end simulation.\n");
		
		//looping statement to print out "tick"
		for(int y=0; y<3; y++)
		{
			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.print("Tick!");
		}
	
		System.out.println("\n\n***HERE WE GO !!!***\n\n\n");

	
		//starting the simulation !!!! press enter to invoke the concurrent thread and terminates the program.
		try 
		{	
			//veriable to keep track the iterations of the simulation
			int count=0;
			
			//initialising object for the concurrent thread to accept user input to break out the simulation
			Reader r = new Reader(br);
				//Endless while loop to continously run the simulation
			while (true)
			{				
				//time delay statement to make output viewable
				try
				{
					Thread.sleep(300);
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
				//Method call to add planes randomly to sky and ground
				
				
				//for each loop, increment planePosition by its speed
				airport.movePlanes();
				
				//check if any plane crashes.
				sq.PlaneCrash();
				
				//For each loop, to land plane and taking off plane
				airport.landLargePlane();
				airport.takeOffLargePlane();
				airport.landMediumPlane();
				airport.takeOffMediumPlane();
				airport.landSmallPlane();
				airport.takeOffSmallPlane();
				sq.FuelConsumption();
				
				
				//displaying runway, sky and ground			
				display.displayAirport(airport);
				System.out.println("***********Chief Airtraffic Controller Kai's Messageboard****************");
				System.out.println("");
                                System.out.println("S=small plane; M=medium plane; L=large plane; X=crashed plane;(Number)=Amount of Fuel");
				System.out.println("Number of planes in sky: "+sq.getSkyQueueSize()+"/"+c.maxsizeOfSkyQueue);
				System.out.println("Number of planes on ground: "+gr.getGroundQueueSize()+"/"+c.maxsizeOfGroundQueue);
                                System.out.println("Number of crashed planes:"+sq.getCrash());
				System.out.println("This is the "+count+" loop.");
				//System.out.println("The SkyGround random number is now "+ g);
				//System.out.println("The number of airplane random number is now "+ h);
				System.out.println("Please press Q-ENTER to stop the simuation.");
				System.out.println("");
				System.out.println("*************************************************************************");
				
				//print out 10 lines to space out each display
				int NUM_LINES = 10;
				for (int r1 = 0; r1 < NUM_LINES; r1++) 
				{	
					System.out.println();
				}
				count++;
			}
			
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	 
	}

}

//concurrent thread to capture the Q-Enter keyboard input to end the program
class Reader extends Thread 
{
	private BufferedReader br;
	
	public Reader(BufferedReader br ) 
	{ 
		this.br = br;
	}
	public void run() 
	{
		try 
		{	
			while( !br.readLine().equalsIgnoreCase("q"));
			br.close();
			System.out.println("****Simulation terminates here - Time to say goodbye to SOFT1001!!****");
			System.exit(0) ;
		}
		catch(Exception e)
		{
			
		}
	}
}





			
	