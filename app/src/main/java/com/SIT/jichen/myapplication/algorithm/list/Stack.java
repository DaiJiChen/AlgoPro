package com.SIT.jichen.myapplication.algorithm.list;

import android.app.Activity;

import com.SIT.jichen.myapplication.util;
import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.visualization.StackVisualizer;


public class Stack extends Algorithm implements DataHandler {

    public static final String PUSH = "push";
    public static final String POP = "pop";
    public static final String PEEK = "peek";

    private StackVisualizer visualizer;
    private Stack stack;

    public int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public Stack(int s, StackVisualizer visualizer, Activity activity) {
        this(s);
        this.visualizer = visualizer;
        this.activity = activity;
    }


    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int[] getStackArray() {
        return stackArray;
    }


    private void visualizePush(int data) {
        if (stack.top == stack.maxSize - 1) {
            return;
        }
        stack.stackArray[++stack.top] = data;
        updateData(stack);
        highlightNode(data);
        sleep();
        highlightNode(-1);
    }

    private void visualizePeek() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.stackArray[stack.top];
        updateData(stack);
        highlightNode(top);
        sleep();
        highlightNode(-1);
    }

    private void visualizePop() {
        if (stack.isEmpty()) {
            return;
        }
        int pop = stack.pop();
        int top = stack.top;
        stack.stackArray[top + 1] = 0;
        highlightNode(pop);
        sleep();
        updateData(stack);
        highlightNode(-1);
    }

    private void highlightNode(final int node) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.highlightNode(node);
            }
        });
    }

    @Override
    public void onMessageReceived(String message) {
        switch (message) {
            case PEEK:
                visualizePeek();
                break;
            case PUSH:
                visualizePush(util.getRandomInt(50) + 15);
                break;
            case POP:
                visualizePop();
                break;
        }
    }

    @Override
    public void onDataRecieved(Object data) {
        this.stack = (Stack) data;
    }

    public void setData(final Stack stack) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(stack);
            }
        });
        start();
        prepareHandler(this);
        sendData(stack);
    }

    private void updateData(final Stack stack) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(stack);
            }
        });

    }
}