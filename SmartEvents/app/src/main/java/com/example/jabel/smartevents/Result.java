package com.example.jabel.smartevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dimanor3 on 10/22/2016.
 */

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
    }

    public void Return (View v) {
        Button button = (Button) v;

        Intent intent = new Intent (this, MainActivity.class);

        startActivity (intent);
    }
}
