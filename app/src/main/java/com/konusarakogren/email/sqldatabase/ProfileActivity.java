package com.konusarakogren.email.sqldatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraUtils;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.Facing;
import com.otaliastudios.cameraview.Grid;

public class ProfileActivity extends AppCompatActivity {
    private int front_back =0;
    private int grit_int = 0;
    CameraView cameraView;
    Button frontcam;
    Button grid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        cameraView = findViewById(R.id.camera_view);
        frontcam = findViewById(R.id.front_cam);
        grid=findViewById(R.id.grid_button);

        cameraView.start();
        cameraView.setClickable(true);
        cameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                       /* startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        finish();*/

            }
        });

        frontcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                front_back += 1;
                if (front_back % 2 == 0) {
                    cameraView.setFacing(Facing.FRONT);
                } else {
                    cameraView.setFacing(Facing.BACK);
                }
            }
        });

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grit_int += 1;
                if (grit_int % 2 == 0) {
                    cameraView.setGrid(Grid.DRAW_4X4);
                } else {
                    cameraView.setGrid(Grid.OFF);
                }


            }
        });


    }

}

