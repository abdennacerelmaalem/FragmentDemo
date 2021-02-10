package com.example.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentSelection extends ListFragment {

    private static final String LAST_SELECTED = "lastSelected";
    boolean TwoColumnMod;
    int lastChoise = 0;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> seasonsList = new ArrayList<>();
        seasonsList.add(String.valueOf(R.string.Spring));
        seasonsList.add(String.valueOf(R.string.Summer));
        seasonsList.add(String.valueOf(R.string.Autumn));
        seasonsList.add(String.valueOf(R.string.Winter));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext()
                , R.layout.activity_details_fragment, seasonsList);
        setListAdapter(adapter);

        View detailsFrame = getActivity().findViewById(R.id.details);
        if (savedInstanceState != null) {
            lastChoise = savedInstanceState.getInt(LAST_SELECTED, 0);
        }

        TwoColumnMod = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (TwoColumnMod) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(lastChoise);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetails(position);
    }

    void showDetails(int index) {

        if (TwoColumnMod) {
            getListView().setItemChecked(index, true);
            DetailsFragment details = (DetailsFragment) getFragmentManager()
                    .findFragmentById(R.id.details);

            if (details == null || details.getIndex() != index) {
                details = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            Intent intent = new Intent(getActivity().getApplicationContext(), DetailsActivity.class);
            startActivity(intent);
        }
    }
}