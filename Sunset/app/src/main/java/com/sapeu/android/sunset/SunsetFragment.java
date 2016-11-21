package com.sapeu.android.sunset;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sapeu on 2016/11/22.
 */

public class SunsetFragment extends Fragment {

    private View mSunsetView;
    private View mSunView;
    private View mSkyView;

    public static SunsetFragment newInstance() {

        Bundle args = new Bundle();

        SunsetFragment fragment = new SunsetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunset,container,false);
        mSunsetView = view;
        mSunView = mSunsetView.findViewById(R.id.sun);
        mSkyView = mSunsetView.findViewById(R.id.sky);

        mSunsetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        return view;
    }

    private void startAnimation() {
        float sunYStart = mSunView.getTop();
        float sunYEnd = mSunView.getHeight();

        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(mSunView,"y",sunYStart,sunYEnd)
                .setDuration(3000);
        heightAnimator.start();
    }
}
