/* Min Heap
- 부모 <= 자식
- 삽입 시 : 부모보다 작으면 올라간다
- 삭제 시 : 자식 중 더 작은 자식과 비교하여 크면 내려간다 */

#include <stdio.h>
#include <stdlib.h>

#define MAX_ELEMENTS 200
#define HEAP_FULL(n) (n == MAX_ELEMENTS - 1)
#define HEAP_EMPTY(n) (!n)

typedef struct {
    int key;
} element;

element heap[MAX_ELEMENTS];
int n = 0;

void insert_min_heap(int key) {
    if (HEAP_FULL(n)) {
        fprintf(stderr, "오류: 히프가 가득 찼습니다.\n");
        return;
    }
    int i = ++n;
    // 부모보다 내 키값이 작으면 위로 올라감
    while ((i != 1) && (key < heap[i/2].key)) {
	    heap[i] = heap[i / 2];
	    i /= 2;
    }
    heap[i].key = key;
}

element delete_min_heap()
{
	element item, temp;
	if (HEAP_EMPTY(n)) {
	}
	item = heap[1];
	temp = heap[n--];
	int parent = 1;
  int child = 2;
  
  while (child <= n) {
	  if ((child < n) && (heap[child].key > heap[child + 1].key))
		  child++;
		if (temp.key <= heap[child].key)
			break;
		heap[parent] = heap[child];
		parent = child;
		child *= 2;
	}
	heap[parent] = temp;
  return item;
}

void up_heap(int index) {
    element temp = heap[index];
    while (index > 1 && heap[index / 2].key > temp.key) {
        heap[index] = heap[index / 2];
        index /= 2;
    }
    heap[index] = temp;
}

void down_heap(int index) {
    element temp = heap[index];
    int parent = index;
    int child = index * 2;

    while (child <= n) {
        if ((child < n) && (heap[child].key > heap[child + 1].key)) {
            child++;
        }
        if (temp.key <= heap[child].key) break;

        heap[parent] = heap[child];
        parent = child;
        child *= 2;
    }
    heap[parent] = temp;
}

void change_priority(int index, int new_key) {
    if (index < 1 || index > n) {
        printf("오류: 유효하지 않은 인덱스입니다.\n");
        return;
    }

    int old_key = heap[index].key;
    heap[index].key = new_key;
    
    if (new_key < old_key) {
	    up_heap(index);
	  }
	  else if (new_key > old_key) {
		  down_heap(index);
		}
}