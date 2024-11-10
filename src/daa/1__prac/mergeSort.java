package popo2;
import java.util.*;
public class mergeSort {
	
	public static List<Integer> MergeSort (List<Integer> arr)
	{
		if(arr.size() == 1)
		{
			return arr;
		}
		
		List<Integer> Left_half = new ArrayList<>();
		List<Integer> right_half = new ArrayList<>();
		
//		for (int i = 0 ; i < arr.size()/2 ; i++)
//		{
//			Left_half.add(arr.get(i));    //not arr[i] but arr.get(i) because its a List
//			
//		}
//		
//		for (int i = arr.size()/2 ; i < arr.size() ; i++)
//		{
//			right_half.add(arr.get(i));    //not arr[i] but arr.get(i) because its a List
//			
//		}
		
		Left_half.addAll(arr.subList(0, arr.size()/2));
		right_half.addAll(arr.subList(arr.size()/2, arr.size()));
		
		
		List<Integer> LeftSorted = MergeSort(Left_half);
		List<Integer> RightSorted = MergeSort(right_half);
		
		return merger(LeftSorted,RightSorted);
		
	}
	
	public static List<Integer> merger(List<Integer> left, List<Integer> right)
	{
		List<Integer> ans = new ArrayList<>();
		
		int i = 0; 
		int j = 0;
		
		while (i < left.size() && j < right.size())
		{
			if (left.get(i) < right.get(j))
			{
				ans.add(left.get(i));
				i++;	
			}
			else
			{
				ans.add(right.get(j));
				j++;
			}
		}
		
		ans.addAll(left.subList(i, left.size()));
		ans.addAll(right.subList(j, right.size()));
		
		
		return ans;
	}
	
	public static void main (String[] s)
	{
//		List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//		System.out.println(MergeSort(array));
		
		List<Integer> array = new ArrayList<>();
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		int size , max;
	    System.out.print("Enter max:");
	    max = sc.nextInt();
	    System.out.print("Enter size:");
	    size = sc.nextInt();
	    
	    
	    
	    for(int i = 0; i<size;i++)
	    {
	    	array.add(r.nextInt(max));
	    }
	    
	    
	    
	    System.out.println(array);
	    
	    long start = System.nanoTime();
	    System.out.println(MergeSort(array));
	    long end = System.nanoTime();
	    
	    System.out.print("time teaken:" +( end - start));
	    
	    
	}

}
