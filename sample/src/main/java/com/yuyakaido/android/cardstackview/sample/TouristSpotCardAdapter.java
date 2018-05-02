package com.yuyakaido.android.cardstackview.sample;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;


public class TouristSpotCardAdapter extends ArrayAdapter<TouristSpot> {

    public TouristSpotCardAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View contentView, @NonNull ViewGroup parent) {
        if (contentView == null) {
            FrameLayout layout = new FrameLayout(parent.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layout.setLayoutParams(params);
            int id = View.generateViewId();
            layout.setId(id);

            ((AppCompatActivity)parent.getContext())
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(id, CardViewFragment
                            .NewInstance(Color.BLUE, "front", "back"))
                    .addToBackStack(null)
                    .commit();
            return layout;
        } else {
            ((AppCompatActivity)parent.getContext())
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(contentView.getId(), CardViewFragment
                            .NewInstance(Color.BLUE, "front", "back"))
                    .addToBackStack(null)
                    .commit();
            return contentView;
        }
    }
}

