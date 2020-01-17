package com.example.admin.customer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }
    void logour(View view)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you Sure you want to Logout.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent p = new Intent(mainmenu.this,login.class);
                        startActivity(p);
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();



    }
    void carter(View view)
    {
        Intent x = new Intent(this,viewcart.class);
        startActivity(x);
    }
    void drinks(View view)
    {
        Intent x = new Intent(this,menu.class);
        Bundle y = new Bundle();
        y.putString("name","drinks");
        x.putExtras(y);
        startActivity(x);
    }
    void all(View view)
    {
        Intent x = new Intent(this,menu.class);
        Bundle y = new Bundle();
        y.putString("name","all");
        x.putExtras(y);
        startActivity(x);
    }
    void burger(View view)
    {
        Intent x = new Intent(this,menu.class);
        Bundle y = new Bundle();
        y.putString("name","burger");
        x.putExtras(y);
        startActivity(x);
    }
    void starter(View view)
    {
        Intent x = new Intent(this,menu.class);
        Bundle y = new Bundle();
        y.putString("name","starter");
        x.putExtras(y);
        startActivity(x);
    }
    void bbq(View view)
    {
        Intent x = new Intent(this,menu.class);
        Bundle y = new Bundle();
        y.putString("name","bbq");
        x.putExtras(y);
        startActivity(x);
    }
    void rolls(View view)
    {
        Intent x = new Intent(this,menu.class);
        Bundle y = new Bundle();
        y.putString("name","rolls");
        x.putExtras(y);
        startActivity(x);
    }
    void openview(View view)
    {
        Intent x = new Intent(this,Accountview.class);
        startActivity(x);
    }
    void searcher(View view)
    {
        Intent x = new Intent(this,search.class);
        startActivity(x);
    }
    void logout(View view)
    {
        Intent x = new Intent(this,login.class);
        startActivity(x);
    }

}
