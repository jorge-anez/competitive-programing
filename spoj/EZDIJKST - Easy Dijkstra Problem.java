import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
class Main{
	public static final int INF = Integer.MAX_VALUE;
	public static final int MAX_NODES = 10010;
	public static int dist[] = new int [MAX_NODES];
	public static List<Pair> G[] = new List[MAX_NODES];
	
	public static void init(int n){
		for(int i = 1; i <= n; i++){
			dist[i] = INF;
			G[i] = new ArrayList<>();
		}
	}
	public static void dijkstra(int from) {
		dist[from] = 0;
		Queue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(from, 0));
		while (!pq.isEmpty()) { // main loop
			Pair front = pq.poll(); // greedy: get shortest unvisited vertex
			int u = front.first;
			int d = front.second;
			if (d > dist[u])
				continue; // this is a very important check
			for (Pair v : G[u]) {
				//ii v = AdjList[u][j]; // all outgoing edges from u
				if (dist[u] + v.second < dist[v.first]) {
					dist[v.first] = dist[u] + v.second; // relax operation
					pq.add(new Pair(v.first, dist[v.first]));
				}
			} 
		}
	}
	public static void main(String arg[]) throws IOException{
		InputReader in = new InputReader(System.in);
		int K = in.nextInt();
		while(K-- > 0){
			int vertexs = in.nextInt();
			int edges = in.nextInt();
			init(vertexs);
			for(int k = 0; k < edges; k++){
				int i = in.nextInt();
				int j = in.nextInt();
				int w = in.nextInt();
				G[i].add(new Pair(j, w));
			}
			int from = in.nextInt();
			int to = in.nextInt();
			dijkstra(from);
			System.out.println(dist[to] == INF? "NO": dist[to]);
		}
	}
	static class Pair implements Comparable<Pair>{
		public int first, second;
		Pair() {}
		Pair(int first, int second) {
			this.first = first;
			this.second = second;		
		}
		public int compareTo(Pair other){
			return second - other.second;
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