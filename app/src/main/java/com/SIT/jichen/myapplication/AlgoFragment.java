package com.SIT.jichen.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AlgoFragment extends Fragment {
    FloatingActionButton floatingActionButton;
    AppBarLayout appBarLayout;

    public static AlgoFragment getInstance(String algoName) {
        AlgoFragment algoFragment = new AlgoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ALGORITHM_KEY, algoName);
        algoFragment.setArguments(bundle);
        return algoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_algo, container, false);

        appBarLayout = (AppBarLayout) rootView.findViewById(R.id.appBarLayout);
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.floatingActionButton);

        return rootView;
    }
}
