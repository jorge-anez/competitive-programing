import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;

class Main{	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
			int s=in.nextInt();
			int n=in.nextInt();
			String secuence[]=new String[100+10];
			int f[]=new int[100+10];
			for(int i=0;i<n;i++)
					secuence[i]=in.next();				
			if(!secuence[0].contains("0"))
				 f[0]=0;
			 else
				 f[0]=1;
			for(int i=1;i<n;i++)
				if(!secuence[i].contains("0")){
						f[i]=0;
				}					
				else
					f[i]+=f[i-1]+1;
			int max=f[0];
			for(int i=1;i<n;i++)
				max=Math.max(max,f[i]);
			System.out.println(max);					  
	}
}
