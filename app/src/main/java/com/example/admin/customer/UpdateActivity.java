package com.example.admin.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class UpdateActivity extends AppCompatActivity {


    EditText x1;
    EditText x2;
    EditText x3;
    EditText x4;
    EditText x5;
    EditText x6;

    String iD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        x1 = findViewById(R.id.name_reg);
        x2 = findViewById(R.id.age_reg);
        x3 = findViewById(R.id.contact_reg);
        x4 = findViewById(R.id.add_reg);
        x5 = findViewById(R.id.email_reg);
        x6 = findViewById(R.id.password_reg);

        x5.setClickable(false);
        x6.setClickable(false);

        x5.setFocusable(false);
        x6.setFocusable(false);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Registered Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String a = null, b = null, c = null, d = null, e = null, f = null, g = null;

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult()) {
                                b = x.getString("name");
                                c = x.getString("age");
                                d = x.getString("number");
                                e = x.getString("address");
                                f = x.getString("email");
                                g = x.getString("password");
                                a = data.email;
                                if (f.equals(a)) {
                                    setiD(x.getId());
                                    getData(b, c, d, e, f, g);

                                    break;
                                }
                                b = null;
                            }
                        } else {
                            System.out.println("Error");
                        }
                    }
                });
    }

    void getData(String nm, String ag, String nmb, String add, String eml, String pass) {
        x1.setText(nm);
        x2.setText(ag);
        x3.setText(nmb);
        x4.setText(add);
        x5.setText(eml);
        x6.setText(pass);
    }

    void setiD(String id) {
        this.iD = id;
    }

    void setItems(View view) {

        if(x2.length() > 3)
        {
            Toast.makeText(this, "Enter Valid age", Toast.LENGTH_LONG).show();
            return;
        }
        int p1 = Integer.parseInt(x2.getText().toString());
        if(x1.getText().length() < 6)
        {
            Toast.makeText(this, "UserName is to Small", Toast.LENGTH_LONG).show();
        }
        else if( p1 > 80 || p1 < 10)
        {
            Toast.makeText(this, "Enter Valid age", Toast.LENGTH_LONG).show();
        }
        else if(x4.getText().length() < 8 )
        {
            Toast.makeText(this, "Address is to Small", Toast.LENGTH_LONG).show();
        }
        else if(x6.getText().length() < 8 )
        {
            Toast.makeText(this, "Password is to Small", Toast.LENGTH_LONG).show();
        }
        else if(x3.getText().length() > 8 && x3.getText().length() < 11)
        {
            Toast.makeText(this, "Enter Valid Number", Toast.LENGTH_LONG).show();
        }
        else
        {

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("Registered Users").document(iD).update("name", x1.getText().toString());
            db.collection("Registered Users").document(iD).update("age", x2.getText().toString());
            db.collection("Registered Users").document(iD).update("number", x3.getText().toString());
            db.collection("Registered Users").document(iD).update("address", x4.getText().toString());

            Intent p = new Intent(this, Accountview.class);
            startActivity(p);

        }










    }
}