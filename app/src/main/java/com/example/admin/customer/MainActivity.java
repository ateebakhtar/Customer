package com.example.admin.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //managerinfo x = new managerinfo();
        //addinventory();

        //additems();
        //x.getinven();
       // x.transfer();
        //adddata();
        //x.setitems(60,"chicken");
        //x.itemdecrease();

    }
    void openlogin(View view)
    {
        Intent x = new Intent(this,login.class);
        startActivity(x);
    }
    void catagories(View view)
    {
        Intent x = new Intent(this,mainmenu.class);
        startActivity(x);
    }
    void opencretaeaccount(View view)
    {
        Intent p = new Intent(this,createaccount.class);
        startActivity(p);
    }
    FirebaseFirestore db = FirebaseFirestore.getInstance();
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
        Intent p = new Intent(this,MainActivity.class);
        startActivity(p);
    }
    void addinventory()
    {
        inventory x = new inventory();
        FirebaseFirestore fb = FirebaseFirestore.getInstance();

        x.insertdata("Chicken","180","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Buns","55","100");
        fb.collection("Inventory").add(x);
        x.insertdata("Mayo","50","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Cheese","40","120");
        fb.collection("Inventory").add(x);
        x.insertdata("Flour","60","100");
        fb.collection("Inventory").add(x);
        x.insertdata("Mushroom","20","120");
        fb.collection("Inventory").add(x);
        x.insertdata("Green-Chillies","10","100");
        fb.collection("Inventory").add(x);
        x.insertdata("Beef","190","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Tortilla","90","90");
        fb.collection("Inventory").add(x);
        x.insertdata("Spices","60","100");
        fb.collection("Inventory").add(x);
        x.insertdata("Fresh Cream","100","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Milk","90","90");
        fb.collection("Inventory").add(x);
        x.insertdata("Coffee","55","85");
        fb.collection("Inventory").add(x);
        x.insertdata("Cocoa Beans","40","100");
        fb.collection("Inventory").add(x);
        x.insertdata("Chutney","30","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Dough","100","105");
        fb.collection("Inventory").add(x);
        x.insertdata("Soda Water","100","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Mint Leaves","35","70");
        fb.collection("Inventory").add(x);
        x.insertdata("Sugar","30","50");
        fb.collection("Inventory").add(x);
        x.insertdata("Herbs","40","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Chocolate Sauce","40","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Water","30","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Garlic Sauce","20","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Lemon Juice","10","50");
        fb.collection("Inventory").add(x);
        x.insertdata("Lemon Zest","10","50");
        fb.collection("Inventory").add(x);
        x.insertdata("Tea Leaves","25","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Natural Flavor","50","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Regular","50","70");
        fb.collection("Inventory").add(x);
        x.insertdata("Can","80","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Cheese Sauce","40","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Potatoes","50","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Mineral Water","30","80");
        fb.collection("Inventory").add(x);
        x.insertdata("Yogurt","40","65");
        fb.collection("Inventory").add(x);
        x.insertdata("Cottage Cheese","50","120");
        fb.collection("Inventory").add(x);
        x.insertdata("Pita Bread","40","65");
        fb.collection("Inventory").add(x);
        x.insertdata("Vegetables","110","75");
        fb.collection("Inventory").add(x);
        x.insertdata("Pickles","40","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Chillies","10","110");
        fb.collection("Inventory").add(x);
        x.insertdata("Apple","10","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Grapes","10","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Pineapple","15","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Pommegranete","15","60");
        fb.collection("Inventory").add(x);
        x.insertdata("Watermelon","10","60");
    }


    void additems()
    {
        menuinfo a = new menuinfo();

        a.insertdata("Chicken Tikka Boti","190","https://i.ytimg.com/vi/iw_6VODJBPM/maxresdefault.jpg","Chicken Spices","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Tikka Boti","240","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWgZfFv73dLEZt4i-a47rusuL6Dx0mCGNXlXwBHCwmGoO7MNjW","Beef Spices","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Malai Boti","210","https://www.fishvish.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/c/h/chicken-malai-tikka_1.jpg","Chicken Spices FreshCream","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Malai Boti","260","https://1.bp.blogspot.com/-Di8ErZ6hBD4/VsmA718afLI/AAAAAAAAABU/7VeVnJSFMtE/s1600/000037432_behari-boti.jpg","Beef Spices FreshCream","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Reshmi Kabab","210","http://www.denofdelights.pk/wp-content/uploads/2017/03/chicken-reshmi-kabab-575x262.jpg","Chicken Spices Yogurt CottageCheese","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Reshmi Kabab","260","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzWAmR6PgaJAr2dj_TjMoXLWHPqZvOGLoH2_hsi4FXyY2ounrl0Q","Beef Spices Yogurt CottageCheese","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Behari Kabab","210","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0lmtF0VNCIeoqIrNSfSeYV93S-VjNHsdO59VpSgCWpW80dTXw","Chicken Spices Herbs","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Behari Kabab","260","https://s3-media1.fl.yelpcdn.com/bphoto/bcUYN-UxQKjFKub9_6wvjw/o.jpg","Beef Spices Herbs","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Gola Kabab","260","https://www.desiakhbar.com/wp-content/uploads/2017/09/BBQ-Gola-Kebab-Recipe.jpg","Beef Spices","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Dhaga Kabab","260","http://i.ytimg.com/vi/6f485omblws/hqdefault.jpg","Beef Spices","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Tandoori Chicken Boti","220","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQExmZGDcznCqtsB0t3a-QIF9PvnRCnTzVfmV72XwkH-Qk46bHxaQ","Chicken Spices,","BBQ","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Classic Roll","100","http://www.foodrider.in/media/catalog/product/cache/1/image/800x800/9df78eab33525d08d6e5fb8d27136e95/c/h/chicken_roll_2.jpg","Tortilla Chicken Chutney","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Classic Cheese Roll","120","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv4mzawCLXyJRlUxP7TbCuOJxtxPM6vjNJgQzo18tWuNZ9Hrgs7w","Tortilla Chicken CheeseSauce","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Mayo Garlic Roll","120","https://www.supermeal.pk/ext-resources/cropped-images/000/051/000051935_chicken-juicy-roll.jpg","Tortilla Chicken Mayo GarlicSauce","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Broast Roll","130","http://www.dishocean.com/media/uploads/food_category/fb5bf987-c7aa-486a-a3ca-e996dcf93fad.jpg","Tortilla Chicken","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Broast Cheese Roll","130","http://i.dawn.com/primary/2016/07/577f6c50443bb.jpg","Tortilla Chicken CheeseSauce","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Behari Roll","120","https://www.supermeal.pk/ext-resources/cropped-images/000/033/000033159_chicken-behari-cheese-roll.jpg","Tortilla Chicken Spices Chutney","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Beef Behari Roll","120","https://i.pinimg.com/originals/dc/00/a2/dc00a2dcbcdb52649538bf688210a137.jpg","Tortilla Beef Spices Chutney","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Shawarma","150","https://canolaeatwell.com/wp-content/uploads/2017/04/Slow-Cooker-Chicken-Shawarma-With-Tomato-Cucumber-Relish-1_WEB-1024x683.jpg","PitaBread Chicken Vegetables Pickles Chillies","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Chicken Arabian Roll","150","http://www.dishocean.com/media/uploads/foods/arabian-mayo-roll-arabian-grilled-nazimabad-karachi.jpg","PitaBread Chicken Spices Vegetables","Rolls & Wraps","1");
        db.collection("Menu").add(a);
        a.insertdata("Soft Drink","80","https://www.google.com/search?q=softdrinks&client=firefox-b-d&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjTvvC71c3hAhWd6nMBHajEAXsQ_AUIDigB&biw=1366&bih=654#imgrc=aYudiKaE6om5DM:","Regular Can","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Chocolate Shake","170","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7k5om3P40dI6-cvueOdY2r9YL3u89Q1KKJ9jT-26LvjAn_BSpig","Milk ChocolateSauce CocoaBeans","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Mocha Shake","170","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQt1ceu4Ozf5DIZvmMQBiecQ5yzpNciEbXmiaO4SeWEf3e1lCpd","Milk Coffee CocoaBeans","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Tea","60","https://www.telegraph.co.uk/content/dam/food-and-drink/2016/04/21/Magna_Carta_for_DT_Features_Picture_to_illstrate_a_story_by_Harry_Wallop_about_h_trans_NvBQzQNjv4Bqeo_i_u9APj8RuoebjoAHt0k9u7HhRJvuo-ZLenGRumA.jpg?imwidth=450","Water TeaLeaves NaturalFlavor","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Coffee","80","https://cdn.zmescience.com/wp-content/uploads/2018/04/Cappuccino_at_Sightglass_Coffee.jpg","Water Milk CoffeeBeans","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Lassi","80","https://www.wikihow.com/images/d/d6/Make-Sweet-Yogurt-Drink-(Sweet-Lassi)-Step-3-Version-2.jpg","Yogurt Milk Sugar","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Mint Margarita","100","http://wholesomesweet.com/wp-content/uploads/2017/02/mint-margarita-recipe-1280x545.jpg","SodaWater MintLeaves Sugar","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Lemonade","80","https://detoxinista.com/wp-content/uploads/2014/07/Basil-Lemonade.jpg","SodaWater LemonJuice LemonZest","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Fresh Fruit Juice","130","https://pistahousevirginia.com/wp-content/uploads/2017/02/juice.jpg","Apple Grapes Pineapple Pommegranete Watermelon","Beverages","1");
        db.collection("Menu").add(a);
        a.insertdata("Water","60","https://4.imimg.com/data4/AI/UU/MY-11635823/aquafina-drinking-water-500x500.jpg","MineralWater","Beverages","1");
        db.collection("Menu").add(a);
    }

    void adddata()
    {
        menuinfo a = new menuinfo();
        a.insertdata("Mega Burger","450","https://i1.wp.com/hip2save.com/wp-content/uploads/2011/07/checkers.png?resize=304%2C227&strip=all","Buns Chicken Mayo Cheese","Burgers","1");
        db.collection("Menu").add(a);

        a.insertdata("Crunch ","170 ","https://feenix.co.in/wp-content/uploads/2017/12/72ef796c-ef3c-4067-adef-f10549d5707c.png ","Buns Chicken Mayo Cheese","Burger ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Beef Lover ","480 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5GczoJvjZeU8UjyRaEBLGD5ZESZ4lgdK7efsvWEH9UBwUMB-u ","Buns Beed Mayo Cheese","Burger ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Cheese Delight ","430 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOzmHO7dQwlUEz5bJOz7SKwv1EWNs_SGtSYHZTuCr50__giQ1aHg ","Buns Chicken Mayo Cheese","Burger ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Mushroom Madness ","430 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRptKQ7cCi_ujtJBfOuJf1nhNBuwXeN9ruknyVkaqkiLI0kahIv ","Buns Chicken Mayo Cheese Mushroom","Burger "," 1");
        db.collection("Menu").add(a);

        a.insertdata("Pizza Burger ","510 ","https://hips.hearstapps.com/del.h-cdn.co/assets/17/14/1491339557-ragu-chicken-pizza-burgers-pinterest-1.jpg ","Buns Chicken Mayo Cheese Mushroom Green-Chillies","Burger ","1");
        db.collection("Menu").add(a);

        a.insertdata("Twister ","280 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJIIXQRRme7HS79ICOnpOOYCirYqsF00MAtXHvQ_bmBEFLEmZA ","Dough Chicken Mayo Cheese"," Burger","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Chicken Strips ","170 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSpFlSMXEqoaFBXX5aphPcV8fgtOFdsYXKgzfaL3n3pc__pASv ","Chicken Flour","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Mozrella Sticks ","130 ","https://i.pinimg.com/originals/5a/d7/c7/5ad7c7082079609c33ae4a6bdd3e4f7c.jpg ","Cheese Flour","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Peri Bites ","130 ","https://magazine.foodpanda.pk/wp-content/uploads/sites/13/2017/02/WhatsApp-Image-2017-02-22-at-10.29.15-AM-e1487747652499.jpeg ","Green-Chillies Cheese","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Load Fries ","130 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmn1xwzL1Kz2m3YWYo0o3hHpCT_u3GE67qQRcs5gywXdTC7LYK ","Mayo Potatoes","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Plain Fries ","90 ","https://www.seriouseats.com/2018/04/20180309-french-fries-vicky-wasik-15-1500x1125.jpg ","Potatoes","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Garlic Bread ","90 ","https://food.fnr.sndimg.com/content/dam/images/food/fullset/2015/5/28/2/TM1A14F_Garlic-Bread_s4x3.jpg.rend.hgtvcom.826.620.suffix/1433523400627.jpeg ","Dough","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Wedges ","110 ","https://www.errenskitchen.com/wp-content/uploads/2014/05/Seasoned-Baked-Potato-Wedges4-2.jpg ","Mayo Potatoes","Starters ","1 ");
        db.collection("Menu").add(a);




    }
}
