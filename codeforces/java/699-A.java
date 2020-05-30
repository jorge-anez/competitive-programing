import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
import java.util.TreeSet;

class Main{		
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
			int n=in.nextInt();
			char V[]=in.next().toCharArray();
			TreeSet<Integer> s=new TreeSet<>();
			int  P[]=new int[n];
			for(int i=0;i<n;i++)
				P[i]=in.nextInt();
			
			for(int i=1;i<n;i++)
				if(V[i-1]=='R' && V[i]=='L'){
					int d=(P[i]-P[i-1])/2;
						s.add(d);						
				}
			if(!s.isEmpty())
				System.out.println(s.first());
			else 
				System.out.println("-1");			
	}
}