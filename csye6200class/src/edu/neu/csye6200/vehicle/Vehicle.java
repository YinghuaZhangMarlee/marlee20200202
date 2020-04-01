package edu.neu.csye6200.vehicle;
/*
 * My Vehicle class
 * @author YiRen
 */
public class Vehicle {
	
	int year;
	String make;
	String model;
	int passengers;
	int fuelCap;
	double kpl;
	int id;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
		make = "Unk.";
		model = "-?-";
        passengers = 4;
		fuelCap = 10;
		kpl = 30.0;
		year = 2019;
		System.out.println("Vehicle constructed called.");		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getMakeModel() {
		return("Vehicle [" + make + ":" +model +"]");
	}
	public Vehicle (int year, String make, String model, int passengers, int fuelCap, double kpl) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.passengers = passengers;
		this.fuelCap = fuelCap;
		this.kpl = kpl;
		
	}
	/**
	 * Generate a formatted Vehicle string
	 * @return the formatted string
	 */
	public String toFormattedString() {
		return String.format(">>>%1$04d %2$10s %3$12s", year, make, model);
	}//%1$04d ��λǰ��������
//	 %:ռλ��;    
//
//    2$:�ڶ�������,��b    
//
//    10:������С���,������ ��ʶ*10����ʽ,���ûдĬ�����Ϊ�ո�,���Ϊ"-",���ұ�Ϊ�ո�  
//
//     s:ת����,��ʾ��������
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public int getFuelCap() {
		return fuelCap;
	}
	public void setFuelCap(int fuelCap) {
		this.fuelCap = fuelCap;
	}
	public double getKpl() {
		return kpl;
	}
	public void setKpl(double kpl) {
		this.kpl = kpl;
	}
	public int getId() {
		return id;
	}

	/**
	 * 
	 */
	//public String toString(){
		//return "Vehicle [make =" + make +", model =" +model +", pass=" + passengers + ", fuelCap=" + fuelCap +", kpl= " + kpl +"]";
		//}
}
