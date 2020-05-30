import java.io.*;
import java.util.*;
class Main {
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 2048);
	public static InputReader in = new InputReader(System.in);
	public static int V[];
	public static Node build(Node p, int i, int j){
		p = new Node(i, j);
		if(i == j){
			p.i = i;
			p.j = j;
		}else{
			int mid = (i + j) / 2;
			p.left = build(p.left, i, mid);
			p.right = build(p.right, mid + 1, j);
			p.merge();
		}
		return p;
	}
	public static Node update(Node p, int i){
		if(i < p.a || i > p.b)
			return p;
		if(p.b - p.a > 1){
			p.left = update(p.left, i);
			p.right = update(p.right, i);
			p.merge();
		}
		return p;
	}
	public static Node query(Node p, int i, int j){
		if(p == null || j < p.a || i > p.b) return null;
		if(i <= p.a && p.b <= j)
			return p;
		else {
			Node temp = new Node(i, j);
			temp.left = query(p.left, i, j);
			temp.right = query(p.right, i, j);
			temp.merge();
			return temp;
		}
	}
	static class Node{
		public int a, b;
		public int i, j;
		Node left, right;
		Node(int a, int b){
			this.a = a;
			this.b = b;
		}
		public void merge(){
			if(!hasLeft() && !hasRight()) return;
			if(!hasLeft()){
				i = right.i;
				j = right.j;
			}else if(!hasRight()){
					i = left.i;
					j = left.j;
					}else{
						Integer A[] = new Integer[]{left.i, left.j, right.i, right.j};
						Arrays.sort(A, new Comparator<Integer>(){
							public int compare(Integer x, Integer y){
								return V[x] - V[y];
							}
						});
						i = A[3];
						j = A[2];
						if(j == i){
							j = A[1];
							if(j == i)
							j = A[0];
						}
					}
		}
		public boolean hasLeft(){
			return left !=  null;
		}
		public boolean hasRight(){
			return right !=  null;
		}
	}
	public static void main(String arg[]) throws IOException{
		int N = in.nextInt();
		V = new int[N];
		Node root = null;
		for(int i = 0; i < N; ++i)
			V[i] = in.nextInt();
		root = build(root, 0, N - 1);
		int Q = in.nextInt();
		for(int i = 0; i < Q; ++i){
			String op = in.next();
			int x = in.nextInt();
			int y = in.nextInt();
			if(op.equals("U")){
				V[x - 1] = y;
				root = update(root, x - 1);
			}else{
				Node q = query(root, x - 1, y - 1);
				out.write(String.format("%d%n",V[q.i] + V[q.j]));
			}
		}
		out.flush();
	}
	static class InputReader{
		public BufferedReader in;
		public StringTokenizer tokens;
		public InputReader(InputStream in){
			this.in = new BufferedReader(new InputStreamReader(in), 2048);
		}
		public String next()throws IOException{
			if(tokens == null || !tokens.hasMoreTokens())
				tokens = new StringTokenizer(in.readLine());
			return tokens.nextToken();
		}
		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
	}
}