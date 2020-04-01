package edu.neu.csye6200.inherit;

import java.util.ArrayList;

public class Kennel {
	private ArrayList<PetAnimal> petList = new ArrayList<PetAnimal>();
	public Kennel() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * Add a pet to out list
	 * @param pAnimal the pet to add
	 */
	public void add(PetAnimal pAnimal) {
		petList.add(pAnimal);
	}
	/**
	 * List all of the pets to the console
	 */
	public void list() {
		for (PetAnimal pet : petList) {
			System.out.println("Pet: " + pet);
		}
	}
	
	//A routine to perform some simple tests
	public void run() {
		add(new Dog("Fido"));// Add some pets
		add(new Dog("Thor"));
		add(new Dog("Fenja"));
		list();//list them out;
	}

	
	public static void main(String[] args) {
		Kennel ken1 = new Kennel();// Create the kennel object
		ken1.run();
	}

}
