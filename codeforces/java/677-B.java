import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
class Main{	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int h=in.nextInt();
		int k=in.nextInt();		
		int V[]=new int[n];
		for(int i=0;i<n;i++){
			V[i]=in.nextInt();			
		}		
		long t=0;
		int i=0,j=0;
		long curr;		
		curr=0;		
		while(i<n){			
			j=i;
			while(i<n && curr+V[i]<=h){
				 curr+=V[i];
				 i++;
			}			
			t+=curr/k;
			if(i==j){
				if(curr>0)
					t++;
				curr=0;
			}else{
				curr=curr%k;
			}			
		}
		t+=curr/k;
		if(curr>0)
			t++;
		System.out.println(t);
			  
	}
}
