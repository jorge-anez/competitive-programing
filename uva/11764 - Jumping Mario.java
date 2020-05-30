import java.util.*;
import java.io.*;
class Main {	
	
	
	public static void main(String []arg)throws IOException{
		InputReader in = new InputReader(System.in);	
		int  k = in.nextInt();
		for(int i = 1; i <= k; i++){
			int n = in.nextInt();
			int V[] = new int[n];	
			int h = 0, l = 0;
			for(int j = 0; j < n; j++)
				V[j] = in.nextInt();			
			for(int j = 1; j < n; j++){
				if(V[j - 1] < V[j])
					h++;
				if(V[j - 1] > V[j])
					l++;
			}
			System.out.println(String.format("Case %d: %d %d", i, h, l));
		}		
	}
	static class InputReader{
		BufferedReader in;
		StringTokenizer tokens;		
		InputReader(InputStream in){
			this.in = new BufferedReader(new InputStreamReader(in), 2048);			
		}
		String next() throws IOException{
			if(tokens == null || !tokens.hasMoreTokens()){
				String str = in.readLine();
				if(str == null || str.equals(""))
					return null;
				tokens = new StringTokenizer(str);			
			}
			return tokens.nextToken();
		}
		int nextInt() throws IOException{			
			return Integer.parseInt(next());
		}		
	}
	
}