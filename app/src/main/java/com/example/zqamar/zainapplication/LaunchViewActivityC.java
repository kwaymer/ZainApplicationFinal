package com.example.zqamar.zainapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by zqamar on 2/22/17.
 */

public class LaunchViewActivityC extends AppCompatActivity {
    private Button a, b, c, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_c);

        a = (Button)findViewById(R.id.button_a);
        b = (Button)findViewById(R.id.button_b);
        c = (Button)findViewById(R.id.button_c);
        d = (Button)findViewById(R.id.button_d);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LaunchViewActivityA.class);
                startActivity(intent);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LaunchViewActivityB.class);
                startActivity(intent);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LaunchViewActivityC.class);
                startActivity(intent);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LaunchViewActivityD.class);
                startActivity(intent);
            }
        });
    }
}

