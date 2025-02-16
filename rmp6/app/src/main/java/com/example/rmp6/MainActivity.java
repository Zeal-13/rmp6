package com.example.rmp6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDrawer();
            }
        });

        NavigationView navMenu = findViewById(R.id.nav_view);
        TextView text = findViewById(R.id.textView);
        ImageView image = findViewById(R.id.image_main);

        Menu menu = navMenu.getMenu();
        MenuItem menuItem1 = menu.add("pepeHi");
        MenuItem menuItem2 = menu.add("pepeEz");
        MenuItem menuItem3 = menu.add("pepeChill");
        MenuItem menuItem4 = menu.add("Next");

        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item == menuItem1) {
                    Log.i("Click Menu", "1");
                    text.setText("pepeHi");
                    image.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.pepehi));
                    return true;
                }
                else if (item == menuItem2) {
                    Log.i("Click Menu", "2");
                    text.setText("pepeEz");
                    image.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.pepeez));
                    return true;
                }
                else if (item == menuItem3) {
                    Log.i("Click Menu", "3");
                    text.setText("pepeChill");
                    image.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.pepechill));
                    return true;
                }
                else if (item == menuItem4) {
                    Log.i("Click Menu", "4");
                    text.setText("Next");
                    Intent intent = new Intent(MainActivity.this, BBActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


    }

    public void OpenDrawer(){
        Log.i("OpenDrawer", "OpenDrawer");
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isOpen()){
            drawerLayout.close();
        }
        else {
            drawerLayout.open();
        }
    }
}