package com.wd.room;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.wd.room.activity.BaseActivity;
import com.wd.room.databinding.ActivityTwoBinding;

public class TwoActivity<ActivityTwoBinding> extends BaseActivity {


    @Override
    protected void initView(Bundle savedInstanceState) {
//        binding.****
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_two;
    }
}
