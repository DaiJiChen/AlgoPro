package com.SIT.jichen.myapplication;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.SIT.jichen.myapplication.algorithm.*;
import com.SIT.jichen.myapplication.algorithm.list.*;
import com.SIT.jichen.myapplication.algorithm.graph.*;
import com.SIT.jichen.myapplication.algorithm.search.*;
import com.SIT.jichen.myapplication.algorithm.tree.*;
import com.SIT.jichen.myapplication.constants.*;
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
    TextView title;
    TextView explanationText;
    TextView complexityText;

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
        title = rootView.findViewById(R.id.explanationTitle);
        explanationText = rootView.findViewById(R.id.explanationText);
        complexityText = rootView.findViewById(R.id.complexityText);

        setupFragment(getArguments().getString(Constants.ALGO_NAME));

        return rootView;
    }

    public void setStartCommand(String startCommand) {
        this.startCommand = startCommand;
    }

    public boolean setupFragment(String algoName) {
        assert algoName != null;

        final AlgoVisualizer visualizer;
        
        floatingActionButton.setVisibility(View.VISIBLE);

        switch (algoName) {
            case Constants.LINEAR_SEARCH:
                visualizer = new SearchVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new LinearSearch((SearchVisualizer) visualizer, getActivity());
                ((LinearSearch) algorithm).setData(util.createArray(Constants.NUM_ITEM_IN_SEARCH, false));
                break;
            case Constants.BINARY_SEARCH:
                visualizer = new SearchVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new BinarySearch((SearchVisualizer) visualizer, getActivity());
                ((BinarySearch) algorithm).setData(util.createArray(Constants.NUM_ITEM_IN_SEARCH, true));
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
                ((QuickSort) algorithm).setData(util.createRandomArray(Constants.NUM_ITEM_IN_SORT));
                break;


            case Constants.BST_SEARCH:
                visualizer = new BSTVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new BSTAlgorithm((BSTVisualizer) visualizer, getActivity());
                ((BSTAlgorithm) algorithm).setData(util.createBinaryTree());
                break;
            case Constants.BST_INSERT:
                visualizer = new BSTVisualizer(getActivity(), 280);
                ArrayVisualizer arrayVisualizer = new ArrayVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                appBarLayout.addView(arrayVisualizer);
                algorithm = new BSTAlgorithm((BSTVisualizer) visualizer, getActivity());
                ((BSTAlgorithm) algorithm).setArrayVisualizer(arrayVisualizer);
                ((BSTAlgorithm) algorithm).setData(util.createBinaryTree());
                break;
            case Constants.BFS:
            case Constants.DFS:
                visualizer = new DirectedGraphVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new GraphTraversalAlgorithm((DirectedGraphVisualizer) visualizer, getActivity());
                ((GraphTraversalAlgorithm) algorithm).setData(util.createDirectedGraph());
                break;


            case Constants.LINKED_LIST:
                visualizer = new LinkedListVisualizer(getActivity());
                LinkedListControls controls = new LinkedListControls(getActivity(), floatingActionButton);
                appBarLayout.addView(visualizer);
                appBarLayout.addView(controls);
                algorithm = new myLinkedList((LinkedListVisualizer) visualizer, getActivity());
                ((myLinkedList) algorithm).setData(util.createLinkedList());
                controls.setMyLinkedList((myLinkedList) algorithm);
                floatingActionButton.setVisibility(View.GONE);
                break;
            case Constants.STACK:
                visualizer = new StackVisualizer(getActivity());
                StackControls stackcontrols = new StackControls(getActivity(), floatingActionButton);
                appBarLayout.addView(visualizer);
                appBarLayout.addView(stackcontrols);
                algorithm = new Stack(5, (StackVisualizer) visualizer, getActivity());
                ((Stack) algorithm).setData(util.createStack());
                stackcontrols.setStack((Stack) algorithm);
                floatingActionButton.setVisibility(View.GONE);
                break;



            case Constants.DIJKSTRA:
                visualizer = new WeightedGraphVisualizer(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new DijkstraAgorithm((WeightedGraphVisualizer) visualizer, getActivity());
                ((DijkstraAgorithm) algorithm).setData(util.createWeightedGraph());
                break;
            case Constants.BELLMAN_FORD:
                visualizer = new WeightedGraphVisualizer2(getActivity());
                appBarLayout.addView(visualizer);
                algorithm = new BellmanFordAlgorithm((WeightedGraphVisualizer2) visualizer, getActivity());
                ((BellmanFordAlgorithm) algorithm).setData(util.createWeightedGraph2());
                break;
            default:
                Toast.makeText(getActivity(), "Unknown algoName while inflate visualizer", Toast.LENGTH_SHORT).show();
                return false;
        }

        Algorithm.setInterval(Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getActivity())
                .getString(Constants.KEY_INTERVAL, "1000")));
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
//                    algorithm.sendMessage(startCommand);
                    algorithm.sendMessage("start_bst_search");
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

        setText(algoName);

        return true;
    }

    public void setText(final String algoName) {
        title.setText(algoName);

        if(explanationText == null || complexityText == null) {
            explanationText.setText(AlgoText.TEXT_DEMO);
            complexityText.setText(AlgoText.TEXT_DEMO);
            return;
        }

        switch (algoName) {
            case Constants.BUBBLE_SORT:
                explanationText.setText(AlgoText.EXP_BUBBLE_SORT);
                complexityText.setText(AlgoText.COMPL_BUBBLE_SORT);
                addCodeDemo(AlgoCode.CODE_BUBBLE_SORT);
                break;
            case Constants.INSERTION_SORT:
                explanationText.setText(AlgoText.EXP_INSERTION_SORT);
                complexityText.setText(AlgoText.COMPL_INSERTION_SORT);
                addCodeDemo(AlgoCode.CODE_INSERTION_SORT);
                break;
            case Constants.SELECTION_SORT:
                explanationText.setText(AlgoText.EXP_SELECTION_SORT);
                complexityText.setText(AlgoText.COMPL_SELECTION_SORT);
                addCodeDemo(AlgoCode.CODE_SELECTION_SORT);
                break;
            case Constants.QUICK_SORT:
                explanationText.setText(AlgoText.EXP_QUICK_SORT);
                complexityText.setText(AlgoText.COMPL_QUICK_SORT);
                addCodeDemo(AlgoCode.CODE_QUICK_SORT);
                break;
                
                
            case Constants.LINEAR_SEARCH:
                explanationText.setText(AlgoText.EXP_LINEAR_SEARCH);
                complexityText.setText(AlgoText.COMPL_LINEAR_SEARCH);
                addCodeDemo(AlgoCode.CODE_LINEAR_SEARCH);
                break;
            case Constants.BINARY_SEARCH:
                explanationText.setText(AlgoText.EXP_BINARY_SEARCH);
                complexityText.setText(AlgoText.COMPL_BINARY_SEARCH);
                addCodeDemo(AlgoCode.CODE_BINARY_SEARCH);
                break;
                
                
            case Constants.BST_SEARCH:
                explanationText.setText(AlgoText.EXP_BST_SEARCH);
                complexityText.setText(AlgoText.COMPL_BST_SEARCH);
                addCodeDemo(AlgoCode.CODE_BST_SEARCH);
                break;
            case Constants.BST_INSERT:
                explanationText.setText(AlgoText.EXP_BST_INSERT);
                complexityText.setText(AlgoText.COMPL_BST_INSERT);
                addCodeDemo(AlgoCode.CODE_BST_INSERT);
                break;
            case Constants.BFS:
                explanationText.setText(AlgoText.EXP_TREE_BFS);
                complexityText.setText(AlgoText.COMPL_TREE_BFS);
                addCodeDemo(AlgoCode.CODE_TREE_BFS);
                break;
            case Constants.DFS:
                explanationText.setText(AlgoText.EXP_TREE_DFS);
                complexityText.setText(AlgoText.COMPL_TREE_DFS);
                addCodeDemo(AlgoCode.CODE_TREE_DFS);
                break;
                
                
            case Constants.LINKED_LIST:
                explanationText.setText(AlgoText.EXP_LINKED_LIST);
                complexityText.setText(AlgoText.COMPL_LINKED_LIST);
                addCodeDemo(AlgoCode.CODE_LINKED_LIST);
                break;
            case Constants.STACK:
                explanationText.setText(AlgoText.EXP_STACK);
                complexityText.setText(AlgoText.COMPL_STACK);
                addCodeDemo(AlgoCode.CODE_STACK);
                break;
                
                
            case Constants.DIJKSTRA:
                explanationText.setText(AlgoText.EXP_DIJKSTRA);
                complexityText.setText(AlgoText.COMPL_DIJKSTRA);
                addCodeDemo(AlgoCode.CODE_DIJKSTRA);
                break;
            case Constants.BELLMAN_FORD:
                explanationText.setText(AlgoText.EXP_BELLMAN_FORD);
                complexityText.setText(AlgoText.COMPL_BELLMAN_FORD);
                addCodeDemo((AlgoCode.CODE_BELLMAN_FORD));
                break;

            default:
                Toast.makeText(getActivity(), "Unknown algoName while inflate text", Toast.LENGTH_SHORT).show();
        }
    }

    private void addCodeDemo(String code) {
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
