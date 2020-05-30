import java.io.*;
import java.util.*;
class Main{
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 2048);
	public static InputReader in = new InputReader(System.in);
	public static Node build(Node p, int l, int r, int[] A){
		p = new Node(l, r);
        if (l == r){ // nodo hoja            
            p.sum = A[l] = A[r];
        }
		else{
			int mid = (l + r) / 2;        
			p.left = build(p.left, l, mid, A);
			p.right = build(p.right, mid + 1, r, A);
			p.merge();
		}
		return p;
    }
	public static Node update(Node p, int i, int j, int val) {
			if (j < p.a || i > p.b) // fuera de rango, no actualizar
					return p;
            if (i <= p.a && j >= p.b){
                p.cache += val;
                p.split();
				return p;
            }
			else{
				p.left = update(p.left, i, j, val);
				p.right = update(p.right, i, j, val);
				p.merge();
				return p;
			}
	}	
	public static Node query(Node p, int i, int j) {			
			if (p == null || j < p.a || i > p.b) 
					return null;
            if (i <= p.a && p.b <= j) {
					p.split();
				return p;
            }
			else{
				p.split();
				Node temp = new Node(i, j);
				temp.left = query(p.left, i, j);
				temp.right = query(p.right, i, j);
				temp.merge();
				return temp;
			}
	}
	public static void print(Node p) { // no importe este metodo
		if(p != null){
			print(p.left);
			System.out.println(String.format("[%d-%d]-> %d", p.a, p.b, p.sum));
			print(p.right);
		}
	}
	static class Node{
		int a, b;
		long sum, cache;
		Node left, right;
		public Node(int l, int r){
			a = l; b = r;
			left = right = null;
		}
		public void merge(){
			if(!hasLeft() && !hasRight()) return;
			if (!hasLeft())
				sum = right.sum + right.cache*(right.b - right.a + 1L);
			else 
				if (!hasRight()) 
					sum = left.sum + left.cache*(left.b - left.a + 1L);
				else 
					sum = left.sum + left.cache*(left.b - left.a + 1L) + 
						  right.sum + right.cache*(right.b - right.a + 1L);
		}
		public void split(){
			if(cache != 0){
				sum += cache * (b - a + 1L);
				if (a != b) {
					if(hasLeft())
						left.cache += cache;
					if(hasRight())
						right.cache += cache;
				}
				cache = 0;
			}
		}
		public boolean hasLeft(){
			return left != null;
		}
		public boolean hasRight(){
			return right != null;
		}
	}
	public static void main(String arg[])throws IOException{
		int T = in.nextInt();
		while(T-- > 0){
			int N = in.nextInt();
			int Q = in.nextInt();
			int V[] = new int [N];
			Node root = null;		
			root = build(root, 0, V.length - 1, V);
			System.out.println();
			for(int k = 0; k < Q; k++){
				int op = in.nextInt();
				int i = in.nextInt();
				int j = in.nextInt();
				if(op == 0){
					root = update(root, i - 1, j - 1, in.nextInt());
				}
				else{
					Node q = query(root, i - 1, j - 1);
					out.write(String.format("%d%n", q.sum));
				}
			}
			out.flush();
		}
	}
	static class InputReader{
		public BufferedReader in;
		public StringTokenizer tokens;
		public InputReader(InputStream in){
			this.in = new BufferedReader(new InputStreamReader(in), 2048);
		}
		public String next() throws IOException{
			if(tokens == null || !tokens.hasMoreTokens()){
				String str = in.readLine();
				if(str == null || str.equals(""))
					return null;
				tokens = new StringTokenizer(str);
			}
			return tokens.nextToken();
		}
		public int nextInt()throws IOException{
			return Integer.parseInt(next());
		}
	}	
}