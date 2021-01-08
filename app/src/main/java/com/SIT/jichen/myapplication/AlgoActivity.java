package com.SIT.jichen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class AlgoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo);

        this.getSupportActionBar().hide();

        Intent intent = getIntent();
        String algoName = intent.getStringExtra(Constants.ALGO_NAME);

        // create a fragment
        AlgoFragment algoFragment = AlgoFragment.getInstance(algoName);
        Log.i("Created fragment", algoName);

        // use the FragmentManager to create a Fragment Transaction which allows us to add fragments to FrameLayout at runtime.
        getSupportFragmentManager().beginTransaction().replace(R.id.container, algoFragment).commit();
    }
}