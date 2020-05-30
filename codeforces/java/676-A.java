import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
 class Main{
	
	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int V[]=new int[n+1];		
		for(int i=1;i<=n;++i)
			V[i]=in.nextInt();			
		int max=1;
		int min=1;		
		for(int i=2;i<=n;++i){		
			if(V[i]>V[max]){				
				max=i;
			}
			if(V[i]<V[min]){				
				min=i;
			}			
		}				
			int a,b; 
			a=Math.max(n-max,max-1);
			b=Math.max(n-min,min-1);					
			System.out.println(Math.max(a,b));
		
	}
}

