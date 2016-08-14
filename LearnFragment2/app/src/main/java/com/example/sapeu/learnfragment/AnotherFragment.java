package com.example.sapeu.learnfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sapeu on 2016/8/14.
 */
public class AnotherFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("AnotherFragment执行onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_another,container,false);
        rootView.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        System.out.println("AnotherFragment执行onCreateView");
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("AnotherFragment执行onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("AnotherFragment执行onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("AnotherFragment执行onDestroyView");
    }
}
