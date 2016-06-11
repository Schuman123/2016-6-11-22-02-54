package com.example.bizhidemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.home.fragment.MoreFragment;
import com.home.fragment.RecommendFragment;
import com.home.fragment.SearchFragment;
import com.home.fragment.TypeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    //1.通过ButterKnife初始化控件
    @Bind(R.id.framelayout)
    FrameLayout framelayout;
    @Bind(R.id.btn_recom)
    RadioButton btnRecom;
    @Bind(R.id.btn_type)
    RadioButton btnType;
    @Bind(R.id.btn_search)
    RadioButton btnSearch;
    @Bind(R.id.btn_more)
    RadioButton btnMore;
    @Bind(R.id.radiogroup)
    RadioGroup radiogroup;

    private FragmentManager manager;

    //2.创建集合 初始化4个fragment对象
    private List<Fragment> frags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFrags();
        setListener();

        manager = getSupportFragmentManager();
        //3.在屏幕上添加默认显示的Fragment
        manager.beginTransaction().add(R.id.framelayout, frags.get(0)).commit();
    }

    //4.监控下方标签的监听事件，在监听事件中进行4个Fragment之间的show hide 判断

    private void setListener() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton select = (RadioButton) radiogroup.findViewById(checkedId);
                int num = Integer.parseInt(select.getTag().toString());
                manager.beginTransaction().replace(R.id.framelayout, frags.get(num)).commit();

            }
        });

    }

    private void initFrags() {
        frags.add(new RecommendFragment());
        frags.add(new TypeFragment());
        frags.add(new SearchFragment());
        frags.add(new MoreFragment());

    }

}
