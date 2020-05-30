import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
class Main{
	
	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int h=in.nextInt();
		int V[]=new int[n];
		for(int i=0;i<n;i++)
			V[i]=in.nextInt();
		Arrays.sort(V);
		int s=0;
		for(int e:V){
			if(e<=h){				 
				 s++;
			}			 
			else{				
					s+=2;
			}
		}
		System.out.println(s);
			  
	}
}
