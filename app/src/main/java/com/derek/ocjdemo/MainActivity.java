package com.derek.ocjdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.derek.ocjdemo.base.BaseActivity;
import com.derek.ocjdemo.ui.classify.ClassifyFragment;
import com.derek.ocjdemo.ui.discover.DiscoverFragment;
import com.derek.ocjdemo.ui.home.HomeFragment;
import com.derek.ocjdemo.ui.mine.MineFragment;
import com.derek.ocjdemo.ui.mycart.MycartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.layout_container)
    FrameLayout layoutContainer;
    @BindView(R.id.tab_line)
    View tabLine;
    @BindView(R.id.tab_btn_main_home)
    RadioButton tabBtnMainHome;
    @BindView(R.id.tab_btn_main_classify)
    RadioButton tabBtnMainClassify;
    @BindView(R.id.tab_btn_main_discover)
    RadioButton tabBtnMainDiscover;
    @BindView(R.id.tab_btn_main_mycart)
    RadioButton tabBtnMainMycart;
    @BindView(R.id.tab_btn_main_mine)
    RadioButton tabBtnMainMine;
    @BindView(R.id.tab_btn_main)
    RadioGroup tabBtnMain;

    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentManager manager;
    private boolean flag = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        tabBtnMainHome = (RadioButton) findViewById(R.id.tab_btn_main_home);
        tabBtnMain = (RadioGroup) findViewById(R.id.tab_btn_main);
    }


    private void initView() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ClassifyFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new MycartFragment());
        fragmentList.add(new MineFragment());

        transaction.add(R.id.layout_container, fragmentList.get(0));

        transaction.add(R.id.layout_container, fragmentList.get(1));
        transaction.add(R.id.layout_container, fragmentList.get(2));
        transaction.add(R.id.layout_container, fragmentList.get(3));
        transaction.add(R.id.layout_container, fragmentList.get(4));

        transaction.hide(fragmentList.get(0));
        transaction.hide(fragmentList.get(1));
        transaction.hide(fragmentList.get(2));
        transaction.hide(fragmentList.get(3));
        transaction.hide(fragmentList.get(4));

        transaction.show(fragmentList.get(0));
        transaction.commit();
        tabBtnMainHome.setChecked(true);
        tabBtnMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                for (int i = 0; i < fragmentList.size(); i++) {
                    transaction.hide(fragmentList.get(i));
                }
                switch (checkedId) {
                    case R.id.tab_btn_main_home:
                        transaction.show(fragmentList.get(0));
                        break;
                    case R.id.tab_btn_main_classify:
                        transaction.show(fragmentList.get(1));
                        break;
                    case R.id.tab_btn_main_discover:
                        transaction.show(fragmentList.get(2));
                        break;
                    case R.id.tab_btn_main_mycart:
                        transaction.show(fragmentList.get(3));
                        break;
                    case R.id.tab_btn_main_mine:
                        transaction.show(fragmentList.get(4));
                        break;

                }
                transaction.commit();
            }
        });
    }



    //设置双击按键退出
    @Override
    public void onBackPressed() {
        new Thread(new Runnable() {//开启子线程，设置延时
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    flag = false;//延时时间到，重置flag
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        if (!flag) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            flag = true;
        } else {
            finish();
        }
    }
}
