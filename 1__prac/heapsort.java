package popo2;
import java.util.*;
public class heapsort {
	
	public static List<Integer>heapsort(int[] arr)
	{
		
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		
		for (int num : arr)
		{
			minheap.offer(num);
		}
		
		
		ArrayList<Integer> sortedarr = new ArrayList<>();
		
		while(!minheap.isEmpty())
		{
			sortedarr.add(minheap.poll());
		}
		
		
		return sortedarr;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,37,8,3,99,4};
	
		System.out.println(heapsort(arr));
	}

}
