package com.example.admin.customer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class managerinfo
{
void getdata()
{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    db.collection("manager")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(Task<QuerySnapshot> task) {
                    String x3 = null, x1 = null, x2 = null,x4 = null;

                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot x : task.getResult())
                        {
                            x2 = x.getString("name");
                            System.out.println("Name"+x2);
                        }
                    }
                    else
                     {
                        System.out.println("Eorrrosr");
                    }
                }
            });
}
    void getinven()
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null;

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult())
                            {
                                x2 = x.getString("ingreidents");
                                System.out.println("Name"+x2);
                            }
                        }
                        else
                        {
                            System.out.println("Eorrrosr");
                        }
                        String[] x0 = x2.split("\\s");
                        System.out.println(x0[0]);

                    }
                });
    }
void transfer()
{
    inventory x = new inventory();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    x.insertdata("chicken","180","60");
    db.collection("Inventory").add(x);
    x.insertdata("beef","380","60");
    db.collection("Inventory").add(x);
    x.insertdata("mushroom","180","150");
    db.collection("Inventory").add(x);
    x.insertdata("cheese","280","160");
    db.collection("Inventory").add(x);
    x.insertdata("mayo","80","10");
    db.collection("Inventory").add(x);

}
    inventory x = new inventory();

}

