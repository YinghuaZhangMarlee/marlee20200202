package edu.neu.csye6200.vehicle;

public class VehicleTest {

	public VehicleTest() {
		// TODO Auto-generated constructor stub
	}
   public static void main(String args[]) {
	   
	   Vehicle minivan = new Vehicle(2020, "Ford", "Aerostar", 8, 30, 40.0);

	   Vehicle sportscar = new Vehicle(2019, "Ford", "Mustang", 2, 20, 30.0);
	   sportscar.passengers = -2;
	   sportscar.setPassengers(-2);
	   //minivan.fuelCap = 30;
	   //minivan.kpl = 40.0;
	   //minivan.passengers = 8;
	   
	   //sportscar.fuelCap = 20;
	   //sportscar.kpl = 40.0;
	   //sportscar.passengers = 2;
	   
	   System.out.println("MiniVan " + minivan);
	   System.out.println("Sportsar " + sportscar);
	   System.out.println(minivan.toFormattedString());
	   System.out.println(sportscar.toFormattedString());
	   //String quote = "The universe is full of stars";
	   String quote = "mars";
	   int len = quote.length();//get the length of a string
	   if (quote.equalsIgnoreCase("Mars"))//判断两个字符串是否相等
		   System.out.println("We have a planet!");
	   int starIndex = quote.indexOf("star");
//	   public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
//
//	   public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
//
//	   int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
//
//	   int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
	   System.out.println("index of star: "+starIndex);
   }
}
