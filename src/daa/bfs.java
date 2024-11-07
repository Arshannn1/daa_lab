package daa;

import java.util.*;

public class bfs {
    static Map<String, List<String>> graph = new HashMap<>();
    static List<String> myQueue = new ArrayList<>();
    static List<String> searched = new ArrayList<>();

    public static void main(String[] args) {
        // Define the graph
        graph.put("A", Arrays.asList("B", "D"));
        graph.put("B", Arrays.asList("F", "C", "A"));
        graph.put("C", Arrays.asList("E", "G"));
        graph.put("D", Arrays.asList("F"));
        graph.put("F", Arrays.asList("A"));
        graph.put("E", Arrays.asList("F"));
        graph.put("G", Arrays.asList("E"));

        // Add the starting point to the queue
        myQueue.add("A");

        // Perform BFS traversal
        bfs();

        // Print the searched nodes and remaining queue
        System.out.println("Visited nodes: " + searched);
        System.out.println("Remaining queue: " + myQueue);
    }

    // BFS traversal function
    public static void bfs() {
        while (!myQueue.isEmpty()) {
            String state = myQueue.remove(0);
            if (!searched.contains(state)) {
                System.out.println("Visited node: " + state);
                myQueue.addAll(graph.get(state));
                searched.add(state);
            }
        }
    }
}
//
//
//public static void bfs() {
//    while (!myQueue.isEmpty()) {
//        String state = myQueue.remove(0);
//        if (!searched.contains(state)) {
//            System.out.println("Visited node: " + state);
//            searched.add(state);
//
//            // Add neighbors to the queue only if they haven't been visited
//            for (String neighbor : graph.get(state)) {
//                if (!searched.contains(neighbor)) {
//                    myQueue.add(neighbor);
//                }
