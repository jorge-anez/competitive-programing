import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
class Main{
	
	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int t=in.nextInt();
		int total=n*n/2;
		
		int s=0;
		int i=1;
		while(i*(i+1)/2 < t){			
			i++;			
		}
		i--;
		int v=i*(i+1)/2;
		int r=t%v+v;		
		System.out.println(r);
			  
	}
}
