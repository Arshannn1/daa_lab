package popo2;
import java.util.*;
//finish up thoery daa and then see this !
public class subset_sum {
	static int[] arr = {5,5,5,5};
	public static boolean issubsetsum(int target, int n, List<Integer> curr)
	{
		if (target == 0) {
			System.out.println("yes subset sum!");
			System.out.println(curr);
			return true;
		}
		
		if (n == 0)
		{
			return false;
		}
		
		if (arr[n] > target)    //skip 
		{
			return issubsetsum(target,n-1,curr);
		}
		
		//CASE 1: exclude:
		 if (issubsetsum(target,n-1,curr))
			 {return true;
			 }
		 
		 //CASE 2: include:
		 curr.add(arr[n]);
		 target = target - arr[n];
		 if (issubsetsum(target,n-1,curr))
		 	{return true;
		 	}
		 
		 
		 //if u do not get target by both by excluding and including, backtrack!
		 //remove the last added element in curr and return false;
		 curr.remove(curr.size()-1);
		 return false;
					
	}
	
	public static void main (String[] args)
	{
		int target = 10;
		int size = arr.length - 1;
		List<Integer> store = new ArrayList<>();
		System.out.println(issubsetsum(target,size,store));
		
	}
	
	
}
	


