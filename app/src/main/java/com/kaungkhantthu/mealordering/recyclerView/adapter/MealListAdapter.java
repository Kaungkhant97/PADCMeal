package com.kaungkhantthu.mealordering.recyclerView.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kaungkhantthu.mealordering.MealOrderingApp;
import com.kaungkhantthu.mealordering.R;
import com.kaungkhantthu.mealordering.data.vos.Meal;
import com.kaungkhantthu.mealordering.recyclerView.vh.MealViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class MealListAdapter extends RecyclerView.Adapter<MealViewHolder>{
    private LayoutInflater inflater;
    private List<Meal> mealList = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public MealListAdapter(List<Meal> mealList,ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(MealOrderingApp.getContext());
        this.mealList = mealList;
        this.itemClickListener = itemClickListener;
    }

    public void setItems(List<Meal> mealList) {
        this.mealList = mealList;
        notifyDataSetChanged();
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_card_item,parent,false);
        return new MealViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        holder.setData(mealList.get(position));
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
    public interface ItemClickListener {
        void onClick(Meal meal, ImageView ivMealImage);


    }
}

