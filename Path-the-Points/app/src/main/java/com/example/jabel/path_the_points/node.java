package com.example.jabel.path_the_points;

/**
 * Created by Dimanor3 on 10/21/2016.
 */

public class node {
    private boolean isCurr = false;

	private int distance;
	
    private int cost;

    private int depth;

    public node (boolean curr, int c, int d,int dist) {
        isCurr = curr;
        cost = c;
        depth = d;
		distance = dist;
    }

	public int getDistance () {
		return distance;
	}
	
	public void setDistance (int dist) {
		distance = dist;
	}
	
    public boolean getCurr () {
        return isCurr;
    }

    public void setCurr (boolean curr) {
        isCurr = curr;
    }

    public int getCost () {
        return cost;
    }

    public int getDepth () {
        return depth;
    }
}
