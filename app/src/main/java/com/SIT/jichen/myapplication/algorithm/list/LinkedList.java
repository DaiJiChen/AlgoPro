package com.SIT.jichen.myapplication.algorithm.list;

import android.app.Activity;

import com.SIT.jichen.myapplication.constants.Constants;
import com.SIT.jichen.myapplication.algorithm.Algorithm;
import com.SIT.jichen.myapplication.algorithm.DataHandler;
import com.SIT.jichen.myapplication.util;
import com.SIT.jichen.myapplication.visualization.LinkedListVisualizer;


public class LinkedList extends Algorithm implements DataHandler {

    public static final String ADD = "add";
    public static final String ADD_AFTER = "add_after";
    public static final String DELETE_FRONT = "delete_front";
    public static final String DELETE_AFTER = "delete_after";
    public static final String TRAVERSE = "traverse";

    private LinkedListVisualizer visualizer;
    private LinkedList linkedList;

    private Node head;
    private Node tail;

    public LinkedList() {

    }

    public LinkedList(LinkedListVisualizer visualizer, Activity activity) {
        this.visualizer = visualizer;
        this.activity = activity;
    }

    //LinkedList implementation
    private class Node {

        private int value;
        private Node nextRef;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextRef() {
            return nextRef;
        }

        public void setNextRef(Node ref) {
            this.nextRef = ref;
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
            tmp = tmp.getNextRef();
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
            tmp = tmp.getNextRef();
            i++;
        }
        return array;
    }

    public void add(int element) {

        Node nd = new Node();
        nd.setValue(element);
        if (head == null) {
            head = nd;
            tail = nd;
        } else {
            tail.setNextRef(nd);
            tail = nd;
        }
        ;
    }

    public void addAfter(int element, int after) {

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
            tmp = tmp.getNextRef();
        }
        if (refNode != null) {
            Node nd = new Node();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if (tmp == tail) {
                tail = nd;
            }
            tmp.setNextRef(nd);

        } else {
            System.out.println("Unable to find the given element...");
        }
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
            tmp = tmp.getNextRef();
        }
        if (refNode != null) {
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if (refNode.getNextRef() == null) {
                tail = refNode;
            }
            System.out.println("Deleted: " + tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }


    //LinkedList visuzlizations
    public void visualizeAdd(int element) {

        Node nd = new Node();
        nd.setValue(element);
        sleep();
        if (linkedList.head == null) {
            linkedList.head = nd;
            linkedList.tail = nd;
        } else {
            linkedList.tail.setNextRef(nd);
            linkedList.tail = nd;
        }
        sleep();
        updateData(linkedList);
        highlightNode(element);
    }

    public void deleteFront() {

        if (linkedList.head == null) {
            return;
        }
        Node tmp = linkedList.head;
        sleep();
        highlightNode(tmp.getValue());
        sleep();
        linkedList.head = tmp.getNextRef();
        if (linkedList.head == null) {
            linkedList.tail = null;
        }
        sleep();
        updateData(linkedList);
    }


    public void traverse() {
        sleep();
        Node tmp = linkedList.head;
        highlightNode(tmp.getValue());
        while (true) {
            if (tmp == null) {
                break;
            }
            highlightNode(tmp.getValue());
            sleep();
            sleep();
            tmp = tmp.getNextRef();
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
            case ADD:
                visualizeAdd(util.getRandomInt(40)+5);
                break;
            case DELETE_FRONT:
                deleteFront();
                break;
        }
    }

    @Override
    public void onDataRecieved(Object data) {
        this.linkedList = (LinkedList) data;
    }

    public void setData(final LinkedList ll) {
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

    private void updateData(final LinkedList ll) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizer.setData(ll);
            }
        });

    }
}



