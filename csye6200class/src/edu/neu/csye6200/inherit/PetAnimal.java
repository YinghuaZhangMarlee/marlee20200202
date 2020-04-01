package edu.neu.csye6200.inherit;

public class PetAnimal {
	private String name = "";
	private int age = 1;
	private int id;//regular member variable
	private static int idCounter = 0;
	
	/*
	 * Constructor
	 */

	public PetAnimal() {
		// TODO Auto-generated constructor stub
		name = "unknown";
		id = idCounter++;//set the private ID, and then increment the counter
	}
	
	public int getId() {
		return id;
	}

	public void setAge(String ageStr) {
		setAge(Integer.valueOf(ageStr));
	}
	
	public int getAge() {
		return age;
	}

/*
 * A setter pattern for controlling the age
 */

	public void setAge(int age) {
		if (age<0) age =0;//no negative values
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	void walk() {
		System.out.println("We are walking");
	}
	public String toString() {
		return "My pet name is "+ name;
	}
}
