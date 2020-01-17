package com.example.admin.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class menu extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String pos;
    public ArrayList<String> mNames = new ArrayList<String>();
    public ArrayList<String> mImageUrls = new ArrayList<String>();
    public ArrayList<String> xn = new ArrayList<String>();
    public ArrayList<String> ingre = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // adddata();
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Bundle q = getIntent().getExtras();

        db.collection("Menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null,x6 = null;
                        String pos = getpos();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult()) {
                                x6 = x.getString("ingreidents");
                                x3 = x.getString("url");
                                x2 = x.getString("name");
                                x1 = x.getString("price");
                                x4 = x.getString("catagory");
                                String x5 = x.getString("availability");
                               // System.out.println(x1 + x2 + x3 + pos + x4);
                                if (x1 != null && x3 != null && x2 != null) {
                                    if(pos.equals("all") )
                                    {
                                        System.out.println("Printing ALL");
                                        xn.add(x2);
                                        mNames.add(x1);
                                        mImageUrls.add(x3);
                                        ingre.add(x6);
                                    }
                                    else if(pos.equals("drinks")  && x4.equals("Beverages")  )
                                    {
                                        xn.add(x2);
                                        mNames.add(x1);
                                        mImageUrls.add(x3);
                                        ingre.add(x6);
                                    }
                                    else if(pos.equals("bbq") && x4.equals("BBQ"))
                                    {
                                        xn.add(x2);
                                        mNames.add(x1);
                                        mImageUrls.add(x3);
                                        ingre.add(x6);
                                    }
                                    else if(pos.equals("burger") && x4.equals("Burger"))
                                    {
                                        System.out.println("Printing ALL");
                                        xn.add(x2);
                                        mNames.add(x1);
                                        mImageUrls.add(x3);
                                        ingre.add(x6);
                                    }
                                    else if(pos.equals("starter")  && x4.equals("Starters")  )
                                    {
                                        System.out.println("Printing ALL");
                                        xn.add(x2);
                                        mNames.add(x1);
                                        mImageUrls.add(x3);
                                        ingre.add(x6);
                                    }
                                    else if(pos.equals("rolls") && x4.equals("Rolls & Wraps"))
                                    {
                                        xn.add(x2);
                                        mNames.add(x1);
                                        mImageUrls.add(x3);
                                        ingre.add(x6);
                                    }
                                    else if(pos.equals("search"))
                                    {
                                        String p = getprice();
                                        String a = getava();
                                        String c = getcat();



                                        if(p.equals("Any"))
                                        {
                                            if(a.equals("All"))
                                            {
                                                if(c.equals("All"))
                                                {
                                                    xn.add(x2);
                                                    mNames.add(x1);
                                                    mImageUrls.add(x3);
                                                    ingre.add(x6);
                                                }
                                                else
                                                {
                                                    if(x4.equals(c))
                                                    {
                                                        xn.add(x2);
                                                        mNames.add(x1);
                                                        mImageUrls.add(x3);
                                                        ingre.add(x6);
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                if(x5.equals("1"))
                                                {
                                                    if(c.equals("All"))
                                                    {
                                                        xn.add(x2);
                                                        mNames.add(x1);
                                                        mImageUrls.add(x3);
                                                        ingre.add(x6);
                                                    }
                                                    else
                                                    {
                                                        if(x4.equals(c))
                                                        {
                                                            xn.add(x2);
                                                            mNames.add(x1);
                                                            mImageUrls.add(x3);
                                                            ingre.add(x6);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        else
                                        {
                                            int p1 = Integer.parseInt(p);
                                            int p2 = Integer.parseInt(x1);
                                            if(p2<=p1)
                                            {
                                                if(a.equals("All"))
                                                {
                                                    if(c.equals("All"))
                                                    {
                                                        xn.add(x2);
                                                        mNames.add(x1);
                                                        mImageUrls.add(x3);
                                                        ingre.add(x6);
                                                    }
                                                    else
                                                    {
                                                        if(x4.equals(c))
                                                        {
                                                            xn.add(x2);
                                                            mNames.add(x1);
                                                            mImageUrls.add(x3);
                                                            ingre.add(x6);
                                                        }
                                                    }
                                                }
                                                else
                                                {
                                                    if(x5.equals("1"))
                                                    {
                                                        if(c.equals("All"))
                                                        {
                                                            xn.add(x2);
                                                            mNames.add(x1);
                                                            mImageUrls.add(x3);
                                                            ingre.add(x6);
                                                        }
                                                        else
                                                        {
                                                            if(x4.equals(c))
                                                            {
                                                                xn.add(x2);
                                                                mNames.add(x1);
                                                                mImageUrls.add(x3);
                                                                ingre.add(x6);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    }
                                } else {
                                    System.out.println("NULLS");
                                }
                            }
                        } else {
                            System.out.println("Eorrrosr");
                        }
                            menuadapter adapter = new menuadapter(menu.this, mImageUrls, mNames, xn,ingre);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(menu.this));
                            System.out.println("this is a tryyy" + xn.isEmpty());

                    }
                });

    }

    void logout(View view)
    {
        Intent x = new Intent(this,Accountview.class);
        startActivity(x);
    }
    void carter(View view)
    {
        Intent x = new Intent(this,viewcart.class);
        startActivity(x);
    }
    String getpos()
    {
        Bundle q = getIntent().getExtras();
        pos = q.getString("name");
        return pos;
    }
    String getprice()
    {
        Bundle q = getIntent().getExtras();
        pos = q.getString("price");
        return pos;
    }
    String getava()
    {
        Bundle q = getIntent().getExtras();
        pos = q.getString("ava");
        return pos;
    }
    String getcat()
    {
        Bundle q = getIntent().getExtras();
        pos = q.getString("catagory");
        System.out.println(pos);
        return pos;
    }
}