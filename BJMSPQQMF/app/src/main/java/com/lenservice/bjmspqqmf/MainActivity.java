package com.lenservice.bjmspqqmf;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lenservice.bjmspqqmf.Interface.fragment.QFCenterDrawFragment;
import com.lenservice.bjmspqqmf.Interface.fragment.QFLeftDrawFragment;

public class MainActivity extends Activity {

    private QFLeftDrawFragment leftDrawFragment;
    private QFCenterDrawFragment centerDrawFragment;

    // 得到fragmentManager
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;

    private RelativeLayout leftLayout;
    private RelativeLayout centerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBaseViews();
        configUI();

        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//透明导航栏
      //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    private void initBaseViews() {
        leftLayout = (RelativeLayout) this.findViewById(R.id.qm_leftRL);
        centerLayout = (RelativeLayout) this.findViewById(R.id.qm_centerRL);
    }
    private void configUI(){
        fragmentManager = this.getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        SCREEN_HEIGHT = outMetrics.heightPixels;

        leftDrawFragment = new QFLeftDrawFragment();
        centerDrawFragment = new QFCenterDrawFragment();

        centerLayout.setBackgroundColor(Color.WHITE);
        //重新设置frame
        RelativeLayout.LayoutParams leftF = new RelativeLayout.LayoutParams(SCREEN_WIDTH, SCREEN_HEIGHT);
        leftF.topMargin = 0;
        leftF.leftMargin = -SCREEN_WIDTH;

        RelativeLayout.LayoutParams centerF = new RelativeLayout.LayoutParams(SCREEN_WIDTH, SCREEN_HEIGHT);
        centerF.topMargin = 0;

        leftLayout.setLayoutParams(leftF);
        centerLayout.setLayoutParams(centerF);
        centerLayout.setEnabled(false);
        centerLayout.setFocusable(false);

        //添加到事务
        transaction.replace(R.id.qm_leftRL, leftDrawFragment, "left");
        transaction.replace(R.id.qm_centerRL, centerDrawFragment, "center");
        // 提交
        transaction.commit();
    }
}
