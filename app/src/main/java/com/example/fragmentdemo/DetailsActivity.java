package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            this.finish();
        }


        if (savedInstanceState == null) {
//            Intent intent = new Intent(this, DetailsFragment.class);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                    , new DetailsFragment()).commit();
//            startActivity(intent);
        }
    }
}