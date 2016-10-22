package com.example.jabel.smartevents;

import java.util.Date;

/**
 * Created by Dimanor3 on 10/22/2016.
 */

public class Node {
    private String type;

    private Date date;

    private int difficulty;

    public Node (String t, Date d, int diff) {
        type = t;
        date = d;
        difficulty = diff;
    }
}
