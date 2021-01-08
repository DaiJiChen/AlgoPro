package com.SIT.jichen.myapplication.visualization;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.SIT.jichen.myapplication.R;
import com.SIT.jichen.myapplication.algorithm.list.LinkedList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LinkedListControls extends LinearLayout {

    LinkedList linkedList;
    FloatingActionButton fab;

    public LinkedListControls(Context context, FloatingActionButton fab) {
        super(context);
        this.fab = fab;
        initialise();
    }

    public LinkedListControls(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise();
    }

    public void setLinkedList(LinkedList algorithm) {
        this.linkedList = algorithm;
    }


    private void initialise() {
        setOrientation(VERTICAL);

        View controls = LayoutInflater.from(getContext()).inflate(R.layout.linked_list_controls, this, false);

        final Button add, deleteFront, traverse;

        add = (Button) controls.findViewById(R.id.llc_add);
        deleteFront = (Button) controls.findViewById(R.id.llc_delete_front);
        traverse = (Button) controls.findViewById(R.id.llc_traverse);

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedList.sendMessage(LinkedList.ADD);
            }
        });
        deleteFront.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedList.sendMessage(LinkedList.DELETE_FRONT);
            }
        });
        traverse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.performClick();
            }
        });


        addView(controls);
    }
}
