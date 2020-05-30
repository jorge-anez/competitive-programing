import java.util.Scanner;
import java.util.Arrays;
//import java.util.StringBuffer;
//import java.util.TreeSet;

class Main{	
	static char M[][]=new char[][]{
			{'*','*','*'},
			{'*','*','*'},
			{'*','*','*'},
			{'-','*','-'},
			};
	public static boolean valid(int i, int j){
		 return (i>=0 && j<=2 && i<=3 && j>=0 && M[i][j] == '*');
	}
	public static Pair getPos(char c){
			switch(c){
				case '1': return new Pair(0,0);
				case '2': return new Pair(0,1);
				case '3': return new Pair(0,2);
				case '4': return new Pair(1,0);
				case '5': return new Pair(1,1);
				case '6': return new Pair(1,2);
				case '7': return new Pair(2,0);
				case '8': return new Pair(2,1);
				case '9': return new Pair(2,2);
				case '0': return new Pair(3,1);
			}
		return new Pair(-1,-1);
	}
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);			
			in.next();							
			String str=in.next();			
			//System.out.println(secuence+(new StringBuffer(secuence).reverse().toString()));	  
			boolean sw=false,ww;
			for(int t=1;t<=4;t++){			
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i,p.j+t);					
				}
				if(ww){System.out.println("NO"); return;}
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i-t,p.j+t);				
				}
				if(ww){System.out.println("NO"); return;}
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i-t,p.j);					
				}
				if(ww){System.out.println("NO"); return;}
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i-t,p.j-t);				
				}
				if(ww){System.out.println("NO"); return;}
				ww=true;				
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i,p.j-t);					
				}
				if(ww){System.out.println("NO"); return;}
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i+t,p.j-t);				
				}
				if(ww){System.out.println("NO"); return;}			
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i+t,p.j);				
				}
				if(ww){System.out.println("NO"); return;}
				ww=true;
				for(int k=0;k<str.length();k++){
					Pair p=getPos(str.charAt(k));
					ww=ww && valid(p.i+t,p.j+t);					
				}
				if(ww){System.out.println("NO"); return;}
			}
			System.out.println("YES");
	}
	
	static class Pair{
		public int i,j;
		public Pair(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
}