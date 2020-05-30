/*
	PROBLEM: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=945
*/
#include<cstdio>
#include<vector>
#include<cstring>
using namespace std;
const int MAX_NODES = 210;
const int BLACK = 1;
const int WHITE = 2;
const int NO_VISITED = 0;

vector<int> G[MAX_NODES];
int V[MAX_NODES];

bool dfs(int node, int color){
	V[node] = color;
	bool coloreable = true;
	for(int k = 0; k < G[node].size(); k++){
		int h = G[node][k];					
		if(V[h] == NO_VISITED)
			coloreable = coloreable && dfs(h, color == BLACK?WHITE:BLACK);
		else
			if(color == WHITE &&  V[h] == WHITE)
				return false;
			if(color == BLACK && V[h] == BLACK)
				return false;					
	}
	return coloreable;
}
int main(){		
	while(true){
		int n, m;
		scanf("%d", &n);
		if(n == 0) 
			break;
		scanf("%d", &m);		
		memset(V, 0, 4*n);
		
		for(int k = 0; k < n + 1; k++)
			G[k].clear();
			
		for(int k = 0; k < m; k++){
			int i, j;
			scanf("%d %d", &i, &j);
			G[i].push_back(j);
			G[j].push_back(i);
		}
		printf(dfs(0,BLACK)?"BICOLORABLE.\n":"NOT BICOLORABLE.\n");		
	}	
}