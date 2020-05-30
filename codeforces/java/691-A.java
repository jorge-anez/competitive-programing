import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
//import java.util.TreeSet;

class Main{		
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
			in.next();
			String str=in.next();
			int f=0;
			for(int i=0;i<str.length();i++)
				if(str.charAt(i)=='0')
						f++;
			System.out.println(f<=1?"YES":"NO");
	}
	
}