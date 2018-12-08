package com.example.stl.clds;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;


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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.template_menu, menu);
        return true;

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
}