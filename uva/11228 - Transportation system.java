import java.util.*;

class Main{
	
	public static void init(int n, int V[]){		
		for(int i = 0;i < n; i++)
			V[i]=i;
	}
	public static int findSet(int i, int V[]){
		return V[i] == i?i:(V[i] = findSet(V[i], V));
	}
	public static void unionSet(int i,int j, int V[]){
		V[findSet(i, V)]=findSet(j, V);
	}
	public static boolean isSameSet(int i,int j, int V[]){
		return (findSet(i, V) == findSet(j, V));
	}
	public static void main(String arg[]){
		Scanner in = new Scanner(System.in);
		PriorityQueue<Data> q = new PriorityQueue<>();
		int T = in.nextInt();
		for(int k = 0; k <= T; k++){
			int n = in.nextInt();
			int r = in.nextInt();
			int R[] = new int[n];
			int F[] = new int[n];			
			init(n, R);
			init(n, F);
			int t = 0;
			Pair P[] = new Pair[n];
			
			for(int i = 0;i < n; i++){
				P[i] = new Pair();
				P[i].i = in.nextInt();
				P[i].j = in.nextInt();
			}
			double f = 0;
			for(int i = 0;i < n; i++)
				for(int j = i + 1;j < n; j++){
					int x1, x2, y1, y2;
					x1 = P[i].i;
					x2 = P[j].i;
					y1 = P[i].j;
					y2 = P[j].j;
					double R = Math.sqrt((x1 - x2)*(x1 - x2)+(y1 - y2)*(y1 - y2));
					if( R <= r){
						Data d = new Data();
						d.i = i;
						d.j = k;
						d.w = R;
						q.push(d);
					}
					else
						f += R;
				}
			int s = 0;
			while(!q.isEmpty()){
				Data d = q.poll();
				if(!isSameSet(d.i, d.j)){
					s += d.w;
					unionSet(d.i, d.j);
				}
			}
			System.out.println(t - s);
		}
	}
	static class Data implements Comparable<Data>{
		int i, j;
		double w;
		public int compareTo(Data other){
			return w - other.w;
		}
	}
	static class Pair {
		int i, j;
	}
}