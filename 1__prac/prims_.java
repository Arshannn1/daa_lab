package popo2;
import java.util.*;
public class prims_ {

	
	
	public static void main(String[] args) {
		
		int[][] graph = {{1,0,8,1},
						 {0,1,9,0},
						 {8,9,1,0},
						 {1,0,0,1,}};
		Scanner sc = new Scanner(System.in);
		int v;
		System.out.println("no of edges = ");
		v = sc.nextInt();
		boolean[] inMst = new boolean[v];
		int[] parent = new int[v];
		int[] minedge = new int[v];
		
		for(int i  = 0; i<v; i++)
		{
			minedge[i] = 9999;
			parent[i] = -1;
		}
		
		minedge[0] = 0;
		parent[0] = -1;
		
		for (int i = 0 ; i < v - 1; i++)
		{
			int min =  9999;
			int go = 0;
			for (int u = 0; u< v; u++)
			{
				if (!inMst[u] &&  minedge[u] < min)
				{
					min = minedge[u];	
					go = u;
				}
			}
			
			inMst[go] = true;
			
			
			
			for(int u = 0; u < v; u++)
			{
				if (!inMst[u] && graph[go][u]!= 0 && graph[go][u] < minedge[u] )
				{
					minedge[u] = graph[go][u];
					parent[u] = go;
				}
			}
			
			
		}
		
		
		
//		System.out.println("answer:");    //correct only
//		int total = 0;
//			for(int i = 0; i < v; i++)
//		{
//			System.out.println("cost from " + parent[i] + " to "+ i +" is "+ minedge[i]);
//			total += minedge[i];
//	            	
//		}
//		System.out.println(total);
//	
		
		 System.out.println("Edges in the Minimum Spanning Tree:");
	        int totalWeight = 0;
	        for (int i = 1; i < v; i++) {
	            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + graph[parent[i]][i]);
	            totalWeight += graph[parent[i]][i];
	        }

	        System.out.println("Total weight of MST: " + totalWeight);
		
		

	}

}
