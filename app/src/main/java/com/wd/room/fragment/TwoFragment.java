package com.wd.room.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.wd.room.R;
import com.wd.room.databinding.FragTwoBinding;
import com.wd.room.viewmodel.ListValueViewModel;

public class TwoFragment extends Fragment implements LifecycleOwner {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final FragTwoBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.frag_two,container,false);

        final ListValueViewModel viewModel = new ViewModelProvider(getActivity())
                .get(ListValueViewModel.class);
        viewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.setValue(s);
                Log.i("dt",viewModel.hashCode()+"");
                binding.notifyChange();
            }
        });

        return binding.getRoot();
    }
}
