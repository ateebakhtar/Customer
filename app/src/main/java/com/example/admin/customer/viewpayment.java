package com.example.admin.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class viewpayment extends AppCompatActivity {
    double total = 0;
    void addtotal(int m)
    {
        total = total + m;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpayment);

        TextView p = findViewById(R.id.textView2);
        TextView p1 = findViewById(R.id.textView3);

        p.setClickable(false);
        p.setFocusable(false);
        p1.setClickable(false);
        p1.setFocusable(false);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Cart")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null;
                        ArrayList<paymentitem>mpaymentlist =  new ArrayList<>();
                        ArrayList<String> names= new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult())
                            {
                                x1 = x.getString("name");
                                x2 = x.getString("price");
                                x4 = x.getString("quantity");
                                int o = Integer.parseInt(x2);
                                int o1 = Integer.parseInt(x4);
                                o = o * o1;
                                x2 = ""+o;
                                System.out.println("Name"+x2);
                                x3 = x.getString("email");
                                if(x3.equals(data.email))
                                {
                                    int temp = Integer.parseInt(x2);
                                    addtotal(temp);
                                    mpaymentlist.add(new paymentitem(x1,x2));
                                }

                            }
                            TextView p = findViewById(R.id.textView2);
                            p.setText(""+total);
                            TextView p1 = findViewById(R.id.textView3);
                            total = total * 1.13;
                            total = Math.round(total);
                            p1.setText(""+total);
                            paymentAdapter adapter = new paymentAdapter( mpaymentlist);
                            RecyclerView recyclerView=findViewById(R.id.recyclerView2);

                            if(adapter != null || recyclerView !=null)
                            {
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(viewpayment.this));
                            }
                        }
                        else
                        {
                            System.out.println("Eorrrosr");
                        }
                    }
                });

    }
    void open(View view)
    {
        Intent p = new Intent(this,payment_opt.class);
        startActivity(p);
    }
}
