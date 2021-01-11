package com.SIT.jichen.myapplication.algorithm.tree;

import android.app.Activity;

import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.util;
import com.SIT.jichen.myapplication.visualization.ArrayVisualizer;
import com.SIT.jichen.myapplication.visualization.BSTVisualizer;

public class BSTAlgorithm extends Algorithm implements DataHandler {

    public static final String START_BST_SEARCH = "start_bst_search";
    public static final String START_BST_INSERT = "start_bst_insert";

    public static void do_search(boolean doSearch) {
        BSTAlgorithm.doSearch = doSearch;
    }

    private static boolean doSearch = false;

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
        int targetId = 4;
        visualizer.setSearchTarget(targetId);
        BinarySearchTree.Node current = b.getRoot();
        highlightNode(current.data);
        sleep();
        while (current != null) {
            if (current.data == targetId) {
                sleep();
                completed();
                break;
            } else if (current.data > targetId) {
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
        sleep();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
            addNode(array[i]);
            highlightNode(array[i]);
            sleep();
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
        if (message.equals(Constants.COMMAND_START_ALGORITHM)) {
            startExecution();
            if (doSearch) {
                startBSTSearch();
            } else {
                startBSTInsert();
            }
        }
    }

    public void setData(final BinarySearchTree b) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(b);
                if (arrayVisualizer!=null) {
                    if(doSearch)
                        arrayVisualizer.setData(util.target_array);
                    else
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
