package com.kaungkhantthu.mealordering.data.agents;

import com.kaungkhantthu.mealordering.data.responses.MealListResponse;
import com.kaungkhantthu.mealordering.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public interface MealApi {

    @FormUrlEncoded
    @POST(Constants.API_GET_MEAL_LIST)
    Call<MealListResponse> loadMealList(
            @Field(Constants.PARAM_ACCESS_TOKEN) String param);

}