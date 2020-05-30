// http://www.spoj.com/problems/RMQSQ/
// similar http://www.spoj.com/problems/KQUERY/

#include<cstdio>
#include<cmath>
#include<cstdlib>
using namespace std;
int max(int a, int b){
    return a > b? a : b;
}
int min(int a, int b){
    return a < b? a : b;
}
struct Node{
		int a,b;
		int max, min;
		Node *iz, *der;
		Node(){
			iz = der = NULL;
		}
		Node(int a, int b){
			this->a=a;
			this->b=b;
			iz = der = NULL;
		}
};
struct SegmentTree{
	Node *root;
	SegmentTree(){
		root = NULL;
	}
	SegmentTree(int V[], int n){
		root = NULL;
		root = buildTree(root, 0, n, V);
	}
	void buildTree(int V[], int n){
		root=buildTree(root, 0, n - 1, V);
	}
	Node* buildTree(Node *node,int A, int B, int V[]){
		node = new Node(A, B);
		if(A == B){
			node->max = V[A];
			node->min = V[A];
		}
		else{
			int middle = (A + B) / 2;
			node->iz = buildTree(node->iz, A, middle,V);
			node->der = buildTree(node->der, middle+1, B,V);
			node->max = max(node->iz->max, node->der->max);
			node->min = min(node->iz->min, node->der->min);
		}
		return node;
	}
	Node* query(int i, int j){
		return query(root, i ,j);
	}
	Node* query(Node *p, int i, int j){
		if(i > p->b || j < p->a) return NULL;
		else if(p->a >= i && p->b <= j)
				return p;
			 else{
				 Node *iz=query(p->iz, i, j);
				 Node *der=query(p->der, i, j);
				 Node *temp = new Node(i,j);
				 if(iz == NULL){
					 temp->max = der->max;
					 temp->min = der->min;
				 }
				 else if(der == NULL){
					 	temp->max = iz->max;
					 	temp->min = iz->min;
				 	  }
				 	  else{
				 		 temp->max = max(der->max, iz->max);
				 		 temp->min = min(der->min, iz->min);
				 	  }
				 return temp;
			 }
	}
	void update(int i, int value){
		root = update(root, i, value);
	}
	Node* update(Node *p, int i, int value){
		if(p->a == i && p->a == p->b){
			p->max = value;
			p->min = value;
		}
		else if(p->a <= i && i <= p->b){
		    	 p->iz  = update(p->iz, i,value);
		    	 p->der = update(p->der, i,value);
		    	 p->max = max(p->iz->max, p->der->max);
		    	 p->min = min(p->iz->min, p->der->min);
			 }
		return p;
	}
};
int main(){
		//freopen("in.txt", "r", stdin);
		int N;
		scanf("%d", &N);
		SegmentTree T;
		int V[100000+10];
		for (int i = 0; i < N; i++) {
			 scanf("%d", &V[i]);
		}
		T.buildTree(V, N);
		int q;
		scanf("%d", &q);
		for (int i = 0; i < q; i++) {
			int x, y;
			scanf("%d", &x);
			scanf("%d", &y);
			Node *r = T.query(x, y);
			printf("%d\n",r->min);
		}
}
