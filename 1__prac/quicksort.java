package popo2;
import java.util.*;
public class quicksort {
	
	public static List<Integer> qsort(List<Integer> arr)
	{
		if (arr.size() <= 1)
		{
			return arr;
		}
		
		List<Integer> remain = new ArrayList<>(arr);
		int mid = arr.size()/2;
		int pivot = arr.get(mid);
		remain.remove(mid);
		
		
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int ele : remain)
		{
			if(ele < pivot)
			{
			 left.add(ele);
			}
			else if (ele > pivot){
				right.add(ele);
			}
		}
		
		
		// return qsort(left) + pivot + qsort(right)
		List<Integer> answer = new ArrayList<>();
		answer.addAll(qsort(left));
		answer.add(pivot);
		answer.addAll(qsort(right));
		
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,8,9,4,5,6));
//		System.out.println(qsort(arr));
		List<Integer> sortedArr = qsort(arr);
		System.out.println(sortedArr);
	}
	
	
	
	

}
