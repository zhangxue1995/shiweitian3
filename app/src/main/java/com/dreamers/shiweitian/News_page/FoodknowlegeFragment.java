package com.dreamers.shiweitian.News_page;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamers.shiweitian.R;

import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by stzha on 2017/1/8.
 */

public class FoodknowlegeFragment extends Fragment {


    public FoodknowlegeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.foodknowledge, container, false);
    }

}
