package com.example.sapeu.learnfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
//    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("PlaceholderFragment执行onCreate");
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    /*public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        rootView.findViewById(R.id.show_another_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,new AnotherFragment())
                        .commit();
            }
        });
        rootView.findViewById(R.id.show_slider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SliderActivity.class));
            }
        });
        rootView.findViewById(R.id.show_tabbed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),TabbedActivity.class));
            }
        });
        System.out.println("PlaceholderFragment执行onCreateView");
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("PlaceholderFragment执行onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("PlaceholderFragment执行onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("PlaceholderFragment执行onDestroyView");
    }
}
