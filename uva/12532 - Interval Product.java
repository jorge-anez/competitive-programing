import java.util.*;

class Main {
	public static int tree[] = new int[500000];	
	public static void build(int node, int a, int b, int V[]){
		if(a == b){
			tree[node] = V[a] < 0?1:V[a] == 0?-1:0;			
		}
		else{
			int middle = (a + b) / 2;
			build(2*node, a, middle, V);
			build(2*node + 1, middle + 1, b, V);
			tree[node] = (tree[2*node] == -1 || tree[2*node + 1] == -1)?-1:tree[2*node] + tree[2*node+1];			
		}
	}
	public static void update(int node, int a, int b, int i,int val){
		if(i < a || i > b) return;
		if(a == b){
			tree[node] = val < 0?1:val == 0?-1:0;			
		}else {		
			int middle = (a + b) / 2;
			update(2*node, a, middle, i,val);
			update(2*node + 1, middle + 1, b, i, val);
			tree[node] = tree[2*node] == -1 || tree[2*node + 1] == -1?-1:tree[2*node] + tree[2*node+1];			
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
			
		return iz < 0 || der < 0 ?-1:iz + der;
	}	
	public static void main(String []arg) {
		Scanner in = new Scanner(System.in);		 
		while(in.hasNext()){
			System.out.println();
			int n = in.nextInt();
			int m = in.nextInt();
			int V[] = new int[n];
			for(int i = 0; i < n; i++){
				int x = in.nextInt();
				V[i] = x < 0?-1:x > 0?1:0;
			}
			build(1, 0, n - 1, V);
			for(int i = 0; i < m; i++){
				String str = in.next();
				int h = in.nextInt();
				int k = in.nextInt();
				if(str.equals("C"))
					update(1, 0, n - 1, h - 1, k);
				else {
					int q = query(1, 0, n - 1, h - 1, k - 1);
					System.out.print(q == -1?'0':q%2 == 0?'+':'-');
				}				
			}
			
		}
	}
	
}