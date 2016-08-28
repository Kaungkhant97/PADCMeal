package com.kaungkhantthu.mealordering.utils;

import com.google.gson.Gson;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class CommonInstance {

    private static Gson gson;

    public static Gson getGsonInstance(){
        if(gson != null) {
            return gson;
        }else {
            gson = new Gson();
            return gson;
    }

}}
