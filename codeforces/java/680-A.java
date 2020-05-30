import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;
class Main{
	
	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		int V[]=new int[200000];
		int F[]=new int[200];
		int n,i=0;
		int s=0;
		while(in.hasNext()){
			V[i]=in.nextInt();
			if(F[V[i]]<3)
				F[V[i]]++;
			s+=V[i];
			i++;			
		}
		n=i;
		//Arrays.sort(V,0,n);
		//System.out.println(n);
		int max=0;
		for(int j=0;j<110;j++){
			if((F[j] == 3 || F[j] == 2) && F[j]*j > max){
					max=F[j]*j;
			}					
		}
		System.out.println(s-max);					  
	}
}
