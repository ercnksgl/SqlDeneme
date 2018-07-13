package com.konusarakogren.email.sqldatabase;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProfilePhotoInterface {
    SQLConnection sqlConnection;
    private LottieAnimationView animationView;
    private int age = 0;
    private boolean isMarried;
    ImageView profil_photo_main;
    List<String> name = new ArrayList<>();
    List<String> surname = new ArrayList<>();
    List<String> like_count = new ArrayList<>();
    RecyclerView recyclerView;
    List_Adapter recyclerAdapter;
    ValueAnimator animator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        profil_photo_main = findViewById(R.id.activity_main_profile_photo);
        profil_photo_main.setClickable(true);
        profil_photo_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                finish();
            }
        });
        animationView=findViewById(R.id.walking_animation);

         animator = ValueAnimator.ofFloat(0f, 1f).setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animationView.setProgress((Float) valueAnimator.getAnimatedValue());
            }
        });

        animationView.setClickable(true);
        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();

            }
        });



        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");


        //insertTable(name, surname, age, isMarried);
        recyclerAdapter = new List_Adapter(this, name, surname, like_count,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);


    }

    private void insertTable(String name, String surname, int age, boolean isMarried) {

        SQLiteDatabase sqLiteDatabase = sqlConnection.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("age", age);
        cv.put("isMarried", isMarried);
        sqLiteDatabase.insertOrThrow("Users", null, cv);
    }

    @Override
    public void sentPositin(int position) {
        Toast.makeText(this, "Profile: " + position, Toast.LENGTH_SHORT).show();
    }
}
