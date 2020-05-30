import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;
class Main{
	
	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			boolean sw=false;
		while(n-->0){
			String str=in.next();
			int b=in.nextInt();
			int a=in.nextInt();
			sw=sw||(b>=2400&& a > b);
		}		
		System.out.println(sw?"YES":"NO");					  
	}
}
