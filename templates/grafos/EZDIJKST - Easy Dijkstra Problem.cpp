/*
	http://www.spoj.com/problems/EZDIJKST/
*/

#include<cstdio>
#include<queue>
#include<vector>
using namespace std;

const int INF = 1E9;
const int MAX_NODES = 10010;
int dist[MAX_NODES];
vector<pair<int, int> > G[MAX_NODES];

struct OrderByWeight{ // comparador
    bool operator() (pair<int, int> const &a, pair<int, int> const &b) { 
		return b.second < a.second; 
	}
};
  
void init(int n){ // init or reset
	for(int i = 1; i <= n; i++){
		dist[i] = INF;
		G[i].clear();
	}
}
void dijkstra(int from) {
	dist[from] = 0;
	priority_queue<pair<int, int>,vector<pair<int, int> >, OrderByWeight> pq;
	pq.push(make_pair(from, 0));
	while (!pq.empty()) { // dfs loop
		pair<int, int> front = pq.top(); pq.pop();// greedy: get shortest unvisited vertex
		int u = front.first;
		int d = front.second;
		if (d > dist[u])
			continue; // this is a very important check
		for (int j = 0; j < G[u].size(); j++) {
			pair<int, int> v = G[u][j]; // all outgoing edges from u
			if (dist[u] + v.second < dist[v.first]) {
				dist[v.first] = dist[u] + v.second; // relax operation
				pq.push(make_pair(v.first, dist[v.first]));
			}
		} 
	}
}
int main(){
	int K;
	scanf("%d", &K);
	while(K-- > 0){
		int vertexs, edges;
		scanf("%d %d", &vertexs, &edges);
		init(vertexs);
		for(int k = 0; k < edges; k++){
			int i, j, w;
			scanf("%d %d %d", &i, &j, &w);
			G[i].push_back(make_pair(j, w));
		}
		int from, to;
		scanf("%d %d", &from, &to);
		dijkstra(from);
		if(dist[to] == INF)
			printf("NO\n");
		else
			printf("%d\n", dist[to]);	
	}	
	return 0;
}	