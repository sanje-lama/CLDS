package com.example.stl.clds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SanjeActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        textView = (TextView) findViewById(R.id.bio_group);
        imageView = (ImageView) findViewById(R.id.photo_group);

        imageView.setImageResource(R.drawable.sanje);
        textView.setText(R.string.bio_sanje);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ConstraintLayout constraintLayout = findViewById(R.id.colorLayout);
        int[] groupColor = getResources().getIntArray(R.array.fav_color);
        int favColor = groupColor[new Random().nextInt(groupColor.length)];
        constraintLayout.setBackgroundColor(favColor);
    }



    @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.template_menu, menu);
                menu.getItem(0).setTitle("Nasa");
                menu.getItem(1).setTitle("Bank");
                menu.getItem(2).setTitle("Mad-Libs");
                return super.onCreateOptionsMenu(menu);
            }
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.project1:
                        firstProject();
                        break;
                    case R.id.project2:
                        secondProject();
                        break;
                    case R.id.project3:
                        thirdProject();
                        break;
                }
                return super.onOptionsItemSelected(item);

            }

            private void firstProject() {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sanje-lama/Nasa"));
                startActivity(intent);
            }

            private void secondProject() {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sanje-lama/Bank-game.git"));
                startActivity(intent);
            }

            private void thirdProject() {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sanje-lama/Mad-Libs"));
                startActivity(intent);




            }
    }

