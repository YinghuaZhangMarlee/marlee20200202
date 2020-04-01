package Inheritance;

	public class PowerMeasure extends MeterA implements Meter  {
	protected double current = 1.0;
	protected double voltage = 12.0;
	
	public PowerMeasure(double current, double voltage) {
		System.out.println("PowerMeasure constructor(i,v) called.");
		this.current = current;
		this.voltage = voltage;
		System.out.println("Measure is: " + measure());
	}
	public double getResistivity() {
	return (voltage/current);
}
	public double getCurrent() {
	return current;
}

	@Override
	public double measure() {
	return voltage * current;
}
	public double calcProbeMeasure() {
		return current  * this.getProbeVal();
	}
}
	
