package com.derek.ocjdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by asus on 2016/10/17 09 49.
 * 邮箱:763433963@qq.com
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    protected abstract void initData();


    protected abstract void initView();

    public abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
