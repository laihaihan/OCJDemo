package com.derek.ocjdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by asus on 2016/10/17 09 49.
 * 邮箱:763433963@qq.com
 * 遵循MVP的设计模式 activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

    }

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}


