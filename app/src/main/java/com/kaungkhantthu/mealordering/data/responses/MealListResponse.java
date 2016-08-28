package com.kaungkhantthu.mealordering.data.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kaungkhantthu.mealordering.data.vos.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class MealListResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("meal_list")
    @Expose
    private List<Meal> mealList = new ArrayList<Meal>();

    public MealListResponse(Integer code, String message, List<Meal> mealList) {
        this.code = code;
        this.message = message;
        this.mealList = mealList;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Meal> getMealList() {
        return mealList;
    }
}
