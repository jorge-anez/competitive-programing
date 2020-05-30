import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
import java.util.TreeSet;
import java.util.HashSet;

class Main{
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
			int n=in.nextInt();
			int c=in.nextInt();
			int XX[] = int [n+1];			
			HashSet<Integer> set=new HashSet();
			for(int j=1;j<=n;j++)
				XX[j]=in.nextInt();
			for(int j=1;j<=c;j++)
				set.add(in.nextInt());
			
			long s=0;
			for(i=1;i<=n;i++){
				 s+=XX[i-1]*XX[i];				 
			}
			s+=XX[n]*XX[1];
						
						
			System.out.println(s);			
	}	
}