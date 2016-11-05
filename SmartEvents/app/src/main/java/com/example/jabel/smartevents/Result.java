package com.example.jabel.smartevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Dimanor3 on 10/22/2016.
 */

public class Result extends AppCompatActivity {
    private ScrollView sV;
    private ArrayList<TextView> result = new ArrayList<TextView> ();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //sV = (ScrollView) findViewById (R.id.scroll);
        result.add ((TextView) findViewById (R.id.textView5));
        result.add ((TextView) findViewById (R.id.textView12));
        result.add ((TextView) findViewById (R.id.textView6));
        result.add ((TextView) findViewById (R.id.textView13));
        result.add ((TextView) findViewById (R.id.textView7));

        PriorityQueue maxHeap = MainActivity.maxHeap;

        for (int i = 0; i < result.size (); i++) {
            result.get (i).setText (maxHeap.access (i + 1).getDescription () + " " + maxHeap.access (i + 1).getDifficulty () + " " + maxHeap.access (i + 1).getDueDate ());
        }
    }

    public void Return (View v) {
        Button button = (Button) v;

        Intent intent = new Intent (this, MainActivity.class);

        startActivity (intent);
    }
}
