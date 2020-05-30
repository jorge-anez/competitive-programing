import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
class Main{
public static void main(String arg[])throws IOException{	
	Scanner in = new Scanner(System.in);
	int V[] = new int [100];
	int n= in.nextInt();
	for(int i = 0; i < n; i++)
		V[i] = in.nextInt();
	
	if(n >= 2){
		int b = V[n - 1];
		int a = V[n - 2];
	
		if(b != 15 && b !=0 && a != 15 && a != 0){			
			if(b < a)
				System.out.println("DOWN");
			else
				System.out.println("UP");				
		}
		else{
			if(b == 0 || a == 0)
				System.out.println("UP");
			else 
				System.out.println("DOWN");
		}					
	}
	else{
		int a = V[n - 1];
		System.out.println(a == 0?"UP":a == 15?"DOWN":"-1");		
	}
}
}

//3 2 1 0 1 2 3
//13 14 15 14 13
