package com.example.mword;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Look_up extends AppCompatActivity implements View.OnClickListener{
    private SQLiteDatabase db;
    private Button back,find;
    private EditText select;
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up);
        init();
        File dbFile = getDatabasePath("/data/data/com.example.mword/databases/words");
        db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
    }
    private void init(){;
        show=findViewById(R.id.show);
        back=findViewById(R.id.back);
        find=findViewById(R.id.find);
        select=findViewById(R.id.select);

        back.setOnClickListener(this);
        find.setOnClickListener(this);
        select.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.find){
            String f=select.getText().toString();
            Cursor cursor=db.query("words",new String[]{"word","translation"},"word like ?",new String[]{f},null,null,null);
            if(cursor.moveToFirst()){
                show.setText("\n单词:"+cursor.getString(0)+"\n翻译:"+cursor.getString(1));
                cursor.close();
            }else{
                cursor=db.query("words",new String[]{"word","translation"},"translation like ?",new String[]{f},null,null,null);
                if( cursor.moveToFirst()){
                    show.setText("\n单词:"+cursor.getString(0)+"\n翻译:"+cursor.getString(1));
                    cursor.close();
                }else{
                    show.setText("查无此数,\n可以在添词按钮进行添加哟\n(＾Ｕ＾)ノ~ＹＯ");
                }
            }
        }else if(id==R.id.back){
            finish();
        }
    }
}