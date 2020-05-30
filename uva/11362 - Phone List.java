import java.util.*;
import java.io.*;
class Main {
	public static final int ALPH_SIZE = 10;
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
	public static boolean solve(Node p){
		if(p.prefixes > 1 && p.word)
			return false;
		boolean sw = true;
		for(int k = 0; k < ALPH_SIZE; k++)
			if(p.existPath(k))
				sw = sw && solve(p.getPath(k));
		return sw;
	}
	public static void main(String []arg)throws IOException{
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		while(T-- > 0){
			int n = in.nextInt();
			Node root = new Node();
			for(int k = 0; k < n; k++){
				Node p = root;
				for(char e :in.next().toCharArray()){
					p = p.getPath(e - '0');
					p.prefixes++;
				}
				p.word = true;
			}				
			System.out.println(solve(root)?"YES":"NO");
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