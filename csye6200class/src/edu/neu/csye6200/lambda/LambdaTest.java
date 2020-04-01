package edu.neu.csye6200.lambda;

public class LambdaTest {

	public interface MyParamValue{
		public double getVal(double v);
		
	}
	public LambdaTest() {
		
		//Anonymous Inner
		MyParamValue mpv2 = new MyParamValue() {

			@Override
			public double getVal(double v) {
				return 30*v ;
			}
			
		};
		System.out.println("The anonymous inner value is"+ mpv2.getVal(2.0));
		
		//Lambda
		MyParamValue mpv1 = (v)-> 30*v;
		System.out.println("The lambda  value is"+ mpv1.getVal(2.0));
		
		mpv1= (n)-> {return 20.0 *n;};
		System.out.println("The lambda  value is"+ mpv1.getVal(2.0));
		
	}
	
	public static void main(String[] args) {

		new LambdaTest();
		}
	}


