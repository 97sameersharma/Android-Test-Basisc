package com.brillicaservices.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> data=new ArrayList<>();
    EditText text1,text2,text3,text4,text5,text6,text7,text8,text9;
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.name);
        text2 = findViewById(R.id.phone);
        text3 = findViewById(R.id.email);
        text4 = findViewById(R.id.address);
        text5 = findViewById(R.id.dob);
        text6 = findViewById(R.id.college);;
        text7 = findViewById(R.id.course);
        text8 = findViewById(R.id.branch);
        text9 = findViewById(R.id.sem);
        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=text1.getText().toString();
                String phone=text2.getText().toString();
                String email=text3.getText().toString();
                String address=text4.getText().toString();
                String dob=text5.getText().toString();
                String college=text6.getText().toString();
                String course=text7.getText().toString();
                String branch=text8.getText().toString();
                String sem=text9.getText().toString();

                data.add(name);
                data.add(phone);
                data.add(email);
                data.add(address);
                data.add(dob);
                data.add(college);
                data.add(course);
                data.add(branch);
                data.add(sem);

                for(int i=0;i<data.size();i++)
                {
                    textView.setText(textView.getText()+data.get(i));
                }

            }
        });


    }
}
