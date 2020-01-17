package com.example.admin.customer;

public class registereduser {
    private String name, address, email, password;
    private String age;
    private String number;

    public registereduser() {

    }

    public registereduser(String name, String address, String email, String password, String age, String number) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getNumber() {
        return number;
    }
}
