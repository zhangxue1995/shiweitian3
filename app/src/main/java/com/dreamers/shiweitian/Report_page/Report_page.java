package com.dreamers.shiweitian.Report_page;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.MainActivity;
import com.dreamers.shiweitian.Home_page.MyGridView;
import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.News_page.News_page;
import com.dreamers.shiweitian.Personal_information;
import com.dreamers.shiweitian.QandA_page.QandA_page;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Search_page.Search_page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stzha on 2017/1/8.
 */

public class Report_page extends AppCompatActivity implements View.OnClickListener {
    private TextView tab1;
    private TextView tab2;
    private TextView tab3;
    private TextView tab4;
    private TextView tab5;

    private ImageView report_merchant,report_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.user_photo);
        actionBar.setTitle("这是昵称");


        //底部导航栏
        tab1 = (TextView) this.findViewById(R.id.txt_1);
        tab2 = (TextView) this.findViewById(R.id.txt_2);
        tab3 = (TextView) this.findViewById(R.id.txt_3);
        tab4 = (TextView) this.findViewById(R.id.txt_4);
        tab5 = (TextView) this.findViewById(R.id.txt_5);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);
        tab5.setOnClickListener(this);
        tab3.setSelected(true);

        report_merchant=(ImageView)this.findViewById(R.id.report_merchant);
        report_product=(ImageView)this.findViewById(R.id.report_product);
        report_merchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Report_page.this, Report_merchant.class);
                startActivity(it);
            }
        });
        report_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent();
                it.setClass(Report_page.this, Report_product.class);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent it =new Intent();
                it.setClass(Report_page.this, Personal_information.class);
                startActivity(it);
                //    MainActivity.this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //重置所有文本的选中状态
    public void selected(){
        tab1.setSelected(false);
        tab2.setSelected(false);
        tab3.setSelected(false);
        tab4.setSelected(false);
        tab5.setSelected(false);
    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.txt_1:
                selected();
                tab1.setSelected(true);
                Intent it1 =new Intent();
                it1.setClass(Report_page.this, MainActivity.class);
                startActivity(it1);
                Report_page.this.finish();
                break;

            case R.id.txt_2:
                selected();
                tab2.setSelected(true);
                Intent it2 =new Intent();
                it2.setClass(Report_page.this, News_page.class);
                startActivity(it2);
                Report_page.this.finish();
                break;

            case R.id.txt_3:
                selected();
                tab3.setSelected(true);
                break;

            case R.id.txt_4:
                selected();
                tab4.setSelected(true);
                Intent it4 =new Intent();
                it4.setClass(Report_page.this, QandA_page.class);
                startActivity(it4);
                Report_page.this.finish();
                break;

            case R.id.txt_5:
                selected();
                tab5.setSelected(true);
                Intent it5 =new Intent();
                it5.setClass(Report_page.this, Search_page.class);
                startActivity(it5);
                Report_page.this.finish();
                break;
        }

//        transaction.commit();
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }


}
