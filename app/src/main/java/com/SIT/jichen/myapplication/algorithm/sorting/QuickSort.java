package com.SIT.jichen.myapplication.algorithm.sorting;

import android.app.Activity;

import com.SIT.jichen.myapplication.Constants;
import com.SIT.jichen.myapplication.visualization.SortingVisualizer;

public class QuickSort extends SortAlgorithm {

    private int[] array;

    public QuickSort(SortingVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void run() {
        super.run();
    }

    private void sort() {
        if (array == null || array.length == 0) {
            return;
        }
        int length = array.length;
        quickSort(0, length - 1);
        completed();
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        sleepFor(1000);
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        highlightTrace(pivot);

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                highlightSwap(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
