/* 깊이 우선 탐색 */
#include <stdio.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1
#define MAX_VERTICES 50

typedef struct node *nodePointer;
typedef struct node {
    int vertex;
    nodePointer link;
} node;
nodePointer graph[MAX_VERTICES];
short int visited[MAX_VERTICES];

// 그래프에 간선을 추가하는 함수 (연결 리스트 맨 앞에 삽입)
// u와 v 연결
void addEdge(int u, int v)
{
		nodePointer temp = (nodePointer)malloc(sizeof(node));
    temp->vertex = v;
    temp->link = graph[u];
    graph[u] = temp;
}

void dfs(int v)
{
	nodePointer w;
	visited[v] = TRUE;
	printf("%5d", v);
	for (w = graph[v]; w; w = w->link) {
		if (!visited[w->vertex])
			dfs(w->vertex);
	}
}

int main()
{
	for (int i = 0; i < MAX_VERTICES; i++) {
        visited[i] = FALSE;
        graph[i] = NULL;
  }
  addEdge(0, 1); addEdge(1, 0);
  addEdge(0, 2); addEdge(2, 0);
  addEdge(1, 2); addEdge(2, 1);
  addEdge(2, 3); addEdge(3, 2);
  
  printf("DFS 탐색 순서: ");
  dfs(0); // 0번부터 탐색 시작!
  printf("\n");

  return 0;
}

/* 그래프의 연결 요소 */
void connected(void)
{
	int i, n;
	for (i = 0; i < n; i++) {
		if (!visited[i]) {
			dfs(i);
			printf("\n");
		}
	}
}