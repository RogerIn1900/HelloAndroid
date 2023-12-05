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

public class Word2 extends AppCompatActivity {
    private TextView w1;
    private int a = 5,b=0,bb=0,bbb=0,bbbb=0;
    private Button a1, a2, a3, a4, next,exit;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word2);
        init();
        int test1=R.string.test1;
        int test2=R.string.test2;
        int test3=R.string.test3;
        int test4=R.string.test4;
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b==0)
                    judge(a1,test2,test1);
                b=1;
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bb==0){
                    judge(a2,test2,test2);
                }
                bb=1;
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bbb==0)
                    judge(a3,test2,test3);
                bbb=1;
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bbbb==0)
                    judge(a4,test2,test4);
                bbbb=1;

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a == 1) {
                    Intent intent = new Intent(Word2.this, Word3.class);
                    Toast.makeText(Word2.this, "turn successfully ", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(Word2.this, "请答对后再记忆下一个单词 ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Word2.this, Exit.class);
                Toast.makeText(Word2.this, "exit", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
    public void init() {
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        w1 = findViewById(R.id.w1);
        next = findViewById(R.id.next);
        exit=findViewById(R.id.exit);
        a = 3;
    }
    public void judge(Button aa,int test1,int test2){
        String msg= getString(test1);
        String[] msg1=msg.split(":");
        String word1=msg1[0];
        String tran1=msg1[1];

        String msg2= getString(test2);
        String[] msg22=msg2.split(":");
        String word2=msg22[0];
        String tran2=msg22[1];
        if(aa.getText().equals(tran1) ){
            Toast.makeText(this,a+aa.getText().toString()+"答对了",Toast.LENGTH_SHORT).show();
            aa.setBackgroundColor(getResources().getColor(holo_green_light));
            a=1;
            aa.setText(word2+"\n"+tran2);
        }else{
            Toast.makeText(this,a+aa.getText().toString()+"答错了",Toast.LENGTH_SHORT).show();
            aa.setBackgroundColor(getResources().getColor(holo_red_light));
            aa.setText(word2+"\n"+tran2);
        }
    }
}
