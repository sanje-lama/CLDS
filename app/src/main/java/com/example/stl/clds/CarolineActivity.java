package com.example.stl.clds;

import android.content.Intent;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class CarolineActivity extends AppCompatActivity {

    TextView myView;
    ImageView myImage;
//    TextView myLink;
//    TextView myLink2;
//    TextView myLink3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        myView = findViewById(R.id.bio_group);
        myImage = findViewById(R.id.photo_group);
//        myLink = findViewById(R.id.project1);
//        myLink2 = findViewById(R.id.project2);
//        myLink3 = findViewById(R.id.project3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myView.setText(R.string.bio_caroline);
        myImage.setImageResource(R.drawable.caroline);
//        myLink.setText(R.string.FortuneTeller_Caroline_Link);
//        myLink.setText(R.string.AnotherHeroStory_Caroline_Link);
//        myLink.setText(R.string.BelcherBank_Caroline_Link);
//        myView.setMovementMethod(new ScrollingMovementMethod());

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
        menu.getItem(0).setTitle("Fortune Teller");
        menu.getItem(1).setTitle("Another Hero Story");
        menu.getItem(2).setTitle("Belcher Bank");
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
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/garlicfiendck/CYOA_Pursuit_HW_Kang_Caroline"));
        startActivity(intent);
    }

    private void secondProject() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/garlicfiendck/Story_App_HW_Kang_Caroline"));
        startActivity(intent);
    }

    private void thirdProject() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/garlicfiendck/Java_Bank_Pursuit_HW_Kang_Caroline"));
        startActivity(intent);

    }

}
