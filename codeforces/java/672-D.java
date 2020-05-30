import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Comparator;
class Main{
public static void main(String arg[])throws IOException{
	
	int n,k;
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer token=new StringTokenizer(in.readLine());
	n=Integer.parseInt(token.nextToken());
	k=Integer.parseInt(token.nextToken());	
	token=new StringTokenizer(in.readLine());
	TreeSet<Integer> S=new TreeSet<>(new Comparator<Integer>(){
		public int compare(Integer a , Integer b){
			return a!=b?a-b:-1;
		}
	});	
	int v[]=new int[n];
	for(int i=0;i<n;i++)
		v[i]=Integer.parseInt(token.nextToken());
	Arrays.sort(v);
	
	//System.out.println(S);	
	
	//System.out.println(S.last()-S.first());	
}
}