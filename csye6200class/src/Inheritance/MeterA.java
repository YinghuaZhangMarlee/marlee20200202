package Inheritance;

	public abstract class MeterA {
		
	private double probeVal = 12.3;
	
	public MeterA() {
		
	}
	public double getProbeVal() {
		
	return probeVal;
}
	final public double getSpecial() {
		return probeVal * 3.1459;
	}
	
	public abstract double calcProbeMeasure();//Must have this!!
}
