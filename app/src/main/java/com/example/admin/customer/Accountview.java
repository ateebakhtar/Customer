package com.example.admin.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Accountview extends AppCompatActivity {




    EditText x1;
    EditText x2;
    EditText x3;
    EditText x4;
    EditText x5;
    EditText x6;
    void logout(View view)
    {
        Intent p = new Intent(this,login.class);
        startActivity(p);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountview);


        x1 = findViewById(R.id.name_reg);
        x2 = findViewById(R.id.age_reg);
        x3 = findViewById(R.id.contact_reg);
        x4 = findViewById(R.id.add_reg);
        x5 = findViewById(R.id.email_reg);
        x6 = findViewById(R.id.password_reg);

        x1.setClickable(false);
        x2.setClickable(false);
        x3.setClickable(false);
        x4.setClickable(false);
        x5.setClickable(false);
        x6.setClickable(false);

        x1.setFocusable(false);
        x2.setFocusable(false);
        x3.setFocusable(false);
        x4.setFocusable(false);
        x5.setFocusable(false);
        x6.setFocusable(false);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Registered Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String a = null, b = null, c = null, d = null, e = null, f = null, g = null;

                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot x : task.getResult()){
                                b = x.getString("name");
                                c = x.getString("age");
                                d = x.getString("number");
                                e = x.getString("address");
                                f = x.getString("email");
                                g = x.getString("password");
                                //x.geti

                                String em = data.email;
                                if (f.equals(em)){
                                    getData(b, c, d, e, f, g);
                                    break;
                                }
                                b = null;
                            }
                        }
                        else {
                            System.out.println("Error");
                        }
                    }
                });
    }

    void getData(String nm, String ag, String nmb, String add, String eml, String pass){
        x1.setText(nm);
        x2.setText(ag);
        x3.setText(nmb);
        x4.setText(add);
        x5.setText(eml);
        x6.setText(pass);

    }

    void editAccount_button(View view){
        Intent toUpdateScreen = new Intent(this, UpdateActivity.class);
        startActivity(toUpdateScreen);
    }
}
