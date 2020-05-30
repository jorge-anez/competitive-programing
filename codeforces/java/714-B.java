import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
class Main{
public static void main(String arg[])throws IOException{	
	Scanner in = new Scanner(System.in);
	TreeSet<Integer> S = new TreeSet<>();
	int n= in.nextInt();
	for(int i = 0; i < n; i++)
		S.add(in.nextInt());
	if(S.size() == 1)
		System.out.println("Y");
	else {
		if(S.size() == 2){
			int a = S.pollFirst();
			int b = S.pollFirst();
			System.out.println(a + a == b - a?"Y":"N");
		}
		else
		System.out.println("N");
	}
}
}


