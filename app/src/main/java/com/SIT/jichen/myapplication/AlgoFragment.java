package com.SIT.jichen.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
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
    FloatingActionButton fab;
    AppBarLayout appBarLayout;

    LogFragment logFragment;
    CodeFragment codeFragment;
    AlgoDescriptionFragment algoFragment;
    ViewPager viewPager;

    Algorithm algorithm;

    String startCommand = Algorithm.COMMAND_START_ALGORITHM;

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

        appBarLayout = (AppBarLayout) rootView.findViewById(R.id.app_bar);


        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);

        logFragment = LogFragment.newInstance();
        codeFragment = CodeFragment.newInstance(getArguments().getString(Algorithm.KEY_ALGORITHM));
        algoFragment = AlgoDescriptionFragment.newInstance(getArguments().getString(Algorithm.KEY_ALGORITHM));

        setupFragment(getArguments().getString(Constants.ALGORITHM_KEY));

        return rootView;
    }
}
