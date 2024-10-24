package com.example.mword;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button addBtn, deleteBtn, updateBtn, selectBtn, PasswordViewBtn, enroll,back,login;
    private EditText user_name, user_password,getBtn;
    private TextView showInfo;
//    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;
    private void init() {
        login = findViewById(R.id.login);
        enroll = findViewById(R.id.enroll);
        back=findViewById(R.id.back);
        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.user_password);
        PasswordViewBtn = findViewById(R.id.PasswordView);


        login .setOnClickListener(this);
        enroll .setOnClickListener(this);
        back.setOnClickListener(this);
        user_name.setOnClickListener(this);
        user_password.setOnClickListener(this);
        PasswordViewBtn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        File dbFile = getDatabasePath("/data/data/com.example.login/databases/MyDatabase");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //添加
        if(id==R.id.enroll){
            setContentView(R.layout.activity_enroll);
            Toast.makeText(this, "跳转到注册界面", Toast.LENGTH_SHORT).show();

            String username=user_name.getText().toString();
            String password=user_password.getText().toString();
//                ContentValues contentValues=new ContentValues();
//                contentValues.put("userName",username);
//                contentValues.put("password",password);
//                db.insert("user",null,contentValues);
            db.execSQL("insert into user(userName,password) values(?,?)",new Object[]{username,password});
            db.close();
        }
        //查询
        else if(id==R.id.login){
            String f=user_name.getText().toString();
            Cursor cursor=db.query("user",new String[]{"serName","password"},"serName like ?",new String[]{f},null,null,null);
            if(cursor.moveToFirst()){
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "无此账号，请注册后使用", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            db.close();
        }
        else if(id==R.id.back){
            finish();
        }
    }
}