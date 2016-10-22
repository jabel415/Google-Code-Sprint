package com.example.jabel.smartevents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/**
 * Created by jabel on 10/22/2016.
 */

public class Event implements Comparable<Event>{
    private String description;
    private Date dueDate;
    private Date currDate = Calendar.getInstance().getTime();
    private int difficulty;
    private int priority;

    public Event(String desc, Date due, int diff){
        this.description = desc;
        this.dueDate = due;
        this.difficulty = diff; // [1-10]
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

    public double timeLeft(Date due){
        double diff = Math.abs(due.getTime() - currDate.getTime());
        double diffDays = diff / (24 * 60 * 60 * 1000);
        return diffDays;
    }

    public double priority(Event task){
        if(timeLeft(task.dueDate)<7){
            priority*=1;
        }
        return priority;
    }

    @Override
    public int compareTo(Event task) {
        return 1;
    }

    public static void main(String[]args){
        Date currDate = Calendar.getInstance().getTime();
        String date = "01/11/2012";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = null;

        try {
            d1 = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double diff = Math.abs(d1.getTime() - currDate.getTime());
        double diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.println(diffDays);
    }
}
