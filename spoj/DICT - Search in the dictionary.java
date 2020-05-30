import java.util.*;
import java.io.*;
class Main {
	public static final int ALPH_SIZE = 26;
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 2048);
	static class Node{
		public int prefixes;
		public boolean word;
		public Node paths[];
		Node(){
			prefixes = 0;
			word = false;
			paths = new Node[ALPH_SIZE];
		}
		public boolean existPath(int i){
			return paths[i] != null;
		}
		public Node getPath(int i){
			if(!existPath(i))
				paths[i] = new Node();
			return paths[i];
		}
	}
	public static void solve(Node p, char V[], char[] buff, int i)throws IOException{
		if(i < V.length){
			if(!p.existPath(V[i] - 'a'))
				out.write("No match.\n");
			else{
				buff[i] = V[i];
				solve(p.getPath(V[i] - 'a'), V, buff, i + 1);
			}
		}
		else
			for(int k = 0; k < ALPH_SIZE; k++)
				if(p.existPath(k)) {
					buff[i] = (char)(k + 'a');					
					solve(p.getPath(k), buff, i + 1);
				}
	}
	public static void solve(Node p, char buff[], int i) throws IOException{		
		if(p.word) {
			buff[i] = '\n';
			out.write(buff, 0, i + 1);
		}
			for(int k = 0; k < ALPH_SIZE; k++)
				if(p.existPath(k)){
					buff[i] = (char)(k + 'a');
					solve(p.getPath(k), buff, i + 1);
				}
	}
	public static void main(String []arg)throws IOException{
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		Node root = new Node();
		for(int k = 0; k < n; k++){
			Node p = root;
			for(char e : in.next().toCharArray()){
				p = p.getPath(e - 'a');
				p.prefixes++;
			}
			p.word = true;
		}
		int m = in.nextInt();
		for(int k = 1; k <= m; k++){
			out.write(String.format("Case #%d:\n", k));
			char buff[] = new char [26];
			solve(root, in.next().toCharArray(), buff, 0);
		}
		out.flush();
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