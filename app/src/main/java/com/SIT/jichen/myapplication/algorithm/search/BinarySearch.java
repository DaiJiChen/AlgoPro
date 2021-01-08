package com.SIT.jichen.myapplication.algorithm.search;

import android.app.Activity;

import com.SIT.jichen.myapplication.Constants;
import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.visualization.BinarySearchVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearch extends Algorithm implements DataHandler {

    private BinarySearchVisualizer visualizer;
    private int[] array;

    private List<Integer> positions = new ArrayList<>();

    public BinarySearch(BinarySearchVisualizer visualizer, Activity activity) {
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
        int rnd = new Random().nextInt(array.length);
        int data = array[rnd];

        int low = 0;
        int high = array.length - 1;

        highlight(low, high);
        highlightTrace((int) (low + high) / 2);
        sleep();

        while (high >= low) {

            int middle = (int) (low + high) / 2;
            highlightTrace(middle);
            sleep();

            if (array[middle] == data) {
                break;
            }
            if (array[middle] < data) {
                low = middle + 1;
                highlight(low, high);
                sleep();
            }
            if (array[middle] > data) {
                high = middle - 1;
                highlight(low, high);
                sleepFor(800);
            }
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
