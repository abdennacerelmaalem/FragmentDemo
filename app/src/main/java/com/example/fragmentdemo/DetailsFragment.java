package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index) {
        DetailsFragment f = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("INDEX", index);
        f.setArguments(args);
        return f;
    }

    int getIndex() {

        return this.getArguments().getInt("INDEX");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(getActivity().getApplicationContext());
        TextView textView = new TextView(getActivity().getApplicationContext());
        scrollView.addView(textView);


        switch (this.getIndex()) {
            case 1: textView.setText(R.string.Spring);
            case 2: textView.setText(R.string.Summer);
            case 3: textView.setText(R.string.Autumn);
            case 4: textView.setText(R.string.Winter);
        }


        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.activity_details_fragment, container, false);
        return  scrollView;

    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_fragment);

    }*/
}