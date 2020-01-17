package com.example.admin.customer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class viewcart extends AppCompatActivity {
    private ArrayList<String> pic= new ArrayList<>();
    private ArrayList<String> names= new ArrayList<>();
    private ArrayList<String> qty= new ArrayList<>();
    private ArrayList<String> price= new ArrayList<>();
    TextView amount;
    int total = 0;
    void settotal(int m)
    {
        total = total + m;
    }
    public void dectotal(int m)
    {
        total = total - m;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcart);



        names.add("burger");
        qty.add("2");
        price.add("200");
        pic.add("https://oukosher.org/content/uploads/2018/06/IF-Burger-1.jpg");
        amount = findViewById(R.id.editText2);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Cart")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null,x5 = null;
                         ArrayList<String> pic= new ArrayList<>();
                         ArrayList<String> names= new ArrayList<>();
                         ArrayList<String> qty= new ArrayList<>();
                         ArrayList<String> price= new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult())
                            {
                                x1 = x.getString("name");
                                x2 = x.getString("price");
                                x3 = x.getString("quantity");
                                x4 = x.getString("url");
                                x5 = x.getString("email");
                                if(x5.equals(data.email))
                                {
                                    System.out.println("Name"+x2);
                                    int o = Integer.parseInt(x2);
                                    int o1 = Integer.parseInt(x3);
                                    o = o1 * o;
                                    settotal(o);
                                    names.add(x2);
                                    qty.add(x3);
                                    price.add(x1);
                                    pic.add(x4);
                                }
                            }
                            String temp = ""+total;
                            amount.setFocusable(false);
                            amount.setClickable(false);
                            amount.setText(temp);
                            cartadapter adapter = new cartadapter( viewcart.this,names,price,qty,pic,15);
                            RecyclerView recyclerView=findViewById(R.id.recyclerView);

                            if(adapter != null || recyclerView !=null)
                            {
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(viewcart.this));
                            }
                        }
                        else
                        {
                            System.out.println("Eorrrosr");
                        }
                    }
                });


    }
    void emppty(View view)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Set Custom Title
        TextView title = new TextView(this);
        // Title Properties
        title.setText("Delete All Item");
        title.setPadding(10, 10, 10, 10);   // Set Position
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);
        alertDialog.setCustomTitle(title);

        // Set Message
        TextView msg = new TextView(this);
        // Message Properties
        msg.setText("Do you wish to delete all the item?");
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        alertDialog.setView(msg);

        // Set Properties for OK Button


        // Set Button
        // you can more buttons
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                total = 0;

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
                                        db.collection("Cart").document(x.getId()).delete();
                                    }
                                    Intent p = new Intent(viewcart.this,mainmenu.class);
                                    startActivity(p);
                                }
                                else
                                {
                                    System.out.println("Eorrrosr");
                                }
                            }
                        });



            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });

        final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        neutralBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        okBT.setPadding(50, 10, 10, 10);   // Set Position
        okBT.setTextColor(Color.BLUE);
        okBT.setLayoutParams(neutralBtnLP);

        final Button cancelBT = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams negBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        negBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        cancelBT.setTextColor(Color.RED);
        cancelBT.setLayoutParams(negBtnLP);

        new Dialog(this);
        alertDialog.show();

    }
    void empty(View view)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure to delete all items.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String id1;
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
                                                db.collection("Cart").document(x.getId()).delete();
                                            }
                                            Intent p = new Intent(viewcart.this,mainmenu.class);
                                            startActivity(p);

                                        }
                                        else
                                        {
                                            System.out.println("Eorrrosr");
                                        }
                                    }
                                });

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
    void openpayment(View view)
    {
        Intent p = new Intent(this,viewpayment.class);
        startActivity(p);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(this,mainmenu.class);
        startActivity(setIntent);
    }

}
