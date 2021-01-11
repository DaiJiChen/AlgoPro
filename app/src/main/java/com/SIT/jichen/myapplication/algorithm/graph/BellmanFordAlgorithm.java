package com.SIT.jichen.myapplication.algorithm.graph;

import android.app.Activity;

import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.visualization.WeightedGraphVisualizer2;

public class BellmanFordAlgorithm extends Algorithm implements DataHandler {

    private WeightedGraph2 graph;

    private WeightedGraphVisualizer2 visualizer;

    public BellmanFordAlgorithm(WeightedGraphVisualizer2 visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    @Override
    public void onDataRecieved(Object data) {
        this.graph = (WeightedGraph2) data;
    }

    private void bellmanford(WeightedGraph2 graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;
        sleep();

        for (int i = 1; i < V; ++i) {
            sleep();

            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                highlightNode1(u);
                highlightNode2(v);
                highlightLine(u, v);
                sleep();
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        completed();
    }

    @Override
    public void onMessageReceived(String message) {
        if (message.equals(Constants.COMMAND_START_ALGORITHM)) {
            startExecution();
            bellmanford(graph, 0);
        }
    }

    private void highlightNode1(final int node) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightNode1(node);
            }
        });
    }

    private void highlightNode2(final int node) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightNode2(node);
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

    public void setData(final WeightedGraph2 g) {
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

