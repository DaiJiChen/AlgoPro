package com.SIT.jichen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Intent intent = getIntent();
        String unitName = intent.getStringExtra("UnitName");
        String[] algosName = MainActivity.allTopics.get(unitName);


        ArrayList<String> algoArray = new ArrayList<>();
        for(String algo : algosName)
            algoArray.add(algo);

        AlgoItemAdapter algoItemAdapter = new AlgoItemAdapter(this, algoArray);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(algoItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("algo item clicked", algosName[i]);

                Intent intent = new Intent(getApplicationContext(), AlgoActivity.class);
                intent.putExtra("AlgoName", algosName[i]);
                startActivity(intent);
            }
        });
    }
}