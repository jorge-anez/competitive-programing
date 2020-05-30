import java.util.*;
import java.io.*;

class Main{
	public static int V[];
	public static void init(int n){
		V = new int[n + 1];
		for(int i = 0;i < n; i++)
			V[i] = i;
	}
	public static int find(int i){
		if(V[i] != i)
			return find(V[i]);
		else
			return i;
	}
	public static void union(int i,int j){
		int a = find(i);
		int b = find(j);
		V[a] = b;
	}
	public static boolean isJoined(int i,int j){
		if(find(i) == find(j))
			return true;
		else 
			return false;
	}
	public static void main(String arg[]) throws IOException{		
		InputReader in = new InputReader(System.in);
		PriorityQueue<Data> q = new PriorityQueue<>();		
			int N = in.nextInt();
			int M = in.nextInt();
			init(N);
			int t = 0;
			for(int i = 0;i < M; i++){
				Data d = new Data();
				d.i = in.nextInt();
				d.j = in.nextInt();
				d.w = in.nextInt();
				q.add(d);
			}
			int s = 0;
			while(!q.isEmpty()){
				Data d = q.poll();
				if(!isJoined(d.i, d.j)){
					s += d.w;
					union(d.i, d.j);
				}
			}
			System.out.println(s);
		
	}
	static class Data implements Comparable<Data>{
		int i, j, w;
		public int compareTo(Data other){
			return w - other.w;
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