import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Main{
	
public static void main(String arg[])throws IOException{
	StringBuffer buf=new StringBuffer();
	int n,k;
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));	
	n=Integer.parseInt(in.readLine());	
	
	for(int i=1;i<=1000;i++)
		buf.append(i+"");
	System.out.println(buf.charAt(n-1));
}
}