package com.example.mword;

import static android.R.color.holo_green_light;
import static android.R.color.holo_red_light;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class PutBox3 extends AppCompatActivity implements View.OnClickListener{
    private Button a1, a2, a3, a4, next, exit;
    public static Cursor cursor;
    public static int i=13;

    public TextView show, w1;
    public String text1,text2,text3,text4,answer;
    private SQLiteDatabase db;
    private int a = 0, b = 0, bb = 0, bbb = 0, bbbb = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_box3);

        init1();

        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
//        cursor.close();

        init2(db,dbFile);
    }
    public void init1() {
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        w1 = findViewById(R.id.w1);
        next = findViewById(R.id.next);
        exit = findViewById(R.id.exit);
        show = findViewById(R.id.show);

        a = 3;
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        next.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    private void init2(SQLiteDatabase db, File dbFile) {
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
        cursor = db.query("words", new String[]{"word", "translation"}, null, null, null, null, null);
        cursor.moveToLast();
        answer=cursor.getString(0)+":"+cursor.getString(1);
        int p=cursor.getPosition();
        Cursor cursor1 = db.query("words", new String[]{"word", "translation"}, null,null, null, null, null);
//        i++;
//        cursor1.moveToPosition(i);

        cursor1.moveToLast();
        show.setText(answer+"\n单词:" + cursor.getString(0) + "\n翻译:" + cursor.getString(1));
        w1.setText("\n单词:" + cursor.getString(0) + "\n翻译:" + cursor.getString(1));

        text1=cursor1.getString(0)+":"+cursor1.getString(1);
        a1.setText("\n单词:" + cursor1.getString(0) + "\n翻译:" + cursor1.getString(1));

        cursor1.moveToPrevious();
        text2=cursor1.getString(0)+":"+cursor1.getString(1);
        a2.setText("\n单词:" + cursor1.getString(0) + "\n翻译:" + cursor1.getString(1));

        cursor1.moveToPrevious();
        text3=cursor1.getString(0)+":"+cursor1.getString(1);
        a3.setText("\n单词:" + cursor1.getString(0) + "\n翻译:" + cursor1.getString(1));

        cursor1.moveToPrevious();
        text4=cursor1.getString(0)+":"+cursor1.getString(1);
        a4.setText("\n单词:" + cursor1.getString(0) + "\n翻译:" + cursor1.getString(1));
    }
    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.a1){
            changecolor(a1,1);

        }
    }
    public void changecolor(Button a1,int a){
        if(a==1){
            a1.setBackgroundColor(getResources().getColor(holo_green_light));
        }else{
            a1.setBackgroundColor(getResources().getColor(holo_red_light));
        }
    }
}