package com.example.mword;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Button start,add,review,putbox,look_up,exit;
    public ImageButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        login.setOnClickListener(this);
        start.setOnClickListener(this);
        putbox.setOnClickListener(this);
        look_up.setOnClickListener(this);
        exit.setOnClickListener(this);
        add.setOnClickListener(this);

        review.setOnClickListener(this);
    }

    public void init(){
        login=findViewById(R.id.loginButton);
        start=findViewById(R.id.start);
        add=findViewById(R.id.add);
        putbox=findViewById(R.id.putbox);
        exit=findViewById(R.id.exit);
        look_up=findViewById(R.id.look_up);
        review=findViewById(R.id.review);

        login.getBackground().setAlpha(128);
        start.getBackground().setAlpha(58);
        add.getBackground().setAlpha(88);
        putbox.getBackground().setAlpha(128);
        exit.getBackground().setAlpha(58);
        look_up.getBackground().setAlpha(58);
        review.getBackground().setAlpha(58);
    }

//    @Override
//    public void onClick(View view) {
//
//    }
//
    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.loginButton){
            Intent intent=new Intent(this,Login1.class);
//            Toast.makeText(this, "跳转到登陆页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.start){
            Intent intent=new Intent(this,Start.class);
//            Toast.makeText(this, "跳转到开始背单词界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.add){
            Intent intent=new Intent(this,Add.class);
//            Toast.makeText(this, "跳转到添加新词界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.putbox){
            Intent intent=new Intent(this,PutBox2.class);
//            Toast.makeText(this, "跳转到收藏夹界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.exit){
            finish();
        }else if(id==R.id.look_up){
            Intent intent=new Intent(this,Look_up.class);
//            Toast.makeText(this, "跳转到查找界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.review){
            Intent intent=new Intent(this,Review.class);
//            Toast.makeText(this, "跳转到复习界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
}