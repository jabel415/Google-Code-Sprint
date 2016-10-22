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
    private Spinner task, difficulty;
    private EditText date;
    private PriorityQueue maxHeap = new PriorityQueue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = (Spinner) findViewById (R.id.task);
        difficulty = (Spinner) findViewById (R.id.difficult);

        ArrayAdapter<CharSequence> adapterTask = ArrayAdapter.createFromResource(this, R.array.weights, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterDifficulty = ArrayAdapter.createFromResource(this, R.array.difficulty, android.R.layout.simple_spinner_item);

        adapterTask.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        task.setAdapter(adapterTask);
        difficulty.setAdapter(adapterDifficulty);

        date = (EditText) findViewById (R.id.date);
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

        maxHeap.add(task.toString(),d, Integer.valueOf(difficulty.toString()));
    }

    public void result (View v) {
        Button button = (Button) v;

        Intent intent = new Intent (this, Result.class);

        startActivity (intent);
    }
}
