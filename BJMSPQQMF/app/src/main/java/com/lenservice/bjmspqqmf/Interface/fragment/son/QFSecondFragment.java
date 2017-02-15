package com.lenservice.bjmspqqmf.Interface.fragment.son;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenservice.bjmspqqmf.R;

/**
 * Created by len on 16/12/28.
 */

public class QFSecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabsecond,null);
        view.setBackgroundColor(Color.GREEN);
        return view;
    }
}
