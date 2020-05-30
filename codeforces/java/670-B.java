import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Main{
public static void main(String arg[])throws IOException{
	
	long n,k;
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer token=new StringTokenizer(in.readLine());
	n=Integer.parseInt(token.nextToken());
	k=Integer.parseInt(token.nextToken());
	long m=1;
	
	/*
	m=(long)(0.5*Math.sqrt(8*k+1)-0.5);	
	if(m*(m+1)/2>=k)
		 m--;
	*/
	
	while(m*(m+1)<2*k)
		  m++;
	m--;
	
	 
	long s=m*(m+1)/2;	
	token=new StringTokenizer(in.readLine());
	long V[]=new long[(int)n];
	for(int i=0;i<n;i++)
		V[i]=Integer.parseInt(token.nextToken());
	long r=k-s-1;
	System.out.println(V[(int)((r<0?0:r)%n)]);
}
}


