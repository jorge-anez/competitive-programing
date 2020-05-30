import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;

class Main{	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			long s=in.nextLong();
			int dis=0;
		while(n-->0){
				String sig=in.next();
				if(sig.equals("+"))
					s+=in.nextInt();
				else{
					int p=in.nextInt();
					if(s-p>=0){
						s-=p;
					}
					else dis++;
				}
		}		
		System.out.println(s+" "+dis);					  
	}
}
