package com.example.admin.customer;

import com.google.firebase.firestore.Exclude;

public class inventory
{
    String name;
    String quantity;
    String price;
    @Exclude
    void insertdata(String x1,String x2,String x3 )
    {
        this.name = x1;
        this.quantity = x3;
        this.price = x2;
    }

}
