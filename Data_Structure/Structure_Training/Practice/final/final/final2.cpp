#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50
#define MAX_PRINT 1000

typedef struct node *nodePointer;
typedef struct node {
    int vertex;
    int weight;  
    struct node* next; 
} node;

typedef struct Vertex {
    int id; 
    nodePointer edgeList; 
} Vertex;

typedef struct Graph {
    int numVertices;
    Vertex* vertices;
} Graph;

Graph *g;
int **distance;
short int *found;

Graph* createGraph(int V);
void insertEdge(Graph *g, int u, int v, int w);
int choose(int *distance, int n, short int *found);
void shortestPath(int v, Graph *G, int *distance, int n, short int *found);
void allCosts(Graph *G, int **distance, int n);
void print_distance(int *distance, int n);
void print_all_distance(int **distance, int n);

Graph* createGraph(int V) 
{
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->numVertices = V;
    graph->vertices = (Vertex*)malloc(V * sizeof(Vertex));

    for (int i = 0; i < V; i++) {
        graph->vertices[i].id = i;
        graph->vertices[i].edgeList = NULL;
    }
    return graph;
}

void insertEdge(Graph *g, int u, int v, int w)
{
    nodePointer newNode = (nodePointer)malloc(sizeof(node));
    newNode->vertex = v;
    newNode->weight = w;
    newNode->next = g->vertices[u].edgeList;
    g->vertices[u].edgeList = newNode;
}

int choose(int *distance, int n, short int *found)
{
	int i, min, minpos;
	min = INT_MAX;
	minpos = -1;
	for (i = 0; i < n; i++) {
		if (distance[i] < min && !found[i]) {
			min = distance[i];
			minpos = i;
		}
	}
	return minpos;
}

void shortestPath(int v, Graph *G, int *distance, int n, short int *found)
{
    int i, u;
    nodePointer ptr;
    
    for (i = 0; i < n; i++) {
        found[i] = FALSE;
        distance[i] = INT_MAX;
    }
    distance[v] = 0;
    ptr = G->vertices[v].edgeList;
    while (ptr != NULL) {
        distance[ptr->vertex] = ptr->weight;
        ptr = ptr->next;
    }
    found[v] = TRUE;
    for (i = 0; i < n - 2; i++) {
        u = choose(distance, n, found);
        if (u == -1) break;
        found[u] = TRUE;
        ptr = G->vertices[u].edgeList;
        while (ptr != NULL) {
            int w = ptr->vertex;
            if (!found[w]) {
                if (distance[u] + ptr->weight < distance[w])
                    distance[w] = distance[u] + ptr->weight;
            }
            ptr = ptr->next;
        }
    }
}


void allCosts(Graph *G, int **distance, int n)
{
    int i, j, k;
    nodePointer ptr;
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (i == j)
                distance[i][j] = 0;
            else
                distance[i][j] = INT_MAX;
        }
    }
    for (i = 0; i < n; i++) {
        ptr = G->vertices[i].edgeList;
        while (ptr != NULL) {
            distance[i][ptr->vertex] = ptr->weight;
            ptr = ptr->next;
        }
    }
    for (k = 0; k < n; k++) {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (distance[i][k] != INT_MAX && distance[k][j] != INT_MAX) {
                    if (distance[i][k] + distance[k][j] < distance[i][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
    }
}

void print_distance(int *distance, int n)
{
    for (int i = 0; i < n; i++) {
        if (distance[i] == INT_MAX) {
            printf(" %4d", MAX_PRINT);
        } else {
            printf(" %4d", distance[i]);
        }
    }
    printf("\n");
}

void print_all_distance(int **distance, int n)
{
    int i, j;
    for (i = 0; i < n; i++) {
        printf("    %2d", i);
        for (j = 0; j < n; j++) {
            if (distance[i][j] == INT_MAX) {
                printf(" %6d", MAX_PRINT);
            } else {
                printf(" %6d", distance[i][j]);
            }
        }
        printf("\n");
    }
}

int main()
{
    int input, vertex;
    int u, v, w;
    g = createGraph(MAX_VERTICES);
    
    printf("Input Vertex # : ");
    scanf("%d", &input);

    int *dist = (int*)malloc(input * sizeof(int));
    distance = (int**)malloc(input * sizeof(int*));
    for (int i = 0; i < input; i++) {
        distance[i] = (int*)malloc(input * sizeof(int));
    }
    found = (short int*)malloc(input * sizeof(short int));
    while (1) {
        scanf("%d %d %d", &u, &v, &w);
        if (u == -1 || v == -1 || w == -1)
            break;
        insertEdge(g, u, v, w);
    }
    printf("Shortest Vertex # : ");
    scanf("%d", &vertex);
    printf("Shortest Path (Vertex #%d)\n", vertex);
    shortestPath(vertex, g, dist, input, found);
    print_distance(dist, input);
    printf("AllCost\n");
    allCosts(g, distance, input);
    print_all_distance(distance, input);
    free(dist);
    free(found);
    for (int i = 0; i < input; i++) {
        free(distance[i]);
    }
    free(distance);
    
    return 0;
}
