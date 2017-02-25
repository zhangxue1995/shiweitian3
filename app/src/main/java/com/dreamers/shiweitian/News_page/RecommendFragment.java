package com.dreamers.shiweitian.News_page;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dreamers.shiweitian.R;

/**
 * Created by stzha on 2017/1/8.
 */

public class RecommendFragment extends Fragment {


    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //动态加载if
//        View rootView = inflater.inflate(R.layout.recommend,container,false);
//        TextView tv=(TextView)rootView.findViewById(R.id.aa);
//        tv.setText("lalala");
//        return rootView;

          View rootView = inflater.inflate(R.layout.recommend_load,container,false);
        return rootView;


    }


}