package com.SIT.jichen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, String[]> allTopics = new HashMap<>();

    public void addAllTopics() {
        String[] SearchAlgos = {"Brute Force", "Two Pointer Technique"};
        String[] TreeAlgos = {"BFS", "DFS"};
        String[] StackAndQueueAlgos = {"queue", "stack"};
        String[] SortingAlgos = {"Bubble Sort", "Selection Sort"};
        String[] HashMapAlgos = {"A", "B"};
        String[] GraphAlgos = {"BFS", "DFS", "Dijkstra's Algorithm"};

        allTopics.put("Search", SearchAlgos);
        allTopics.put("Tree", TreeAlgos);
        allTopics.put("StackAndQueue", StackAndQueueAlgos);
        allTopics.put("Sorting", SortingAlgos);
        allTopics.put("HashMap", HashMapAlgos);
        allTopics.put("Graph", GraphAlgos);
    }

    public void cardOnClick(View view) {
        TextView cardName = (TextView) view;
        if(cardName.getText().equals("Search")) {
            Log.i("Card Clicked", "Search");

            Intent intent = new Intent(this, OverviewActivity.class);
            intent.putExtra("UnitName", "Search");
            startActivity(intent);
        }
        else if(cardName.getText().equals("Tree")) {
            Log.i("Card Clicked", "Tree");

            Intent intent = new Intent(this, OverviewActivity.class);
            intent.putExtra("UnitName", "Tree");
            startActivity(intent);
        }
        else if(cardName.getText().equals("Stack\nand\nQueue")) {
            Log.i("Card Clicked", "Stack and Queue");

            Intent intent = new Intent(this, OverviewActivity.class);
            intent.putExtra("UnitName", "Stack and Queue");
            startActivity(intent);
        }
        else if(cardName.getText().equals("Sorting")) {
            Log.i("Card Clicked", "Sorting");

            Intent intent = new Intent(this, OverviewActivity.class);
            intent.putExtra("UnitName", "Sorting");
            startActivity(intent);
        }
        else if(cardName.getText().equals("HashMap")) {
            Log.i("Card Clicked", "HashMap");

            Intent intent = new Intent(this, OverviewActivity.class);
            intent.putExtra("UnitName", "HashMap");
            startActivity(intent);
        }
        else if(cardName.getText().equals("Graph")) {
            Log.i("Card Clicked", "Graph");

            Intent intent = new Intent(this, OverviewActivity.class);
            intent.putExtra("UnitName", "Graph");
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAllTopics();
    }
}