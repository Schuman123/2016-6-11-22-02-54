package com.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.bizhidemo.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bean.TypeBean;
import home.request.BiZhiRequest;
import utils.MyApp;
import utils.UrlUtils;

/**
 * Created by Schuman on 2016/6/2.
 * 分类页面
 * 显示：一个标题栏，一个listview列表
 */
public class TypeFragment extends Fragment {

    private RequestQueue queue;
    private ImageLoader loader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置布局
        return inflater.inflate(R.layout.fragment_type, null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化控件

        //启动异步任务进行联网读取数据并解析(GsonFormat插件)
        initData();


        //封装并设置适配器(外部类)
        //在newAdapter时需传递Loader对象
        loader = ((MyApp) getActivity().getApplication()).getLoader();


    }

    private void initData() {

        final BiZhiRequest<TypeBean> request = new BiZhiRequest<TypeBean>(
                TypeBean.class,
                UrlUtils.TYPE_BASE_URL,
                new Response.Listener<TypeBean>() {
                    @Override
                    public void onResponse(TypeBean response) {
                        //获取data集合
                        List<TypeBean.DataBean> data  = response.getData();
                        //将data集合存入fragment的数据集合中


                        //刷新适配器

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //一旦出错，弹出出错信息

                    }
                }


        );
    }
}
