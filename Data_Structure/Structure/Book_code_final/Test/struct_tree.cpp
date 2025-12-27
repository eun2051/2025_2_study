#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *lchild;
    struct node *rchild;
};
typedef struct node *treePointer;
struct node *top = NULL;
struct node *front = NULL, *rear = NULL;

struct graph {
    int vertex;
    struct graph *link;
};

void inorder(struct node *ptr)
{
    if (ptr) {
        inorder(ptr->lchild);
        printf("%d", ptr->data);
        inorder(ptr->rchild);
    }
}

void preorder(struct node *ptr)
{
    if (ptr) {
        printf("%d", ptr->data);
        preorder(ptr->lchild);
        preorder(ptr->rchild);
    }
}

void postorder(struct node *ptr)
{
    if (ptr) {
        postorder(ptr->lchild);
        postorder(ptr->rchild);
        printf("%d", ptr->data);
    }
}

void push(struct node *node)
{
    struct node *temp;
    temp = (struct node *)malloc(sizeof(struct node));
    if (temp != NULL) {
        fprintf(stderr, "malloc error\n");
        exit(0);
    }
    temp->lchild = node;
    temp->rchild = top;
    top = temp;
}

struct node *pop()
{
    if (top == NULL)
        return NULL;
    struct node *temp = top;
    struct node *save_val = temp->lchild;

    top = top->rchild;
    free(temp);
    return save_val;
}

void iterinorder(struct node *node)
{
    for (;;) {
        for (; node; node = node->lchild)
            push(node);
        node = pop();
        if (!node) break;
        printf("%d", node->data);
        node = node->rchild;
    }
}

void addq(struct node *ptr)
{
    struct node *temp;
    temp = (struct node *)malloc(sizeof(struct node));
    if (temp == NULL) {
        fprintf(stderr, "empty queue\n");
        exit(0);
    }
    //
    temp->lchild = ptr;
    temp->rchild = NULL;
    if (front == NULL) {
        front = temp;
    } else {
        rear->rchild = temp;
    }
    rear = temp;
}

struct node *deleteq()
{
    if (front == NULL)
        return NULL;
    struct node *temp = front;
    struct node *save_val = temp->lchild;

    front = front->rchild;
    if (front == NULL)
        rear = NULL;
    free(temp);
    return save_val;
}

void level_order(struct node *ptr)
{
    if (!ptr)
        return ;
    addq(ptr);
    for (;;) {
        ptr = deleteq();
        if (ptr == NULL)
            break;
        printf("%d", ptr->data);
        if (ptr->lchild)
            addq(ptr->lchild);
        if (ptr->rchild)
            addq(ptr->rchild);
    }
}