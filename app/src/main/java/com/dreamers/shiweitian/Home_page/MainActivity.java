package com.dreamers.shiweitian.Home_page;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.dreamers.shiweitian.Personal_information;
import com.dreamers.shiweitian.QandA_page.QandA_page;
import com.dreamers.shiweitian.R;
import com.dreamers.shiweitian.Report_page.Feedback;
import com.dreamers.shiweitian.Report_page.Report_merchant;
import com.dreamers.shiweitian.Report_page.Report_page;
import com.dreamers.shiweitian.Report_page.Report_product;
import com.dreamers.shiweitian.Search_page.Search_page;
import com.dreamers.shiweitian.News_page.News_page;
import com.dreamers.shiweitian.zxing.QR_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnClickListener,AdapterView.OnItemClickListener{
    private TextView tab1;
    private TextView tab2;
    private TextView tab3;
    private TextView tab4;
    private TextView tab5;

    private final static int SCANNIN_GREQUEST_CODE = 1;

    // 声明ListView控件
    private ListView mListView;
    // 声明数组链表，其装载的类型是ListItem(封装了一个Drawable和一个String的类)
    private ArrayList<ListItem> mList;


    private MyGridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;  private SimpleAdapter sim_adapter1;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.jubao_chanpin, R.drawable.jubao_shangjia,
            R.drawable.saomajubao, R.drawable.jubaofankui, R.drawable.shipinchaxun,
            R.drawable.zhuanjiawenda, R.drawable.jiankangzixun, R.drawable.shijianxinwen,
            };
    private String[] iconName = { "举报产品", "举报商家", "扫码举报", "举报反馈", "食品查询", "专家问答", "健康资讯",
            "食监新闻" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
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
        tab1 = (TextView)this.findViewById(R.id.txt_1);
        tab2 = (TextView)this.findViewById(R.id.txt_2);
        tab3 = (TextView)this.findViewById(R.id.txt_3);
        tab4 = (TextView)this.findViewById(R.id.txt_4);
        tab5 = (TextView)this.findViewById(R.id.txt_5);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);
        tab5.setOnClickListener(this);
        tab1.setSelected(true);

//gridview
        gview = (MyGridView) findViewById(R.id.gview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(this);


        // 通过findviewByID获取到ListView对象
        mListView=(ListView)findViewById(R.id.listView1);
        mListView.setEnabled(false);//xiugai
        // 获取Resources对象
        Resources res = this.getResources();
        mList = new ArrayList<MainActivity.ListItem>();
        // 初始化data，装载八组数据到数组链表mList中
        ListItem item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目一");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目二");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目三");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目四");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目五");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目六");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目七");
        mList.add(item);

        item = new ListItem();
        item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("项目八");
        mList.add(item);

        // 获取MainListAdapter对象
        MainListViewAdapter adapter = new MainListViewAdapter();
        // 将MainListAdapter对象传递给ListView视图
        mListView.setAdapter(adapter);
    }


    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
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
                break;

            case R.id.txt_2:
                selected();
                tab2.setSelected(true);
                Intent it2 =new Intent();
                it2.setClass(MainActivity.this, News_page.class);
                startActivity(it2);
                MainActivity.this.finish();
                break;

            case R.id.txt_3:
                selected();
                tab3.setSelected(true);
                Intent it3 =new Intent();
                it3.setClass(MainActivity.this, Report_page.class);
                startActivity(it3);
                MainActivity.this.finish();
                break;

            case R.id.txt_4:
                selected();
                tab4.setSelected(true);
                Intent it4 =new Intent();
                it4.setClass(MainActivity.this, QandA_page.class);
                startActivity(it4);
                MainActivity.this.finish();
                break;

            case R.id.txt_5:
                selected();
                tab5.setSelected(true);
                Intent it5 =new Intent();
                it5.setClass(MainActivity.this, Search_page.class);
                startActivity(it5);
                MainActivity.this.finish();
                break;
        }

//        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent it =new Intent();
                it.setClass(MainActivity.this, Personal_information.class);
                startActivity(it);
            //    MainActivity.this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

/**
 * 定义ListView适配器MainListViewAdapter
 */
class MainListViewAdapter extends BaseAdapter {

    /**
     * 返回item的个数
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    /**
     * 返回item的内容
     */
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    /**
     * 返回item的id
     */
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    /**
     * 返回item的视图
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView listItemView;

        // 初始化item view
        if (convertView == null) {
            // 通过LayoutInflater将xml中定义的视图实例化到一个View中
            convertView = LayoutInflater.from(MainActivity.this).inflate(
                    R.layout.items, null);

            // 实例化一个封装类ListItemView，并实例化它的两个域
            listItemView = new ListItemView();
            listItemView.imageView = (ImageView) convertView
                    .findViewById(R.id.image);
            listItemView.textView = (TextView) convertView
                    .findViewById(R.id.title);

            // 将ListItemView对象传递给convertView
            convertView.setTag(listItemView);
        } else {
            // 从converView中获取ListItemView对象
            listItemView = (ListItemView) convertView.getTag();
        }
        // 获取到mList中指定索引位置的资源
        Drawable img = mList.get(position).getImage();
        String title = mList.get(position).getTitle();

        // 将资源传递给ListItemView的两个域对象
        listItemView.imageView.setImageDrawable(img);
        listItemView.textView.setText(title);
        // 返回convertView对象
        return convertView;
    }

}
/**
 * 封装两个视图组件的类
 */
class ListItemView {
    ImageView imageView;
    TextView textView;
}
/**
 * 封装了两个资源的类
 */
class ListItem {
    private Drawable image;
    private String title;
    public Drawable getImage() {
        return image;
    }
    public void setImage(Drawable image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent it0 =new Intent();
                it0.setClass(MainActivity.this, Report_product.class);
                startActivity(it0);
                break;
            case 1:
                Intent it1 =new Intent();
                it1.setClass(MainActivity.this, Report_merchant.class);
                startActivity(it1);
               // MainActivity.this.finish();
                break;
            case 2:
//                Intent it2 =new Intent();
//                it2.setClass(MainActivity.this, QR_report.class);
//                startActivity(it2);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, QR_report.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
                break;
            case 3:
                Intent it3 =new Intent();
                it3.setClass(MainActivity.this, Feedback.class);
                startActivity(it3);
                break;
            case 4:
                Intent it4 =new Intent();
                it4.setClass(MainActivity.this, Search_page.class);
                startActivity(it4);
                break;
            case 5:

                break;
            default:


                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
                    Toast.makeText(this,bundle.getString("result"),Toast.LENGTH_LONG);

                }
                break;
        }
    }
}
