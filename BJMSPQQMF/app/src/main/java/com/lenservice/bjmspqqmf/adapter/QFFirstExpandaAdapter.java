package com.lenservice.bjmspqqmf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.lenservice.bjmspqqmf.R;

import java.util.List;

/**
 * Created by len on 16/12/28.
 */

public class QFFirstExpandaAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private List<String> listArr;

    public QFFirstExpandaAdapter(Context context, List<String> listArr) {
        this.listArr = listArr;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listArr.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return getGroup(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return getChildId(groupPosition, childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        QFTextView searchView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemgroup_tab_firstexpandalistview, null);
            searchView = new QFTextView();
            convertView.setTag(searchView);
        } else {
            searchView = (QFTextView) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        QFTextView searchView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemchild_tab_firstlistview, null);
            searchView = new QFTextView();
            convertView.setTag(searchView);
        } else {
            searchView = (QFTextView) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}

class QFTextView {
    TextView tv;
}