package com.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Schuman on 2016/6/2.
 */
public class MoreFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //将返回值修改，加载fragment_more的布局
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //重写onViewCreated方法
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //通过ButterKnife初始化控件

        //修改控件上的文字
    }

}
