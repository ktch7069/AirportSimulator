import java.io.BufferedReader;
import java.util.Random;

public class RandomAddPlanes 
{
	private Airport ap1;
	private Sky sk1;
	private Ground gr1;
	private Configuration config;
	private Random ranSkyGround;
	private Random ranNumPlanes;
	
	//constructor
	public RandomAddPlanes(Airport ap1, Sky sk1,Ground gr1, Configuration config)
	{
		this.ap1=ap1;
		this.sk1=sk1;
		this.gr1=gr1;
		this.config=config;
		this.ranSkyGround = new Random();
		ranSkyGround.setSeed(120);
		this.ranNumPlanes = new Random();
		ranNumPlanes.setSeed(53);
	}
	
	public int getPlanesArriveInterval() 
	{
		return config.returnPlanesArriveInterval();
	}
	
	//generateSkyGroundRan returns a double rad for selecting type of plane randomly
	public double generateSkyGroundRan()
	{
		Random ran=new Random();
		double b=10*(ranSkyGround.nextDouble());
		return b;
	}
	
	//generateNumPlaneRan returns a double for selecting the number of planes randomly
	public double generateNumPlaneRan()
	{
		Random ran1=new Random();
		double e=config.returnNumOfPlanesPerInterval()*(ranNumPlanes.nextDouble());
		return e;
	}
	
	//addPlanesRandomly adds planes randomly to sky and ground using the two random numbers generated  
	public void addPlanesRandomly()
	{
		//System.out.println("\n\n\n\n*************************************\nADD PLANES RANDOMLY\n\n\n");
		//for loop to create multiple planes
		for(int q=0; q<generateNumPlaneRan(); q++) 
		{	
			
			try 
			{
				Thread.sleep(config.planeArriveInterval);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			//each loop generate a random number for selecting plane type and where they add to
			double ranAddPlanes=generateSkyGroundRan();
			
			// if ranAddPlanes variable is >5, adding plans to the sky
			if(ranAddPlanes>6) {
				//initialise a int variable as plane size indicator
				int a =0;
				
				//establishing value of a base on random value
				if (ranAddPlanes<=7.5)
					a=1;
				if (ranAddPlanes>7.5 && ranAddPlanes<=9)
					a=2;
				if(ranAddPlanes>9)
					a=3;
				
				//switch statement to choose the size of airplane
				switch(a)
				{
					case 1:
						sk1.addPlane(new Plane(1,config));
						break;
					case 2 :
						sk1.addPlane(new Plane(2,config));
						break;
					case 3: 
						sk1.addPlane(new Plane(3,config));
						break;
				}
			}	
			//adding plane to the ground if random number generated is <5
			else if (ranAddPlanes<=6 && ranAddPlanes>=2)
			{
				//initialise a int variable as plane size indicator
				int a =0;
				
				//establishing value of a base on random value
				if (ranAddPlanes>=2 && ranAddPlanes<=3.5)
					a=1;
				if (ranAddPlanes>3.5 && ranAddPlanes<=5)
					a=2;
				if(ranAddPlanes>5)
					a=3;
				
				//switch statement to choose the size of airplane
				switch(a)
				{
					case 1:		
						gr1.addPlane(new Plane(1,config));
						break;
					case 2 :
						gr1.addPlane(new Plane(2,config));
						break;
					case 3: 
						gr1.addPlane(new Plane(3,config));
						break;
				}	
			}	
			else if (ranAddPlanes<2)
			{
				//do nothing
			}		
		}
	}
}




