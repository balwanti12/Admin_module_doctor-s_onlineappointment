package com.example.new_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    MyHelper mh;

    EditText name;
    EditText email;
    EditText phone;
    EditText pass1,education,department;
    //TextView edu1;
    //TextView dep1;

    //Spinner edu;
    //Spinner dep;
    Button register;
    //Button show;

    Boolean  EditTextEmptyHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mh=new MyHelper(this);

        name = findViewById(R.id.editText3);
        email = findViewById(R.id.editText4);
        phone = findViewById(R.id.editText5);
        pass1 = findViewById(R.id.editText6);
       // edu1 = findViewById(R.id.textView);
       // dep1 = findViewById(R.id.textView2);
        register = findViewById(R.id.button5);
        education = findViewById(R.id.editText7);
        department= findViewById(R.id.editText8);
      //  edu = findViewById(R.id.spinner);
       // dep = findViewById(R.id.spinner2);
      //  show = findViewById(R.id.button7);

        //ArrayAdapter<String> arrayAdapter1;
       // ArrayAdapter<String> arrayAdapter2;
        //String[] s1 = {"mbbbs", "bhms", "bams", "dentist"};
        //String[] s2 = {"surgery", "operation", "checking", "something something"};

        //arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s1);
        //arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //edu.setAdapter(arrayAdapter1);

        //arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s2);
        //arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //dep.setAdapter(arrayAdapter2);
        //AddData();
        //show();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= name.getText().toString();
                String Email= email.getText().toString();
                String Mobile=phone.getText().toString();
                String Password= pass1.getText().toString();
                //int Mobile=Integer.parseInt(Mob);
                String Education=education.getText().toString();
                String Department= department.getText().toString();
                if (TextUtils.isEmpty(Name) ||TextUtils.isEmpty(Email)|| TextUtils.isEmpty(Mobile)||TextUtils.isEmpty(Password)) {

                    EditTextEmptyHolder = false;
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();


                }


                else{


                    mh.insertRecords(Name,Email,Mobile,Password,Education,Department);

                    Toast.makeText(getApplicationContext(),"Successfully Registered"+Name+ Mobile+Password+Education+Department,Toast.LENGTH_LONG).show();

                }
            }
        });

        /*

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c1=mh.getRecords();
                while(c1.moveToNext())
                {

                    Toast.makeText(Register.this, c1.getString(0) + c1.getString(1) + c1.getString(2), Toast.LENGTH_LONG).show();

                }
            }
        });



         */


    }
}

