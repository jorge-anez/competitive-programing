import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
import java.util.TreeSet;

class Main{	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
			String secuence=in.next();							
			System.out.println(secuence+(new StringBuffer(secuence).reverse().toString()));	  
	}
}
