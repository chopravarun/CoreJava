package exp;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Test {
	public static void main(String[] args) throws InterruptedException {
		/*for(int k=1;k<=5;k++){
			for( int g=((13*k-k*k-12)/2)+1;g<=((13*(k+1))-((k+1)*(k+1))-12)/2;g++){
				if(g%2!=0){
					System.out.print('*');
				}else{
					System.out.print('#');
				}
			}
			System.out.println();
		}*/
		 for(int k=1;k<=5;k++){
			 for(int g=k;g<=5;g++){
				 if((((k==1 || k==2)) && (g)%2==0) || ((k==3 || k==4) && (g+1)%2==0)){
					 System.out.print("# ");
				 }else{
					 System.out.print("* ");
				 }
			 }
		 }
			   
				   
				 

		HashMap<String,String> t = new HashMap<String, String>();
		System.out.println(t.put("a","test"));
		System.out.println(t.put("a","done"));
		
		StringBuilder strb=  new StringBuilder("yo");
		
		HashMap<StringBuilder, String> ff= new HashMap<StringBuilder, String>();
		ff.put(strb,"man");
		System.out.println(strb.hashCode());
		strb.reverse();
		System.out.println(strb.hashCode());
		System.out.println("String vaue : "+ff.get(strb));
		
		
		String ss = "testvaruntesbatintest";
		Pattern p = Pattern.compile("test");
		Matcher m = p.matcher(ss);
		while(m.find())
			System.out.println(m.group());
		//System.out.println(m.group());
	}	
}