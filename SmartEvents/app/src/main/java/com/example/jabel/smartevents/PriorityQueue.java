package com.example.jabel.smartevents;

import java.lang.Comparable;
import java.util.Date;

/**
 * Created by jabel on 10/22/2016.
 */

public class PriorityQueue<T extends Comparable<? super T>> {
    private int numItems;
    private Event[] maxHeap;


    public PriorityQueue(){
        numItems = 0;
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

    public void add(String desc, Date due, int diff) {
        //assert numItems < size : "Heap is full";
        int currNode = numItems++;

        maxHeap[currNode] = new Event (desc, due, diff);
    }

    public Event getMax(){
        Event head = null;

        if(!isEmpty()){
            head = maxHeap[1];
        }

        return head;
    }
    public boolean isEmpty(){
        return (numItems == 0);
    }
}
