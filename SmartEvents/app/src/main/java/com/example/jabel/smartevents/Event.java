package com.example.jabel.smartevents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by jabel on 10/22/2016.
 */

public class Event implements Comparable<Event>{
    private String description;
    private Date dueDate;
    private Date currDate = Calendar.getInstance().getTime();
    private int difficulty;
    private double priority;

    public Event(String desc, Date due, int diff){
        this.description = desc;
        this.dueDate = due;
        this.difficulty = diff; // [1-10]
        this.priority=priority(this);
    }

    public double timeLeft(Date due) {
        if (due != null) {
            double diff = Math.abs (due.getTime () - currDate.getTime ());
            double diffDays = diff / (24 * 60 * 60 * 1000);
            return diffDays;
        }

        return -1;
    }

    /*public double priority(Event task){
        double difficulty = (double)this.difficulty;
        if(timeLeft(task.dueDate)<7){
            priority=Math.ceil(difficulty*(timeLeft(task.dueDate)));
        }
        else if(timeLeft(task.dueDate)%7==0){
            priority=Math.ceil((difficulty*.75)*(timeLeft(task.dueDate)));
        }
        else{
            priority=Math.ceil((difficulty*.5)*(timeLeft(task.dueDate)));
        }
        return priority;
    }*/

    public double priority(Event task){
        double difficulty = (double)this.difficulty;
        if(timeLeft(task.dueDate)<=1)
        {
            priority=Math.ceil(difficulty*2 / ((timeLeft(task.dueDate))));
        }
        if(timeLeft(task.dueDate)<7){
            priority=Math.ceil(difficulty / ((timeLeft(task.dueDate))));
        }
        else{
            priority=Math.ceil((difficulty*.5)/(timeLeft(task.dueDate)));
        }
        return priority;
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

    public double getPriority(){ return priority; }

    @Override
    public int compareTo(Event task) {
        if (this != null && task != null) {
            if (this.priority < task.priority) {
                return -1;
            } else if (this.priority == task.priority) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -2;
        }
    }

    /*public static void main(String[]args){

        Date currDate = Calendar.getInstance().getTime();
        String date1 = "11/11/2016";
        String date2 = "11/15/2016";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = df.parse(date1);
            d2 = df.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Event task1 = new Event("paper", d1,4);
        Event task2 = new Event("test", d2,7);
        double diff = Math.abs(d1.getTime() - currDate.getTime());
        double diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.println(diffDays);
        System.out.println(task1.compareTo(task2));
    }*/
}
