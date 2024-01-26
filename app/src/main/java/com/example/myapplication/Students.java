package com.example.myapplication;

public class Students {
    String name;
    String phone;
    String dept;
    String roll;
    String registration;
    String no;
    String year;
    String admission;
    String email;

    public Students(){

    }
    public Students(String name, String phone, String dept, String roll, String registration, String no, String year, String admission, String email) {
        this.name = name;
        this.phone = phone;
        this.dept = dept;
        this.roll = roll;
        this.registration = registration;
        this.no = no;
        this.year = year;
        this.admission = admission;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
