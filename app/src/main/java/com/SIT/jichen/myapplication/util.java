package com.SIT.jichen.myapplication;

import android.content.Context;

import com.SIT.jichen.myapplication.algorithm.graph.Digraph;
import com.SIT.jichen.myapplication.algorithm.graph.WeightedGraph;
import com.SIT.jichen.myapplication.algorithm.graph.WeightedGraph2;
import com.SIT.jichen.myapplication.algorithm.list.myLinkedList;
import com.SIT.jichen.myapplication.algorithm.list.Stack;
import com.SIT.jichen.myapplication.algorithm.tree.BinarySearchTree;
import com.SIT.jichen.myapplication.constants.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class util {

    public static final boolean algoExist(String algoName) {
        for(String[] algos : MainActivity.allTopics.values())
            for(String algo : algos)
                if(algo.equals(algoName) && !algo.equals(Constants.MORE_IS_COMING))
                    return true;

        return false;
    }

    public static final int[] target_array = {4};

    public static final int[] bst_array = {3, 2, 5, 1, 4, 6};

    public static final int[][] bst = {
            {3, 2, 5, 1, 4, 6}, //nodes
            {2, 1, 4, -1, -1, -1}, //left child of nodes
            {5, -1, 6, -1, -1, -1} //right child of nodes
    };


    public static int[] createRandomArray(int size) {

        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = 0; i < size; i++)
            integers.add(i+1);

        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            int index = new Random().nextInt(integers.size());
            res[i] = integers.get(index);
            integers.remove(index);
        }
        return res;
    }

    public static int[] createUniqueRandomArray(int size) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            a.add(i);
        }
        Collections.shuffle(a);

        int[] intArray = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            intArray[i] = a.get(i);
        }
        return intArray;
    }

    public static BinarySearchTree createBinaryTree() {
        BinarySearchTree b = new BinarySearchTree();
        for (int i = 0; i < bst_array.length; i++) {
            b.insert(bst_array[i]);
        }
        return b;

    }

    public static myLinkedList createLinkedList() {
        myLinkedList ll = new myLinkedList();
        for (int i = 0; i < Constants.NUM_NODES_IN_LINKEDLIST; i++) {
            ll.add(i + 1);
        }
        return ll;

    }

    public static Stack createStack() {
        Stack stack = new Stack(8);
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= Constants.NUM_NODES_IN_STACK; i++) {
            a.add(i);
        }

        for (int i = 0; i < a.size(); i++) {
            stack.push(a.get(i));
        }
        return stack;

    }

    public static Digraph createDirectedGraph() {
        Digraph graph = new Digraph();
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(2, 6);

        double[][] array = {
                {0, 2, 6, 5, 1, 4, 3}, //nodes
                {1, 5, -1, -1, 3, -1, -1},//left child
                {2, 6, -1, -1, 4, -1, -1}, //right child
                {0, 1.5, 2.5, 0.5, 1.5, 0.5, 2.5}, //number of left/right nodes from root in horizontal
                {0, 1, 2, 2, 1, 2, 2}, //number of left/right nodes from root in vertical
                {-1, 0, 0, 0, 1, 1, 1} //is the node left of the root?
        };
        graph.setDirectedArray(array);
        return graph;
    }

    public static WeightedGraph2 createWeightedGraph2() {
        int vertex = Constants.NUM_VERTEX_IN_GRAPH;
        int E = 8;

        WeightedGraph2 graph = new WeightedGraph2(vertex, E);

        switch (new Random().nextInt(3)) {
            case 0:
                graph.addEdge(0, 0, 1, 1);
                graph.addEdge(1, 0, 2, 4);
                graph.addEdge(2, 1, 2, 7);
                graph.addEdge(3, 1, 3, 9);
                graph.addEdge(4, 1, 4, 2);
                graph.addEdge(5, 3, 2, 15);
                graph.addEdge(6, 0, 4, 4);
                graph.addEdge(7, 4, 3, 3);
                break;
            case 1:
                graph.addEdge(0, 0, 3, 1);
                graph.addEdge(1, 0, 2, 4);
                graph.addEdge(2, 1, 3, 9);
                graph.addEdge(3, 1, 2, 2);
                graph.addEdge(4, 1, 4, 7);
                graph.addEdge(5, 2, 3, 5);
                graph.addEdge(6, 3, 4, 12);
                graph.addEdge(7, 4, 2, 3);
                break;
            case 2:
                graph.addEdge(0, 4, 3, 1);
                graph.addEdge(1, 4, 0, 4);
                graph.addEdge(2, 0, 3, 8);
                graph.addEdge(3, 0, 1, 2);
                graph.addEdge(4, 0, 2, 14);
                graph.addEdge(5, 2, 1, 5);
                graph.addEdge(6, 2, 4, 6);
                graph.addEdge(7, 1, 3, 3);
                break;
            case 3:
                graph.addEdge(0, 0, 1, 1);
                graph.addEdge(1, 0, 3, 4);
                graph.addEdge(2, 0, 4, 7);
                graph.addEdge(3, 4, 3, 8);
                graph.addEdge(4, 3, 2, 2);
                graph.addEdge(5, 4, 2, 9);
                graph.addEdge(6, 1, 4, 3);
                graph.addEdge(7, 2, 1, 2);
                break;
        }


        return graph;

    }

    public static WeightedGraph createWeightedGraph() {
        WeightedGraph graph = new WeightedGraph(Constants.NUM_VERTEX_IN_GRAPH);
        graph.setLabel(0, 0);
        graph.setLabel(1, 1);
        graph.setLabel(2, 2);
        graph.setLabel(3, 3);
        graph.setLabel(4, 4);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 9);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 3, 1);
        graph.addEdge(4, 3, 3);
        graph.addEdge(4, 2, 7);
        graph.addEdge(3, 4, 3);

        return graph;
    }


    public static int[] createArray(int size, boolean sorted) {
        int[] integers = new int[size];
        for (int i = 0; i < size; i++) {
            integers[i] = new Random().nextInt(88) + 10;
        }
        if (sorted)
            Arrays.sort(integers);
        return integers;
    }

    public static int[][] createNQueenArray(int n) {
        //all values will be initialised to zero
        return new int[n][n];

    }

    public static int getRandomKeyFromBST() {
        int rnd = new Random().nextInt(bst_array.length);
        return bst_array[rnd];
    }

    public static int getRandomInt(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public static int getRandomUniqueInt(int range, int[] array) {
        Random random = new Random();
        int number = random.nextInt(range) + array.length;
        return number;
    }

    public static String readDescJson(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("desc.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

