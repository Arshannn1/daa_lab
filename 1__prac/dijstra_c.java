
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

		graph.put("a", new HashMap<>() {{ put("b", 5); put("c", 2); }});
        graph.put("b", new HashMap<>() {{ put("d", 1); put("e", 6); }});
        graph.put("c", new HashMap<>() {{ put("b", 8); put("d", 7); }});     
        graph.put("d", new HashMap<>() {{ put("e", 3);}});
        graph.put("e", new HashMap<>());
        
		
		
		for (String node: graph.keySet())
		{
			costs.put(node, Integer.MAX_VALUE);       //initilaize cost
		}
		costs.put("a",0);
		
		
		
		
		for(String node: graph.keySet())		
		{   										//initialize parent
			parents.put(node, null);
		}
		
		
		String Start = "a";
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