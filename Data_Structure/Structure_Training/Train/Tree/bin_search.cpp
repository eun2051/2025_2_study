/* binary search tree의 탐색 */
#include <stdio.h>
#include <stdlib.h>

typedef int iType;
typedef struct {
	iType key;
	iType item;
} element;

typedef struct node *treePointer;
typedef struct node {
	element data;
	treePointer leftChild;
	treePointer rightChild;
};

element *search(treePointer tree, int key)
{
	if (!tree) return NULL;
	if (key == tree->data.key)
		return &(tree->data);
	if (key < tree->data.key)
		return search(tree->leftChild, key);
	return search(tree->rightChild, key);
}

/* 순환 탐색 함수*/
element *iterSearch(treePointer tree, int k)
{
	while (tree) {
		if (k == tree->data.key)
			return &(tree->data);
		if (k < tree->data.key)
			tree = tree->leftChild;
		else
			tree = tree->rightChild;
	}
	return NULL;
}

/* binary search tree에서 삽입 */
void insert(treePointer *node, int k, iType theItem)
{
	treePointer temp = modified_search(*node, k);
	if (temp || !(*node)) {
		struct node *ptr = (struct node *)malloc(sizeof(struct node));
		ptr->data.key = k;
		ptr->data.item = theItem;
		ptr->leftChild = ptr->rightChild = NULL;
		if (*node) {
			if (k < temp->data.key)
				temp->leftChild = ptr;
			else
				temp->rightChild = ptr;
		} else {
			*node = ptr;
		}
	}
}

struct node *modified_search(struct node *root, int key)
{
    for (struct node *ptr = root; ptr != NULL;) {
		if (key == ptr->data.key)
			return NULL;
		if (key < ptr->data.key) {
			if (ptr->leftChild == NULL)
                return ptr;
			else
				ptr = ptr->leftChild;
		} else {
			if (ptr->rightChild == NULL)
                return ptr;
			else
				ptr = ptr->rightChild;
		}
	}
	return NULL;
}

/* binary search tree 에서 삭제 
- case1 : 자식이 없는 경우 -> 그냥 삭제
- case2 : 자식이 1개인 경우 -> 자식을 부모 위치로 올리고 삭제
- case3 : 자식이 2개인 경우 -> 오른쪽 서브트리에서 가장 작은 값(succesor)을 찾ㄷ아 현재 노드 위치로 옮긴다
                        -> 원래 있던 그 successor 노드 삭제 */

// 오른쪽 서브트리에서 가장 작은 노드(successor)를 찾는 함수
treePointer findMin(treePointer node) {
    treePointer current = node;
    // 맨 왼쪽 단말 노드로 내려감
    while (current && current->leftChild != NULL) {
        current = current->leftChild;
    }
    return current;
}

treePointer deleteNode(treePointer root, int key)
{
	if (root == NULL)
		return root;
	if (key < root->data.key) {
		root->leftChild = deleteNode(root->leftChild, key);
	}
	else if (key > root->data.key) {
		root->rightChild = deleteNode(root->rightChild, key);
	} else {
		if (root->leftChild == NULL) {
			treePointer temp = root->rightChild;
			free(root);
			return temp;
		}
		else if (root->rightChild == NULL) {
			treePointer temp = root->leftChild;
			free(root);
			return temp;
		}
		treePointer temp = findMin(root->rightChild);
		root->data = temp->data;
		root->rightChild = deleteNode(root->rightChild, temp->data.key);
	}
	return root;
}