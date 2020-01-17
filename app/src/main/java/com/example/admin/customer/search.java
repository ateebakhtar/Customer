package com.example.admin.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class search extends AppCompatActivity {
    Spinner w;

    String [] list = {"All","Burger","Starters","Rolls & Wraps","BBQ","Beverages"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        w = findViewById(R.id.spinner);
        ArrayAdapter<String> x = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w.setAdapter(x);


    }
    void next(View view)
    {
        String m = w.getSelectedItem().toString();

        EditText m3 = findViewById(R.id.editText);
        String m4 = m3.getText().toString();
        if(m4.length() > 5)
        {
            Toast.makeText(this,"Enter Valid Number",Toast.LENGTH_LONG).show();
            return;
        }

        System.out.println(m+m4);
        Intent x = new Intent(this,menu.class);
        Bundle p = new Bundle();
        p.putString("name","search");
        p.putString("price",m4);
        p.putString("catagory",m);
        p.putString("ava","All");
        x.putExtras(p);
        startActivity(x);
    }
}
