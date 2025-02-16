package com.example.rmp6;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbactivity);

        BottomNavigationView bottomNavigationView = findViewById(R.id.babn);
        ImageView image = findViewById(R.id.imageView3);


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

        Menu menu = navMenu.getMenu();
        MenuItem menuItem1 = menu.add("Back");

        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item == menuItem1) {
                    Log.i("Click Menu", "1");
                    text.setText("Back");
                    Intent intent = new Intent(BBActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener
        (new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottom_bar_item1){
                    text.setText("pepeEz");
                    image.setBackground(ContextCompat.getDrawable(BBActivity.this, R.drawable.pepeez));
                    Toast.makeText(BBActivity.this,"pepeEz",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (item.getItemId()==R.id.bottom_bar_item2){
                    text.setText("pepeSad");
                    image.setBackground(ContextCompat.getDrawable(BBActivity.this, R.drawable.pepesad));
                    Toast.makeText(BBActivity.this,"pepeSad",
                            Toast.LENGTH_LONG).show();
                }
                else if (item.getItemId()==R.id.bottom_bar_item3){
                    text.setText("pepeChill");
                    image.setBackground(ContextCompat.getDrawable(BBActivity.this, R.drawable.pepechill));
                    Toast.makeText(BBActivity.this,"pepeChill",
                            Toast.LENGTH_LONG).show();
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

    private void updateFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(fragment.getClass().getSimpleName());
        }
    }
}
