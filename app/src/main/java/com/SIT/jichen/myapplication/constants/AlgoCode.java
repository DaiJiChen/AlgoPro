package com.SIT.jichen.myapplication.constants;

public class AlgoCode {

//    public static final String CODE_BUBBLE_SORT = ;
//
//    public static final String CODE_INSERTION_SORT = ;
//
//    public static final String CODE_SELECTION_SORT = ;
//
//    public static final String CODE_QUICKSORT = ;
//
//    public static final String CODE_BST_SEARCH = ;
//
//    public static final String CODE_BST_INSERT = ;
//    public static final String CODE_BINARY_SEARCH = ;
//
//    public static final String CODE_LINEAR_SEARCH = ;
//
//    public static final String CODE_LINKED_LIST_INSERT = ;
//
//    public static final String CODE_LINKED_LIST_DELETE = ;
//
//    public static final String CODE_STACK_PUSH = ;
//
//    public static final String CODE_STACK_PEEK = ;
//
//    public static final String CODE_STACK_POP = ;
//
//    public static final String CODE_GRAPH_BFS = ;
//
//    public static final String CODE_GRAPH_DFS = ;
//
//    public static final String CODE_BELLMAN_FORD = ;
//
//    public static final String CODE_DIJKSTRA = ;

    public static final String CODE_LINEAR_SEARCH =
            "int linear_search(int arr[], int x) { \n" +
            "    int n = arr.length; \n" +
            "    for (int i = 0; i < n; i++)  \n" +
            "    { \n" +
            "        if (arr[i] == x) \n" +
            "            return i; \n" +
            "    } \n" +
            "    return -1; \n" +
            "}" ;

    public static final String CODE_BINARY_SEARCH =
            "int binary_Search(int arr[], int l, int r, int x) { \n" +
            "    if (r >= l) { \n" +
            "        int mid = l + (r - l) / 2; \n" +
            "  \n" +
            "        if (arr[mid] == x) \n" +
            "            return mid; \n" +
            "  \n" +
            "        if (arr[mid] > x) \n" +
            "            return binarySearch(arr, l, mid - 1, x); \n" +
            "  \n" +
            "        return binarySearch(arr, mid + 1, r, x); \n" +
            "    } \n" +
            "  \n" +
            "    return -1; \n" +
            "}";


    public static final String CODE_BUBBLE_SORT =
            "void bubble_Sort(int arr[]) \n" +
            "{ \n" +
            "    int n = arr.length; \n" +
            "    for (int i = 0; i < n-1; i++) \n" +
            "        for (int j = 0; j < n-i-1; j++) \n" +
            "            if (arr[j] > arr[j+1]) \n" +
            "                swap(arr, i, j);\n" +
            "} \n" +
            "\n" +
            "void swap(int arr[], int i, int j) {\n" +
            "    int temp = arr[j]; \n" +
            "    arr[j] = arr[j+1]; \n" +
            "    arr[j+1] = temp; \n" +
            "}";

    public static final String CODE_INSERTION_SORT =
            "void insertion_Sort(int arr[], int n) {   \n" +
            "    for (int i = 1; i < n; i++) \n" +
            "    {  \n" +
            "        int key = arr[i];  \n" +
            "        int j = i - 1;  \n" +
            "        while (j >= 0 && arr[j] > key) \n" +
            "        {  \n" +
            "            arr[j + 1] = arr[j];  \n" +
            "            j = j - 1;  \n" +
            "        }  \n" +
            "        arr[j + 1] = key;  \n" +
            "    }  \n" +
            "}";

    public static final String CODE_SELECTION_SORT =
            "void selection_sort(int arr[]) { \n" +
            "    int n = arr.length; \n" +
            "    for (int i = 0; i < n-1; i++) \n" +
            "    { \n" +
            "        int min_idx = i; \n" +
            "        for (int j = i+1; j < n; j++) \n" +
            "            if (arr[j] < arr[min_idx]) \n" +
            "                min_idx = j; \n" +
            "  \n" +
            "        int temp = arr[min_idx]; \n" +
            "        arr[min_idx] = arr[i]; \n" +
            "        arr[i] = temp; \n" +
            "    } \n" +
            "}";

    public static final String CODE_QUICK_SORT =
            "int partition(int arr[], int low, int high) { \n" +
            "    int pivot = arr[high];  \n" +
            "    int i = (low-1);\n" +
            "\n" +
            "    for (int j=low; j<high; j++) { \n" +
            "        if (arr[j] < pivot) \n" +
            "        { \n" +
            "            i++; \n" +
            "            wsap(arr, i, j);\n" +
            "        } \n" +
            "    } \n" +
            "    swap(arr, i+1, high);\n" +
            "  \n" +
            "    return i+1; \n" +
            "}";



    public static final String CODE_BST_SEARCH =
            "public Node search(Node root, int key) { \n" +
            "    if (root==null || root.key==key) \n" +
            "        return root; \n" +
            "  \n" +
            "    if (root.key < key) \n" +
            "       return search(root.right, key); \n" +
            "  \n" +
            "    return search(root.left, key); \n" +
            "}";

    public static final String CODE_BST_INSERT =
            "Node insert(Node root, int key) { \n" +
            "    if (root == null) { \n" +
            "        root = new Node(key); \n" +
            "        return root; \n" +
            "    } \n" +
            "  \n" +
            "    if (key < root.key) \n" +
            "        root.left = insert(root.left, key); \n" +
            "    else if (key > root.key) \n" +
            "        root.right = insert(root.right, key); \n" +
            "  \n" +
            "    return root; \n" +
            "} ";

    public static final String CODE_TREE_BFS =
            "public List<List<Integer>> level_order(TreeNode root) {\n" +
            "    List<List<Integer>> result = new LinkedList<List<Integer>>();\n" +
            "    if(root == null) return result;\n" +
            "        \n" +
            "    Queue<TreeNode> queue = new LinkedList<>();\n" +
            "    queue.add(root);\n" +
            "        \n" +
            "    while(!queue.isEmpty()) {\n" +
            "        int size = queue.size();\n" +
            "        List<Integer> list = new ArrayList<>();\n" +
            "        for(int i = 0; i < size; i++) {\n" +
            "            TreeNode node = queue.poll();\n" +
            "            list.add(node.val);\n" +
            "                \n" +
            "            if(node.left != null) queue.add(node.left);\n" +
            "            if(node.right != null) queue.add(node.right);\n" +
            "        }\n" +
            "        result.add(list);\n" +
            "    }\n" +
            "        \n" +
            "    return result;\n" +
            "}";

    public static final String CODE_TREE_DFS =
            "public List<Integer> preorder_DFS(TreeNode root) {\n" +
            "    List<Integer> output = new ArrayList<>();\n" +
            "    if(root == null) return output;\n" +
            "        \n" +
            "    output.add(root.val);\n" +
            "    preorder_DFS(root.left);\n" +
            "    preorder_DFS(root.right);\n" +
            "            \n" +
            "    return output;\n" +
            "}";




    public static final String CODE_LINKED_LIST =
            "void insert_at_Index(int index, int val) {\n" +
            "    if(index < 0 || index > size) return;\n" +
            "        \n" +
            "    ListNode node = new ListNode(val);\n" +
            "    ListNode prev = head;\n" +
            "        \n" +
            "    for(int i = 0; i < index; i++) prev = prev.next;\n" +
            "\n" +
            "    node.next = prev.next;\n" +
            "    prev.next = node;  \n" +
            "    size++;\n" +
            "}\n" +
            "    \n\n" +
            "void delete_at_Index(int index) {\n" +
            "    if(index < 0 || index >= size) return;\n" +
            "        \n" +
            "    ListNode prev = head;\n" +
            "    for(int i = 0; i < index; i++) prev = prev.next;\n" +
            "\n" +
            "    prev.next = prev.next.next;  \n" +
            "    size--;\n" +
            "}";


    public static final String CODE_STACK =
            "class MyStack {\n" +
            "    private List<Integer> data;\n" +
            "\n" +
            "    public MyStack() {\n" +
            "        data = new ArrayList<>();\n" +
            "    }\n" +
            "\n" +
            "    public void push(int x) {\n" +
            "        data.add(x);\n" +
            "    }\n" +
            "\n" +
            "    public boolean isEmpty() {\n" +
            "        return data.isEmpty();\n" +
            "    }\n" +
            "\n" +
            "    public int top() {\n" +
            "        return data.get(data.size() - 1);\n" +
            "    }\n" +
            "\n" +
            "    public boolean pop() {\n" +
            "        if (isEmpty()) {\n" +
            "            return false;\n" +
            "        }\n" +
            "        data.remove(data.size() - 1);\n" +
            "        return true;\n" +
            "    }\n" +
            "};";


    public static final String CODE_BELLMAN_FORD =
            "void Bellman_Ford(Graph graph, int src) { \n" +
            "    int V = graph.V, E = graph.E; \n" +
            "    int dist[] = new int[V]; \n" +
            "  \n" +
            "    // Step 1: Initialize distances from src to all other \n" +
            "    // vertices as INFINITE \n" +
            "    for (int i = 0; i < V; ++i) \n" +
            "        dist[i] = Integer.MAX_VALUE; \n" +
            "    dist[src] = 0; \n" +
            "  \n" +
            "    // Step 2: Relax all edges |V| - 1 times. A simple \n" +
            "    // shortest path from src to any other vertex can \n" +
            "    // have at-most |V| - 1 edges \n" +
            "    for (int i = 1; i < V; ++i) { \n" +
            "        for (int j = 0; j < E; ++j) { \n" +
            "            int u = graph.edge[j].src; \n" +
            "            int v = graph.edge[j].dest; \n" +
            "            int weight = graph.edge[j].weight; \n" +
            "            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) \n" +
            "                dist[v] = dist[u] + weight; \n" +
            "        } \n" +
            "    } \n" +
            "  \n" +
            "    // Step 3: check for negative-weight cycles. The above \n" +
            "    // step guarantees shortest distances if graph doesn't \n" +
            "    // contain negative weight cycle. If we get a shorter \n" +
            "    // path, then there is a cycle. \n" +
            "    for (int j = 0; j < E; ++j) { \n" +
            "        int u = graph.edge[j].src; \n" +
            "        int v = graph.edge[j].dest; \n" +
            "        int weight = graph.edge[j].weight; \n" +
            "        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { \n" +
            "            System.out.println(\"Graph contains negative weight cycle\"); \n" +
            "            return; \n" +
            "        } \n" +
            "    } \n" +
            "}";

    public static final String CODE_DIJKSTRA =
            "public static Graph calculate_shortest_path_from_source(Graph graph, Node source) {\n" +
            "    source.setDistance(0);\n" +
            "\n" +
            "    Set<Node> settledNodes = new HashSet<>();\n" +
            "    Set<Node> unsettledNodes = new HashSet<>();\n" +
            "\n" +
            "    unsettledNodes.add(source);\n" +
            "\n" +
            "    while (unsettledNodes.size() != 0) {\n" +
            "        Node currentNode = get_lowest_distance_node(unsettledNodes);\n" +
            "        unsettledNodes.remove(currentNode);\n" +
            "        for (Entry < Node, Integer> adjacencyPair: \n" +
            "          currentNode.getAdjacentNodes().entrySet()) {\n" +
            "            Node adjacentNode = adjacencyPair.getKey();\n" +
            "            Integer edgeWeight = adjacencyPair.getValue();\n" +
            "            if (!settledNodes.contains(adjacentNode)) {\n" +
            "                calculate_minimum_distance(adjacentNode, edgeWeight, currentNode);\n" +
            "                unsettledNodes.add(adjacentNode);\n" +
            "            }\n" +
            "        }\n" +
            "        settledNodes.add(currentNode);\n" +
            "    }\n" +
            "    return graph;\n" +
            "}\n" +
            "\n\n" +
            "private static Node get_lowest_distance_node(Set < Node > unsettledNodes) {\n" +
            "    Node lowestDistanceNode = null;\n" +
            "    int lowestDistance = Integer.MAX_VALUE;\n" +
            "    for (Node node: unsettledNodes) {\n" +
            "        int nodeDistance = node.getDistance();\n" +
            "        if (nodeDistance < lowestDistance) {\n" +
            "            lowestDistance = nodeDistance;\n" +
            "            lowestDistanceNode = node;\n" +
            "        }\n" +
            "    }\n" +
            "    return lowestDistanceNode;\n" +
            "}\n" +
            "\n\n" +
            "private static void calculate_minimum_distance(Node evaluationNode,\n" +
            "  Integer edgeWeigh, Node sourceNode) {\n" +
            "    Integer sourceDistance = sourceNode.getDistance();\n" +
            "    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {\n" +
            "        evaluationNode.setDistance(sourceDistance + edgeWeigh);\n" +
            "        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());\n" +
            "        shortestPath.add(sourceNode);\n" +
            "        evaluationNode.setShortestPath(shortestPath);\n" +
            "    }\n" +
            "}";

}
