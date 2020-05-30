/*
http://www.spoj.com/problems/DICT/
*/
#include<cstdio>
#include<cstring>
using namespace std;
const int ALPH_SIZE = 26;
const int MAX_WORD_SIZE = 30;
struct Node{
	int prefixes;
	bool word;
	Node *paths[ALPH_SIZE];
	Node() {
		prefixes = 0;
		word = false;
		for(int i = 0; i < ALPH_SIZE; i++)
			paths[i] = NULL;
	}
	bool existPath(int i) {
		return (paths[i] != NULL);
	}
	Node* getPath(int i){
		if(!existPath(i))
			paths[i] = new Node();
		return paths[i];
	}
	~Node(){
		Node *p;
		for(int i = 0; i < ALPH_SIZE; i++) {
			if(paths[i] != NULL) {
					p = paths[i];
					delete p;
			}
		}
	}
};

struct Trie{
	Node root;
	Node *getRoot(){
		return &root;
	}
	void insert(char str[], int n){
		Node *p = &root;
		for(int i = 0; i < n; i++){
			p = p->getPath(str[i] - 'a');
			p->prefixes++;
		}
		p->word = true;
	}
	void remove(char str[], int n){
		
	}
	bool exist(char str[], int n){
		Node *p = &root;
		for(int i = 0; i < n; i++){
			if(!p->existPath(str[i] - 'a'))
				return false;
			p = p->getPath(str[i] - 'a');
		}
		return true;
	}
	void print(){
		char buff[MAX_WORD_SIZE];
		print(&root, buff, 0);
	}	
	void print(Node *p, char buff[], int i) {		
		if(p->word) {
			buff[i] = '\0';
			printf("%s\n", buff);
		}
		for(int k = 0; k < ALPH_SIZE; k++)
			if(p->existPath(k)){
				buff[i] = (k + 'a');
				print(p->getPath(k), buff, i + 1);
			}
	}
};

void solve1(Node *p, char buff[], int i) {		
	if(p->word) {
		buff[i] = '\0';
		printf("%s\n", buff);
	}
	for(int k = 0; k < ALPH_SIZE; k++)
		if(p->existPath(k)){
			buff[i] = (k + 'a');
			solve1(p->getPath(k), buff, i + 1);
		}
}

void solve(Node *p, char V[], char buff[], int i, int n) {
	if(i < n){
		if(!p->existPath(V[i] - 'a'))
			printf("No match.\n");
		else{
			buff[i] = V[i];
			solve(p->getPath(V[i] - 'a'), V, buff, i + 1, n);
		}
	}
	else
		for(int k = 0; k < ALPH_SIZE; k++)
			if(p->existPath(k)) {
				buff[i] = (k + 'a');					
				solve1(p->getPath(k), buff, i + 1);
			}
}

int main(){
	char str[50];
	int K, n, m;
	Trie trie;
	scanf("%d", &K);
	for(int k = 0; k < K; k++){
		scanf("%s", str);
		int n = strlen(str);
		trie.insert(str, n);
	}
	
	scanf("%d", &m);
	for(int k = 1; k <= m; k++){
		printf("Case #%d:\n", k);
		char buff[50];
		scanf("%s", str);
		solve(trie.getRoot(), str, buff, 0, strlen(str));
	}	
}
	
	
