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

public class Add extends AppCompatActivity implements View.OnClickListener{

    private int putting=0;
    private TextView show;
    private Button add,put,back,putbox;
    private EditText word,translation;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init1();
        init2();
        myDbHelper=new MyDbHelper(this,"words",null,666);
        db=myDbHelper.getWritableDatabase();

    }

    public void init1(){
        add=findViewById(R.id.add);
        put=findViewById(R.id.put);
        word=findViewById(R.id.word);
        translation=findViewById(R.id.translation);
        back=findViewById(R.id.back);
        putbox=findViewById(R.id.putbox);
        show=findViewById(R.id.show);

        add.getBackground().setAlpha(128);
        put.getBackground().setAlpha(1);
        word.getBackground().setAlpha(255);
        translation.getBackground().setAlpha(255);
        back.getBackground().setAlpha(128);
        putbox.getBackground().setAlpha(128);
        show.getBackground().setAlpha(228);


    }
    public void init2(){
        add.setOnClickListener(this);
        put.setOnClickListener(this);
        word.setOnClickListener(this);
        translation.setOnClickListener(this);
        back.setOnClickListener(this);
        putbox.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.add){

            String word1 =word.getText().toString();
            String translation1 =translation.getText().toString();
//            ContentValues contentValues=new ContentValues();
//            contentValues.put("word",word1);
//            contentValues.put("translation",translation1);
//            contentValues.put("put","1");
//            db.insert("words",null,contentValues);

//            db.execSQL("insert into words(word,translation) values(?,?,?)",new Object[]{word1,translation1,putting});

            ContentValues values = new ContentValues();

            Cursor cursor = db.rawQuery("SELECT * FROM words WHERE word=?", new String[]{word1});
            if (cursor.moveToFirst()) {
                values.put("translation", translation1);

                int a=db.update("words", values, "translation=?", new String[]{translation1});
                if(a>0){
//                    Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();

                }else{
//                    Toast.makeText(this, "修改失败！", Toast.LENGTH_SHORT).show();

                }

            } else {

                values.put("word", word1);
                values.put("translation", translation1);
                db.insert("words", null, values);
//                Toast.makeText(this, "添加成功！", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
        else if(id==R.id.put){
            String word1 =word.getText().toString();
            String translation1 =translation.getText().toString();
            ContentValues values = new ContentValues();
            Cursor cursor = db.rawQuery("SELECT * FROM puts WHERE word=?", new String[]{word1});
            if (cursor.moveToFirst()) {
                values.put("translation", translation1);

                int a=db.update("words", values, "word=?", new String[]{word1});
                Toast.makeText(this, a, Toast.LENGTH_SHORT).show();

                if(a>0){
//                    Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(this, "修改失败！", Toast.LENGTH_SHORT).show();
                }

            } else {

                values.put("word", word1);
                values.put("translation", translation1);
                db.insert("words", null, values);
//                Toast.makeText(this, "添加成功！", Toast.LENGTH_SHORT).show();
            }
            cursor.close();

            db=myDbHelper.getWritableDatabase();

            ContentValues contentValues=new ContentValues();
            contentValues.put("word",word1);
            contentValues.put("translation",translation1);
            contentValues.put("puts",0);

            long a=db.insert("words",null,contentValues);
            long b=db.insert("puts",null,contentValues);

            if(a>0){
                Toast.makeText(this, "新单词添加成功！", Toast.LENGTH_SHORT).show();

            }else if(b>0){
//                Toast.makeText(this, "收藏成功！", Toast.LENGTH_SHORT).show();

            }

        }else if(id==R.id.back){
//            Toast.makeText(this, "点击了返回", Toast.LENGTH_SHORT).show();
            finish();

        }else if(id==R.id.putbox){
//            Intent intent=new Intent(MainActivity.this,Putbox.class);
//            Toast.makeText(this, "进入收藏夹", Toast.LENGTH_SHORT).show();
//            startActivity(intent);

            Cursor cursor=db.query("words",new String[]{"word","translation"},null,null,null,null,null);
            cursor.moveToLast();
            show.setText("\n单词:"+cursor.getString(0)+"\n翻译:"+cursor.getString(1));
            cursor.close();


        }

    }

    static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table words(word_id integer primary key autoincrement ,word varchar(30),translation varchar(150),put int)");
            db.execSQL("create table puts(put_id integer primary key autoincrement ,word varchar(30),translation varchar(150),put int)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        }
    }
}