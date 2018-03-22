public class Plane
{
	private int size;
	private int amtFuel;
	private int rateFuelConsumption;
	private int speedOnRunway;

	public Plane(int a,Configuration c)
	{
		switch(a)
		{
			case 1:
				size=1;
				amtFuel=c.amtFuelOfSmallPlane;
				rateFuelConsumption=c.RateConsumptionOfSmallPlane;
				speedOnRunway=c.SpeedOnRunwayOfSmallPlane;
				break;

			case 2:
				size=2;
				amtFuel=c.amtFuelOfMediumPlane;
				rateFuelConsumption=c.RateConsumptionOfMediumPlane;
				speedOnRunway=c.SpeedOnRunwayOfMediumPlane;
				break;

			case 3:
				size=3;
				amtFuel=c.amtFuelOfLargePlane;
				rateFuelConsumption=c.RateConsumptionOfLargePlane;
				speedOnRunway=c.SpeedOnRunwayOfLargePlane;
				break;
		}
	}

	public int getsize()
	{
		return size;
	}
	
	public void FuelConsumption()
	{
		amtFuel=amtFuel-rateFuelConsumption;
	}

	public int getamtFuel()
	{
		return amtFuel;
	}
        
	public int getrateFuelConsumption()
	{
		return rateFuelConsumption;
	}

	public int getspeedOnRunway()
	{
		return speedOnRunway;
	}
	
        public void setamtFuel(int a)
        {
            amtFuel=a;
        }
}