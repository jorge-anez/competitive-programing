import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
import java.util.TreeSet;

class Main{		
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
			int n=in.nextInt();
			int A=0,B=0,a=0,b=0;
			while(n-->0){
				A=in.nextInt();
				B=in.nextInt();
				if(A>B) a++;
				else if(B>A) b++;
			}
			System.out.println(a==b?"Friendship is magic!^^":a>b?"Mishka":"Chris");
			
	}
}