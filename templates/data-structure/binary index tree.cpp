#include<cstdio>
using namespace std;
const int MAX_SIZE = 10000;
int V[MAX_SIZE];
int n;
void init() { // init tree
	for(int i = 0; i <= n; i++)
		V[i] = 0;		
}
int query(int b){ // query de [0...b]
	int sum = 0;
	while(b > 0){
		sum += V[b];
		b = b - (b & (-b));
	}
	return sum;
}
int query(int a, int b){ // query [a...b]
	return query(b) - (a == 1? 0: query(a - 1));
}
void update(int k, int val){ // update tree
	while(k <= n){
		V[k] = V[k] + val;
		k = k + (k&(-k));
	}
}
int main(){
	n = 8;
	init();
	update(2 ,1);
	update(4 ,1);
	update(5 ,2);
	update(6 ,3);
	update(7 ,2);
	update(8 ,1);
	printf("%d\n", query(1, 1));
	printf("%d\n", query(1, 2));
	printf("%d\n", query(1, 6));
	printf("%d\n", query(1, 8));
	printf("%d\n", query(3, 6));
	
	return 0;
}












