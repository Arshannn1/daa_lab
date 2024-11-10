package popo2;



import java.util.*;


public class floydwarshall {
	static int x = Integer.MAX_VALUE;

	public static int[][] floyd(int[][] matrix)
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
				{ if (matrix[i][k] != x && matrix[k][j] != x)
			     matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
				}
				
			}
		}
		return matrix;
		
	}
	
	
	public static void main(String[] args)
	{
		
		int[][] graph = {
				        {11,9,18,10}, 
						{1,13,1,x},
						{14,x,x,x},
						{x,x,88,x}
						};
		
		 int[][] ans = floyd(graph);
		 
		 
		 
		 for (int[] row : graph)
		 {
			 for(int ele : row)
			 { if (ele != 'x')
				 {System.out.print(ele + "  ");}
			 else
				 {
					System.out.println("X  "); 
				 }
			 }
			 System.out.println();
		 }
		
	}
}
