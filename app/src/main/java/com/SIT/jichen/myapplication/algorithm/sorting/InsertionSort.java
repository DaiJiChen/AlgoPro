package com.SIT.jichen.myapplication.algorithm.sorting;

import android.app.Activity;

import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.visualization.SortingVisualizer;

public class InsertionSort extends SortAlgorithm {

    int[] array;

    public InsertionSort(SortingVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void run() {
        super.run();
    }

    private void sort() {

        int n = array.length;
        for (int j = 1; j < n; j++) {
            highlightFound(j);
            sleep();
            int key = array[j];
            int i = j-1;
            while (i >= 0 && array[i] > key) {
                highlightTrace(i);
                sleep();

                highlightSwap(i, i + 1);
                sleep();
                array [i+1] = array [i];
                highlightSwap(i, i + 1);
                sleep();
                i--;
            }
            array[i+1] = key;
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
