/* 최대 히프에서 임의 원소의 우선순위를 변경할 수 있는 함수 */
#include <stdio.h>
#include <stdlib.h>
#define MAX_ELEMENTS 200 // 최대 히프 크기 + 1
#define HEAP_FULL(n) (n == MAX_ELEMENTS - 1)
#define HEAP_EMPTY(n) (!n)

typedef struct {
	int key;
} element;
element heap[MAX_ELEMENTS];
int n = 0;

// 키 값이 커졌을 때 위로 올리는 함수
void up_heap(int index)
{
	//루트가 아니고 (index > 1), 부모보다 내 키값이 더 크면 반복
	while (index > 1 && heap[index / 2].key < heap[index].key) {
		element temp = heap[index];
    heap[index] = heap[index / 2];
    heap[index / 2] = temp; // 부모와 교환
	  
	  index = index / 2; // 인덱스를 부모 위치로 이동
	}
}

// 키 값이 작아졌을 때 아래로 내리는 함수
void down_heap(int index)
{
	int child;
	element temp = heap[index]; // 현재 노드를 잠시 저장
	
	// 왼쪽 자식이 힙 범위 내에 있는 동안 반복
	while (index * 2 <= n) {
		child = index * 2;
		// 오른쪽 자식이 있고, 오른쪽 자식이 왼쪽 자식보다 크다면 오른쪽 선택
		if (child < n && heap[child].key < heap[child + 1].key)
			child++;
		// 만약 temp 값이 더 큰 자식보다 크거나 같다면 멈춤 
		if (temp.key >= heap[child].key)
			break;
		// 자식이 더 크다면 자식을 부모 자리로 올림
		heap[index] = heap[child];
		index = child; // 아래로 이동	
	}
	heap[index] = temp; // 최종 위치에 값 저장
}

// 메인 기능 - 임의의 위치의 우선순위를 new_key로 변경
void change_priority(int index, int new_key)
{
	if (index < 1 || index > n) {
		printf("index error");
		return ;
	}
	int old_key = heap[index].key;
	heap[index].key = new_key;
	if (new_key > old_key) {
		up_heap(index);
	}
	else if (new_key < old_key) {
		down_heap(index);
	}
}

element pop(int *n)
{
	int parent, child;
	element item, temp;
	if (HEAP_EMPTY(*n)) {
		fprintf(stderr, "empty heap\n");
		exit(0);
	}
	item = heap[1]; // 반환할 최대값(루트) 저장
	temp = heap[(*n)--]; // 힙의 맨 마지막 노드를 가져오고 크기를 줄임
	parent = 1;
	child = 2;
	while (child <= *n) {
		// 현재 노드의 왼쪽 자식과 오른쪽 자식 중 큰 것을 선택
		if ((child < *n) && (heap[child].key < heap[child + 1].key))
			child++;
		// 마지막 노드인 temp가 더 큰 자식보다 크거나 같으면
		// 제자리를 찾은 것이므로 루프 종료
		if (temp.key >= heap[child].key)
			break;
		// 자식이 더 크다면 부모 자리로 끌어올림
		heap[parent] = heap[child];
		// 한 단계 아래로 내려감
		parent = child;
		child *= 2;		
	}
	// 찾아낸 위치에 마지막 노드를 삽입
	heap[parent] = temp;
	return item;
}

/* 최대 히프에서 임의 원소를 삭제하는 함수 */
element delete_element(int index, int *n)
{
	// 인덱스 유효성 검사
	if (index < 1 || index > *n) {
		fprintf(stderr, "index error\n");
		exit(0);
	}
	// 삭제할 원소의 키를 현재 힙의 최대값(루트)보다 더 크게 설정
	// -> 이렇게 하면 힙 속상 상 무조건 루트로 올라가야함
	int infinity_key = heap[1].key + 1;
	// 우선순위 변경( 내부적으로 upheap, downheap있음)
	change_priority(index, infinity_key);
	return pop(n);
}

/* 최대 히프에서 임의 원소를 탐색하는 C 함수*/
int find_element(element heap[], int n, int target_key)
{
	for (int i = 1; i <= n; i++) {
		if (heap[i].key == target_key)
			return i;
			//찾은 위치의 인덱스 반환
	}
	return 0;
}