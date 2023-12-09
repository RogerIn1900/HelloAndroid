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

public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button addBtn, deleteBtn, updateBtn, selectBtn, PasswordViewBtn, generateBtn,back;
    private EditText user_name, user_password,getBtn;
    private TextView showInfo;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;
    private void init() {
        addBtn = findViewById(R.id.add);
        deleteBtn = findViewById(R.id.delete);
        updateBtn = findViewById(R.id.update);
        selectBtn = findViewById(R.id.select);
        generateBtn = findViewById(R.id.generate);
        back=findViewById(R.id.back);
        getBtn = findViewById(R.id.get);
        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.user_password);
        PasswordViewBtn = findViewById(R.id.PasswordView);

        addBtn.setOnClickListener(this);
        deleteBtn .setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        selectBtn .setOnClickListener(this);
        generateBtn.setOnClickListener(this);
        back.setOnClickListener(this);
        getBtn.setOnClickListener(this);
        user_name.setOnClickListener(this);
        user_password.setOnClickListener(this);
        PasswordViewBtn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        myDbHelper = new MyDbHelper(Login.this, "MyDatabase", null, 666);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //添加
        if(id==R.id.add){
            db=myDbHelper.getWritableDatabase();

            String username=user_name.getText().toString();
            String password=user_password.getText().toString();
//                ContentValues contentValues=new ContentValues();
//                contentValues.put("userName",username);
//                contentValues.put("password",password);
//                db.insert("user",null,contentValues);
            db.execSQL("insert into user(userName,password) values(?,?)",new Object[]{username,password});
            db.close();
        }

        //删除
        else if(id==R.id.delete){
            db=myDbHelper.getWritableDatabase();
            String delete=getBtn.getText().toString();
//            db.execSQL("delete from user where userName=?",new Object[]{getBtn});//删除不返回值
            int i = db.delete("user","userName=?",new String[]{delete});
            if(i>0){
                Toast.makeText(Login.this,"删除成功，删除了"+i+"条数据",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Login.this,"删除失败",Toast.LENGTH_SHORT).show();
            }
            db.close();
        }

        //查询
        else if(id==R.id.select){
            db=myDbHelper.getWritableDatabase();
//            db.execSQL("select userName,passname from user where userNmae=?",new Object[]{selection});
            Cursor cursor=db.query("user",new String[]{"serName","password"},null,null,null,null,null);
            cursor.moveToFirst();
            showInfo.setText("查询结果如下:");
            while(cursor.moveToNext()){
                showInfo.append("\n"+"username:"+cursor.getString(0)+"password:"+cursor.getString(1));
            }
            cursor.close();
            db.close();
        }
        else if(id==R.id.update){
            db=myDbHelper.getWritableDatabase();
            String username1=user_name.getText().toString();
            String password1=user_password.getText().toString();
            String selectioin2=getBtn.getText().toString();
            ContentValues contenValues = new ContentValues();
            contenValues.put("userName",username1);
            contenValues.put("password",password1);
            db.update("user",contenValues,"userName=?",new String[]{selectioin2});
            db.close();
        }
        else if(id==R.id.generate){
            db=myDbHelper.getWritableDatabase();
            String selection=getBtn.getText().toString();
            Cursor cursor=db.query("user",new String[]{"serName","password"},"userName=?",new String[]{selection},null,null,null);
            showInfo.setText("查询结果如下:");
            while(cursor.moveToNext()){
                showInfo.append("\n"+"username:"+cursor.getString(0)+"password:"+cursor.getString(1));
            }
            cursor.close();
            db.close();
        }else if(id==R.id.back){
            finish();
        }
    }

    class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table user(user_id integer primary key autoincrement,userName varchar(20),password varchar(30))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}