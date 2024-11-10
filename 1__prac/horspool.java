package popo2;
import java.util.*;

public class horspool {
	
	static Map<Character,Integer> shift_table = new HashMap<>();
	
		
		
		public static void main(String[] args)
		{
			String pattern = "he";
			String text = "where are you hey";
			
			int n = pattern.length();
			
			for (int i = 0; i < n; i++)
			{
				shift_table.put(pattern.charAt(i),pattern.length() - i -1);
			}
			
			
			
			int i = n;
			while (i <= text.length())
			{
				int k = 0;
				while(k < n && pattern.charAt(n-1-k) == text.charAt(i-1-k) )
				{
					k++;
				}
				
				if (k==n)
				{
					System.out.println("found at " + (i -n));
					return;
				}
				else
				{
					//char mismatchChar = text.charAt(i - 1);
				char mismatchChar = text.charAt(i - k - 1 );
	//			 char mismatchChar = pattern.charAt(n - k - 1);  //never do this!!
					i = i + shift_table.getOrDefault(mismatchChar, n);
					
					
				}
				
			 }
			
			
			}
		}
		

