package com.wd.room.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.wd.room.R;
import com.wd.room.databinding.ItemOneBinding;

import java.util.ArrayList;
import java.util.List;

public class OneListAdapter extends BaseAdapter {

    List<String> list = new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }

    public void add(String value){
        list.add(value);
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemOneBinding binding;
        if (convertView == null){
            binding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.getContext()),
                    R.layout.item_one,parent,false);
            convertView = binding.getRoot();
        }else{
            binding = DataBindingUtil.bind(convertView);
        }
        binding.setValue(list.get(position));

        return convertView;
    }
}
