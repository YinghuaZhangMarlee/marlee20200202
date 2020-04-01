package edu.neu.csye6200.inherit;

public class Dog extends PetAnimal {
	
	
	/*
	 * Constructor - default name
	 */
	public Dog() {
		// TODO Auto-generated constructor stub
		inti();
		}
	
	private void inti() {
		// Do common stuff here
	}
	
	public Dog(String name) {
		setName(name);
		inti();
	}
	public void bark (int count) {
		for (int i =0; i < count; i++)
			bark();	}
	
//	public void bark (double age) {
//		for (int i =0; i < age; i++)
//			bark();	}
	// different date type can make the same method name
	void bark() {
		System.out.println("Bark");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetAnimal pet = new PetAnimal();
		
		pet.walk();//make my pet walk
		
		pet.setName("Fido");
		
		//private item is not available
		
		System.out.println("My pet is named "+ pet.getName() +
		
				" ID:" + pet.getId());
		
		Dog dog = new Dog("Thor");
		//dog.setName("Thor");
		
//		String ageStr = "8";
		//dog.setAge("8");//input using a string
		dog.setAge(8);//input using a int
//		dog.setAge(Integer.parseInt(ageStr));
		
		//dog.bark(5);
		
		System.out.println("My dog is named "+ dog.getName()+" ID:" + dog.getId());
	}

}
