import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
class Main{
public static void main(String arg[])throws IOException{
	
	long L1,R1,R2,L2,k;
	Scanner in = new Scanner(System.in);
	L1 = in.nextLong();
	R1 = in.nextLong();
	L2 = in.nextLong();
	R2 = in.nextLong();
	k = in.nextLong();
	long l,r;
	if(L1 <= L2 && R1<= R2 && L2 <=R1){
		l = L2;
		r = R1;
		System.out.println(k >=l && k<= r?r-l:r-l+1);
		return;
	}
	if(L2 <= L1 && R2<= R1 && L1 <= R2){
		l = L1;
		r = R2;
		System.out.println(k >=l && k<= r?r-l:r-l+1);
		return;
	}
	if(L2 <= L1 && R1<= R2){
		l = L1;
		r = R1;
		System.out.println(k >=l && k<= r?r-l:r-l+1);
		return;
	}
	if(L1 <= L2 && R2<= R1){
		l = L2;
		r = R2;
		System.out.println(k >=l && k<= r?r-l:r-l+1);
		return;
	}
	System.out.println(0);
}
}


