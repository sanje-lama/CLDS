package com.example.stl.clds;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.drawer_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);


        int[] groupColor = getResources().getIntArray(R.array.fav_color);
        int groupFavColor = groupColor[new Random().nextInt(groupColor.length)];
        mDrawerLayout.setBackgroundColor(groupFavColor);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight

                        switch (menuItem.getItemId()) {
                            case R.id.nav_caroline:
                                mDrawerLayout.closeDrawers();
                                startActivity(new Intent(MainActivity.this, CarolineActivity.class));
//start your activity from main here**
                                return true;
                            case R.id.nav_linda:
                                startActivity(new Intent(MainActivity.this, LindaActivity.class));
                                mDrawerLayout.closeDrawers();
//start your activity from main here**
                                return true;
                            case R.id.nav_danny:
                                mDrawerLayout.closeDrawers();
                                startActivity(new Intent(MainActivity.this,DannyActivity.class));
                                return true;
                            case R.id.nav_sanje:
                                mDrawerLayout.closeDrawers();
                                startActivity(new Intent(MainActivity.this, SanjeActivity.class));

                                return true;

                            default:
                                return false;
                        }
                    }
                });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
