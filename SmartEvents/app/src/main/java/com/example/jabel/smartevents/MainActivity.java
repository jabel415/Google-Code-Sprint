package com.example.jabel.smartevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Spinner task;
    private EditText date, difficulty;
    public static PriorityQueue maxHeap = new PriorityQueue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = (Spinner) findViewById (R.id.task);

        ArrayAdapter<CharSequence> adapterTask = ArrayAdapter.createFromResource(this, R.array.weights, android.R.layout.simple_spinner_item);

        adapterTask.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        task.setAdapter(adapterTask);

        date = (EditText) findViewById (R.id.date);
        difficulty = (EditText) findViewById (R.id.difficult);
    }

    public void submit (View v) {
        Button button = (Button) v;
        String dateString = date.toString();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date d = null;
        try {
            d = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        maxHeap.add(task.toString (),d, Integer.parseInt (difficulty.getText ().toString ()));
    }

    public void result (View v) {
        Button button = (Button) v;

        Intent intent = new Intent (this, Result.class);

        startActivity (intent);
    }
}