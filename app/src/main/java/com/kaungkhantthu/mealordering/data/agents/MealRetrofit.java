package com.kaungkhantthu.mealordering.data.agents;

import android.util.Log;

import com.kaungkhantthu.mealordering.data.models.MealModel;
import com.kaungkhantthu.mealordering.data.responses.MealListResponse;
import com.kaungkhantthu.mealordering.utils.CommonInstance;
import com.kaungkhantthu.mealordering.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class MealRetrofit implements DataAgent {

    private static MealRetrofit objInstance;

    private final MealApi theApi;

    private MealRetrofit() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstance.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(MealApi.class);

    }

    public static MealRetrofit getInstance() {

        if (objInstance == null) {
            objInstance = new MealRetrofit();
        }


        return objInstance;
    }


    @Override
    public void loadMealList() {
        final Call<MealListResponse> mealListResponseCall = theApi.loadMealList(Constants.ACCESS_TOKEN);
        mealListResponseCall.enqueue(new Callback<MealListResponse>() {
            @Override
            public void onResponse(Call<MealListResponse> call, Response<MealListResponse> response) {
                Log.d("Meal Ordering Retrofit",response.body().getMealList().size()+"");
                MealListResponse mealListResponse = response.body();
                MealModel.getInstance().setMealList(mealListResponse.getMealList());
            }

            @Override
            public void onFailure(Call<MealListResponse> call, Throwable t) {
                MealModel.getInstance().setMealError(t.getMessage());
            }
        });
    }
}