// http://www.spoj.com/problems/MST/
// MST - Minimum Spanning Tree
#include<cstdio>
#include<algorithm>
using namespace std;

struct Edge{  
	int i, j, w;
	Edge(){}	
};

bool compare(Edge A, Edge B){ // funcion de comparacion
	if(A.w < B.w) 
		return true;
	else
		return false;
}

const int MAX_VERTEXS=100010;
const int MAX_NODES=10010;	

int V[MAX_NODES];
Edge E[MAX_VERTEXS];

void init(int n) {  // iniciar estructura disjoinSet UnionFind
	for(int i = 0;i < n; i++)
		V[i] = i;
}
int find(int i) {  // encontrar el padre de i
	if(V[i] != i)
		return find(V[i]);
	else
		return i;
}
void unionSet(int i,int j) { // unir componentes
	int a = find(i);
	int b = find(j);
	V[a] = b;
}
bool isJoined(int i,int j) { // preguntar si estan en ma misma componente
	if(find(i) == find(j))
		return true;
	else 
		return false;
}
int main() {	
	int N, M;
	scanf("%d %d", &N, &M);
	init(N);
	int t = 0;
	for(int k = 0; k < M; k++){
		int i, j, w;
		scanf("%d %d %d", &i, &j, &w);
		E[k].i = i;
		E[k].j = j;
		E[k].w = w;
	}
	
	sort(E, E + M, compare);
	int s = 0;
	for(int k = 0; k < M; k++){
		int i, j, w;
		i = E[k].i;
		j = E[k].j;
		w = E[k].w;
		if(!isJoined(i, j)){
			s += w;
			unionSet(i, j);
		}
	}
	printf("%d\n", s);	
	
	return 0;
}
	