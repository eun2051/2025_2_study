#include <stdio.h>
#include <stdlib.h>

struct node {
	int v;			// vertex 번호
	int weight;		// edge의 가중치
	struct node* next;
};

void add_edge(struct node** G, int src, int dest, int weight);
void DFS(struct node** G, int N, int v);
void find_earliest_time(struct node **G, int N, int earliest[]);

void main()
{
	int N, src, dest, weight;
	char fname[40];
	FILE* fp;

	printf("파일 이름? ");
	scanf("%s", fname);

	fp = fopen(fname, "r");
	fscanf(fp, "%d", &N);

	struct node** G = (struct node**)calloc(N, sizeof(struct node*));
	while (fscanf(fp, "%d%d%d", &src, &dest, &weight) != EOF) {
		// src에서 dest로 가는 가중치가 weight인 에지를 G에 추가
		// 새로운 에지는 stack 방식으로 연결 리스트의 제일 앞에 추가
		add_edge(G, src, dest, weight);	
	}

	printf("시작점? ");
	scanf("%d", &src);

	// 문제 2.1 : 시작점에서 시작하는 DFS 결과를 출력
	printf("문제 2.1: %d에서 시작하는 DFS = [ ", src);
	DFS(G, N, src);
	printf("]\n");

	// 문제 2.2 : 모든 정점의 earliest time을 출력
	int* earliest = (int*)calloc(N, sizeof(int));
	find_earliest_time(G, N, earliest);
	printf("문제 2.2: Earliest time = [");
	for (int i = 0; i < N; i++)
		printf("%d ", earliest[i]);
	printf("]\n");
}
