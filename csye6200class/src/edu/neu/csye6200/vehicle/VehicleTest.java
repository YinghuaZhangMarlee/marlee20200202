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
	   if (quote.equalsIgnoreCase("Mars"))//�ж������ַ����Ƿ����
		   System.out.println("We have a planet!");
	   int starIndex = quote.indexOf("star");
//	   public int indexOf(int ch): ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1��
//
//	   public int indexOf(int ch, int fromIndex): ���ش� fromIndex λ�ÿ�ʼ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1��
//
//	   int indexOf(String str): ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1��
//
//	   int indexOf(String str, int fromIndex): ���ش� fromIndex λ�ÿ�ʼ����ָ���ַ����ַ����е�һ�γ��ִ���������������ַ�����û���������ַ����򷵻� -1
	   System.out.println("index of star: "+starIndex);
   }
}
