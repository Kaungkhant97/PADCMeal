package com.kaungkhantthu.mealordering.data.events;

import com.kaungkhantthu.mealordering.data.vos.Meal;

import java.util.List;

/**
 * Created by kaungkhantthu on 8/28/16.
 */
public class DataEvent {
    public static class AttractionDataLoadedEvent {

        private String extraMessage;
        private List<Meal> mealList;

        public AttractionDataLoadedEvent(String extraMessage, List<Meal> mealList) {
            this.extraMessage = extraMessage;
            this.mealList = mealList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<Meal> getAttractionList() {
            return mealList;
        }
    }

}