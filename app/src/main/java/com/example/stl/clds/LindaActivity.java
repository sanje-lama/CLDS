package com.example.stl.clds;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static android.net.Uri.parse;

public class LindaActivity extends AppCompatActivity {

    TextView bioText;
    ImageView bioImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        bioText = findViewById(R.id.bio_group);
        bioText.setText(R.string.bio_linda);

        bioImage = findViewById(R.id.photo_group);
        bioImage.setImageResource(R.drawable.linda);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ConstraintLayout cl = findViewById(R.id.colorLayout);
        int[] groupColor = getResources().getIntArray(R.array.fav_color);
        int groupFavColor = groupColor[new Random().nextInt(groupColor.length)];
        cl.setBackgroundColor(groupFavColor);

        Button button = (Button) findViewById(R.id.linkedin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.linkedin_linda)));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.template_menu, menu);
            menu.getItem(0).setTitle("PathFinder");
            menu.getItem(1).setTitle("Haunted House");
            menu.getItem(2).setTitle("Mad Libs");

            return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.project1:
                goToWeb();
                break;
            case R.id.project2:
                goToWeb2();
                break;
            case R.id.project3:
                goToWeb3();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToWeb() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lindapokorny/IntelliJProjects/tree/master/Pathfinder"));
        startActivity(intent);
    }

    private void goToWeb3() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lindapokorny/Story_App_HW_POKORNY_LINDA"));
        startActivity(intent);
    }

    private void goToWeb2() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lindapokorny/CYOA_Pursuit_HW_Pokorny_Linda"));
        startActivity(intent);
    }

}
