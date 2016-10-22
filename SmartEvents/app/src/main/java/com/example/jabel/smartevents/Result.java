package com.example.jabel.smartevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Dimanor3 on 10/22/2016.
 */

public class Result extends AppCompatActivity {
    private ScrollView sV;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //sV = (ScrollView) findViewById (R.id.scroll);
        TextView result = (TextView) findViewById (R.id.textView5);
        TextView result1 = (TextView) findViewById (R.id.textView6);
        TextView result2 = (TextView) findViewById (R.id.textView7);

        PriorityQueue maxHeap = MainActivity.maxHeap;

        result.setText (maxHeap.getMax ().getDescription () + " " + maxHeap.getMax ().getDifficulty () + " " + maxHeap.getMax ().getDueDate ());
        result1.setText (maxHeap.getMax ().getDescription () + " " + maxHeap.getMax ().getDifficulty () + " " + maxHeap.getMax ().getDueDate ());
        result2.setText (maxHeap.getMax ().getDescription () + " " + maxHeap.getMax ().getDifficulty () + " " + maxHeap.getMax ().getDueDate ());
    }

    public void Return (View v) {
        Button button = (Button) v;

        Intent intent = new Intent (this, MainActivity.class);

        startActivity (intent);
    }
}
