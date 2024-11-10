package popo2;
import java.util.*;



public class bfsd {
	public static void main(String[] args)
	{
		Map<String, List<String>> graph = new HashMap<>();
		Set<String> visited = new HashSet<>();
		List<String>  q = new ArrayList<>(); 
		//or else for q u can use linked list, and then instead of q.remove(0) u can use q.poll()
		
		graph.put("A",  Arrays.asList("B","D"));
		graph.put("B",Arrays.asList("C","D"));
		graph.put("C", Arrays.asList("F","A"));
		graph.put("D", Arrays.asList());
		graph.put("F", Arrays.asList());
		
		
		q.add("A");
		
		
		while(!q.isEmpty())
		{
			String state = q.remove(0);
			
			if (!visited.contains(state))
			{ 
				q.addAll(graph.get(state));
				visited.add(state);
			}
			
			
		}
		
	System.out.println(visited);	
	}

}
