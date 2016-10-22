package com.example.jabel.smartevents;

import android.provider.CalendarContract;

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

    public PriorityQueue(Event[] events){
        for(int x = 0; x < events.length; x++){
            add(events[x].getDescription(), events[x].getDueDate(), events[x].getDifficulty());
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

    private void swap(int x, int y){
        Event temp = maxHeap[x];
        maxHeap[x] = maxHeap[y];
        maxHeap[y] = temp;
    }

    public void heapify(){
        for (int x = numItems/2-1; x>=0; x++){
            siftDown(x);
        }
    }

    public void add(String desc, Date due, int diff) {
        //assert numItems < size : "Heap is full";
        int currNode = ++numItems;

        maxHeap[currNode] = new Event (desc, due, diff);

        while((currNode != 0) && (maxHeap[currNode].compareTo(maxHeap[getParent(currNode)]) > 0)) {
            swap(currNode, getParent(currNode));
            currNode=getParent(currNode);
        }
    }

    public Event remove(int x) {
        if (x == (numItems-1)){
            numItems--;
        }
        else{
            swap(x, --numItems);
            while ((x > 0) && (maxHeap[x].compareTo(maxHeap[getParent(x)]) > 0)){
                swap(x, getParent(x));
                x = getParent(x);
            }
            if (numItems != 0){
                siftDown(x);
            }
        }
        return maxHeap[x];
    }

    private void siftDown(int x){
        while(!isLeaf(x)) {
            int y = getLeftChild(x);
            if ((y<(numItems-1)) && (maxHeap[y].compareTo(maxHeap[y+1]) < 0)){
                y++;
            }
            if (maxHeap[x].compareTo(maxHeap[y]) >= 0){
                return;
            }
            swap(x, y);
            x=y;
        }
    }

    public boolean isLeaf(int pos)
    { return (pos >= numItems/2) && (pos < numItems); }

    public Event getMax(){
        Event head = null;

        if(!isEmpty()){
            head = maxHeap[1];
        }

        return head;
    }

    public Event removeMax(){
        swap(0, --numItems);
        if (numItems != 0) {
            siftDown(0);
        }
        return maxHeap[numItems];
    }

    public boolean isEmpty(){
        return (numItems == 0);
    }
}
