package com.example.mword;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Review extends AppCompatActivity {
    ListView myList = null;

    ArrayList<Food> foods;
    private SQLiteDatabase db;
    TextView title1;
    ImageView iv;
    TextView price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        myList = findViewById(R.id.mylist);
        foods = inData();
        MyAdapter myAdapter = new MyAdapter();
        myList.setAdapter(myAdapter);
    }
    public class Food {

        private int icon;
        private String title;
        private String price;

        public Food(int icon, String title, String price) {
            this.icon = icon;
            this.title = title;
            this.price = price;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrivce(String price) {
            this.price = price;
        }
    }
    private ArrayList<Food> inData(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(R.drawable.ic_launcher_background,"小笼包","10元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"草莓蛋糕","20元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"龙虾","200元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"火锅","150元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"披萨","60元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"鳗鱼饭","40元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"小笼包","10元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"草莓蛋糕","20元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"龙虾","200元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"火锅","150元"));
        foods.add(new Food(R.drawable.ic_launcher_background,"披萨","60元"));
        return foods;
    }
    static class ViewHolder{
        TextView title;
        ImageView iv;
        TextView price;
    }
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {//获取item的数量
            return foods.size();
        }

        @Override
        public Object getItem(int i) {//i表示当前item的序号，序号从0开始编写，getIte用于获取某个item
            return foods.get(i);
        }

        @Override
        public long getItemId(int i) {//获取选中的item的编号
            return i;
        }

        @Override//用于配置listview要加载的内容，包括视图和数据
        public View getView(int i, View view, ViewGroup viewGroup) {

//             这种写法，每次调用都要生成一个新的View,那么当数据多了，那就要生成很多个view，
//             这样会造成资源浪费
//             View view1 = View.inflate(MainActivity.this,R.layout.itemlayout,null);
//             title1 = view1.findViewById(R.id.title1);
//             iv = view1.findViewById(R.id.iv);
//             price = view1.findViewById(R.id.price);
//             title1.setText(foods.get(i).getTitle());
//             iv.setBackgroundResource(foods.get(i).getIcon());
//             price.setText(foods.get(i).getPrice());


//             优化写法
            ViewHolder holder = null;
            if(view == null){
                //这里是将item视图与view绑定起来
                view = View.inflate(Review.this,R.layout.item,null);
                holder = new ViewHolder();
//                注意，这里是去view的视图里面拿id
                holder.title = view.findViewById(R.id.title1);
                holder.iv = view.findViewById(R.id.iv);
                holder.price = view.findViewById(R.id.price);

                holder.title.setText(foods.get(i).getTitle());
                holder.iv.setBackgroundResource(foods.get(i).getIcon());
                holder.price.setText(foods.get(i).getPrice());

                view.setTag(holder);
            }else {
                holder = (ViewHolder) view.getTag();
                holder.title.setText(foods.get(i).getTitle());
                holder.iv.setBackgroundResource(foods.get(i).getIcon());
                holder.price.setText(foods.get(i).getPrice());
            }
            return view;
        }
    }
}