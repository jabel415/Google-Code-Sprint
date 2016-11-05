package com.example.jabel.smartevents;

import android.provider.CalendarContract;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jabel on 10/22/2016.
 * Edited by Dimanor3 on 11/5/2016.
 */

public class PriorityQueue<T extends Comparable<? super T>> {
    private int numItems;
    private ArrayList <Event> maxHeap = new ArrayList <Event> ();


    public PriorityQueue () {
        numItems = 0;
        place ("Empty", null, 0);
    }

    public PriorityQueue (ArrayList<Event> events) {
        for (int x = 0; x < events.size (); x++){
            place (events.get (x).getDescription (), events.get (x).getDueDate (), events.get (x).getDifficulty ());
        }
    }

    private int getParent (int x) {
        return (x - 1) / 2;
    }

    private int getLeftChild (int x){
        return 2 * x + 1;
    }

    private int getRightChild (int x){
        return 2 * x + 2;
    }

    private void swap (int x, int y) {
        Event temp = maxHeap.get (x);
        maxHeap.set (x, maxHeap.get (y));
        maxHeap.set (y, temp);
    }

    public void heapify () {
        for (int x = numItems / 2 - 1; x >= 0; x++){
            siftDown (x);
        }
    }

    public void place (String desc, Date due, int diff) {
        //assert numItems < size : "Heap is full";
        int currNode = ++numItems;

        maxHeap.add (new Event (desc, due, diff));

        if (numItems <= maxHeap.size () - 1) {
            while ((currNode != 0) && (maxHeap. get (currNode).compareTo (maxHeap.get (getParent (currNode))) > 0)) {
                swap (currNode, getParent (currNode));
                currNode = getParent (currNode);
            }
        } else {
            System.out.println ("Full!");
        }
    }

    public Event access (int x) {
        if (x >= numItems || x <= 0) {
            return new Event ("Empty", null, 0);
        }

        System.out.println ("TEST: " + Integer.toString (x));

        return maxHeap.get (x);
    }

    public Event remove (int x) {
        if (x == (numItems - 1)){
            numItems--;
        } else {
            swap (x, --numItems);

            while ((x > 0) && (maxHeap.get (x).compareTo (maxHeap.get (getParent(x))) > 0)){
                swap (x, getParent (x));
                x = getParent (x);
            }

            if (numItems != 0) {
                siftDown (x);
            }
        }

        return maxHeap.get (x);
    }

    private void siftDown (int x) {
        while (!isLeaf (x)) {
            int y = getLeftChild (x);

            if ((y < (numItems-1)) && (maxHeap.get (y).compareTo(maxHeap.get (y+1)) < 0)){
                y++;
            }

            if (maxHeap.get (x).compareTo (maxHeap.get (y)) >= 0){
                return;
            }

            swap (x, y);

            x = y;
        }
    }

    public boolean isLeaf (int pos) { return (pos >= numItems / 2) && (pos < numItems); }

    public Event getMax () {
        Event head = null;

        if(!isEmpty ()){
            head = maxHeap.get (1);
        } else {
            System.out.println ("Failed!");
        }

        return head;
    }

    public Event removeMax () {
        swap(1, --numItems);
        if (numItems != 1) {
            siftDown (1);
        }
        return maxHeap.get (numItems);
    }

    public boolean isEmpty (){
        return (numItems == 0);
    }
}
