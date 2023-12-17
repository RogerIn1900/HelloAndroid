package com.example.mword;

import static android.R.color.holo_green_light;
import static android.R.color.holo_red_light;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Putbox extends Activity implements View.OnClickListener {
    private SQLiteDatabase db;
    private int a = 0, b = 0, bb = 0, bbb = 0, bbbb = 0;
    private int[] c = new int[4];
    //    private  int b[]={0};
    private Button a1, a2, a3, a4, next, exit;
    public int currentPosition1, currentPosition2, currentPosition3, currentPosition4;
    public static Cursor cursor;

    public TextView show, w1;
    public String text1,text2,text3,text4,answer;

    public void init1() {
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        w1 = findViewById(R.id.w1);
        next = findViewById(R.id.next);
        exit = findViewById(R.id.exit);
        a = 3;
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        next.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putbox);
        show = findViewById(R.id.show);

        init1();
        init();
        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);

        cursor = db.query("words", new String[]{"word", "translation"}, null, null, null, null, null);
        cursor.moveToLast();
        show.setText("\n单词:" + cursor.getString(0) + "\n翻译:" + cursor.getString(1));
        answer=cursor.getString(0)+":"+cursor.getString(1);
        cursor.close();
    }
    private void init() {
        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);

        Cursor cursor = db.query("words", new String[]{"word", "translation","put"}, "word like ?", new String[]{"model"}, null, null, null);
        cursor.moveToLast();

        a=0;
        w1.setText(cursor.getString(0));
//
//        if (cursor != null&& cursor.getPosition()!=-1) {
//            a1.setText( cursor.getString(1));
//            //以下两行代码都是存储光标的位置，记录当前的数据
//            currentPosition1 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//
//             cursor.moveToPrevious();
//            a++;
//        }else {
//            cursor.moveToLast();
//            a1.setText( cursor.getString(1));
//            //以下两行代码都是存储光标的位置，记录当前的数据
//            currentPosition1 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//
//            cursor.moveToPrevious();
//            a++;
//        }
//        if ( cursor != null && cursor.getPosition()!=-1) {
//
//            a2.setText( cursor.getString(1));
//            //记录当前位置(数据)
//            currentPosition2 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//            cursor.moveToPrevious();
//            //位置存放数组的下标下移
//            a++;
//        }else {
//            cursor.moveToLast();
//            a1.setText( cursor.getString(1));
//            //以下两行代码都是存储光标的位置，记录当前的数据
//            currentPosition1 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//
//            cursor.moveToPrevious();
//            a++;
//        }
//        if (cursor != null&& cursor.getPosition()!=-1) {
//            a2.setText(cursor.getString(1));
//            currentPosition2 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//            cursor.moveToPrevious();
//            a++;
//        }else {
//            cursor.moveToLast();
//            a3.setText( cursor.getString(1));
//            //以下两行代码都是存储光标的位置，记录当前的数据
//            currentPosition3 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//
//            cursor.moveToPrevious();
//            a++;
//        }
//        if (cursor != null&& cursor.getPosition()!=-1) {
//            a4.setText(cursor.getString(1));
//            currentPosition4 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//            cursor.moveToPrevious();
//            a++;
//        }else {
//            cursor.moveToLast();
//            a4.setText( cursor.getString(1));
//            //以下两行代码都是存储光标的位置，记录当前的数据
//            currentPosition4 = cursor.getPosition();
//            c[a] = cursor.getPosition();
//
//            cursor.moveToPrevious();
//            a++;
//        }


            a1.setText(cursor.getString(1));
            text1=cursor.getString(0)+":"+cursor.getString(1);
            cursor.moveToNext();
            a2.setText(cursor.getString(1));
            text1=cursor.getString(0)+":"+cursor.getString(1);
            cursor.moveToNext();
            a3.setText(cursor.getString(1));
            text1=cursor.getString(0)+":"+cursor.getString(1);
            cursor.moveToNext();
            a4.setText(cursor.getString(1));
            text1=cursor.getString(0)+":"+cursor.getString(1);

    }
    private void init2() {
        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);

        cursor = db.query("words", new String[]{"word", "translation","put"}, "word like ?", new String[]{"apple"}, null, null, null);
        cursor.moveToFirst();

        a=0;
        w1.setText(cursor.getString(0));

        if (cursor != null) {
            a1.setText(cursor.getString(1));
            //以下两行代码都是存储光标的位置，记录当前的数据
            currentPosition1 = cursor.getPosition();
            c[a] = cursor.getPosition();

            cursor.moveToNext();
            a++;
        }
        if (cursor != null) {

            a2.setText(cursor.getString(1));
            //记录当前位置(数据)
            currentPosition2 = cursor.getPosition();
            c[a] = cursor.getPosition();
//            cursor.moveToNext();
            //位置存放数组的下标下移
            a++;
        }
        if (cursor != null) {
            a3.setText(cursor.getString(1));
            currentPosition3 = cursor.getPosition();
            c[a] = cursor.getPosition();
//            cursor.moveToNext();
            a++;
        }
        if (cursor != null) {
            a4.setText(cursor.getString(1));
            currentPosition4 = cursor.getPosition();
            c[a] = cursor.getPosition();
//            cursor.moveToNext();
            a++;
        }
//            a1.setText(cursor.getString(0)+"\n"+cursor.getString(1));
//            cursor.moveToNext();
//            a2.setText(cursor.getString(0) + "\n" + cursor.getString(1));
//            cursor.moveToNext();
//            a3.setText(cursor.getString(0) + "\n" + cursor.getString(1));
//            cursor.moveToNext();
//            a4.setText(cursor.getString(0) + "\n" + cursor.getString(1));
    }
    private void init3() {
        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);

        Cursor cursor = db.query("words", new String[]{"word", "translation"}, null, null, null, null, null);
        cursor.moveToFirst();


        a=0;
        w1.setText(cursor.getString(0));

        if (cursor != null) {
            a1.setText(cursor.getString(1));
            //以下两行代码都是存储光标的位置，记录当前的数据
            currentPosition1 = cursor.getPosition();
            c[a] = cursor.getPosition();

            cursor.moveToNext();
            a++;
        }
        if (cursor != null) {
            //这里获取随机的数据库位置
            Cursor cursor2 = db.rawQuery("SELECT * FROM words ORDER BY RANDOM() LIMIT 1", null);
            //对随机数据进行查重(利用cursor的position来对比--checking())
            while(checking(c,a,c[a])!=1){
                //数据重复则重新生成一个数据的位置光标
                cursor2 = db.rawQuery("SELECT * FROM words ORDER BY RANDOM() LIMIT 1", null);
            }
            //将最终的数据放入button的textview中
            a2.setText(cursor.getString(1));
            //记录当前位置(数据)
            currentPosition2 = cursor.getPosition();
            c[a] = cursor.getPosition();
//            cursor.moveToNext();
            //位置存放数组的下标下移
            a++;
        }
        if (cursor != null) {
            Cursor cursor2 = db.rawQuery("SELECT * FROM words ORDER BY RANDOM() LIMIT 1", null);
            while(checking(c,a,c[a])!=1){
                cursor2 = db.rawQuery("SELECT * FROM words ORDER BY RANDOM() LIMIT 1", null);
            }
            a3.setText(cursor.getString(1));
            currentPosition3 = cursor.getPosition();
            c[a] = cursor.getPosition();
//            cursor.moveToNext();
            a++;
        }
        if (cursor != null) {
            Cursor cursor2 = db.rawQuery("SELECT * FROM words ORDER BY RANDOM() LIMIT 1", null);
            while(checking(c,a,c[a])!=1){
                cursor2 = db.rawQuery("SELECT * FROM words ORDER BY RANDOM() LIMIT 1", null);
            }
            a4.setText(cursor.getString(1));
            currentPosition4 = cursor.getPosition();
            c[a] = cursor.getPosition();
//            cursor.moveToNext();
            a++;
        }
//            a1.setText(cursor.getString(0)+"\n"+cursor.getString(1));
//            cursor.moveToNext();
//            a2.setText(cursor.getString(0) + "\n" + cursor.getString(1));
//            cursor.moveToNext();
//            a3.setText(cursor.getString(0) + "\n" + cursor.getString(1));
//            cursor.moveToNext();
//            a4.setText(cursor.getString(0) + "\n" + cursor.getString(1));
    }
    public int checking(int[] c, int now, int currentPosition) {
        for (int ccc : c) {
            if (ccc != c[now]) {
                if (ccc == currentPosition)
                    return -1;
            }
        }
        return 1;
    }

    @Override
    public void onClick(View view) {
        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);

        Cursor cursor = db.query("words", new String[]{"word", "translation"}, null, null, null, null, null);
        cursor.move(currentPosition1);

        int id = view.getId();

        if (id == R.id.a1) {
            if (b == 0)
                judge(a1, answer,text1);
            b = 1;
        } else if (id == R.id.a2) {
            if (bb == 0)
                judge(a1, answer,text2);

            bb = 1;
        } else if (id == R.id.a3) {
            if (bbb == 0)
                judge(a1, answer,text3);

            bbb = 1;
        } else if (id == R.id.a4) {
            if (bbbb == 0)
                judge(a1, answer,text4);

            bbbb = 1;
        } else if (id == R.id.next) {
            if (a == 1) {
                Intent intent = new Intent(this, Putbox.class);
                Toast.makeText(this, "turn successfully ", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Toast.makeText(this, "请答对后再记忆下一个单词 ", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.exit) {
            Intent intent=new Intent(this, MainActivity.class);
            Toast.makeText(this, "跳转到离开页面", Toast.LENGTH_SHORT).show();
            startActivity(intent);
//            finish();
        }
    }

    public void judge(Button a1, String test1, String test2) {
//        String msg = getString(test1);
        String[] msg1 = test1.split(":");
        String word1 = msg1[0];
        String tran1 = msg1[1];

//        String msg2 = getString(test2);
        String[] msg22 = test2.split(":");
        String word2 = msg22[0];
        String tran2 = msg22[1];

        if (a1.getText().equals(tran1)) {
            Toast.makeText(this, a + a1.getText().toString() + "答对了", Toast.LENGTH_SHORT).show();
            a1.setBackgroundColor(getResources().getColor(holo_green_light));
            a1.setText(word2 + "\n" + tran2);
            a = 1;
        } else {
            Toast.makeText(this, a + a1.getText().toString() + "答错了", Toast.LENGTH_SHORT).show();
            a1.setBackgroundColor(getResources().getColor(holo_red_light));
            a1.setText(word2 + "\n" + tran2);
        }
    }

    public void judge1(Button a1, int c1) {
        Cursor cursor = db.query("words", new String[]{"word", "translation"}, null, null, null, null, null);
        cursor.moveToPosition(c1);
        String cc = new String();
        cc = String.valueOf(cursor.move(c1));
        String word = cursor.getString(0);
        String translation = cursor.getString(1);
        a1.setText(word + "\n" + translation);

        if (a1.getText().equals(translation)) {
            Toast.makeText(this, a + a1.getText().toString() + "答对了", Toast.LENGTH_SHORT).show();
            a1.setBackgroundColor(getResources().getColor(holo_green_light));

            a = 1;
        } else {
            Toast.makeText(this, a + a1.getText().toString() + "答错了", Toast.LENGTH_SHORT).show();
            a1.setBackgroundColor(getResources().getColor(holo_red_light));
        }
    }
}






