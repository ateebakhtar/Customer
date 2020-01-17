package com.example.admin.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class confirmitem extends AppCompatActivity {

    int total;
    int count = 1;
    int sum;
    TextView s1;
    TextView s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmitem);
        de.hdodenhof.circleimageview.CircleImageView image = findViewById(R.id.image);
        Bundle x = getIntent().getExtras();

        s1 = findViewById(R.id.textView3);
        s2 = findViewById(R.id.textView5);

        String t1 = x.getString("Name");
        String t2 = x.getString("Price");
        String t3 = x.getString("url");

        Glide.with(this)

                .load(t3)
                .into(image);


        total =  Integer.parseInt(t1);
        s1.setText(t2);
        s2.setText(t1);
    }
    public void add(View view)
    {
        count++;
        sum = total * count;
        s2.setText(" "+sum);
    }


    public void subract(View view) {
        if(count > 1)
        {
            count--;
        }
        else
        {
            Toast.makeText(this, "Cant be lower", Toast.LENGTH_SHORT).show();
        }
        sum = total * count;
        s2.setText(" "+sum);
    }
    public void addtocart(View view)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        cartinfo  x1 = new cartinfo();

        Bundle x = getIntent().getExtras();
        String t1 = x.getString("Name");

        String t2 = x.getString("Price");
        String t3 = x.getString("url");
        namep = t2;
        String t4 = x.getString("ingre");
        String t5 = ""+count;
        x1.insertdata(t1,t2,t5,t4,t3);

        db.collection("Cart").add(x1);

        System.out.println(getname());
        db.collection("Cart")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null, x4 = null;
                        String[] x0;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult()) {
                                if(x.getString("name").equals(getname()))
                                {
                                    System.out.println(getname());
                                    x1 = x.getString("ingredients");
                                    System.out.println(x1);
                                    x0 = x1.split("\\s");

                                    data(x0);
                                    int i1 = editinventory(x0);

                                    for(int i=0;i<x0.length;i++)
                                    {
                                        System.out.println(x0[i]);
                                    }
                                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                                    //db.collection("Cart").document(x.getId()).delete();

                                }
                            }
                        }
                    }
                });
    }
    String namep;
    String getname()
    {
        return namep;
    }
    String m[];
    void data(String m[])
    {
        this.m = m;
    }
    int editinventory(String m12[])
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Inventory")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null;
                        String[] x0;
                        String m1[] = m;
                        //                       System.out.println(m);
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult())
                            {
                                x1 = x.getString("name");
                                for(int i=0;i<m1.length;i++)
                                {
                                    System.out.println(m1[i]);
                                    if(x1.equals(m1[i]))
                                    {
                                        x2 = x.getString("quantity");

                                        x3 = x.getId();

                                        update(x2,x3);

                                    }

                                }
                            }
                        }
                    }
                });
        return 1;
    }
    void update(String x,String y)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        int temp = Integer.parseInt(x);
        System.out.println("thing"+count);
        temp = temp - count;
        x = ""+temp;
        db.collection("Inventory").document(y).update("quantity",x);
    }
    public void opencart(View view)
    {
        Intent x = new Intent(this,viewcart.class);
        startActivity(x);
    }
}
