package com.derek.ocjdemo.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.derek.ocjdemo.R;
import com.derek.ocjdemo.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2016/10/17 09 49.
 * 邮箱:763433963@qq.com
 * 该fragment用于实现主页页面
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tab_main_tabLayout)
    TabLayout tabMainTabLayout;
    @BindView(R.id.viewPager_main_home)
    ViewPager viewPagerMainHome;

    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] arrTabTitles = null;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initData() {
        arrTabTitles = getResources().getStringArray(R.array.home_arrTabTitles);

    }

    @Override
    protected void initView() {

    }
}
