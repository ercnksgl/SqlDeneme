package com.konusarakogren.email.sqldatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity{
    ImageView profile_ımg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        profile_ımg = findViewById(R.id.profile_img);
        profile_ımg.setClickable(true);
        profile_ımg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        finish();

            }
        });

    }



}

