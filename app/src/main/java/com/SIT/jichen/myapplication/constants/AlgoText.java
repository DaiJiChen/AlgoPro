package com.SIT.jichen.myapplication.constants;

public class AlgoText {
    public static final String TEXT_DEMO =
            "text\n" + "demo \n" + "will \n" + "show \n" + "up \n" + "here\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "...\n" + "end";

    public static final String EXP_LINEAR_SEARCH =
            "    Linear Search is a brute force method, it sequentially checks each element in the list until a match is found or reaches the end of this list.\n\n" +
            "    Linear Search is applicable when the list isn't sorted or has only a few elements.\n\n" +
            "    However, the size of data in modern softwares are usually large, which makes linear search too slow. In reality, we usually pre-processing the data to be able to use faster approaches (such as sorting or constructing more complex data struecures). For example: Binary Search and Binary Search Tree";

    public static final String COMPL_LINEAR_SEARCH =
            "- Time: best O(1), worst O(n), avarageO(n)\n\n" +
            "- Space: worst O(1)";


    public static final String EXP_BINARY_SEARCH =
            "    In computer science, Binary Search is one of teh fastedst searching algorithms.\n\n" +
            "    In its simplest form, Binary Search operates on a contiguous sequence with a specified left and right index. This is called the Search Space. Binary Search maintains the left, right, and middle indicies of the search space and compares the search target or applies the search condition to the middle value of the collection; if the condition is unsatisfied or values unequal, the half in which the target cannot lie is eliminated and the search continues on the remaining half until it is successful. If the search ends with an empty half, the condition cannot be fulfilled and target is not found.\n\n" +
            "    The disadvantage of Binary Search is that it needs the array to be sorted in advance.";

    public static final String COMPL_BINARY_SEARCH =
            "- Time: best O(1), worst O(log n), avarageO(log n)\n\n" +
            "- Space: worst O(1)";



    public static final String EXP_BUBBLE_SORT =
            "    Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements \"bubble\" to the top of the list.\n\n" +
            "    It is stable and in place (no need for extra memory). When the list is already sorted (best-case), the complexity of bubble sort is only O(n).\n\n" +
            "    However, it is very slow. It has a (worst-case and average-case) O(N^2) quadratic running time. Bubble sort should be avoided in the case of large collections. It will not be efficient in the case of a reverse-ordered collection.";

    public static final String COMPL_BUBBLE_SORT =
            "- Time: best O(n), worst O(n^2), avarageO(n^2)\n\n" +
            "- Space: worst O(1)";

    public static final String EXP_INSERTION_SORT =
            "    Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.\n\n" +
            "    Much like other quadratic sorting algorithm, it is stable and efficient for small date sets. It is more efficient in practice than most other simple quadratic algorithms.\n\n" +
            "    Insertion sort is very similar to selection sort. As in selection sort, after k passes through the array, the first k elements are in sorted order. However, the fundamental difference between the two algorithms is that insertion sort scans backwards from the current key, while selection sort scans forwards. This results in selection sort making the first k elements the k smallest elements of the unsorted input, while in insertion sort they are simply the first k elements of the input. The primary advantage of insertion sort over selection sort is that selection sort must always scan all remaining elements to find the absolute smallest element in the unsorted portion of the list, while insertion sort requires only a single comparison when the (k + 1)-st element is greater than the k-th element.\n\n" +
            "    While some divide-and-conquer algorithms such as quicksort and mergesort outperform insertion sort for larger arrays, non-recursive sorting algorithms such as insertion sort or selection sort are generally faster for very small arrays (the exact size varies by environment and implementation, but is typically between 7 and 50 elements). Therefore, a useful optimization in the implementation of those algorithms is a hybrid approach, using the simpler algorithm when the array has been divided to a small size.";

    public static final String COMPL_INSERTION_SORT =
            "- Time: best O(n), worst O(n^2), avarageO(n^2)\n\n" +
            "- Space: worst O(n) ";

    public static final String EXP_SELECTION_SORT =
            "    In computer science, selection sort is an in-place comparison sorting algorithm. Selection Sort is noted for it's simplicity, it is particularly useful when auxiliary memory is limited.\n\n" +
            "    The time efficiency of selection sort is quadratic, so there are a number of sorting techniques which have better time complexity than selection sort. One thing which distinguishes selection sort from other sorting algorithms is that it makes the minimum possible number of swaps, n − 1 in the worst case.\n\n" +
            "    Among quadratic sorting algorithms, selection sort almost always outperforms bubble sort and gnome sort. Insertion sort is very similar in that after the kth iteration, the first k elements in the array are in sorted order. Insertion sort's advantage is that it only scans as many elements as it needs in order to place the k + 1st element, while selection sort must scan all remaining elements to find the k + 1st element.\n\n" +
            "    Selection sort is greatly outperformed on larger arrays by Θ(n log n) divide-and-conquer algorithms such as mergesort. However, insertion sort or selection sort are both typically faster for small arrays (i.e. fewer than 10–20 elements). A useful optimization in practice for the recursive algorithms is to switch to insertion sort or selection sort for \"small enough\" sublists.";

    public static final String COMPL_SELECTION_SORT =
            "- Time: best O(n^2) comparisons, O(1) swaps\n" +
            "        worst O(n^2) comparisons, O(n) swaps\n" +
            "        avarageO(n^2) comparisons, O(n) swaps\n" +
            "\n" +
            "- Space: worst O(1) ";

    public static final String EXP_QUICK_SORT =
            "    Quicksort is a divide-and-conquer algorithm. When implemented well, it can be about two or three times faster than its main competitors, merge sort and heapsort. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.\n\n" +
            "    Quicksort is a comparison sort, meaning that it can sort items of any type for which a \"less-than\" relation (formally, a total order) is defined. Efficient implementations of Quicksort are not a stable sort, meaning that the relative order of equal sort items is not preserved.\n\n" +
            "    Quicksort is a space-optimized version of the binary tree sort. Instead of inserting items sequentially into an explicit tree, quicksort organizes them concurrently into a tree that is implied by the recursive calls. The algorithms make exactly the same comparisons, but in a different order. An often desirable property of a sorting algorithm is stability – that is the order of elements that compare equal is not changed, allowing controlling order of multikey tables (e.g. directory or folder listings) in a natural way.";

    public static final String COMPL_QUICK_SORT =
            "- Time: best O(n logn), worst O(n^2), avarageO(n logn)\n" +
            "\n" +
            "- Space: worst O(n)";



    public static final String EXP_BST_SEARCH =
            "   BSTs support three main operations: search, insertion and deletion. In this section, we are going to talk about how to search for a specific value in a BST. According to the property of BST, for each node:\n\n" +
            "   1. return the node if the target value is equal to the value of the node;\n" +
            "   2. continue searching in the left subtree if the target value is less than the value of the node;\n" +
            "   3. continue searching in the right subtree if the target value is larger than the value of the node.";

    public static final String COMPL_BST_SEARCH =
            "For recursion solution:\n" +
            "- Time: O(h)\n" +
            "- Space: O(h)\n" +
            "\n" +
            "For iterative solution:\n" +
            "- Time: O(h)\n" +
            "- Space: O(1)";

    public static final String EXP_BST_INSERT =
            "   Another common operation in BST is to insert a new node. The main idea is to find out a proper leaf position for the target node and then insert the node as a leaf. Therefore, insertion will begin as a search.\n\n" +
            "   Similar to our search strategy, for each node, we will:\n" +
            "   1. search the left or right subtrees according to the relation of the value of the node and the value of our target node;\n" +
            "   2. repeat STEP 1 until reaching an external node;\n" +
            "   3. add the new node as its left or right child depending on the relation of the value of the node and the value of our target node.\n\n" +
            "   Similar to search, we can do insertion recursively or iteratively. The solution is so similar with search that you should be able to implement it by yourself and analyze the time complexity and space complexity in the same way.";

    public static final String COMPL_BST_INSERT =
            "For recursion solution:\n" +
            "- Time: O(h)\n" +
            "- Space: O(h)\n" +
            "\n" +
            "For iterative solution:\n" +
            "- Time: O(h)\n" +
            "- Space: O(1)";

    public static final String EXP_TREE_BFS =
            "   Breadth-First Search, also called Level-order traversal, is an algorithm to traverse or search in data structures like a tree or a graph. The algorithm starts with a root node and visit the node itself first. Then traverse its neighbors, traverse its second level neighbors, traverse its third level neighbors, so on and so forth.\n" +
            "\n" +
            "   When we do breadth-first search in a tree, the order of the nodes we visited is in level order. Typically, we use a queue to help us to do BFS. Pleease see the code demo for detailed implementation.";

    public static final String COMPL_TREE_BFS =
            "- Time: O(n)\n" +
            "\n" +
            "- Space: O(n)";

    public static final String EXP_TREE_DFS =
            "   There are three kinds of Depth-First Search: Pre-order, in-order and post-order.\n\n" +
            "   Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.\n" +
            "   In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree. Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal.\n" +
            "   Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.";

    public static final String COMPL_TREE_DFS =
            "- Time: O(n)\n" +
            "\n" +
            "- Space: O(n)";



    public static final String EXP_LINKED_LIST =
            "   Similar to the array, the linked list is also a linear data structure. Each element in the linked list is actually a separate object while all the objects are linked together by the reference field in each element.\n\n" +
            "   In computer science, a linked list is a linear collection of data elements whose order is not given by their physical placement in memory. Instead, each element points to the next. It is a data structure consisting of a collection of nodes which together represent a sequence. In its most basic form, each node contains: data, and a reference (in other words, a link) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence during iteration. More complex variants add additional links, allowing more efficient insertion or removal of nodes at arbitrary positions. A drawback of linked lists is that access time is linear (and difficult to pipeline). Faster access, such as random access, is not feasible. Arrays have better cache locality compared to linked lists.\n\n" +
            "   The principal benefit of a linked list over a conventional array is that the list elements can be easily inserted or removed without reallocation or reorganization of the entire structure because the data items need not be stored contiguously in memory or on disk, while restructuring an array at run-time is a much more expensive operation. Linked lists allow insertion and removal of nodes at any point in the list, and allow doing so with a constant number of operations by keeping the link previous to the link being added or removed in memory during list traversal.\n\n" +
            "   On the other hand, since simple linked lists by themselves do not allow random access to the data or any form of efficient indexing, many basic operations—such as obtaining the last node of the list, finding a node that contains a given datum, or locating the place where a new node should be inserted—may require iterating through most or all of the list elements. Linked list are dynamic, so the length of list can increase or decrease as necessary. Each node does not necessarily follow the previous one physically in the memory.";

    public static final String COMPL_LINKED_LIST =
            "Search:\n" +
            "- Time: O(n)\n" +
            "\n" +
            "Insert/Delete at begining:\n" +
            "- Time: O(1)\n" +
            "\n" +
            "Insert/Delete at end:\n" +
            "- Time: O(1)\n" +
            "\n" +
            "Insert/Delete in middle:\n" +
            "- Time: search time + O(1)";

    public static final String EXP_STACK =
            "   In computer science, a stack is an abstract data type that serves as a collection of elements, with two main principal operations:\n" +
            "   Push, which adds an element to the collection, and\n" +
            "   Pop, which removes the most recently added element that was not yet removed.\n\n" +
            "   The order in which elements come off a stack gives rise to its alternative name, LIFO (last in, first out). Additionally, a peek operation may give access to the top without modifying the stack.[1] The name \"stack\" for this type of structure comes from the analogy to a set of physical items stacked on top of each other. This structure makes it easy to take an item off the top of the stack, while getting to an item deeper in the stack may require taking off multiple other items first.\n\n" +
            "   Considered as a linear data structure, or more abstractly a sequential collection, the push and pop operations occur only at one end of the structure, referred to as the top of the stack. This data structure makes it possible to implement a stack as a singly linked list and a pointer to the top element. A stack may be implemented to have a bounded capacity. If the stack is full and does not contain enough space to accept an entity to be pushed, the stack is then considered to be in an overflow state. The pop operation removes an item from the top of the stack.";

    public static final String COMPL_STACK =
            "Push:\n" +
            "- Time: O(n)\n" +
            "\n" +
            "Pop:\n" +
            "- Time: O(1)\n" +
            "\n" +
            "Peek:\n" +
            "- Time: O(1)";



    public static final String EXP_DIJKSTRA =
            "Dijkstra's algorithm (or Dijkstra's Shortest Path First algorithm) is an algorithm for finding the shortest paths between nodes in a graph, which may represent, for example, road networks. It was conceived by computer scientist Edsger W. Dijkstra in 1956 and published three years later.\n\n" +
            "In some fields, artificial intelligence in particular, Dijkstra's algorithm or a variant of it is known as uniform cost search and formulated as an instance of the more general idea of best-first search.\n";

    public static final String COMPL_DIJKSTRA =
            "- Time: O(V^2), but in min-priority queue it drops down to O(V + ElogV))";

    public static final String EXP_BELLMAN_FORD =
            "Bellman Ford's algorithm is used to find the shortest paths from the source vertex to all other vertices in a weighted graph. It depends on the following concept: Shortest path contains at most  edges, because the shortest path couldn't have a cycle.\n" +
            "\n" +
            "Algorithm Steps:\n" +
            "1. The outer loop traverses from  0: n-1.\n" +
            "2. Loop over all edges, check if the next node distance > current node distance + edge weight, in this case update the next node distance to \"current node distance + edge weight\".";

    public static final String COMPL_BELLMAN_FORD =
            "- Time: O(V * E). In case E = V^2, O(V^3)";

}
