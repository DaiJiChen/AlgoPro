package com.SIT.jichen.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AlgoItemAdapter extends ArrayAdapter<String> {
    public AlgoItemAdapter(Context context, ArrayList<String> algos) {
        super(context,0, algos);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String algoItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.algo_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.algoName);
        Log.i("Adapter name", algoItem);
        name.setText(algoItem);

        return convertView;
    }
}
