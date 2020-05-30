import java.util.*;
import java.io.*;
class Main {
	public static List<Integer> G[];
	public static int V[];
	public static final int BLACK = 1;
	public static final int WHITE = 2;
	public static final int NO_VISITED = 0;
	public static boolean solve(int node, int color){
			V[node] = color;
			boolean c = true;
				for(int k = 0; k < G[node].size(); k++){
					int h = G[node].get(k);					
					if(V[h] == NO_VISITED)
						c = c && solve(h, color == BLACK?WHITE:BLACK);
					else
					if(color == WHITE &&  V[h] == WHITE)
						return false;
					if(color == BLACK && V[h] == BLACK)
						return false;					
				}
			return c;
	}
	public static void main(String []arg)throws IOException{
		InputReader in = new InputReader(System.in);	
		//Scanner in = new Scanner(System.in);		
		while(true){
			int n = in.nextInt();
			if(n == 0) break;
			int m = in.nextInt();
			G = new ArrayList[n];
			V = new int[n + 1];
			for(int k = 0; k < n; k++)
				G[k] = new ArrayList<>();			
			for(int k = 0; k < m; k++){
				int i = in.nextInt();
				int j = in.nextInt();
				G[i].add(j);
				G[j].add(i);
			}
			System.out.println(solve(0,BLACK)?"BICOLORABLE.":"NOT BICOLORABLE.");
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