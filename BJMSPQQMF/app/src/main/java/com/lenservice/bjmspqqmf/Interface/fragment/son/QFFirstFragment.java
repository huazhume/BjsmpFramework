package com.lenservice.bjmspqqmf.Interface.fragment.son;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lenservice.bjmspqqmf.R;
import com.lenservice.bjmspqqmf.adapter.QFFirstExpandaAdapter;
import com.lenservice.bjmspqqmf.category.QFCommonExpandaListView;
import com.lenservice.bjmspqqmf.Interface.view.QFCarouselDiagramViewPager;
import com.lenservice.bjmspqqmf.dataService.QFLunBoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 16/12/28.
 */

public class QFFirstFragment extends Fragment {

    private QFCommonExpandaListView expandableListView;
    private QFFirstExpandaAdapter adapter;
    private List<String> listArr;

    private LinearLayout headerView;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabfirst, null);
        //  view.setBackgroundColor(Color.YELLOW);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        WindowManager manager = this.getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        SCREEN_WIDTH = outMetrics.widthPixels;
        SCREEN_HEIGHT = outMetrics.heightPixels;
        initData();
        initBaseViews();
    }

    private void initData() {
        listArr = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            listArr.add("fasdf");
        }
    }

    private void initBaseViews() {
        expandableListView = (QFCommonExpandaListView) this.getView().findViewById(R.id.qm_firstexpListView);
        adapter = new QFFirstExpandaAdapter(this.getActivity(), listArr);
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);
        //展开
        int groupCount = expandableListView.getCount();
        for (int i = 0; i < groupCount; i++) {
            expandableListView.expandGroup(i);
        }
        ;
        //不能够点击
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });

        headerView = (LinearLayout) this.getView().findViewById(R.id.qm_firstheaderView);

        expandableListView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

            }
        });
        expandableListView.setOnScrollChanged(new QFCommonExpandaListView.OnScrollChanged() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                Log.i("QFCommonExpandaListView","<<<<<<<<<<<<<: " +l + "  "+t+"  "+oldl + "  "+oldt );

            }
        });
       expandableListView.setOnScrollListener(new AbsListView.OnScrollListener() {
           private Integer index;
           @Override
           public void onScrollStateChanged(AbsListView view, int scrollState) {
               Log.i("QFCommonExpandaListView","<<<<<<<<<<<<<: " +view.getY() + "   "+ view.getX());
           }
           @Override
           public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                index = firstVisibleItem;
               View c = view.getChildAt(index); //this is the first visible row
               if (c != null) {
                   int scrollY = -c.getTop();
                   if((scrollY)< 180 ){
                       headerView.setY(-scrollY);
                   }
                   Log.d("QFCommonExpandaListView","<<<<<<<<<<<<<: " + (scrollY/2.0) + headerView.getY());
               }
           }
       });

        List<Integer>images = new ArrayList<>();
        images.add(R.mipmap.qm_tab_thirdnon);
        images.add(R.mipmap.qm_drawleft_icon);
        images.add(R.mipmap.qm_launcher2);
        images.add(R.mipmap.qm_drawicon2);

//        QFAdViewRelativeLayout adView = new QFAdViewRelativeLayout(this.getActivity(),images);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SCREEN_WIDTH,200);
//        headerView.addView(adView,params);
//        adView.configUI();
        initAdView();
    }
    private void initAdView() {
        List<QFLunBoUtil.Lunbo> lunbos=new ArrayList<QFLunBoUtil.Lunbo>();
        QFLunBoUtil.Lunbo lunbo1=new QFLunBoUtil.Lunbo();
        lunbo1.id="0";
        lunbo1.pic="http://www.005.tv/uploads/allimg/161124/15415064P-8.jpg";
        lunbos.add(lunbo1);
        QFLunBoUtil.Lunbo lunbo2=new QFLunBoUtil.Lunbo();
        lunbo2.id="1";
        lunbo2.pic="http://d.hiphotos.baidu.com/zhidao/pic/item/7e3e6709c93d70cf98dc8742fcdcd100baa12b5e.jpg";
        lunbos.add(lunbo2);
        QFLunBoUtil.Lunbo lunbo3=new QFLunBoUtil.Lunbo();
        lunbo3.id="2";
        lunbo3.pic="http://img3.imgtn.bdimg.com/it/u=4151395345,950572058&fm=214&gp=0.jpg";
        lunbos.add(lunbo3);

        QFCarouselDiagramViewPager viewPager=new QFCarouselDiagramViewPager(this.getActivity(), lunbos);
        //将轮播控件直接加入到线性布局中
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SCREEN_WIDTH,280);
       // params.topMargin = 60;
        headerView.addView(viewPager.getView(), RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
      //  headerView.addView(viewPager,params);
    }


}
