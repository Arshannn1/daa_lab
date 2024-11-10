package popo2;
import java.util.*;


public class dfs {
	
	static Map<String, List<String>> graph = new HashMap<>();
	static ArrayList<String> deadend = new ArrayList<>();
	static ArrayList<String> visited = new ArrayList<>();

	
	public static void dfs(String node)
	{
		if ( visited.contains(node))
		{
			return;
		}
		
		
		visited.add(node);
		
		for(String neighbour : graph.get(node))
		{ 
			 dfs(neighbour);
			
		}
		
		
		deadend.add(node);
	}
	
 public static void main(String[] args)
 {
	 graph.put("A", Arrays.asList("B", "C"));
     graph.put("B", Arrays.asList("D"));
     graph.put("C", Arrays.asList("E"));
     graph.put("D", Arrays.asList("F"));
     graph.put("E", Arrays.asList("F"));
     graph.put("F", new ArrayList<>()); 
     
	 dfs("A");
	 
	 System.out.println(visited);
	 System.out.println(deadend.reversed());
	 
 }
 
 
}
