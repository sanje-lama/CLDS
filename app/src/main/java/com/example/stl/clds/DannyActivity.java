package com.example.stl.clds;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class DannyActivity extends AppCompatActivity {
    TextView bioView;
    ImageView bioImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        bioView = findViewById(R.id.bio_group);
        bioImage = findViewById(R.id.photo_group);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bioImage.setImageResource(R.drawable.danny);
        bioView.setText(R.string.bio_danny);

        Button button = (Button) findViewById(R.id.linkedin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.linkedin_caroline)));
                startActivity(intent);
            }
        });

        ConstraintLayout cl = findViewById(R.id.colorLayout);
        int[] groupColor = getResources().getIntArray(R.array.fav_color);
        int groupFavColor = groupColor[new Random().nextInt(groupColor.length)];
        cl.setBackgroundColor(groupFavColor);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.template_menu, menu);
        menu.getItem(0).setTitle("Mad Libs");
        menu.getItem(1).setTitle("Bank App for Tellers");
        menu.getItem(2).setTitle("PathWalker");
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
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dhchung317/Story_App_HW_CHUNG_HYUNKI"));
        startActivity(intent);
    }

    private void secondProject() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dhchung317/Java_Bank_Pursuit_HW_CHUNG_HYUNKI"));
        startActivity(intent);
    }

    private void thirdProject() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dhchung317/CYOA_Pursuit_HW_CHUNG_HYUNKI"));
        startActivity(intent);

    }
}