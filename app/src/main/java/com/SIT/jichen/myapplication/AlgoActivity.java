package com.SIT.jichen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AlgoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo);

        // create a fragment
        final AlgoFragment algoFragment = AlgoFragment.newInstance(Algorithm.BUBBLE_SORT);
        // use the FragmentManager to create a Fragment Transaction which allows us to add fragments to FrameLayout at runtime.
        getSupportFragmentManager().beginTransaction().replace(R.id.container, algoFragment).commit();
    }
}