package com.lenservice.bjmspqqmf.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenservice.bjmspqqmf.R;

import java.util.List;
import java.util.Map;

/**
 * Created by len on 16/12/29.
 */

public class QFDrawLeftAdapter extends BaseAdapter {
    private List<Map<String,Object>>listArr;
    private LayoutInflater inflater;

    public QFDrawLeftAdapter(Context context,List<Map<String,Object>> listArr){
        this.listArr = listArr;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listArr.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LeftListItem searchView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemchild_drawleft_listview, null);
            searchView = new LeftListItem();
            searchView.titletv = (TextView) convertView.findViewById(R.id.qm_left_name);
            searchView.image = (ImageView) convertView.findViewById(R.id.qm_left_icon);
            convertView.setTag(searchView);
        } else {
            searchView = (LeftListItem) convertView.getTag();
        }
        searchView.titletv.setText(listArr.get(position).get("name").toString());
        searchView.image.setBackgroundResource((int)listArr.get(position).get("image"));
        return convertView;
    }

    class LeftListItem{
        TextView titletv;
        ImageView image;
    }
}
