#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *lchild;
    struct node *rchild;
};

struct node *copy(struct node *original)
{
    struct node *temp;
    if (original)
    {
        temp = (struct node *)malloc(sizeof(struct node));
        temp->lchild = copy(original->lchild);
        temp->rchild = copy(original->rchild);
        temp->data = original->data;
        return temp;
    }
    return NULL;
}

int equal(struct node *first, struct node *second)
{
    return ((!first && !second) || (first && second && (first->data == second->data) && equal(first->lchild, second->lchild) && equal(first->rchild, second->rchild)));
}

//이진 트리에서 리프 노드의 수를 세는 C 함수 작성
int count_leafnode(struct node *root)
{
    if (root == NULL)
        return 0;
    if (root->lchild == NULL && root->rchild == NULL)
        return 1;
    return count_leafnode(root->lchild) + count_leafnode(root->rchild);
}

//이진트리를 입력하여 왼쪽 자식과 오른쪽 자식을 교환하는 함수
void swapTree(struct node *root)
{
    if (root == NULL)
        return ;
    struct node *temp = root->lchild;
    root->lchild = root->rchild;
    root->rchild = temp;
    swapTree(root->lchild);
    swapTree(root->rchild);
}