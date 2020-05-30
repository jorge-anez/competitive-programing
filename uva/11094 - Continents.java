import java.util.*;
import java.io.*;
class Main {	
	public static char land;
	public static int dx[] = new int[]{0, 0, 1, -1};	
	public static int dy[] = new int[]{1, -1, 0, 0};
	public static char map[][];
	public static boolean v[][] = new boolean[50][50];
	public static int N, M;	
	public static int dfs(int i, int j){
		if(j < 0)
			j = M - 1;
		if(j == M)
			j = 0;
		if(i < 0 || i == N)
			return 0;
		if(map[i][j] != land)
			return 0;
		if(v[i][j])
			return 0;
		v[i][j] = true;
		int a = 1;
		for(int k = 0; k < 4; k++){
			int x = dx[k] + i;
			int y = dy[k] + j;
			a +=dfs(x,y);			
		}
		return a;
	}
	
	public static void main(String []arg)throws IOException{
		//InputReader in = new InputReader(System.in);	
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
				int n = in.nextInt();
				int m = in.nextInt();
				N = n;
				M = m;
				map = new char[n][];
				for(int k = 0; k < n; k++){
					map[k] = in.next().toCharArray();					
				}
				int h = in.nextInt();
				int k = in.nextInt();
				land = map[h][k];
				dfs(h, k);				
				int s = 0;
				for(int i = 0; i < n; i++)
					for(int j = 0; j < m; j++)
						if(!v[i][j]){
							s = Math.max(s, dfs(i, j));							
						}
				System.out.println(s);				
				for(int i = 0; i < n; i++)
					for(int j = 0; j < m; j++)
						v[i][j] = false;
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