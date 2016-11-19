package com.sapeu.android.draganddraw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sapeu on 2016/11/20.
 */

public class DragAndDrawFragment extends Fragment {

    public static DragAndDrawFragment newInstance() {

//        Bundle args = new Bundle();

        DragAndDrawFragment fragment = new DragAndDrawFragment();
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.fragment_drag_and_draw,container,false);
        return v;
    }
}
