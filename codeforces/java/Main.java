import java.util.*;
public class Main{	
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		
		int n=in.nextInt();
		int a=in.nextInt();
		int b=in.nextInt();		
		b=b%n;
		int r;		
		if(b<0){
			b=Math.abs(b);
			r= a>b? a-b:b>a?n-(b-a):n;
		}else{
			r= a+b<=n?a+b:(a+b)-n;
		}	
		System.out.printf("%d\n", r);
	}
}