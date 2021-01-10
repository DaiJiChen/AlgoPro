package com.SIT.jichen.myapplication.algorithm.list;

import android.app.Activity;

import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.util;
import com.SIT.jichen.myapplication.visualization.LinkedListVisualizer;


public class myLinkedList extends Algorithm implements DataHandler {

    public static final String ADD_FRONT = "_front";
    public static final String ADD_END = "add_end";
    public static final String DELETE_FRONT = "delete_front";
    public static final String DELETE_AFTER = "delete_after";
    public static final String TRAVERSE = "traverse";

    private LinkedListVisualizer visualizer;
    private myLinkedList myLinkedList;

    int currMax = Constants.NUM_NODES_IN_LINKEDLIST + 1;

    private Node head;
    private Node tail;

    public myLinkedList() {

    }

    public myLinkedList(LinkedListVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    //myLinkedList implementation
    private class Node {

        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public int size() {
        int size = 0;
        Node tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    public int[] getArray() {
        int[] array = new int[size()];
        int i = 0;
        Node tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }
            array[i] = tmp.getValue();
            tmp = tmp.getNext();
            i++;
        }
        return array;
    }

    public void add(int element) {

        Node node = new Node();
        node.setValue(element);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public void addAfter(int element) {

        Node node = new Node();
        node.setValue(element);
        if (myLinkedList.head == null) {
            myLinkedList.head = node;
            myLinkedList.tail = node;
        } else {
            myLinkedList.tail.setNext(node);
            myLinkedList.tail = node;
        }
        updateData(myLinkedList);
        highlightNode(element);
        sleep();
    }

    public void addFront(int element) {

        Node node = new Node();
        node.setValue(element);
        if (myLinkedList.head == null) {
            myLinkedList.head = node;
            myLinkedList.tail = node;
        } else {
            node.setNext(myLinkedList.head);
            myLinkedList.head = node;
        }
        updateData(myLinkedList);
        highlightNode(element);
        sleep();
    }


    public void deleteAfter(int after) {

        Node tmp = head;
        Node refNode = null;
        System.out.println("Traversing to all nodes..");

        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.getValue() == after) {
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        if (refNode != null) {
            tmp = refNode.getNext();
            refNode.setNext(tmp.getNext());
            if (refNode.getNext() == null) {
                tail = refNode;
            }
            System.out.println("Deleted: " + tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }



    public void deleteFront() {
        if (myLinkedList.head == null) {
            return;
        }
        Node tmp = myLinkedList.head;
        highlightNode(tmp.getValue());
        sleep();
        myLinkedList.head = tmp.getNext();
        if (myLinkedList.head == null) {
            myLinkedList.tail = null;
        }
        updateData(myLinkedList);
    }


    public void traverse() {
        Node tmp = myLinkedList.head;
        highlightNode(tmp.getValue());
        while (true) {
            if (tmp == null) {
                break;
            }
            highlightNode(tmp.getValue());
            sleep();
            tmp = tmp.getNext();
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

    @Override
    public void onMessageReceived(String message) {
        switch (message) {
            case Constants.COMMAND_START_ALGORITHM:
                //traverse command
                startExecution();
                traverse();
                break;
            case ADD_END:
                addAfter(currMax++);
                break;
            case ADD_FRONT:
                addFront(currMax++);
                break;
            case DELETE_FRONT:
                deleteFront();
                break;
        }
    }

    @Override
    public void onDataRecieved(Object data) {
        this.myLinkedList = (myLinkedList) data;
    }

    public void setData(final myLinkedList ll) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(ll);
            }
        });
        start();
        prepareHandler(this);
        sendData(ll);
    }

    private void updateData(final myLinkedList ll) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(ll);
            }
        });

    }
}



