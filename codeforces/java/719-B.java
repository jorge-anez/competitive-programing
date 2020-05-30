import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
class Main{
public static void main(String arg[])throws IOException{	
	Scanner in = new Scanner(System.in);
	int n= in.nextInt();
	char V[];	
	V = in.next().toCharArray();	
	int wb = 0;	
	int wr = 0;
	for(int i = 0; i < n; ++i){
		if(i % 2 == 0 && V[i] != 'r')			
			wr++;		
		if(i % 2 == 1 && V[i] != 'b')			
			wb++;
	}
	int r1 = Math.min(wb,wr) + Math.abs(wb-wr);	
	wb = 0;
	wr = 0;
	for(int i = 0; i < n; ++i){
		if(i % 2 == 1 && V[i] != 'r')			
			wr++;		
		if(i % 2 == 0 && V[i] != 'b')			
			wb++;
	}
	int r2 = Math.min(wb,wr) + Math.abs(wb-wr);	
	System.out.println(Math.min(r1,r2));
}
}