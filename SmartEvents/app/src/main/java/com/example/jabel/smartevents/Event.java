package com.example.jabel.smartevents;

import java.util.Date;

/**
 * Created by jabel on 10/22/2016.
 */

public class Event {
    private String description;
    private Date dueDate;
    private int difficulty;

    public Event(String desc, Date due, int diff){
        this.description = desc;
        this.dueDate = due;
        this.difficulty = diff;
    }

    public String getDescription(){
        return description;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public int getDifficulty(){
        return difficulty;
    }
}
