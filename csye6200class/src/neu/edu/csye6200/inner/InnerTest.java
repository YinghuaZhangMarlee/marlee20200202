package neu.edu.csye6200.inner;

public class InnerTest {
	
	private int key =20;//My secret key
	
	public class InnerProc{
		public String encode(String input) {
			StringBuffer sb = new StringBuffer();
			
			for(char c : input.toCharArray()) {
				char c2 = (char)(c^ key);//XOR
				sb.append(c2);
			}
				
			
			return sb.toString();
		}
	}
	
	//Constructor
	public InnerTest(int key) {
		this.key=key;//save my key
		
		InnerProc iproc= new InnerProc();//Created an encode Inner Class
		String str0= "My secret message 123";
		System.out.println("Str0: "+ str0);
		
		String str1= iproc.encode(str0);
		System.out.println("Str1: "+ str1);
		
		//this.key= 21; no right key(20) = no secret message
		
		
		String str2= iproc.encode(str1);
		System.out.println("Str2: "+ str2);
	}

	public static void main(String[] args) {

		new InnerTest(20);
	
		
		
	}

}
