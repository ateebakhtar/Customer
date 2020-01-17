package com.example.admin.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class payment_opt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_opt);
    }
    void open1(View view)
    {
        Intent p = new Intent(this,payment.class);
        startActivity(p);
    }
    void open2(View view)
    {
        Intent p = new Intent(this,thankyou.class);
        Toast.makeText(this, "Thank you for purchase", Toast.LENGTH_LONG).show();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Cart")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null,x5=null;

                        if (task.isSuccessful()) {
                            FirebaseFirestore db = FirebaseFirestore.getInstance();
                            for (QueryDocumentSnapshot x : task.getResult())
                            {
                                x2 = x.getString("email");
                                if(x2.equals(data.email))
                                {
                                    db.collection("Cart").document(x.getId()).delete();
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Eorrrosr");
                        }
                    }
                });
        startActivity(p);
    }
}
