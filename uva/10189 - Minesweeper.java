import java.util.*;
import java.io.*;
class Main {
	public static int dx[] = new int[]{0, 0, 1, -1, -1, 1, -1, 1};	
	public static int dy[] = new int[]{1, -1, 0, 0, -1, 1, 1, -1};
	public static char map[][];	
	public static int mines[][] = new int[110][100];	
	public static void main(String []arg)throws IOException{
		InputReader in = new InputReader(System.in);	
		//Scanner in = new Scanner(System.in);
		int T = 1;
		int n = in.nextInt();
		int m = in.nextInt();
		while(true){								
				map = new char[n][];
				for(int k = 0; k < n; k++)
					map[k] = in.next().toCharArray();
				
				for(int i = 0; i < n; i++)
					for(int j = 0; j < m; j++)
						for(int k = 0; k < 8; k++){
							int x = dx[k] + i;
							int y = dy[k] + j;
							if(x < 0 || x == n || y < 0 || y == m)
								continue;
							if(map[x][y] == '*')
								mines[i][j]++;								
						}
								 
				StringBuffer buff = new StringBuffer(String.format("Field #%d:\n", T));		
				T++;				
				for(int i = 0; i < n; i++){
					for(int j = 0; j < m; j++)
						if(map[i][j] == '*')
							buff.append('*');
						else
							buff.append(""+mines[i][j]);
					buff.append('\n');
				}
				for(int i = 0; i < n; i++)
					for(int j = 0; j < m; j++)
						mines[i][j] = 0;
				System.out.print(buff.toString());
			n = in.nextInt();
			m = in.nextInt();	
			if(n + m == 0) break;
			System.out.println();
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