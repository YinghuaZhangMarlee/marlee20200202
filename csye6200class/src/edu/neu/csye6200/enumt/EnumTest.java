package edu.neu.csye6200.enumt;

public class EnumTest {

	enum WeekDay {SUNDAY(0), MONDAY(10),TUESDAY(20),WEDNESDAY(30),
				THURSDAY(40),FRIDAY(50), SATURDAY(60);
		
				private int value;
					
				//constructor
				WeekDay(int n){
					value= n;
				}
					
				public void setValue(int value) {this.value= value;}
				public int getValue() {return value;}
					
				}
	
	private WeekDay currDay = WeekDay.TUESDAY;
	
	//Constructor
	public EnumTest() {
		System.out.println("Current Day is "+ currDay);
		
		setCurrDay(WeekDay.THURSDAY);
		setCurrDay(WeekDay.FRIDAY);
		setCurrDay("WEDNESDAY");
		
		WeekDay days[] = WeekDay.values();
		for (WeekDay d:days) {
			System.out.println("Current Day is "+ d.name()
							+ " ordinal :"+ d.ordinal()
							+" value :"+ d.getValue());
	
		}
		
	}
	
	
	
	public WeekDay getCurrDay() {
		return currDay;
	}

	public void setCurrDay(WeekDay currDay) {
		this.currDay = currDay;
		System.out.println("Current Day is "+ currDay.name()
							+ " ordinal :"+ currDay.ordinal()
							+" value :"+ currDay.getValue());
	}


	
	public void setCurrDay(String dayStr) {
		currDay = WeekDay.valueOf(dayStr);
		System.out.println("Current Day is "+ currDay.name()
		+ " ordinal :"+ currDay.ordinal()
		+" value :"+ currDay.getValue());
	}

	public static void main(String[] args) {
		new EnumTest();
	}
	
	
}
