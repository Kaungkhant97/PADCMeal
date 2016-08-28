package com.kaungkhantthu.mealordering.recyclerView.adapter;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaungkhantthu.mealordering.MealOrderingApp;
import com.kaungkhantthu.mealordering.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class IngredientRVAdapter extends RecyclerView.Adapter<IngredientRVAdapter.IngredientViewHolder> {

    private LayoutInflater inflater;
    private List<String> ingredientList;

    public IngredientRVAdapter(List<String> ingredientList) {
        this.ingredientList = ingredientList;
        inflater = LayoutInflater.from(MealOrderingApp.getContext());
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ingredients_item,parent,false);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {
        holder.tvIngredient.setText("- " + ingredientList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_ingredients)
        TextView tvIngredient;

        public IngredientViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}