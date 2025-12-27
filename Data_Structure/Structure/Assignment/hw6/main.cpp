
#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <time.h> 

#define MAX_NODES 500
#define MAX_NAME_LEN 50
#define INF 1000000000
#define REPEAT_COUNT 200000

typedef struct Edge {
    int to;
    int weight;
    struct Edge* next;
} Edge;
Edge *adj[MAX_NODES]; 

int adjMatrix[MAX_NODES][MAX_NODES];

typedef struct {
    char name[MAX_NAME_LEN];
    int id;
} Station;
Station stations[MAX_NODES];
int node_count = 0;

typedef struct {
    int cost;
    int node;
} HeapNode;

typedef struct {
    HeapNode data[MAX_NODES * 10];
    int size;
} MinHeap;
MinHeap pq;

void initHeap() { pq.size = 0; }
int isHeapEmpty() { return pq.size == 0; }

void push(int cost, int node) {
    int i = ++pq.size;
    while ((i != 1) && (cost < pq.data[i / 2].cost)) {
        pq.data[i] = pq.data[i / 2];
        i /= 2;
    }
    pq.data[i].cost = cost;
    pq.data[i].node = node;
}

HeapNode pop() {
    HeapNode minNode = pq.data[1];
    HeapNode lastNode = pq.data[pq.size--];
    int parent = 1;
    int child = 2;

    while (child <= pq.size) {
        if ((child < pq.size) && (pq.data[child].cost > pq.data[child + 1].cost))
            child++;
        if (lastNode.cost <= pq.data[child].cost)
            break;
        pq.data[parent] = pq.data[child];
        parent = child;
        child *= 2;
    }
    pq.data[parent] = lastNode;
    return minNode;
}

int find_addStation(char *name) {
    for (int i = 0; i < node_count; i++) {
        if (strcmp(stations[i].name, name) == 0) {
            return stations[i].id;
        }
    }
    strcpy(stations[node_count].name, name);
    
    stations[node_count].id = node_count;
    return node_count++;
}

char *getName(int id) {
    if (id < 0 || id >= node_count) return (char*)"";
    return stations[id].name;
}

void addEdge(int u, int v, int w) {
    Edge *newEdge = (Edge *)malloc(sizeof(Edge));
    newEdge->to = v;
    newEdge->weight = w;
    newEdge->next = adj[u];
    adj[u] = newEdge;
}

void loadSubwayData(const char *filename) {
    FILE *fp = fopen(filename, "r");
    if (fp == NULL) {
        fprintf(stderr, "file open error: %s\n", filename);
        exit(0);
    }
    char u_str[MAX_NAME_LEN], v_str[MAX_NAME_LEN];
    int w;

    printf(">> 데이터 파일을 읽는 중...");

    for (int i = 0; i < MAX_NODES; i++) {
        adj[i] = NULL; 
        for (int j = 0; j < MAX_NODES; j++) {
            if (i == j) adjMatrix[i][j] = 0;
            else adjMatrix[i][j] = INF; 
        }
    }
    while (fscanf(fp, "%s %s %d", u_str, v_str, &w) != EOF) {
        int u = find_addStation(u_str);
        int v = find_addStation(v_str);

        addEdge(u, v, w);
        addEdge(v, u, w);

        adjMatrix[u][v] = w;
        adjMatrix[v][u] = w;
    }
    fclose(fp);
    printf(" 완료 ! (총 %d개 역 로드됨)\n", node_count);
}

int dijkstra_array(int start, int end) {
    int dist[MAX_NODES];
    int visited[MAX_NODES] = {0};

    for(int i=0; i<node_count; i++) dist[i] = INF;
    dist[start] = 0;

    for (int i = 0; i < node_count; i++) {
        int u = -1;
        int minVal = INF;
        for (int j = 0; j < node_count; j++) {
            if (!visited[j] && dist[j] < minVal) {
                minVal = dist[j];
                u = j;
            }
        }
        
        if (u == -1 || dist[u] == INF) break;
        if (u == end) return dist[end];
        
        visited[u] = 1;

        for (int v = 0; v < node_count; v++) {
            if (adjMatrix[u][v] != INF) {
                if (dist[u] + adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                }
            }
        }
    }
    return dist[end];
}

int dijkstra_heap(int start, int end) {
    int dist[MAX_NODES];
    for(int i=0; i<node_count; i++) dist[i] = INF;
    
    pq.size = 0; 
    
    dist[start] = 0;
    push(0, start);

    while (!isHeapEmpty()) {
        HeapNode top = pop();
        int cost = top.cost;
        int u = top.node;

        if (dist[u] < cost) continue;
        if (u == end) return cost;

        Edge *ptr = adj[u];
        while (ptr != NULL) {
            int v = ptr->to;
            int w = ptr->weight;

            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                push(dist[v], v);
            }
            ptr = ptr->next;
        }
    }
    return dist[end];
}

void printPath(int node, int startNode, int *parent) {
    if (node == startNode) {
        printf("%s", getName(node));
        return;
    }
    printPath(parent[node], startNode, parent);
    printf(" -> %s", getName(node));
}

void showResult(int start, int end) {
    int dist[MAX_NODES];
    int parent[MAX_NODES];
    for(int i=0; i<MAX_NODES; i++) { dist[i] = INF; parent[i] = -1; }

    pq.size = 0;
    dist[start] = 0;
    push(0, start);

    while (!isHeapEmpty()) {
        HeapNode top = pop();
        int cost = top.cost;
        int u = top.node;

        if (dist[u] < cost) continue;
        if (u == end) break;

        Edge *ptr = adj[u];
        while (ptr) {
            int v = ptr->to;
            int w = ptr->weight;
            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                parent[v] = u;
                push(dist[v], v);
            }
            ptr = ptr->next;
        }
    }

    if (dist[end] == INF) {
        printf(">> 경로가 존재하지 않습니다.\n");
    } else {
        printf("\n [이동 경로 안내]\n");
        printf(" 경로: ");
        printPath(end, start, parent);
        printf("\n 총 소요 시간: %d분\n", dist[end]);
    }
}

int main() {
    loadSubwayData("subway_data.txt");

    char startInput[MAX_NAME_LEN], endInput[MAX_NAME_LEN];

    while (1) {
        printf("\n=======================================================\n");
        printf("출발역 입력 (종료: exit): ");
        // [원상 복구] 일반 scanf 사용
        scanf("%s", startInput);
        if (strcmp(startInput, "exit") == 0) break;

        printf("도착역 입력: ");
        scanf("%s", endInput);

        int s_id = -1, e_id = -1;
        for(int i=0; i<node_count; i++) {
            if(strcmp(stations[i].name, startInput)==0) s_id = i;
            if(strcmp(stations[i].name, endInput)==0) e_id = i;
        }
        if (s_id == -1 || e_id == -1) {
            printf(">> 존재하지 않는 역입니다. 다시 확인해주세요.\n");
            continue;
        }
        printf("\n>> [성능 분석] 해당 경로를 %d회 반복 계산하여 비교합니다.\n", REPEAT_COUNT);
        clock_t t1 = clock();
        long long dummy1 = 0;
        for(int i=0; i<REPEAT_COUNT; i++) {
            dummy1 += dijkstra_array(s_id, e_id);
        }
        clock_t t2 = clock();
        double time_arr = (double)(t2 - t1) / CLOCKS_PER_SEC;

        t1 = clock();
        long long dummy2 = 0;
        for(int i=0; i<REPEAT_COUNT; i++) {
            dummy2 += dijkstra_heap(s_id, e_id);
        }
        t2 = clock();
        double time_heap = (double)(t2 - t1) / CLOCKS_PER_SEC;

        printf("-------------------------------------------------------\n");
        printf(" 방식             | 총 소요 시간 (%d회 반복) \n", REPEAT_COUNT);
        printf("-------------------------------------------------------\n");
        printf(" 1. 배열 (Array)  | %.4f 초\n", time_arr);
        printf(" 2. 히프 (Heap)   | %.4f 초\n", time_heap);
        printf("-------------------------------------------------------\n");
        
        if (time_heap > 0)
            printf(" >> 히프 방식이 약 %.1f배 더 빠릅니다.\n", time_arr / time_heap);

        showResult(s_id, e_id);
    }
    for(int i=0; i<node_count; i++) {
        Edge *ptr = adj[i];
        while(ptr) { Edge* t = ptr; ptr = ptr->next; free(t); }
    }
    return 0;
}