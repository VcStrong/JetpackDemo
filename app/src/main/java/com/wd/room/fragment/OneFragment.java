package com.wd.room.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.wd.room.R;
import com.wd.room.adapter.MyAdapter;
import com.wd.room.adapter.OneListAdapter;
import com.wd.room.databinding.FragOneBinding;
import com.wd.room.databinding.FragTwoBinding;
import com.wd.room.viewmodel.ListValueViewModel;

public class OneFragment extends Fragment {

    OneListAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragOneBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.frag_one,container,false);

        final ListValueViewModel viewModel = new ViewModelProvider(getActivity())
                .get(ListValueViewModel.class);

        myAdapter = new OneListAdapter();
        myAdapter.add("吴新仲");
        myAdapter.add("轩冉");
        myAdapter.add("刘炳良");
        myAdapter.add("断线的杨世博");
        myAdapter.add("打酱油的刘阳");
        myAdapter.add("修电表的杨石");
        binding.list.setAdapter(myAdapter);
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("dt",viewModel.hashCode()+"");
                viewModel.setName(myAdapter.getItem(position));
            }
        });

        return binding.getRoot();
    }
}
