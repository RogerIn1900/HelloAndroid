package com.example.mword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    private Button back, word1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        back = findViewById(R.id.back);
        word1 = findViewById(R.id.word1);

        //匿名内部类的方式创建点击
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent();
//                intent.setClass(Start.this,MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

    //用方法的方式实现点击
    public void Word1(View view) {

        //用隐式跳转的方式实现页面跳转
        Intent intent = new Intent("Word1");
        startActivity(intent);
    }

}