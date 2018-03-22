import java.io.*;

//this class stores the data from user input for configuration.
public class Configuration 
{
	//configuration of plane
	public int amtFuelOfSmallPlane;
	public int RateConsumptionOfSmallPlane;
	public int SpeedOnRunwayOfSmallPlane;
	
	public int amtFuelOfMediumPlane;
	public int RateConsumptionOfMediumPlane;
	public int SpeedOnRunwayOfMediumPlane;
	
	public int amtFuelOfLargePlane;
	public int RateConsumptionOfLargePlane;
	public int SpeedOnRunwayOfLargePlane;
	
	//configuration of runways
	public int NumOfSmallRunways;
	public int lengthOfSmallRunways;
	
	public int NumOfMediumRunways;
	public int lengthOfMediumRunways;
	
	public int NumOfLargeRunways;
	public int lengthOfLargeRunways;
	
	//configuration of sky and ground
	public int maxsizeOfSkyQueue;
	public int maxsizeOfGroundQueue;
	
	//plane arriving time interval
	public int planeArriveInterval;
	
	//number of planes per each interval parameter
	public int numOfPlanesPerInterval;
	
	public Configuration()
	{
		amtFuelOfSmallPlane=30;
		RateConsumptionOfSmallPlane=1;
		SpeedOnRunwayOfSmallPlane=3;
		
		amtFuelOfMediumPlane=45;
		RateConsumptionOfMediumPlane=2;
		SpeedOnRunwayOfMediumPlane=2;
		
		amtFuelOfLargePlane=60;
		RateConsumptionOfLargePlane=3;
		SpeedOnRunwayOfLargePlane=1;
		
		//configuration of runways
		NumOfSmallRunways=2;
		lengthOfSmallRunways=10;
		
		NumOfMediumRunways=2;
		lengthOfMediumRunways=15;
		
		NumOfLargeRunways=2;
		lengthOfLargeRunways=20;
		
		//configuration of sky and ground
		maxsizeOfSkyQueue=100;
		maxsizeOfGroundQueue=100;
		
		//plane arriving time interval
		planeArriveInterval=200;   
		
		//number of planes per each interval parameter
		numOfPlanesPerInterval=5;
	}
	
	//getNumberOfPlanesPerInterval - prompt user to enter the number of planes that they want
	//to have arriving to either ground or sky in a given period of time
	public void getNumberOfPlanesPerInterval(BufferedReader br) 
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer =0;
		
		//do while statement loops over until a valid input from the user is received.
		do 
		{
			//system prompt for user to enter number of planes arrving per each interval
			System.out.println("\nMaximum Number of planes arriving per each interval");
			System.out.println("(Maximum number of planes generated in simulation would be between 0 ~ Number entered-1)");
			System.out.println("Please enter a integer now: ");
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				answer = Integer.parseInt(br.readLine());
				break;  
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only.Please try again !! ");
			}
			
		} while(true);
		
		//setting numOfPlanesPerInterval variable to the value input by the user
		setNumOfPlanesPerInterval(answer);
	}
	
	//getPlaneArriveInterval - prompt user to enter the interval for planes arriving and taking off
	public void getPlaneArriveInterval(BufferedReader br1)
	{
		//int variable to store user's response
		int answer = 0;
		
		//do while statement loops over until a valid input from the user is received.
		do {
			//system prompt for user to enter number of planes arrving per each interval
			System.out.println("\nPlease enter the time delay prameter in MILLISECOND:\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				answer = Integer.parseInt(br1.readLine());
				break;  
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
			
		} while(true);
		
		//setting variable to the value input by the user
		setPlanesArriveInterval(answer);	
	}
	
	//getPlanesFuelAmnt method - prompt user to enter the fuel amount for all 3 types of planes
	public void getPlanesFuelAmnt(BufferedReader br1)
	{
		//int variables to store user's response
		int answer1=0;
		int answer2=0;
		int answer3=0;
		
		//do while statement to get user to input valid fuel amount for small planes 
		do	     		
		{	
			//system prompt for user to enter number of planes arrving per each interval
			System.out.println("\nPlease enter fuel amount for small planes in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				answer1 = Integer.parseInt(br1.readLine());
				break;
				
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//do while statement to get user to input valid fuel amount for medium planes
		do
		{	
			System.out.println("\nPlease enter fuel amount for medium planes in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				answer2 = Integer.parseInt(br1.readLine());
				break;
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		
		//do while statement to get user to input valid fuel amount for large planes
		do
		{
			System.out.println("\nPlease enter fuel amount for large planes in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				answer3 = Integer.parseInt(br1.readLine());
				break;
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//method calls to set the fuel amount variable for all types of planes
		setSmallPlaneFuelAmnt(answer1);
		setMediumPlaneFuelAmnt(answer2);
		setLargePlaneFuelAmnt(answer3);
	}
	
	//setNumOfPlanesPerInterval method - setting the numOfPlanesPerInterval variable
	public void setNumOfPlanesPerInterval(int r)
	{
		numOfPlanesPerInterval=r;
	}
	
	//returnNumOfPlanesPerInterval method - returns the value of numOfPlanesPerInterval
	public int returnNumOfPlanesPerInterval()
	{
		return numOfPlanesPerInterval;
	}
	
	//setplanesArriveInterval method -  set the value for planeArriveInterval variable
	public void setPlanesArriveInterval(int r)
	{
		planeArriveInterval=r;
	}
	
	//returnPlanesArriveInterval method - returns the value of planeArriveInterval
	public int returnPlanesArriveInterval()
	{
		return planeArriveInterval;
	}
	
	//setSmallPlaneFuelAmnt method - sets the value for amtFuelOfSmallPlane variable
	public void setSmallPlaneFuelAmnt(int r)
	{
		amtFuelOfSmallPlane=r;
	}
	
	//setMediumPlaneFuelAmnt method - sets the value for amtFuelOfMediumPlane variable
	public void setMediumPlaneFuelAmnt(int r)
	{
		amtFuelOfMediumPlane=r;
	}
	
	//setLargePlaneFuelAmnt method - sets the value for amtFuelOfLargePlane variable
	public void setLargePlaneFuelAmnt(int r)
	{
		amtFuelOfLargePlane=r;
	}
	
	public void getRunways(BufferedReader br1)
	{	
		//do while statement to get user to input valid number of small runways
		do	     		
		{	
			//system prompt for user to enter the number of small runways
			System.out.println("\nPlease enter the number of small runways in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				NumOfSmallRunways = Integer.parseInt(br1.readLine());
				break;
				
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//do while statement to get user to input valid length for small runways
		do	     		
		{	
			//system prompt for user to enter the length of small runway
			System.out.println("\nPlease enter the length of small runway in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				lengthOfSmallRunways = Integer.parseInt(br1.readLine());
				break;
				
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//do while statement to get user to input valid number of medium runways
		do	     		
		{	
			//system prompt for user to enter the number of medium runways
			System.out.println("\nPlease enter the number of medium runways in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				NumOfMediumRunways = Integer.parseInt(br1.readLine());
				break;
				
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//do while statement to get user to input valid length of medium runways
		do
		{	
			System.out.println("\nPlease enter the length of medium runway in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				lengthOfMediumRunways = Integer.parseInt(br1.readLine());
				break;
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//do while statement to get user to input valid number of large runways
		do	     		
		{	
			//system prompt for user to enter the number of large runways
			System.out.println("\nPlease enter the number of large runways in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				NumOfLargeRunways = Integer.parseInt(br1.readLine());
				break;
				
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
		
		//do while statement to get user to input valid length of large runways
		do
		{
			System.out.println("\nPlease enter the length of large runway in integer format\n" );
			
			//statement to read user's input, break when a valid input is receive
			try 
			{
				//getting the int from keyboard
				lengthOfLargeRunways = Integer.parseInt(br1.readLine());
				break;
			}
			catch(Exception e) 
			{
				//error message if a non integer input is encountered 
				System.out.println("Integer input only. Please try again !! ");
			}
		}while(true);
	}
	
	public void getInput(BufferedReader br) 
	{
		do
		{    
			System.out.println();
			System.out.println("Please choose from the following :");
			System.out.println("A. Enter 1 to customise plane setting only");
			System.out.println("B. Enter 2 to customise plane settings only");
			System.out.println("C. Enter 3 to customise both plane and runway settings");
			System.out.println("C. Enter 0 to load the default settings..........");
			System.out.println();
			try
			{
				int customize = Integer.parseInt(br.readLine());
				
				if (customize==1)
				{
					//Method calls to get the simulation parameter from the user
					getNumberOfPlanesPerInterval(br);
					getPlaneArriveInterval(br);
					getPlanesFuelAmnt(br);
					break;
				}
				if (customize==2)
				{
					getRunways(br);
					break;
				}
				if (customize==3)
				{
					getNumberOfPlanesPerInterval(br);
					getPlaneArriveInterval(br);
					getPlanesFuelAmnt(br);
					getRunways(br);
					break;
				}
				if (customize==0)
				{
					break;
				}
				else
				{
					System.out.println("Come on!It's not that hard, try again!");
				}
			}
			
			catch(Exception e) 
			{
				System.out.println("Integer only, please try again!");
			}
		}while(true);
	}
	
}
