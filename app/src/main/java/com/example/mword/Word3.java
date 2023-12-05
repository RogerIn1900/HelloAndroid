package com.example.mword;

import static android.R.color.holo_green_light;
import static android.R.color.holo_red_light;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Word3 extends AppCompatActivity implements View.OnClickListener{
    private TextView w1;
    private int a = 5,b=0,bb=0,bbb=0,bbbb=0;
    private Button a1, a2, a3, a4, next,exit;
    private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word3);
        init();
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        next.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    public void init() {
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        w1 = findViewById(R.id.w1);
        next=findViewById(R.id.next);
        exit=findViewById(R.id.exit);
        a=3;

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int a=R.string.test5;

        int test1=R.string.test11;
        int test2=R.string.test6;
        int test3=R.string.test5;
        int test4=R.string.test13;

        if (id == R.id.a1) {
            if(b==0)
                judge(a1,a,test2);
            b=1;
        }else if(id == R.id.a2){
            if(bb==0)
                judge(a2,a,test2);
            bb=1;
        }else if(id == R.id.a3){
            if(bbb==0)
                judge(a3,a,test3);
            bbb=1;
        }else if(id == R.id.a4){
            if(bbbb==0)
                judge(a4,a,test4);
            bbbb=1;
        }else if(id==R.id.next){
            if(a!=1){
                Intent intent=new Intent(Word3.this, Exit.class);
                Toast.makeText(this,"turn successfully ",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else{
                Toast.makeText(this,"请答对后再记忆下一个单词 ",Toast.LENGTH_SHORT).show();
            }
        }else if(id==R.id.exit){
            Intent intent=new Intent(Word3.this, Exit.class);
            Toast.makeText(this, "跳转到离开页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
//            finish();
        }
    }
    public void judge(Button a1,int test1,int test2){
        String msg= getString(test1);
        String[] msg1=msg.split(":");
        String word1=msg1[0];
        String tran1=msg1[1];

        String msg2= getString(test2);
        String[] msg22=msg2.split(":");
        String word2=msg22[0];
        String tran2=msg22[1];

        if(a1.getText().equals(tran1) ){
            Toast.makeText(this,a+a1.getText().toString()+"答对了",Toast.LENGTH_SHORT).show();
            a1.setBackgroundColor(getResources().getColor(holo_green_light));
            a1.setText(word2+"\n"+tran2);
            a=1;
        }else{
            Toast.makeText(this,a+a1.getText().toString()+"答错了",Toast.LENGTH_SHORT).show();
            a1.setBackgroundColor(getResources().getColor(holo_red_light));
            a1.setText(word2+"\n"+tran2);
        }
    }
}