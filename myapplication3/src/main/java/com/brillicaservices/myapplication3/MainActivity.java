package com.brillicaservices.myapplication3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    AlertDialog.Builder builder;
    ArrayList<Student> data=new ArrayList<>();
    EditText text1,text2,text3,text4,text5,text7,text8,text9;
    Button btn1,btn2;
    TextView textView1;
    String collegeName = "";
    Spinner spinnerCollegeNames;
    String collegeNames[] = {"Select college name","DIT", "Graphic Era", "HNB"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 =(EditText) findViewById(R.id.name);
        text2 =(EditText) findViewById(R.id.phone);
        text3 =(EditText) findViewById(R.id.email);
        text4 =(EditText) findViewById(R.id.address);
        text5 =(EditText) findViewById(R.id.dob);
        spinnerCollegeNames = findViewById(R.id.college_name_spinner);
        text7 =(EditText) findViewById(R.id.course);
        text8 =(EditText) findViewById(R.id.branch);
        text9 =(EditText) findViewById(R.id.sem);
        btn1 =(Button) findViewById(R.id.button);
        btn2 =(Button) findViewById(R.id.display);
        textView1 =(TextView) findViewById(R.id.textView);

        builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        spinnerCollegeNames.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, collegeNames);
        spinnerCollegeNames.setAdapter(arrayAdapter);
        spinnerCollegeNames.setPrompt(collegeNames[0]);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setMessage("check your name").setTitle("name error");

//                        builder.setNegativeButton("OK)
                AlertDialog dialog = builder.create();
                dialog.show();

                try {

                    String name = text1.getText().toString();
                    int phone = Integer.parseInt(text2.getText().toString());
                    String email = text3.getText().toString();
                    String address = text4.getText().toString();
                    String dob = text5.getText().toString();
                    String course = text7.getText().toString();
                    String branch = text8.getText().toString();
                    int sem =Integer.parseInt(text9.getText().toString());

                    if((name.length()>2)&&(text2.length()==10)&&(email.length()>5)&&(address.length()>5)&&(dob.length()==10)&&(text9.length()==1)&&(course.length()>2)) {
                        data.add(new Student(name, phone, email, address, dob, collegeName, course, branch, sem));
                        Toast.makeText(getApplicationContext(), "Student data saved sucessfully", Toast.LENGTH_LONG).show();
                    }


                    else if(name.length()<3)
                    {




                    }
                    else if(!(text2.length()==10))
                    {

                        Toast.makeText(getApplicationContext(),"phone number must be 10 digit number",Toast.LENGTH_LONG).show();
                    }
                    else if(email.length()<5)
                    {
                        Toast.makeText(getApplicationContext(),"email address must be 5 character long",Toast.LENGTH_LONG).show();

                    }
                    else if(address.length()<5)
                    {
                        Toast.makeText(getApplicationContext(),"address must be 5 character long",Toast.LENGTH_LONG).show();
                    }
                    else if(dob.length()<10)
                    {
                        AlertDialog.Builder builder2= new AlertDialog.Builder(getApplicationContext());
                        final AlertDialog.Builder builder3=builder2.setMessage(" DOB will be in DD/MM/YYYY format ").setTitle("DOB Error");
                    }
                    else if (!(text9.length()==1))
                    {
                        Toast.makeText(getApplicationContext(),"semester must be 1 digit number",Toast.LENGTH_LONG).show();
                    }

                    }
                    catch (NumberFormatException e)
                    {

                        Toast.makeText(getApplicationContext(), "Please check your values and enter a valid input",Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Please check your values, enter  a valid input", Toast.LENGTH_LONG).show();
                    }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<data.size();i++)
                {textView1.setText("");
                    textView1.setText(textView1.getText()+"\n NAME : "+data.get(i).name);
                    textView1.setText(textView1.getText()+"\n PHONE : "+data.get(i).phone);
                    textView1.setText(textView1.getText()+"\n EMAIL : "+data.get(i).email);
                    textView1.setText(textView1.getText()+"\n ADDRESS : "+data.get(i).address);
                    textView1.setText(textView1.getText()+"\n DOB : "+data.get(i).dob);
                    textView1.setText(textView1.getText()+"\n COLLEGE : "+data.get(i).collegeName);
                    textView1.setText(textView1.getText()+"\n COURSE : "+data.get(i).course);
                    textView1.setText(textView1.getText()+"\n BRANCH : "+data.get(i).branch);
                    textView1.setText(textView1.getText()+"\n SEM : "+data.get(i).sem);

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
