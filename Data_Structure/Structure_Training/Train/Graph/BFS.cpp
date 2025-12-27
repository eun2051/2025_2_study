/* 너비 우선 탐색 */

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50

typedef struct node *nodePointer;
typedef struct node {
    int vertex;
    nodePointer link;
} node;

typedef struct queue *queuePointer;
typedef struct queue {
	int vertex;
	queuePointer link;
} queue;

nodePointer graph[MAX_VERTICES];
short int visited[MAX_VERTICES];
queuePointer front = NULL, rear = NULL;

void addq(int v)
{
    queuePointer temp = (queuePointer)malloc(sizeof(queue));
    temp->vertex = v;
    temp->link = NULL;
    if (front == NULL) 
        front = temp;
    else 
        rear->link = temp;
    rear = temp;
}

int deleteq()
{
    if (front == NULL) return -1;
    queuePointer temp = front;
    int item = temp->vertex;
    front = temp->link;
    free(temp);
    return item;
}

void bfs(int v)
{
	nodePointer w;
	front = rear = NULL;
	printf("%5d", v);
	visited[v] = TRUE;
	addq(v);
	while (front) {
		v = deleteq();
		for (w = graph[v]; w; w = w->link) {
			if (!visited[w->vertex]) {
				printf("%5d", w->vertex);
				addq(w->vertex);
				visited[w->vertex] = TRUE;
			}
		}
	}
}