package com.wd.room.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.room.Goods;
import com.wd.room.R;
import com.wd.room.databinding.ItemGoodsBinding;

import java.util.ArrayList;
import java.util.List;

public abstract class WDAdapter<D,T extends ViewDataBinding> extends RecyclerView.Adapter<WDAdapter.MyHodler> {

    private List<D> list = new ArrayList<>();

    @NonNull
    @Override
    public MyHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        T binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                getLayoutId(viewType),parent,false);

        return new MyHodler(binding.getRoot());
    }

    protected abstract @LayoutRes
    int getLayoutId(int viewType);

    @Override
    public void onBindViewHolder(@NonNull MyHodler holder, int position) {
        T binding = DataBindingUtil.bind(holder.itemView);
        bindView(binding,position);
    }

    protected abstract void bindView(T binding,int position);

    public D getItem(int position){
        return list.get(position);
    }

    public void addItem(D item){
        if (item != null)
            list.add(item);
    }

    public void addAll(List<D> data){
        if (data != null)
            list.addAll(data);
    }

    public void clear(){
        list.clear();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHodler extends RecyclerView.ViewHolder{
        public MyHodler(@NonNull View itemView) {
            super(itemView);
        }
    }

}
