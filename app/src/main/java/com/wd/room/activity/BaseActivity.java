package com.wd.room.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.wd.room.R;
import com.wd.room.databinding.ActivityTwoBinding;

public abstract class BaseActivity<D extends ViewDataBinding> extends AppCompatActivity {

    protected D binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        initView(savedInstanceState);
        //发送请求
    }


    protected abstract void initView(Bundle savedInstanceState);
    protected abstract  @LayoutRes int getLayoutId();
}
