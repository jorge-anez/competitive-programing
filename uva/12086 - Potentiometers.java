import java.util.*;
import java.io.*;
class Main {
	public static int tree[] = new int[1000000];	
	public static void build(int node, int a, int b, int V[]){
		if(a == b){
			tree[node] = V[a];
		}
		else{
			int middle = (a + b) / 2;
			build(2*node, a, middle, V);
			build(2*node + 1, middle + 1, b, V);
			tree[node] = tree[2*node] + tree[2*node+1];
		}
	}
	public static void update(int node, int a, int b, int i,int val){
		if(i < a || i > b) return;
		if(a == b){
			tree[node] = val;			
		}else {		
			int middle = (a + b) / 2;
			update(2*node, a, middle, i,val);
			update(2*node + 1, middle + 1, b, i, val);
			tree[node] = tree[2*node] + tree[2*node+1];			
		}
	}
	public static int query(int node, int a, int b, int i,int j){
		if(j < a || b < i){
			return 0;
		}
		if(i <= a && b <= j )
			return tree[node];
		
		int middle = (a + b) / 2;
		int iz = query(2*node, a, middle, i, j);
		int der = query(2*node + 1, middle + 1, b, i, j);
			
		return iz + der;
	}	
	public static void main(String []arg) throws Exception{
		InputReader in = new InputReader(System.in);		 
		int N = 1;
		boolean sw = true;
		int n = in.nextInt();
		while(true){			
			int V[] = new int[n];
			for(int i = 0; i < n; i++){
				int x = in.nextInt();
				V[i] = x;
			}
			build(1, 0, n - 1, V);
			System.out.println(String.format("Case %d:", N)); N++;			
			while(true){
				String str = in.next();
				if(str.equals("END")) break;				
				int h = in.nextInt();
				int k = in.nextInt();
				if(str.equals("S"))
					update(1, 0, n - 1, h - 1, k);
				else {
					int q = query(1, 0, n - 1, h - 1, k - 1);
					System.out.println(q);
				}				
			}
			n = in.nextInt();
			if(n == 0)
				break;
			System.out.println();
			
		}
	}
	static class InputReader{
		BufferedReader in;
		StringTokenizer tokens;
		InputReader(InputStream in){
			this.in = new BufferedReader(new InputStreamReader(in), 2048);
		}
		String next() throws Exception{
			if(tokens == null || !tokens.hasMoreTokens())
				tokens = new StringTokenizer(in.readLine());
			return tokens.nextToken();
		}
		int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
	}
	
}