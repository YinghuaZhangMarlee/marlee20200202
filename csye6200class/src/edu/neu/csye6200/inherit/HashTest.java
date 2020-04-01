package edu.neu.csye6200.inherit;

import java.util.HashMap;

public class HashTest {
	private HashMap<String, String> myMap = new HashMap<String, String>();
	
	public HashTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void list() {
		for(String objs: myMap.values()) {
			System.out.println("We have value: " +objs);
		}
	}
	private void run() {
		myMap.put("obj1", " This is Object 1");
		myMap.put("obj2", " This is Object 2");
		myMap.put("obj3", " This is Object 3");
		myMap.put("obj4", " This is Object 4");		
		myMap.put("obj5", " This is Object 5");
		
		if(myMap.containsKey("obj1"))
			System.out.println("We found obj1 " + myMap.get("obj1"));
		String removed = myMap.remove("obj3");//delete obj3
		System.out.println("We removed " + removed);
		list(); //list the values
		
	}

	
	
	public static void main(String[] args) {
		HashTest ht = new HashTest();
		ht.run();
	}

}
