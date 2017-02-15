package com.lenservice.bjmspqqmf.Interface.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by len on 16/12/27.
 */

public class QFCenterRelativeLayout extends RelativeLayout {

    public QFCenterRelativeLayout(Context context) {
        super(context);
    }

    public QFCenterRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QFCenterRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public QFCenterRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
