package com.lenservice.bjmspqqmf.Interface.fragment;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lenservice.bjmspqqmf.Interface.fragment.son.QFFirstFragment;
import com.lenservice.bjmspqqmf.Interface.fragment.son.QFSecondFragment;
import com.lenservice.bjmspqqmf.Interface.fragment.son.QFThirdFragment;
import com.lenservice.bjmspqqmf.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 16/12/27.
 */

public class QFCenterDrawFragment extends Fragment implements View.OnClickListener {

    private Button drawbtn;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private RelativeLayout leftL;
    private RelativeLayout centerL;
    private LinearLayout Occlusionll;
    private RelativeLayout tabbarll;

    // 得到fragmentManager
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    // tabbarFragment
    private QFFirstFragment tab_FirstFragment;
    private QFSecondFragment tab_SecondFragment;
    private QFThirdFragment tab_thirdFragment;

    private Button tab_firstBtn;
    private Button tab_secondBtn;
    private Button tab_thirdBtn;

    private List<Button>listbtn;

    private List<Integer>tabImageNOList;
    private List<Integer>tabImageOFFList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_draw_center, null);
    }

    @Override
    public void onResume() {
        super.onResume();
        initBaseViews();
        configUI();
        initSonFragment();
    }

    private void initSonFragment() {
        // 创建管理者
        fragmentManager = this.getChildFragmentManager();
        // 初始化对象
        tab_FirstFragment = new QFFirstFragment();
        tab_SecondFragment = new QFSecondFragment();
        tab_thirdFragment = new QFThirdFragment();

        // 添加回退栈中
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.qm_center_contentrl, tab_thirdFragment, "thirdFragment");
        transaction.replace(R.id.qm_center_contentrl, tab_SecondFragment, "secondFragment");
        transaction.replace(R.id.qm_center_contentrl, tab_FirstFragment, "firstFragment");
        transaction.addToBackStack("thirdFragment");
        transaction.addToBackStack("secondFragment");
        transaction.addToBackStack("firstFragment");
        transaction.commit();
    }
    private void configUI() {
        WindowManager manager = this.getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        SCREEN_HEIGHT = outMetrics.heightPixels;
        //add
        View sepV = new View(this.getActivity());
        sepV.setBackgroundColor(Color.GRAY);
        RelativeLayout.LayoutParams sep_lp = new RelativeLayout.LayoutParams(SCREEN_WIDTH, 1);
        tabbarll.addView(sepV, sep_lp);
    }

    private void initBaseViews() {
        drawbtn = (Button) this.getView().findViewById(R.id.drawbtn);
        tabbarll = (RelativeLayout) this.getView().findViewById(R.id.qm_tabbar);
        leftL = (RelativeLayout) this.getActivity().findViewById(R.id.qm_leftRL);
        centerL = (RelativeLayout) this.getActivity().findViewById(R.id.qm_centerRL);
        Occlusionll = (LinearLayout) this.getView().findViewById(R.id.Occlusionll);
        tab_firstBtn = (Button) this.getView().findViewById(R.id.qm_tabbar_firstbtn);
        tab_secondBtn = (Button) this.getView().findViewById(R.id.qm_tabbar_secondbtn);
        tab_thirdBtn = (Button) this.getView().findViewById(R.id.qm_tabbar_thirdbtn);
        drawbtn.setOnClickListener(this);
        Occlusionll.setOnClickListener(this);
        tab_firstBtn.setOnClickListener(this);
        tab_secondBtn.setOnClickListener(this);
        tab_thirdBtn.setOnClickListener(this);
        listbtn = new ArrayList<>();
        listbtn.add(tab_firstBtn);
        listbtn.add(tab_secondBtn);
        listbtn.add(tab_thirdBtn);

        //添加资源
        tabImageNOList = new ArrayList<>();
        tabImageNOList.add(R.mipmap.qm_tab_first);
        tabImageNOList.add(R.mipmap.qm_tab_second);
        tabImageNOList.add(R.mipmap.qm_tab_third);

        tabImageOFFList = new ArrayList<>();
        tabImageOFFList.add(R.mipmap.qm_tab_firstnon);
        tabImageOFFList.add(R.mipmap.qm_tab_secondnon);
        tabImageOFFList.add(R.mipmap.qm_tab_thirdnon);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()){
            case R.id.Occlusionll:
                centerPropertyAnimationBack();
                leftPropertyAnimationBack();
                Occlusionll.setVisibility(View.INVISIBLE);
                break;
            case R.id.drawbtn:
                centerPropertyAnimation();
                leftPropertyAnimation();
                Occlusionll.setVisibility(View.VISIBLE);
                break;
            case R.id.qm_tabbar_firstbtn:
                changeTabbarProperty(tab_firstBtn);
                addToBackStack(tab_FirstFragment);
                break;
            case R.id.qm_tabbar_secondbtn:
                changeTabbarProperty(tab_secondBtn);
                addToBackStack(tab_SecondFragment);
                break;
            case R.id.qm_tabbar_thirdbtn:
                changeTabbarProperty(tab_thirdBtn);
                addToBackStack(tab_thirdFragment);
                break;
        }

    }
    // 中间视图右移并缩小
    public void centerPropertyAnimation() {

        float s = centerL.getTranslationX();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(centerL, "translationX", 0f, s + 500);
        centerL.clearAnimation();
        objectAnimator.setDuration(400).start();

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(centerL, "scaleY", 1.0f, 0.8f);
        centerL.setPivotX(0);
        centerL.invalidate();
        objectAnimator2.setDuration(400).start();

        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(centerL, "scaleX", 1.0f, 0.8f);
        centerL.setPivotX(0);
        centerL.invalidate();
        objectAnimator3.setDuration(400).start();

//        float y = centerL.getTranslationY();
//        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(centerL, "translationY", 0f,
//                y );
//        centerL.clearAnimation();
//        objectAnimator4.setDuration(400).start();
    }
    //左边视图右移 显示左侧导航栏
    public void leftPropertyAnimation() {

        float s = leftL.getTranslationX();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(leftL, "translationX", 0f, s + 500);
        objectAnimator.setDuration(400).start();
    }
    // 中间视图左移并增大
    public void centerPropertyAnimationBack() {
        float s = centerL.getTranslationX();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(centerL, "translationX", 0f, s - 500);
        centerL.clearAnimation();
        objectAnimator.setDuration(400).start();

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(centerL, "scaleY", 1.0f, 1.0f);
        centerL.setPivotX(0);
        centerL.invalidate();
        objectAnimator2.setDuration(400).start();

        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(centerL, "scaleX", 1.0f, 1.0f);
        centerL.setPivotX(0);
        centerL.invalidate();
        objectAnimator3.setDuration(400).start();

//        float y = centerL.getTranslationY();
//        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(centerL, "translationY", 0f,
//                0);
//        centerL.clearAnimation();
//        objectAnimator4.setDuration(400).start();
    }
    //左边视图左移 关闭左侧导航栏
    public void leftPropertyAnimationBack() {
        float s = leftL.getTranslationX();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(leftL, "translationX", 0f, s - 500);
        objectAnimator.setDuration(400).start();
    }

    // 加载tabbarFragment
    public void addToBackStack(Fragment object) {
        String tagstring = null;
        if (object instanceof QFFirstFragment) {
            tagstring = "firstFragment";
        } else if (object instanceof QFSecondFragment) {
            tagstring = "secondFragment";
        } else if (object instanceof QFThirdFragment) {
            tagstring = "thirdFragment";
        }
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.qm_center_contentrl, object, tagstring);
        transaction.commit();
        Log.i("MainActivity", "<<<<<<<" + fragmentManager.getBackStackEntryCount());
    }
    // 点击tabbar 改变图片
    public void changeTabbarProperty(Button tabBtn) {
        for (int i = 0; i<3;i++) {
            Button iBtn = listbtn.get(i);
            if (iBtn == tabBtn) {
                tabBtn.setBackgroundResource(tabImageNOList.get(i));
            } else {
                iBtn.setBackgroundResource(tabImageOFFList.get(i));
            }
        }
    }
}
