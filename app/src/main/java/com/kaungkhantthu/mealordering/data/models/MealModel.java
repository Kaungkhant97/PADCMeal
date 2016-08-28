package com.kaungkhantthu.mealordering.data.models;

import android.util.Log;

import com.kaungkhantthu.mealordering.data.agents.MealRetrofit;
import com.kaungkhantthu.mealordering.data.events.MealSetEvent;
import com.kaungkhantthu.mealordering.data.vos.Meal;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class MealModel {

    private static MealModel objInstance;

    private List<Meal> mMealList;

    private MealModel() {
        Log.d("Data", "data");

        MealRetrofit.getInstance().loadMealList();
        mMealList = new ArrayList<>();

    }

    public static MealModel getInstance() {
        if (objInstance == null) {
            objInstance = new MealModel();
        }
        return objInstance;
    }

    public List<Meal> getMealList() {

        Log.d("Meal Ordering Model",mMealList.size()+"");
        return mMealList;
    }

    public void setMealList(List<Meal> mealList) {

        this.mMealList = mealList;
        Log.e("meal size", mMealList.size()+"");
        EventBus.getDefault().post(new MealSetEvent());

    }

    public void setMealError(String message) {
        Log.e("Meal Application", message);
    }

}
