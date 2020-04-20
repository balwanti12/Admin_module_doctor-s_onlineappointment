package com.example.new_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText adminname;
    EditText pass;
    Button login;
    String admin_name="admin",admin_pass="a123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adminname=findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);
        login=findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    void login()
    {
        if(admin_name.equals(adminname.getText().toString()) && admin_pass.equals(pass.getText().toString()))
        {
            Intent i = new Intent(getApplicationContext(),Dashboard.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Enter valid adminname or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
