package com.kaungkhantthu.mealordering;

import android.app.Application;
import android.content.Context;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class MealOrderingApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}