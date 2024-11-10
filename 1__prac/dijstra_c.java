//package popo2;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ArrayList;
//
//public class dijstra_c {
//    // Graph representation
//    static Map<String, Map<String, Integer>> graph = new HashMap<>();
//    static Map<String, Integer> costs = new HashMap<>();
//    static Map<String, String> parents = new HashMap<>();
//
//    static {
//        graph.put("a", new HashMap<>() {{ put("b", 5); put("c", 2); }});
//        graph.put("b", new HashMap<>() {{ put("d", 1); put("e", 6); }});
//        graph.put("c", new HashMap<>() {{ put("b", 8); put("d", 7); }});
//        graph.put("d", new HashMap<>() {{ put("e", 3); put("f", 2); }});
//        graph.put("e", new HashMap<>() {{ put("f", 1); }});
//        graph.put("f", new HashMap<>());
//    }
//
//    // Initialize costs and parents based on the chosen start node
//    public static void initializeCosts(String start) {
//        for (String node : graph.keySet()) {
//            costs.put(node, Integer.MAX_VALUE);
//        }
//        costs.put(start, 0);
//    }
//
//    public static void initializeParents() {
//        for (String node : graph.keySet()) {
//            parents.put(node, null);
//        }
//    }
//
//    // Function to find the lowest cost node
//    public static String findLowestCostNode(List<String> processed) {
//        int lowestCost = Integer.MAX_VALUE;
//        String lowestCostNode = null;
//        for (String node : costs.keySet()) {
//            int cost = costs.get(node);
//            if (cost < lowestCost && !processed.contains(node)) {
//                lowestCost = cost;
//                lowestCostNode = node;
//            }
//        }
//        return lowestCostNode;
//    }
//
//    // Dijkstra's algorithm to find shortest paths from the chosen start node
//    public static void dijkstra(String start) {
//        initializeCosts(start);
//        initializeParents();
//        List<String> processed = new ArrayList<>();
//
//        String node = findLowestCostNode(processed);
//        while (node != null) {
//            int cost = costs.get(node);
//            for (String neighbor : graph.get(node).keySet()) {
//                int newCost = cost + graph.get(node).get(neighbor);
//                if (newCost < costs.get(neighbor)) {
//                    costs.put(neighbor, newCost);
//                    parents.put(neighbor, node);
//                }
//            }
//            processed.add(node);
//            node = findLowestCostNode(processed);
//        }
//    }
//
//    public static void main(String[] args) {
//        // Choose a start node
//        String start = "a";  // Replace "a" with any node to start from
//
//        // Run Dijkstra's algorithm
//        dijkstra(start);
//
//        // Output the shortest paths and costs from the chosen start node
//        System.out.println("Costs: " + costs);
//        System.out.println("Parents: " + parents);
//    }
//}






package popo2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class dijstra_c {
	
	static Map<String,Map<String,Integer>>graph = new HashMap<>();
	static Map<String,Integer>costs = new HashMap<>();
	static Map<String,String>parents = new HashMap<>();
	
	
	public  static String get_smallest_node(List<String> processed)
	{
		int min = Integer.MAX_VALUE;
		String min_node = null;
		
		for(String node: costs.keySet())
		{
			if (costs.get(node)<min && !processed.contains(node))
			{
				min = costs.get(node);
				min_node = node;
			}
		}
		return min_node;
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		
		graph.put("A", new HashMap<>() {   {put("b",6);  put("c",10);  }});
		graph.put("b", new HashMap<>() {{put("c",3);}});
		graph.put("c", new HashMap<>());
		
		
		
		for (String node: graph.keySet())
		{
			costs.put(node, Integer.MAX_VALUE);       //initilaize cost
		}
		costs.put("A",0);
		
		
		
		
		for(String node: graph.keySet())		
		{   										//initialize parent
			parents.put(node, null);
		}
		
		
		
		
		String Start = "A";
		List<String> processed = new ArrayList<>();
		
//		while(processed.size() != costs.keySet().size())   //works though
		while(Start != null)
		{
			processed.add(Start);
			for(String node: graph.get(Start).keySet())
			{
				int new_cost = costs.get(Start) + graph.get(Start).get(node);
				if (new_cost < costs.get(node))
				{
					costs.put(node,new_cost);
					parents.put(node, Start);  //umm good 
				}
				
			}
			
			Start = get_smallest_node(processed);
			
		}
		
		
		System.out.println(costs);
		System.out.println(parents);
			
	}			
}