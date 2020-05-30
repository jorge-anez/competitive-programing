import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
import java.util.TreeSet;

class Main{		
	static String s1="I hate";
	static String s2="I love";
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
		StringBuffer buff=new StringBuffer();
		
		buff.append(s1);
		int n=in.nextInt();
		for(int j=2;j<=n;j++)
				if(j%2==0)
					buff.append(" that "+s2);
				else
					buff.append(" that "+s1);
		buff.append(" it");
			System.out.println(buff.toString());
			
	}
}