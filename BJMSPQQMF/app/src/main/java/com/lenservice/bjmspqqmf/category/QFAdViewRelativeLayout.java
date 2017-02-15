package com.lenservice.bjmspqqmf.category;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 16/12/29.
 */

public class QFAdViewRelativeLayout extends RelativeLayout {

    private LayoutInflater inflater;
    private Context context;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    private List<ImageView> listImage;
    private int current;

    private List<Integer> listArr;

    public QFAdViewRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QFAdViewRelativeLayout(Context context, List<Integer> listArr) {
        super(context);
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.listArr = listArr;
    }

    public QFAdViewRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QFAdViewRelativeLayout(Context context) {
        super(context);
    }

    public void configUI() {
        viewPager = new ViewPager(this.context);
        viewPager.setBackgroundColor(Color.BLUE);
        Log.i("QFAdviewRelaticelayout", ">>>>>>>>>>>>>>>>>offset" + this.getX() + "  "+this.getY());

        RelativeLayout.LayoutParams prams = new RelativeLayout.LayoutParams(800, 800);
        this.addView(viewPager, prams);
        //加载数据
        listImage = new ArrayList<>();
        //创建三个imageView
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this.context);
            listImage.add(imageView);
        }
        //添加adapter
        adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return listImage.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = QFAdViewRelativeLayout.this.listImage.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(QFAdViewRelativeLayout.this.listImage.get(position));
            }
        };
        viewPager.setAdapter(adapter);
        //默认显示中间～
        viewPager.setCurrentItem(1);


      // viewPager.setonsc
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (current > position) {
                    QFAdViewRelativeLayout.this.changeImage(QFAdViewRelativeLayout.this.trueIndexByCurrentIndex(position + 1));
                } else if (current < position) {
                    QFAdViewRelativeLayout.this.changeImage(QFAdViewRelativeLayout.this.trueIndexByCurrentIndex(position - 1));
                }
                viewPager.setCurrentItem(1);
                Log.i("QFAdviewRelaticelayout", "<<<<<<<<<<<<<<offset" + positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                // ViewPager.SCROLL_STATE_SETTLING
                if(state == ViewPager.SCROLL_STATE_SETTLING){

                }
            }

        });
    }

    private void changeImage(int currentIndex) {
        ImageView image1 = listImage.get(0);
        image1.setBackgroundResource(this.listArr.get(trueIndexByCurrentIndex(currentIndex - 1)));

        ImageView image2 = listImage.get(1);
        image1.setBackgroundResource(this.listArr.get(currentIndex));
        ImageView image3 = listImage.get(2);
        image1.setBackgroundResource(this.listArr.get(trueIndexByCurrentIndex(currentIndex + 1)));
    }
    private int trueIndexByCurrentIndex(int currentIndex) {
        if (currentIndex == -1) {
            return this.listArr.size() - 1;
        } else if (currentIndex == this.listArr.size()) {
            return 0;
        }
        return currentIndex;
    }
}
