package com.SIT.jichen.myapplication.algorithm.graph;

import android.app.Activity;

import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.visualization.WeightedGraphVisualizer;

public class DijkstraAgorithm extends Algorithm implements DataHandler {

    private WeightedGraph graph;

    private WeightedGraphVisualizer visualizer;

    public DijkstraAgorithm(WeightedGraphVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void onDataRecieved(Object data) {
        this.graph = (WeightedGraph) data;
    }

    private void dijkstra(WeightedGraph G, int s) {

        final int[] dist = new int[G.size()];
        final int[] pred = new int[G.size()];
        final boolean[] visited = new boolean[G.size()];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        sleep();

        for (int i = 0; i < dist.length; i++) {
            final int next = minVertex(dist, visited);
            visited[next] = true;

            final int[] n = G.neighbors(next);
            for (int j = 0; j < n.length; j++) {
                final int v = n[j];
                highlightNode(v);
                highlightLine(next, v);
                sleep();
                final int d = dist[next] + G.getWeight(next, v);
                if (dist[v] > d) {
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }

        completed();
    }

    private static int minVertex(int[] dist, boolean[] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!v[i] && dist[i] < x) {
                y = i;
                x = dist[i];
            }
        }
        return y;
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
            dijkstra(graph, 0);
        }
    }

    public void setData(final WeightedGraph g) {
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
