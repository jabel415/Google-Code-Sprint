package com.example.jabel.smartevents;

import java.lang.Comparable;

/**
 * Created by jabel on 10/22/2016.
 */

public class PriorityQueue<T extends Comparable<? super T>> {
    private int size;
    private int numItems;
    private Event task;
    private T[] maxHeap;


    public PriorityQueue(T[] heap, int length, int max){
        this.maxHeap = heap;
        this.numItems = length;
        this.size = max;
        constructHeap();
    }

    public void constructHeap(){
        for(int x = numItems/2-1; x >= 0; x++){
        //siftdown(
        }
    }
    private int getParent(int x){
        return (x-1)/2;
    }

    private int getLeftChild(int x){
        return 2*x+1;
    }

    private int getRightChild(int x){
        return 2*x+2;
    }

    public void add(Event task) {
        assert numItems < size : "Heap is full";
        int currNode = numItems++;

    }

    public T getMax(){
        T head = null;
        if(!isEmpty()){
            head = maxHeap[1];
        }
        return head;
    }
    public boolean isEmpty(){
        return (numItems == 0);
    }
}
