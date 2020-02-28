package com.wd.room.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.wd.room.R;
import com.wd.room.User;
import com.wd.room.databinding.FragTestBinding;

public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragTestBinding fragTestBinding = DataBindingUtil.inflate(inflater, R.layout.frag_test,container,false);
        fragTestBinding.setU(new User());
        return fragTestBinding.getRoot();
    }
}
