package Inheritance;

public class InheritTest {

	public InheritTest() {
		PowerMeasure pm0 = new PowerMeasure(2, 24);
		System.out.println("PowerMeasure resistivity: " + pm0.getResistivity());
		
		AhPowerMeasure apm0 = new AhPowerMeasure();
		System.out.println("AhPowerMeasure resistivity: " + apm0.getResistivity());
		
		displayMeter(pm0);
		MeterManager meterMgr = MeterManager.instance();

		
	}
	public void displayMeter(Meter meter) {
		System.out.println("Meter is: " + meter);
		System.out.println("Meter is: " + meter.getResistivity());
		MeterManager meterMga = MeterManager.instance();
//		meterMga.add(pm0);
//		meterMga.add(apm0);
	
	}
	public static void main(String[] args) {
		InheritTest inht = new InheritTest();
	}

}
