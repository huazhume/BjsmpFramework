package com.lenservice.bjmspqqmf.Interface.fragment.son;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lenservice.bjmspqqmf.Interface.view.QFCarouselDiagramViewPager;
import com.lenservice.bjmspqqmf.R;
import com.lenservice.bjmspqqmf.dataService.QFLunBoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 16/12/28.
 */

public class QFThirdFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabthird,null);
        view.setBackgroundColor(Color.RED);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initAdView();

    }
    private void initAdView() {

        List<QFLunBoUtil.Lunbo> lunbos=new ArrayList<QFLunBoUtil.Lunbo>();
        QFLunBoUtil.Lunbo lunbo1=new QFLunBoUtil.Lunbo();
        lunbo1.id="0";
        lunbo1.pic="http://img4.imgtn.bdimg.com/it/u=3810558644,337339478&fm=21&gp=0.jpg";
        lunbos.add(lunbo1);
        QFLunBoUtil.Lunbo lunbo2=new QFLunBoUtil.Lunbo();
        lunbo2.id="1";
        lunbo2.pic="http://imgsrc.baidu.com/forum/pic/item/3790ac25bc315c6043c547688db1cb1348547757.jpg";
        lunbos.add(lunbo2);
        QFLunBoUtil.Lunbo lunbo3=new QFLunBoUtil.Lunbo();
        lunbo3.id="2";
        lunbo3.pic="http://imgsrc.baidu.com/forum/pic/item/71ec9544ad345982dad33d4a0cf431adcaef84bb.jpg";
        lunbos.add(lunbo3);

        QFLunBoUtil.Lunbo lunbo4=new QFLunBoUtil.Lunbo();
        lunbo4.id="3";
        lunbo4.pic="http://img2.imgtn.bdimg.com/it/u=3715481280,1547638277&fm=214&gp=0.jpg";
        lunbos.add(lunbo4);

        QFCarouselDiagramViewPager viewPager=new QFCarouselDiagramViewPager(this.getActivity(), lunbos);

        // params.topMargin = 60;
        LinearLayout headerView = (LinearLayout) this.getView().findViewById(R.id.qm_third_ll);
        headerView.addView(viewPager.getView(), 1000, 400);
        //  headerView.addView(viewPager,params);
    }
}
