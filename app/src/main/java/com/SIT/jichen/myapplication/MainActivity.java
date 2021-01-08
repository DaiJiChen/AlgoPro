package com.SIT.jichen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, String[]> allTopics = new HashMap<>();

    public void addAllTopics() {
        String[] SearchAlgos = {Constants.LINEAR_SEARCH, Constants.BINARY_SEARCH};
        String[] TreeAlgos = {Constants.BST_INSERT, Constants.BST_SEARCH};
        String[] ListAlgos = {Constants.LINKED_LIST, Constants.STACK, Constants.QUEUE};
        String[] SortingAlgos = {Constants.BUBBLE_SORT, Constants.SELECTION_SORT, Constants.INSERTION_SORT, Constants.QUICK_SORT};
        String[] HashMapAlgos = {"A", "B"};
        String[] GraphAlgos = {Constants.BFS, Constants.DFS, Constants.DIJKSTRA};

        allTopics.put(Constants.SEARCH, SearchAlgos);
        allTopics.put(Constants.TREE, TreeAlgos);
        allTopics.put(Constants.LIST, ListAlgos);
        allTopics.put(Constants.SORTING, SortingAlgos);
        allTopics.put(Constants.HASHMAP, HashMapAlgos);
        allTopics.put(Constants.GRAPH, GraphAlgos);
    }

    public void cardOnClick(View view) {
        TextView cardName = (TextView) view;
        if(cardName.getText().equals(Constants.SEARCH)) {
            Log.i("Card Clicked", Constants.SEARCH);

            Intent intent = new Intent(this, UnitActivity.class);
            intent.putExtra(Constants.UNIT_NAME, Constants.SEARCH);
            startActivity(intent);
        }
        else if(cardName.getText().equals(Constants.TREE)) {
            Log.i("Card Clicked", Constants.TREE);

            Intent intent = new Intent(this, UnitActivity.class);
            intent.putExtra(Constants.UNIT_NAME, Constants.TREE);
            startActivity(intent);
        }
        else if(cardName.getText().equals(Constants.LIST)) {
            Log.i("Card Clicked", Constants.LIST);

            Intent intent = new Intent(this, UnitActivity.class);
            intent.putExtra(Constants.UNIT_NAME, Constants.LIST);
            startActivity(intent);
        }
        else if(cardName.getText().equals(Constants.SORTING)) {
            Log.i("Card Clicked", Constants.SORTING);

            Intent intent = new Intent(this, UnitActivity.class);
            intent.putExtra(Constants.UNIT_NAME, Constants.SORTING);
            startActivity(intent);
        }
        else if(cardName.getText().equals(Constants.HASHMAP)) {
            Log.i("Card Clicked", Constants.HASHMAP);

            Intent intent = new Intent(this, UnitActivity.class);
            intent.putExtra(Constants.UNIT_NAME, Constants.HASHMAP);
            startActivity(intent);
        }
        else if(cardName.getText().equals(Constants.GRAPH)) {
            Log.i("Card Clicked", Constants.GRAPH);

            Intent intent = new Intent(this, UnitActivity.class);
            intent.putExtra(Constants.UNIT_NAME, Constants.GRAPH);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Unknown unit", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().hide();

        addAllTopics();
    }
}