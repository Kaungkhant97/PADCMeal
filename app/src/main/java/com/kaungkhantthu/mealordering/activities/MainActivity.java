package com.kaungkhantthu.mealordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.kaungkhantthu.mealordering.R;
import com.kaungkhantthu.mealordering.data.events.MealSetEvent;
import com.kaungkhantthu.mealordering.data.models.MealModel;
import com.kaungkhantthu.mealordering.data.vos.Meal;
import com.kaungkhantthu.mealordering.recyclerView.adapter.MealListAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MealListAdapter.ItemClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_meal)
    RecyclerView rvMeal;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<Meal> mealList;
    private MealListAdapter mAdapter;

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Subscribe
    public void onDataLoaded(MealSetEvent event) {
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.setItems(MealModel.getInstance().getMealList());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mealList = MealModel.getInstance().getMealList();
        mAdapter =new MealListAdapter(mealList,this);
        rvMeal.setLayoutManager(new GridLayoutManager(this,getResources().getInteger(R.integer.spancount)));
        rvMeal.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(Meal meal, ImageView ivMealImage) {
        Intent intent = DetailActivity.newInstance(meal);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, new Pair(ivMealImage, getString(R.string.share_image_transition)));
       ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
    }
}

