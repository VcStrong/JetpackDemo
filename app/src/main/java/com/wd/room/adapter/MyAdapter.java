package com.wd.room.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.room.Goods;
import com.wd.room.R;
import com.wd.room.databinding.ItemGoodsBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends WDAdapter<Goods,ItemGoodsBinding> {


    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_goods;
    }

    @Override
    protected void bindView(ItemGoodsBinding binding, int position) {
        binding.setGoods(getItem(position));
//        binding.call.setOnClickListener();
    }
}
