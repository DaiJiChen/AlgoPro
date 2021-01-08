package com.SIT.jichen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class UnitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        this.getSupportActionBar().hide();

        Intent intent = getIntent();
        String unitName = intent.getStringExtra(Constants.UNIT_NAME);
        String[] algoNames = MainActivity.allTopics.get(unitName);


        ArrayList<String> algoArray = new ArrayList<>();
        for(String algo : algoNames)
            algoArray.add(algo);

        AlgoItemAdapter algoItemAdapter = new AlgoItemAdapter(this, algoArray);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(algoItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("algo item clicked", algoNames[i]);

                Intent intent = new Intent(getApplicationContext(), AlgoActivity.class);
                intent.putExtra(Constants.ALGO_NAME, algoNames[i]);
                startActivity(intent);
            }
        });
    }
}