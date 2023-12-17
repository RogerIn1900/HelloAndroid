package com.example.mword;

import static android.R.color.holo_green_light;
import static android.R.color.holo_red_light;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class PutBox2 extends AppCompatActivity implements View.OnClickListener{
    private Button a1, a2, a3, a4, next, exit,fresh;
    public static Cursor cursor;
    public static int i=13;

    private TextView show, w1;
    private String text1,text2,text3,text4,answer;
    private SQLiteDatabase db;
    private int aa = 0, b = 0, bb = 0, bbb = 0, bbbb = 0;
    public static int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_box2);
        init1();

        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
//        cursor.close();
        init2(db,dbFile);
    }
    public void init1() {
        i=1;
        String buttonID = "a" + i ;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        a1 =findViewById(resID);
        // 这里可以对button进行操作
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        w1 = findViewById(R.id.w1);
        next = findViewById(R.id.next);
        exit = findViewById(R.id.exit);
        show = findViewById(R.id.show);
        fresh= findViewById(R.id.fresh);

        exit.getBackground().setAlpha(128);
        fresh.getBackground().setAlpha(128);
        a1.getBackground().setAlpha(128);
        a2.getBackground().setAlpha(128);
        a3.getBackground().setAlpha(128);
        a4.getBackground().setAlpha(128);
        next.getBackground().setAlpha(128);



        aa = 3;
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        next.setOnClickListener(this);
        exit.setOnClickListener(this);
        fresh.setOnClickListener(this);
    }
    @SuppressLint("ResourceType")
    private void init2(SQLiteDatabase db, File dbFile) {
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
        cursor = db.query("words", new String[]{"word", "translation"}, null, null, null, null, null);
        cursor.moveToLast();
        for(int i=0;i<j;i++){
            cursor.moveToPrevious();
        }
        j++;
        Cursor cursor1 = db.query("words", new String[]{"word", "translation"}, null,null, null, null, null);

        int num = (int)(Math.random()*3) + 1;
        i=num;

        cursor1.moveToPosition(cursor.getPosition());
//        show.setText(j+"\n单词:" + cursor.getString(0) + "\n翻译:" + cursor.getString(1));
//        w1.setText(cursor.getString(0));
//        answer=cursor.getString(0)+":"+cursor.getString(1);




        text1=cursor1.getString(0)+":"+cursor1.getString(1);
        a1.setText(cursor1.getString(1));
        cursor1.moveToPrevious();

        text2=cursor1.getString(0)+":"+cursor1.getString(1);
        a2.setText(cursor1.getString(1));
        cursor1.moveToPrevious();

        text3=cursor1.getString(0)+":"+cursor1.getString(1);
        a3.setText(cursor1.getString(1));
        cursor1.moveToPrevious();

        text4=cursor1.getString(0)+":"+cursor1.getString(1);
        a4.setText(cursor1.getString(1));
        cursor1.moveToPrevious();

        i= (int) (1+Math.random()*4);
        String buttonID = "a" + i ;
//        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
//        answer=getString(resID);
        switch(i){
            case 1:{
//                Toast.makeText(this, "是1", Toast.LENGTH_SHORT).show();
                answer=text1;
                String[] str=answer.split(":");
                w1.setText(str[0]);
                break;
            } case 2:{
//                Toast.makeText(this, "是2", Toast.LENGTH_SHORT).show();
                answer=text2;
                String[] str=answer.split(":");
                w1.setText(str[0]);
                break;

            } case 3:{
//                Toast.makeText(this, "是3", Toast.LENGTH_SHORT).show();
                answer=text3;
                String[] str=answer.split(":");
                w1.setText(str[0]);
                break;

            } case 4:{
//                Toast.makeText(this, "是4", Toast.LENGTH_SHORT).show();
                answer=text4;
                String[] str=answer.split(":");
                w1.setText(str[0]);
                break;

            }
        }

        show.setText(answer+i+"\n单词:" + cursor.getString(0) + "\n翻译:" + j+cursor.getString(1));
        i++;

//
//        text2=cursor1.getString(0)+":"+cursor1.getString(1);
//        i=(i%4+1);
//        buttonID = "a" +i;
//        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
//        a2 =findViewById(resID);
//        a2.setOnClickListener(this);
//        i++;
//        a2.setText(cursor1.getString(1));
//
//
//        cursor1.moveToPrevious();
//        text3=cursor1.getString(0)+":"+cursor1.getString(1);
//        i=(i%4+1);
//        buttonID = "a" +i;
//        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
//        a3 =findViewById(resID);
//        a3.setOnClickListener(this);
//        i++;
//        a3.setText(cursor1.getString(1));
//
//
//        cursor1.moveToPrevious();
//        text4=cursor1.getString(0)+":"+cursor1.getString(1);
//        i=(i%4+1);
//        buttonID = "a" +i;
//        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
//        a4 =findViewById(resID);
//        a4.setOnClickListener(this);
//        i++;
//        a4.setText(cursor1.getString(1));
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.a1&&b==0){
            changecolor(a1,judge(a1,answer));
            changetext(a1,text1);
            b=1;
        }else if(id==R.id.a2&&bb==0){
            changecolor(a2,judge(a2,answer));
            changetext(a2,text2);
            bb=1;
        }else if(id==R.id.a3&&bbb==0){
            changecolor(a3,judge(a3,answer));
            changetext(a3,text3);
            bbb=1;
        }else if(id==R.id.a4&&bbbb==0){
            changecolor(a4,judge(a4,answer));
            changetext(a4,text4);
            bbbb=1;
        }else if(id==R.id.exit){
            Intent intent=new Intent(this,MainActivity.class);
            finish();
            startActivity(intent);
        }else if(id==R.id.next){
            if(aa!=1){
                Toast.makeText(this, "请答对之后再记忆下一个单词", Toast.LENGTH_SHORT).show();
            }else{
//                Toast.makeText(this, "开始背诵下一个单词", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,PutBox2.class);
                startActivity(intent);
            }
        }else if(id==R.id.fresh){
            j=0;
            Intent intent=new Intent(this,PutBox2.class);
            startActivity(intent);
        }
    }
    public void changecolor(Button a1,int a){
        if(a==1){
            a1.setBackgroundColor(getResources().getColor(holo_green_light));
        }else{
            a1.setBackgroundColor(getResources().getColor(holo_red_light));
        }
    }
    public void changetext(Button a1,String text){
        String[] t=text.split(":");
        a1.setText(t[0]+"\n"+t[1]);
    }
    public int judge(Button a1,String answer) {
        String[] a = answer.split(":");
        if (a[0] != null && a[1] != null) {
            if (a1.getText().toString().equals(a[1])) {
                aa = 1;
                return 1;
            } else {
                return -1;
            }
        }
        return 1;
    }
}