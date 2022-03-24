package com.example.gayllary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class Bigger_image extends AppCompatActivity {

    ImageView imageView;
    int index;
    ArrayList<String> pathsArr;
    Bundle arguments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigger_image);
        imageView = findViewById(R.id.img);
        arguments = getIntent().getExtras();
        index = arguments.getInt("Index");
        pathsArr = arguments.getStringArrayList("Paths");
        setImageFromPath(arguments.getString("Image"), imageView);

    }
    private void setImageFromPath(String path, ImageView image) {
        File imgFile = new File(path);
        if (imgFile.exists()) {
            Bitmap myBitmap = ImageHelper.decodeSampleBitmapFromPath(imgFile.getAbsolutePath(), 1000, 1000);
            image.setImageBitmap(myBitmap);
        }}}