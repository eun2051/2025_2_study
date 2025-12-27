#include <stdio.h>
#include <stdlib.h>

void add_max_heap(int heap[], int data, int pos);
int delete_max_heap(int heap[], int *N);
void inorder(int heap[], int pos, int N);

void main()
{
	int seed, N;

	printf("seed와 노드 수? ");
	scanf("%d%d", &seed, &N);
	srand(seed);

	int* heap = (int*)malloc(sizeof(int) * (N + 1));	// 1부터 N까지 데이터 저장
	for (int i = 1; i <= N; i++)
		add_max_heap(heap, rand() % 100, i);

	printf("문제 1.1 insert 후의 Heap 내용: [ ");
	for (int i = 1; i <= N; i++)
		printf("%d ", heap[i]);
	printf("]\n");

	printf("문제 1.2 heap을 inorder 순회한 내용: [ ");
	inorder(heap, 1, N);
	printf("]\n");

	int loop_count = N / 3;
	for (int i = 0; i < loop_count; i++)
		delete_max_heap(heap, &N);			// heap에서 root 제거하고, N을 1 감소
	
	printf("문제 1.3 delete 후의 Heap 내용: [ ");
	for (int i = 1; i <= N; i++)
		printf("%d ", heap[i]);
	printf("]\n");
}
