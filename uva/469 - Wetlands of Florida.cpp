#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
#include <map>
#include <utility>
#define INF 0x7FFFFFFF
#define MAXN 100010

#define msg(a) cout<<#a<<" : "<<a<<endl;
#define ms(a) cout<<#a<<" : "<<a<<", ";
typedef long long int LL;

using namespace std;

struct Nodo{
	int padre, tam, rank;
	Nodo( ) {  }
	Nodo( int P, int T, int R ) { padre = P; tam = T; rank = R; }
}DS[MAXN];

int find( int x ){
	if( DS[x].padre == x ) return x;
	return DS[x].padre = find( DS[x].padre );
}

void link( int x, int y ){
	if( x==y ) return;
	if( DS[x].rank > DS[y].rank ){
		DS[y].padre = x;
		DS[x].tam += DS[y].tam;
	}else{
		DS[x].padre = y;
		DS[y].tam += DS[x].tam;
		if( DS[y].rank == DS[x].rank ) DS[y].rank += 1;
	}
}

char M[150][150]; int N;

int id( int i, int k, int col )
{ return i*col+k+1; }

void mostrarM(int n, int m){
	for(int i=0; i<n; i++){
		for(int k=0; k<m; k++){
			cout<<M[i][k];
		}
		cout<<endl;
	}}

void mostrarIDs(int fila, int col){
	for(int i=0; i<fila; i++){
		for(int k=0; k<col; k++){
			int ID = id(i, k, col);
			cout<</*id(i, k, col)*/ID<<" ";
		}		
	}
	cout<<endl;}

void mostrarPadres( int n, int m ){
	cout<<"[ ";
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			cout<< DS[ id(i, j, m) ].padre <<", ";
		}
		cout<<endl;	
	}
}
int movx[10] = { 0,  1, 1, 1, 0, -10, -10, -10, -10, -10};
int movy[10] = {-1, -1, 0, 1, 1, -10, -10, -10, -10, -10};


void procesar( int n, int m ){
	// ms(n); msg(m);
	N = n * m; int c1, c2, px, py;
	for( int i=1; i<=N; i++ )
	{ DS[i].padre = i; DS[i].tam = 1; DS[i].rank = 1; }
	for(int i=0; i<n-1; i++){
		for(int j=0; j<m; j++){
			for( int k=0; k<5; k++ ){
				px = i+movx[k]; py = j+movy[k];
				if( 	M[i][j]=='W' && 
						px >= 0 && px<n &&
					 	py >= 0 && py<m &&
					  	M[ px ][ py ]=='W' ){
					// cout<<"("<<i+1<<", "<<j+1<<")<->("<<px+1<<", "<<py+1<<")\n";
					c1 = find( id(i, j, m)   );
					c2 = find( id(px, py, m) );
					// ms(c1); msg(c2);
					link( c1, c2 );
				}
			}
		}
	}
	for(int j=0; j<m-1; j++){
		if( M[n-1][j] == 'W' && M[n-1][j+1]=='W' ){	
			// cout<<"("<<n-1<<", "<<j<<")<->("<<n-1<<", "<<j+1<<")\n";
			c1 = find( id(n-1, j,   m) );
			c2 = find( id(n-1, j+1, m) );
			link(c1, c2);
		}
	}
}


int main(){
	int T, fila, i, j, col, c;
	char cad[110];
	cin>>T;
	fgets(cad, sizeof(cad), stdin);
	fgets(cad, sizeof(cad), stdin);
	fila = 0;

	for( int caso=1; caso<=T-1; caso++ ) {
		while( fgets(cad, sizeof(cad), stdin) && (cad[0]=='L'||cad[0]=='W') ){
			col = strlen(cad)-1;
			for(int i=0; i<col; i++) M[fila][i] = cad[i];
			fila++;
		}
		procesar( fila, col );
		sscanf(cad, "%d %d", &i, &j);
		if( M[i-1][j-1]=='L' ) cout<<0<<endl;
		else{
			c = find( id(i-1, j-1, col) );
			cout<<DS[c].tam<<endl;
		}
		
		while( fgets(cad, sizeof(cad), stdin) && cad[0]!='\n' ){
			sscanf(cad, "%d%d", &i, &j);
			if( M[i-1][j-1]=='L' ) cout<<0<<endl;
			else{
				c = find( id(i-1, j-1, col) );
				cout<<DS[c].tam<<endl;
			}
		}
		cout<<endl;
		fila = 0;
	}


	//Last case
	fila = 0;
	while( fgets(cad, sizeof(cad), stdin) && (cad[0]=='L'||cad[0]=='W') ){
		col = strlen(cad)-1;
		for(int i=0; i<col; i++) M[fila][i] = cad[i];
		fila++;
	}
	// ms(fila); msg(col);
	procesar( fila, col );
	// mostrarM(fila, col);
	sscanf(cad, "%d %d", &i, &j);
	if( M[i-1][j-1]=='L' ) cout<<0<<endl;
	else{
		c = find( id(i-1, j-1, col) );
		cout<<DS[c].tam<<endl;
	}
	
	while( fgets(cad, sizeof(cad), stdin) && cad[0]!='\n' ){
		sscanf(cad, "%d%d", &i, &j);
		if( M[i-1][j-1]=='L' ) cout<<0<<endl;
		else{
			c = find( id(i-1, j-1, col) );
			cout<<DS[c].tam<<endl;
		}
	}
	return 0;
}
