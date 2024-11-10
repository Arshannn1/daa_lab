package popo2;
import java.util.*;
public class warshall {

	public static int[][] war(int[][] matrix)
	{ 
		int n = matrix[0].length;
		
		
		for(int i = 0; i < n; i++)
		{ for (int j = 0; j<n;j++)
			{
			  if (i==j)
			  {
				  matrix[i][j] = 1;
			  }
			}
		}
		
		
		for (int k = 0; k<n; k++)
		{ for(int i = 0; i < n; i++)
			{
				for(int j = 0; j<n;j++)
				{
			     matrix[i][j] = matrix[i][j] | (matrix[i][k] & matrix[k][j]);
				}
				
			}
		}
		return matrix;
		
	}
	
	
	public static void main(String[] args)
	{
		
		int[][] graph = {
				        {1,0,1,1}, 
						{1,1,1,0},
						{1,0,0,0},
						{0,0,1,0}
						};
		
		 int[][] ans = war(graph);
		 
		 
		 
		 for (int[] row : graph)
		 {
			 for(int ele : row)
			 {
				 System.out.print(ele);
			 }
			 System.out.println();
		 }
		
	}
}
