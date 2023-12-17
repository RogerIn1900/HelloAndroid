package com.example.mword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login1 extends AppCompatActivity implements View.OnClickListener{

    private Button back,login,enroll;
    private EditText user_name,user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        init();
    }
    private void init(){
        back=findViewById(R.id.back);
        login=findViewById(R.id.login);
        enroll=findViewById(R.id.enroll);
        user_name=findViewById(R.id.user_name);
        user_password=findViewById(R.id.user_password);

        back.setOnClickListener(this);
        login.setOnClickListener(this);
        enroll.setOnClickListener(this);
        user_name.setOnClickListener(this);
        user_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.back){
            finish();
        }else if(id==R.id.login){
            
        }else if(id==R.id.enroll){
            Intent intent=new Intent(Login1.this, Enroll.class);
            startActivity(intent);
        }
    }
}