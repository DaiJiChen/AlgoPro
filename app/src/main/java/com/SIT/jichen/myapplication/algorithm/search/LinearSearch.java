package com.SIT.jichen.myapplication.algorithm.search;

import android.app.Activity;

import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.visualization.SearchVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LinearSearch extends Algorithm implements DataHandler {

    private SearchVisualizer visualizer;
    private int[] array;

    private List<Integer> positions = new ArrayList<>();

    public LinearSearch(SearchVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    public void setData(final int[] array) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(array);
            }
        });
        start();
        prepareHandler(this);
        sendData(array);
    }

    private void search() {

        int targetPos = new Random().nextInt(array.length);

        int n = array.length ;

        for (int i = 0 ; i<n ; i++) {
            highlight(0, i-1);
            highlightTarget(targetPos);
            highlightTrace(i);
            if (i == targetPos){
                break;
            }
            sleep();

        }

        completed();
    }

    private void highlight(int minIndex, int maxIndex) {
        positions.clear();
        for (int i = minIndex; i <= maxIndex; i++) {
            positions.add(i);
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlight(positions);
            }
        });
    }

    private void highlightTrace(final int pos) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightTrace(pos);
            }
        });
    }

    private void highlightTarget(final int pos) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightTarget(pos);
            }
        });
    }

    @Override
    public void onMessageReceived(String message) {
        if (message.equals(Constants.COMMAND_START_ALGORITHM)) {
            startExecution();
            search();
        }
    }

    @Override
    public void onDataRecieved(Object data) {
        this.array = (int[]) data;
    }
}