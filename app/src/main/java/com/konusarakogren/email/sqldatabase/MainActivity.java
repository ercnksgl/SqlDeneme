package com.konusarakogren.email.sqldatabase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLConnection sqlConnection;

    private int age = 0;
    private boolean isMarried;

    List<String> name = new ArrayList<>();
    List<String> surname = new ArrayList<>();
    List<String> like_count = new ArrayList<>();
    RecyclerView recyclerView;
    List_Adapter recyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        name.add("Ercan");
        surname.add("Köseoğlu");
        like_count.add("35");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Olanları Unutup");
        surname.add("Geriye Dönemem");
        like_count.add("60");

        name.add("Yandım Çok");
        surname.add("Öylece Sevemem");
        like_count.add("35");

        name.add("Ercan");
        surname.add("Köseoğlu");
        like_count.add("35");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Ercan");
        surname.add("Köseoğlu");
        like_count.add("35");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");     name.add("Ercan");
        surname.add("Köseoğlu");
        like_count.add("35");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Olanları Unutup");
        surname.add("Geriye Dönemem");
        like_count.add("60");

        name.add("Yandım Çok");
        surname.add("Öylece Sevemem");
        like_count.add("35");

        name.add("Ercan");
        surname.add("Köseoğlu");
        like_count.add("35");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");

        name.add("Ercan");
        surname.add("Köseoğlu");
        like_count.add("35");

        name.add("Deneme");
        surname.add("Test");
        like_count.add("25");

        name.add("Test");
        surname.add("AltDeneme");
        like_count.add("15");



        //insertTable(name, surname, age, isMarried);
        recyclerAdapter = new List_Adapter(this, name, surname, like_count);
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
}
