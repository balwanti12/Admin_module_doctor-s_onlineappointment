package com.example.new_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    MyHelper mh;

    Button view;
    Button register;
    Button update;
    Button viewdoctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        view=findViewById(R.id.button2);
        register=findViewById(R.id.button3);
        update=findViewById(R.id.button4);
        viewdoctors=findViewById(R.id.button4);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i=new Intent(getApplicationContext(),second.class);
                // startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),Register.class);
                startActivity(i1);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "update info", Toast.LENGTH_SHORT).show();
            }
        });

        viewdoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c1=mh.getRecords();
                while(c1.moveToNext())
                {

                    Toast.makeText(Dashboard.this, c1.getString(0) + c1.getString(1) + c1.getString(2), Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
