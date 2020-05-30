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
	String str=in.readLine();
	int v[]=new int[26];
	for(int i=0;i<n;i++)
		v[str.charAt(i)-'a']++;
	int c=0;
	for(int i=0;i<26;i++)
		if(v[i]==0) 
			c++;
	int r=0;
	for(int i=0;i<26;i++)
		if(v[i]>0) 
		 r+=v[i]-1;
	System.out.println(r>c?"-1":r);
}
}