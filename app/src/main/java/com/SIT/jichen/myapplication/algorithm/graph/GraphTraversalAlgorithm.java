package com.SIT.jichen.myapplication.algorithm.graph;

import android.app.Activity;

import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.visualization.DirectedGraphVisualizer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversalAlgorithm extends Algorithm implements DataHandler {

    public static final String TRAVERSE_BFS = "traverse_bfs";
    public static final String TRAVERSE_DFS = "traverse_dfs";

    private Digraph graph;

    private DirectedGraphVisualizer visualizer;

    public GraphTraversalAlgorithm(DirectedGraphVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void onDataRecieved(Object data) {
        this.graph = (Digraph) data;
    }

    private void bfs(int source) {

        Queue<Integer> queue = new LinkedList<Integer>();

        int numberOfNodes = graph.size();
        int[] visited = new int[numberOfNodes + 1];

        int i, element;

        highlightNode(source);
        visited[source] = 1;
        queue.add(source);
        sleep();

        while (!queue.isEmpty()) {
            element = queue.remove();
            i = element;
            while (i <= numberOfNodes) {
                if (graph.edgeExists(element, i) && visited[i] == 0) {
                    highlightNode(i);
                    highlightLine(element, i);
                    queue.add(i);
                    visited[i] = 1;
                    sleep();
                }
                i++;
            }
        }
        completed();

    }

    private void dfs(int source) {

        Stack<Integer> stack = new Stack<>();

        int numberOfNodes = graph.size();

        int visited[] = new int[numberOfNodes + 1];
        int element = source;
        int i = source;
        highlightNode(source);
        visited[source] = 1;
        stack.push(source);
        sleep();

        while (!stack.isEmpty()) {
            element = stack.peek();
            i = element;
            while (i <= numberOfNodes) {
                if (graph.edgeExists(element, i) && visited[i] == 0) {
                    highlightNode(i);
                    highlightLine(element, i);
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    sleep();
                    continue;
                }
                i++;
            }
            stack.pop();
        }
        completed();

    }


    private void highlightNode(final int node) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightNode(node);
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

    @Override
    public void onMessageReceived(String message) {
        if (message.equals(Constants.COMMAND_START_ALGORITHM)) {
            startExecution();
        }
        else if (message.equals(TRAVERSE_BFS)) {
            startExecution();
            bfs(graph.getRoot());
        } else if (message.endsWith(TRAVERSE_DFS)) {
            startExecution();
            dfs(graph.getRoot());
        }
    }

    public void setData(final Digraph g) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(g);
            }
        });
        start();
        prepareHandler(this);
        sendData(g);
    }
}
