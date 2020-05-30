import java.util.*;

class Main {
	
	public static void main(String []arg) {
		Scanner in = new Scanner(System.in);
		Set<Integer> s = new HashSet<>();
		
		while(true){
			int n = in.nextInt();
			int m = in.nextInt();
			if( n + m == 0) break;
			while(n -- > 0){
				s.add(in.nextInt());
			}
				
			int c = 0;
			while(m -- > 0) {
				int x = in.nextInt();
				c += s.contains(x)?1:0;
			}
			System.out.println(c);
			s.clear();
		}
	}
	
}