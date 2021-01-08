package com.SIT.jichen.myapplication;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.SIT.jichen.myapplication.algorithm.*;
import com.SIT.jichen.myapplication.visualization.*;
import com.SIT.jichen.myapplication.algorithm.sorting.*;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class AlgoFragment extends Fragment {
    FloatingActionButton floatingActionButton;
    AppBarLayout appBarLayout;
    CodeView codeView;


    Algorithm algorithm;

    String startCommand = Constants.COMMAND_START_ALGORITHM;

    public static AlgoFragment getInstance(String algoName) {
        AlgoFragment algoFragment = new AlgoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ALGO_NAME, algoName);
        algoFragment.setArguments(bundle);
        return algoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_algo, container, false);

        appBarLayout = (AppBarLayout) rootView.findViewById(R.id.appBarLayout);
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.floatingActionButton);
        codeView = (CodeView) rootView.findViewById(R.id.code_view);

        setupFragment(getArguments().getString(Constants.ALGO_NAME));

        return rootView;
    }

    public void setStartCommand(String startCommand) {
        this.startCommand = startCommand;
    }

    public void setupFragment(String algorithmKey) {
        setCode(algorithmKey);
        setCodeDesc(algorithmKey);

        assert algorithmKey != null;

        final AlgoVisualizer visualizer;

        floatingActionButton.setVisibility(View.VISIBLE);

        switch (algorithmKey) {
            case Constants.BINARY_SEARCH:
                visualizer = new BinarySearchVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new BinarySearch((BinarySearchVisualizer) visualizer, getActivity());
                ((BinarySearch) algorithm).setData(util.createArray(7, true));
                break;
            case Constants.LINEAR_SEARCH:
                visualizer = new BinarySearchVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new LinearSearch((BinarySearchVisualizer) visualizer, getActivity());
                ((LinearSearch) algorithm).setData(util.createArray(7, false));
                break;
            case Constants.BUBBLE_SORT:
                visualizer = new SortingVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new BubbleSort((SortingVisualizer) visualizer, getActivity());
                ((BubbleSort) algorithm).setData(util.createRandomArray(Constants.NUM_ITEM_IN_SORT));
                break;
            case Constants.INSERTION_SORT:
                visualizer = new SortingVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new InsertionSort((SortingVisualizer) visualizer, getActivity());
                ((InsertionSort) algorithm).setData(util.createRandomArray(Constants.NUM_ITEM_IN_SORT));
                break;
            case Constants.SELECTION_SORT:
                visualizer = new SortingVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new SelectionSort((SortingVisualizer) visualizer, getActivity());
                ((SelectionSort) algorithm).setData(util.createRandomArray(Constants.NUM_ITEM_IN_SORT));
                break;
            case Constants.QUICK_SORT:
                visualizer = new SortingVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new QuickSort((SortingVisualizer) visualizer, getActivity());
                ((QuickSort) algorithm).setData(util.createRandomArray(15));
                break;
//            case Constants.BST_SEARCH:
//                visualizer = new BSTVisualizer(getActivity());
//                appBarLayout.addView(visualizer);
//                algorithm = new BSTAlgorithm((BSTVisualizer) visualizer, getActivity());
//                ((BSTAlgorithm) algorithm).setData(util.createBinaryTree());
//                break;
//            case Constants.BST_INSERT:
//                visualizer = new BSTVisualizer(getActivity(), 280);
//                ArrayVisualizer arrayVisualizer = new ArrayVisualizer(getActivity());
//                appBarLayout.addView(visualizer);
//                appBarLayout.addView(arrayVisualizer);
//                algorithm = new BSTAlgorithm((BSTVisualizer) visualizer, getActivity());
//                ((BSTAlgorithm) algorithm).setArrayVisualizer(arrayVisualizer);
//                ((BSTAlgorithm) algorithm).setData(util.createBinaryTree());
//                break;
//            case Constants.LINKED_LIST:
//                visualizer = new LinkedListVisualizer(getActivity());
//                LinkedListControls controls = new LinkedListControls(getActivity(), floatingActionButton);
//                appBarLayout.addView(visualizer);
//                appBarLayout.addView(controls);
//                algorithm = new LinkedList((LinkedListVisualizer) visualizer, getActivity());
//                ((LinkedList) algorithm).setData(util.createLinkedList());
//                controls.setLinkedList((LinkedList) algorithm);
//                break;
//            case Constants.STACK:
//                visualizer = new StackVisualizer(getActivity());
//                StackControls stackcontrols = new StackControls(getActivity(), floatingActionButton);
//                appBarLayout.addView(visualizer);
//                appBarLayout.addView(stackcontrols);
//                algorithm = new Stack(5, (StackVisualizer) visualizer, getActivity());
//                ((Stack) algorithm).setData(util.createStack());
//                stackcontrols.setStack((Stack) algorithm);
//                floatingActionButton.setVisibility(View.GONE);
//                break;
//            case Constants.BFS:
//            case Constants.DFS:
//                visualizer = new DirectedGraphVisualizer(getActivity());
//                appBarLayout.addView(visualizer);
//                algorithm = new GraphTraversalAlgorithm((DirectedGraphVisualizer) visualizer, getActivity());
//                ((GraphTraversalAlgorithm) algorithm).setData(util.createDirectedGraph());
//                break;
//            case Constants.DIJKSTRA:
//                visualizer = new WeightedGraphVisualizer2(getActivity());
//                appBarLayout.addView(visualizer);
//                algorithm = new DijkstraAgorithm((WeightedGraphVisualizer2) visualizer, getActivity());
//                ((DijkstraAgorithm) algorithm).setData(util.createWeightedGraph2(5));
//                break;
            default:
                visualizer = null;

        }

        Algorithm.setInterval(Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getActivity())
                .getString(Constants.KEY_INTERVAL, "500")));
        algorithm.setStarted(false);
        floatingActionButton.setImageResource(R.drawable.ic_play);

        algorithm.setCompletionListener(new AlgoCompletionListener() {
            @Override
            public void onAlgoCompleted() {
                floatingActionButton.setImageResource(R.drawable.ic_replay);
                if (visualizer != null)
                    visualizer.onCompleted();

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!algorithm.isStarted()) {
                    algorithm.sendMessage(startCommand);
                    floatingActionButton.setImageResource(R.drawable.ic_pause);
                } else {
                    if (algorithm.isPaused()) {
                        algorithm.setPaused(false);
                        floatingActionButton.setImageResource(R.drawable.ic_pause);
                    } else {
                        algorithm.setPaused(true);
                        floatingActionButton.setImageResource(R.drawable.ic_play);
                    }
                }
            }
        });
    }

    public void setCodeDesc(final String algorithmKey) {
        // get name of algorithm
        // set text in view
    }

    public void setCode(String key) {
        if (codeView != null) {
            switch (key) {
                case Constants.BUBBLE_SORT:
                    addCodeItem(AllCodeDemo.CODE_BUBBLE_SORT);
                    break;
                case Constants.INSERTION_SORT:
                    addCodeItem(AllCodeDemo.CODE_INSERTION_SORT);
                    break;
                case Constants.SELECTION_SORT:
                    addCodeItem(AllCodeDemo.CODE_SELECTION_SORT);
                    break;
                case Constants.QUICK_SORT:
                    addCodeItem(AllCodeDemo.CODE_QUICKSORT);
                    break;
                case Constants.BST_SEARCH:
                    addCodeItem(AllCodeDemo.CODE_BST_SEARCH);
                    break;
                case Constants.LINEAR_SEARCH:
                    addCodeItem(AllCodeDemo.CODE_LINEAR_SEARCH);
                    break;
                case Constants.BST_INSERT:
                    addCodeItem(AllCodeDemo.CODE_BST_INSERT);
                    break;
                case Constants.BINARY_SEARCH:
                    addCodeItem(AllCodeDemo.CODE_BINARY_SEARCH);
                    break;
                case Constants.LINKED_LIST:
                    addCodeItem(AllCodeDemo.CODE_LINKED_LIST_INSERT);
                    addCodeItem(AllCodeDemo.CODE_LINKED_LIST_DELETE);
                    break;
                case Constants.STACK:
                    addCodeItem(AllCodeDemo.CODE_STACK_PUSH);
                    addCodeItem(AllCodeDemo.CODE_STACK_POP);
                    addCodeItem(AllCodeDemo.CODE_STACK_PEEK);
                    break;
                case Constants.BFS:
                    addCodeItem(AllCodeDemo.CODE_GRAPH_BFS);
                    break;
                case Constants.DFS:
                    addCodeItem(AllCodeDemo.CODE_GRAPH_DFS);
                    break;
                case Constants.DIJKSTRA:
                    addCodeItem(AllCodeDemo.CODE_DIJKSTRA);
                    break;
            }
        }

    }

    private void addCodeItem(String code) {
        codeView.setTheme(CodeViewTheme.GITHUB);
        codeView.setHorizontalScrollBarEnabled(true);
        codeView.setOnTouchListener(new HorizontalMoveListener());
        codeView.showCode(code);
    }

    class HorizontalMoveListener implements View.OnTouchListener {

        float downX = 0;
        float downY = 0;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float dx = Math.abs(event.getX() - downX);
                    float dy = Math.abs(event.getY() - downY);

                    if(dx > dy){
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                    }

                    downX = event.getX();
                    downY = event.getY();

                    break;
            }
            return false;
        }
    }

}
