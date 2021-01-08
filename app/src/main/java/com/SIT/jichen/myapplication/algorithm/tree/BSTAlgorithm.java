package com.SIT.jichen.myapplication.algorithm.tree;

import android.app.Activity;

import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.util;
import com.SIT.jichen.myapplication.visualization.ArrayVisualizer;
import com.SIT.jichen.myapplication.visualization.BSTVisualizer;

public class BSTAlgorithm extends Algorithm implements DataHandler {

    public static final String START_BST_SEARCH = "start_bst_search";
    public static final String START_BST_INSERT = "start_bst_insert";

    private BSTVisualizer visualizer;
    private ArrayVisualizer arrayVisualizer;
    public BinarySearchTree b;

    public BSTAlgorithm(BSTVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void run() {
        super.run();
    }

    private void startBSTSearch() {
        int id = util.getRandomKeyFromBST();
        BinarySearchTree.Node current = b.getRoot();
        highlightNode(current.data);
        sleep();
        while (current != null) {
            if (current.data == id) {
                completed();
                break;
            } else if (current.data > id) {
                highlightLine(current.data, current.left.data);
                current = current.left;
                highlightNode(current.data);
                sleep();
            } else {
                highlightLine(current.data, current.right.data);
                current = current.right;
                highlightNode(current.data);
                sleep();
            }
        }

    }

    private void startBSTInsert() {
        int[] array = util.bst_array;
        BinarySearchTree tree = new BinarySearchTree();
        removeAllNodes();
        sleepFor(800);

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
            addNode(array[i]);
            highlightNode(array[i]);
            sleepFor(800);
        }

        highlightNode(-1);
        completed();
    }

    @Override
    public void onDataRecieved(Object data) {
        this.b = (BinarySearchTree) data;
    }

    @Override
    public void onMessageReceived(String message) {
        if (message.equals(START_BST_SEARCH)) {
            startExecution();
            startBSTSearch();
        } else if (message.equals(START_BST_INSERT)) {
            startExecution();
            startBSTInsert();
        }
    }

    public void setData(final BinarySearchTree b) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(b);
                if (arrayVisualizer!=null) {
                    arrayVisualizer.setData(util.bst_array);
                }
            }
        });
        start();
        prepareHandler(this);
        sendData(b);
    }

    private void highlightNode(final int node) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightNode(node);
                if (arrayVisualizer!=null) {
                    arrayVisualizer.highlightValue(node);
                }
            }
        });
    }

    private void highlightLine(final int start, final int end) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightLine(start, end);
            }
        });
    }

    private void removeAllNodes() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.removeAllNodes();
            }
        });
    }

    private void addNode(final int n) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.addNode(n);
            }
        });
    }


    public void setArrayVisualizer(ArrayVisualizer arrayVisualizer) {
        this.arrayVisualizer = arrayVisualizer;
    }
}
