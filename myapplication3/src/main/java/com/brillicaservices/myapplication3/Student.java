package com.brillicaservices.myapplication3;

public class Student {
    String name,email,address,dob,collegeName,course,branch;
    int phone,sem;
 public Student(String name, int phone,String email,String address,String dob,String collegeName,String course,String branch,int sem) {
        this.name =name;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.dob=dob;
        this.course=course;
        this.branch=branch;
        this.sem=sem;
        this.collegeName=collegeName;
    }
}
