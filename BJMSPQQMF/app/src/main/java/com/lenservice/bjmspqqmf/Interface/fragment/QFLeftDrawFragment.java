package com.lenservice.bjmspqqmf.Interface.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.lenservice.bjmspqqmf.R;
import com.lenservice.bjmspqqmf.adapter.QFDrawLeftAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by len on 16/12/27.
 */

public class QFLeftDrawFragment extends Fragment {

    private RelativeLayout leftDrawRl;
    private ListView listView;

    private RelativeLayout drawHeaderRl;
    private RelativeLayout drawFooterRl;
    private Integer SCREEN_WIDTH;
    private Integer SCREEN_HEIGHT;


    private List<Map<String,Object>>listArr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_draw_left, null);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        initBaseViews();
        configUI();
    }

    private void initData() {
        listArr = new ArrayList<>();

        Map<String ,Object>map1 = new HashMap<>();
        map1.put("image",R.mipmap.qm_left_chongzhi);
        map1.put("name","账户充值");

        Map<String ,Object>map2 = new HashMap<>();
        map2.put("image",R.mipmap.qm_left_tixian);
        map2.put("name","余额提现");

        Map<String ,Object>map3 = new HashMap<>();
        map3.put("image",R.mipmap.qm_left_duihuan);
        map3.put("name","兑换码兑换");

        Map<String ,Object>map4 = new HashMap<>();
        map4.put("image",R.mipmap.qm_left_huifu);
        map4.put("name","我的回复");

        Map<String ,Object>map5 = new HashMap<>();
        map5.put("image",R.mipmap.qm_left_shoucang);
        map5.put("name","我的收藏");

        Map<String ,Object>map6 = new HashMap<>();
        map6.put("image",R.mipmap.qm_left_yijian);
        map6.put("name","意见反馈");

        listArr.add(map1);
        listArr.add(map2);
        listArr.add(map3);
        listArr.add(map4);
        listArr.add(map5);
        listArr.add(map6);
    }

    private void configUI() {


        drawHeaderRl = (RelativeLayout) LayoutInflater.from(this.getActivity()).inflate(R.layout.itemgroup_drawleft_header,null);
        RelativeLayout.LayoutParams pram2 = new RelativeLayout.LayoutParams(500,400);
        pram2.leftMargin = SCREEN_WIDTH-500;
        pram2.topMargin = (int) (SCREEN_HEIGHT * 0.07);
        leftDrawRl.addView(drawHeaderRl,pram2);

        listView = new ListView(this.getActivity());
        RelativeLayout.LayoutParams pram = new RelativeLayout.LayoutParams(500,480);
        pram.leftMargin = SCREEN_WIDTH-500;
        pram.topMargin = 480;
        leftDrawRl.addView(listView,pram);

        QFDrawLeftAdapter adapter = new QFDrawLeftAdapter(this.getActivity(),listArr);
        listView.setAdapter(adapter);

        listView.setDividerHeight(0);
        listView.setDivider(null);
        listView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        drawFooterRl = (RelativeLayout) LayoutInflater.from(this.getActivity()).inflate(R.layout.itemgroup_drawleft_footer,null);
        RelativeLayout.LayoutParams pram3 = new RelativeLayout.LayoutParams(500,60);
        pram3.leftMargin = SCREEN_WIDTH-500;
        pram3.topMargin = (int)(0.8*SCREEN_HEIGHT);
        pram3.bottomMargin = (int) (SCREEN_HEIGHT * 0.1);
        leftDrawRl.addView(drawFooterRl,pram3);
    }

    private void initBaseViews() {
        leftDrawRl = (RelativeLayout) this.getView().findViewById(R.id.qm_drawleftrl);
        WindowManager manager = this.getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        SCREEN_HEIGHT = outMetrics.heightPixels;
    }
}
