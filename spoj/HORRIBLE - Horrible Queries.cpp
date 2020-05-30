#include<cstdio>
#include<cstring>
using namespace std;
struct Node{
		int a, b;
		long long sum, cache;
		Node *left, *right;
		Node(int l, int r){
			a = l; b = r;
			left = right = NULL;
			sum = cache = 0;
		}
		~Node(){
			if(hasLeft())
				delete left;
			if(hasRight())
				delete right;
		}
		void merge(){
			if(!hasLeft() && !hasRight()) 
				return;
			if (!hasLeft())
				sum = right->sum + right->cache*(right->b - right->a + 1L);
			else 
				if (!hasRight()) 
					sum = left->sum + left->cache*(left->b - left->a + 1L);
				else 
					sum = left->sum + left->cache*(left->b - left->a + 1L) + 
						  right->sum + right->cache*(right->b - right->a + 1L);
		}
		void split(){
			if(cache != 0){
				sum += cache * (b - a + 1L);
				if (a != b) {
					if(hasLeft())
						left->cache += cache;
					if(hasRight())
						right->cache += cache;
				}
				cache = 0;
			}
		}
		bool hasLeft(){
			return left != NULL;
		}
		bool hasRight(){
			return right != NULL;
		}
	
};
    
	Node* build(Node *p, int l, int r, int A[200000]){
		p = new Node(l, r);
        if (l == r){ // nodo hoja            
            p->sum = A[l] = A[r];
        }
		else{
			int mid = (l + r) / 2;        
			p->left = build(p->left, l, mid, A);
			p->right = build(p->right, mid + 1, r, A);
			p->merge();
		}
		return p;
    }
	Node* update(Node *p, int i, int j, int val) {
			if (j < p->a || i > p->b) // fuera de rango, no actualizar
					return p;
            if (i <= p->a && j >= p->b){
                p->cache += val;
                p->split();
				return p;
            }
			else{
				p->left = update(p->left, i, j, val);
				p->right = update(p->right, i, j, val);
				p->merge();
				return p;
			}
	}	
	Node* query(Node *p, int i, int j) {			
			if (p == NULL || j < p->a || i > p->b) 
					return NULL;
            if (i <= p->a && p->b <= j) {
					p->split();
				return p;
            }
			else{
				p->split();
				Node *temp = new Node(i, j);
				temp->left = query(p->left, i, j);
				temp->right = query(p->right, i, j);
				temp->merge();
				return temp;
			}
	}
	int main() {
		int T;
		scanf("%d", &T);
		int V[200000];
		while(T-- > 0){
			int N, Q;
			scanf("%d %d", &N, &Q);
			Node *root;
			memset(V, 0, N);
			root = build(root, 0, N - 1, V);
			for(int k = 0; k < Q; k++){
				int op, i ,j;
				scanf("%d %d %d", &op, &i, &j);
				if(op == 0){
					int val;
					scanf("%d", &val);
					root = update(root, i - 1, j - 1, val);
				}
				else{
					Node *q = query(root, i - 1, j - 1);
					printf("%lld\n", q->sum);
				}
			}
			delete root;
		}
	}