#include <stdio.h>
#include <stdlib.h>

typedef struct threadedTree *threadedPointer;
typedef struct threadedTree {
    char data;
    short int leftThread;
    short int rightThread;
    threadedPointer leftChild;
    threadedPointer rightChild;
};

threadedPointer insucc(threadedPointer tree)
{
    threadedPointer temp;
    temp = tree;
}