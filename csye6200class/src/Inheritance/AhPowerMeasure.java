package Inheritance;

public class AhPowerMeasure extends PowerMeasure {


	public AhPowerMeasure() {
		super(2.0, 4.0);
		System.out.println("AhPowerMeasure constructor called");
		// TODO Auto-generated constructor stub
	}

	public double getResistivity() {
		return (voltage/current)*2;
	}
}
