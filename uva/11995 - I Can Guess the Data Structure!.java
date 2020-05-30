import java.util.*;

class Main {
	
	public static void main(String []arg) {
		Scanner in = new Scanner(System.in);
		 Queue<Integer> PQ = new PriorityQueue<>(100, new Comparator<Integer>(){
			 public int compare(Integer a, Integer b){
				 return b - a;
			 }
		 });
		 Queue<Integer> Q = new LinkedList<>();
		 Stack<Integer> S = new Stack<>();
		boolean pq,q,s;
		while(in.hasNext()){
			int n = in.nextInt();
			pq = true;
			q = true;
			s = true;
			while( n-- >0){
				int op, v;			
				op = in.nextInt();
				v = in.nextInt();
				if(op == 1){
					PQ.add(v);
					Q.add(v);
					S.add(v);
				}else{
					if(S.size() == 0 || v != S.pop())
						s=false;
					if(PQ.size() == 0 || v != PQ.remove())
						pq = false;
					if(Q.size() == 0 || v != Q.remove())
						q = false;
				}
			}
			String ressult = "";
			if(!pq && !q && !s)
				System.out.println("impossible");
			else if(s && !pq && !q)
				System.out.println("stack");
			else if(pq && !s && !q)
				System.out.println("priority queue");
			else
				if(q && !pq && !s)
					System.out.println("queue");
			else
					System.out.println("not sure");
			S.clear();
			PQ.clear();
			Q.clear();
		}
	}
	
}