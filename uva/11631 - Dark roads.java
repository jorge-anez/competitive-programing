import java.util.*;

class Main{
	public static int V[];
	public static void init(int n){
		V = new int[n];
		for(int i = 0;i < n; i++)
			V[i]=i;
	}
	public static int findSet(int i){
		return V[i] == i?i:(V[i] = findSet(V[i]));
	}
	public static void unionSet(int i,int j){
		V[findSet(i)]=findSet(j);
	}
	public static boolean isSameSet(int i,int j){
		return (findSet(i) == findSet(j));
	}
	public static void main(String arg[]){		
		Scanner in = new Scanner(System.in);
		PriorityQueue<Data> q = new PriorityQueue<>();
		while(true){
			int n = in.nextInt();
			int m = in.nextInt();
			if(n + m == 0) break;
			init(n);
			int t = 0;
			for(int i = 0;i < m; i++){
				Data d = new Data();
				d.i = in.nextInt();
				d.j = in.nextInt();
				d.w = in.nextInt();
				t += d.w;
				q.add(d);
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
		int i, j, w;
		public int compareTo(Data other){
			return w - other.w;
		}
	}
}