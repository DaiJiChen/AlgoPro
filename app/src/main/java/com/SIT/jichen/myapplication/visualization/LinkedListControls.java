package com.SIT.jichen.myapplication.visualization;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.SIT.jichen.myapplication.R;
import com.SIT.jichen.myapplication.algorithm.list.myLinkedList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LinkedListControls extends LinearLayout {

    myLinkedList myLinkedList;
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

    public void setMyLinkedList(myLinkedList algorithm) {
        this.myLinkedList = algorithm;
    }


    private void initialise() {
        setOrientation(VERTICAL);

        View controls = LayoutInflater.from(getContext()).inflate(R.layout.linked_list_controls, this, false);

        final Button addFront, addEnd, deleteFront, traverse;

        addFront = (Button) controls.findViewById(R.id.llc_add_front);
        addEnd = (Button) controls.findViewById(R.id.llc_add_end);
        deleteFront = (Button) controls.findViewById(R.id.llc_delete_front);
        traverse = (Button) controls.findViewById(R.id.llc_traverse);

        addFront.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myLinkedList.sendMessage(myLinkedList.ADD_FRONT);
            }
        });
        addEnd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myLinkedList.sendMessage(myLinkedList.ADD_END);
            }
        });
        deleteFront.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myLinkedList.sendMessage(myLinkedList.DELETE_FRONT);
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
