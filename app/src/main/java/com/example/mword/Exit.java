package com.example.mword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Exit extends AppCompatActivity implements View.OnClickListener{

    private Button exit1,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        init();
        exit1.setOnClickListener(this);
        back.setOnClickListener(this);

    }
    public void init(){
//        这里的xml文件内的id名最好不要和其他xml文件的id名重复
        exit1=findViewById(R.id.exit);
        back=findViewById(R.id.back);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id == R.id.exit){
            Toast.makeText(Exit.this, "退出", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Exit.this,MainActivity.class);
            startActivity(intent);
//            Intent intent=new Intent();
//            intent.setClass(Exit.this,MainActivity.class);
//            intent.setFlags(Exit.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);

//            finish();

//            android.os.Process.killProcess(android.os.Process.myPid());

//            这个方法只能关掉当前的activity
//            System.exit(0);
        }else if(id==R.id.back){
            Toast.makeText(Exit.this, "返回", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}