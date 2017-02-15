package com.lenservice.bjmspqqmf.category;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * Created by len on 16/12/28.
 */

public class QFCommonExpandaListView extends ExpandableListView {
    private OnScrollChanged mOnScrollChanged;

    public QFCommonExpandaListView(Context context) {
        super(context);
    }

    public QFCommonExpandaListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QFCommonExpandaListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (mOnScrollChanged != null)
            mOnScrollChanged.onScroll(l, t, oldl, oldt);

    }
    public void setOnScrollChanged(OnScrollChanged onScrollChanged){
        this.mOnScrollChanged = onScrollChanged;
    }
    public interface OnScrollChanged{
        void onScroll(int l, int t, int oldl, int oldt);
    }
}
