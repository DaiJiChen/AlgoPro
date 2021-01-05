package com.SIT.jichen.myapplication.algorithm.sorting;

import android.app.Activity;

import com.SIT.jichen.myapplication.Constants;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.visualization.SortingVisualizer;

public class BubbleSort extends SortAlgorithm implements DataHandler {

    int[] array;

    public BubbleSort(SortingVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void run() {
        super.run();
    }

    private void sort() {
        logArray("Original array - " ,array);

        for (int i = 0; i < array.length; i++) {
            addLog("Doing iteration - " + i);
            boolean swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                highlightTrace(j);
                sleep();
                if (array[j] > array[j + 1]) {
                    highlightSwap(j, j + 1);
                    addLog("Swapping " + array[j] + " and " + array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    sleep();
                }
            }
            if (!swapped) {
                break;
            }
            sleep();
        }
        addLog("Array has been sorted");
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
