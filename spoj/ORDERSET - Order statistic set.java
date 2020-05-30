import java.util.*;
import java.io.*;
class Main {
	public static final int ALPH_SIZE = 10;
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 2048);
	public static Node root = new Node(true);
	static class Node{
		public int prefixes, axis;
		public boolean word;
		public Node paths[];
		Node(){
			prefixes = 0;
			axis = 0;
			word = false;
			paths = new Node[ALPH_SIZE];
		}
		Node(boolean sw){
			prefixes = 0;
			word = false;
			paths = new Node[2];
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
	public static Node insert(Node p, char str[], int i){
		
	}
	public static boolean exist(char pattern[]){
		Node p = root;
		if(pattern[0] == '-'){
			p = p.getPath(0);
			for(int i = pattern.length - 1; i > 0; i--){
				if(!p.existPath(pattern[i] - '0'))
					return false;
				p = p.getPath(pattern[i] - '0');
			}
		}
		else{
			p = p.getPath(1);
			for(int i = 1 ; i < pattern.length; i++){
				if(!p.existPath(pattern[i] - '0'))
					return false;
				p = p.getPath(pattern[i] - '0');
			}
		}
		return p.word;
	}
	public static void print(Node p, char buff[], int i) throws IOException{		
		if(p.word) {			
			out.write(buff, 0, i);
			//out.write(String.format("prefixes %d", p.prefixes));
			out.newLine();
		}
		if(p.paths.length == 2){
			if(p.existPath(0)){
				buff[i] = '-';
				print(p.getPath(0), buff, i + 1);
			}
			if(p.existPath(1)){
				buff[i] = '+';
				print(p.getPath(1), buff, i + 1);
			}
		}else
			for(int k = 0; k < ALPH_SIZE; k++)
				if(p.existPath(k)){
					buff[i] = (char)(k + '0');
					print(p.getPath(k), buff, i + 1);
				}
	}
	public static long count2(char pattern[]) throws IOException{
		Node p = root;
		long s = 0;
		s +=p.getPath(0).prefixes;
		p = p.getPath(1);
		for(int i = 1 ; i < pattern.length; i++){
			for(int j = 0; j < pattern[i] - '0'; j++ ){
				if(p.existPath(j))
					s += p.getPath(j).prefixes;
			}
			if(p.existPath(pattern[i] - '0'))
				p = p.getPath(pattern[i] - '0');
		}
		//out.write(String.format("--%d%n",s));
		return s;
	}
	
	public static void main(String []arg)throws IOException{
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		for(int k = 0; k < T; k++){
			Node p = root;
			char str[] = String.format("%+d", Integer.parseInt(in.next())).toCharArray();
			/*
			out.write(new String(str));
			out.newLine();
			if(true)
			continue;
			*/
			if(exist(str))
				continue;
			if(str[0] == '-'){
				p = p.getPath(0);
				p.prefixes++;				
				for(int i = str.length - 1; i > 0; i--){
					p = p.getPath(str[i] - '0');
					p.prefixes++;
				}
			}else{
				p = p.getPath(1);
				p.prefixes++;
				for(int i = 1; i < str.length; i++){
					p = p.getPath(str[i] - '0');					
					p.prefixes++;
				}
			}
			p.word = true;
		}
		
		char buff[] = new char[11];
		print(root, buff, 0);
		String pattern = "+987";
		out.write(String.valueOf(count2(pattern.toCharArray())));		
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