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

    public Button start,add,review,putbox,b1,b2;
    public ImageButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        login.setOnClickListener(this);
        start.setOnClickListener(this);
        putbox.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        add.setOnClickListener(this);

//        review.setOnClickListener(this);
    }

    public void init(){
        login=findViewById(R.id.loginButton);
        start=findViewById(R.id.start);
        add=findViewById(R.id.add);
        putbox=findViewById(R.id.putbox);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        review=findViewById(R.id.review);


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
            Intent intent=new Intent(this,Login.class);
            Toast.makeText(this, "跳转到登陆页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.start){
            Intent intent=new Intent(this,Start.class);
            Toast.makeText(this, "跳转到开始背单词界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.add){
            Intent intent=new Intent(this,Add.class);
            Toast.makeText(this, "跳转到添加新词界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.putbox){
            Intent intent=new Intent(this,Putbox.class);
            Toast.makeText(this, "跳转到收藏夹界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.b1){
            Intent intent=new Intent(this,B1.class);
            Toast.makeText(this, "跳转到B1界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.b2){
            Intent intent=new Intent(this,B2.class);
            Toast.makeText(this, "跳转到B2界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(id==R.id.review){
            Intent intent=new Intent(this,Review.class);
            Toast.makeText(this, "跳转到复习界面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
}