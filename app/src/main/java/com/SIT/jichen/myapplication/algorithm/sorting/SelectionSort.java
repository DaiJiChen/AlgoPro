package com.SIT.jichen.myapplication.algorithm.sorting;

import android.app.Activity;

import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.visualization.SortingVisualizer;

public class SelectionSort extends SortAlgorithm {

    int[] array;

    public SelectionSort(SortingVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void run() {
        super.run();
    }

    private void sort() {

        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            int temp = array[min_idx];
            array[min_idx] = array[i];
            highlightSwap(min_idx,i);
            array[i] = temp;
            sleep();
        }
        completed();
    }

    @Override
    public void onDataRecieved(Object data) {
        super.onDataRecieved(data);
        this.array = (int[]) data;
    }

    @Override
    public void onMessageReceived(String message) {
        super.onMessageReceived(message);
        if (message.equals(Constants.COMMAND_START_ALGORITHM)) {
            startExecution();
            sort();
        }
    }
}
