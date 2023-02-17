package com.jobstack.jobstack.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobApplication")
public class Application {
    private String name;
    private int age;
    private String email;
    private int contact_no;

    private String status;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Application() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", contact_no=" + contact_no +
                ", status='" + status + '\'' +
                '}';
    }

}
