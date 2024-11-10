package popo2;
import java.util.*;
public class kanppysack {

	public static int kp(int[] cost, int[] weight,int capacity)
	{
		int n = weight.length;              //adjusted for zero indexing + adding zero in main itself!
		int[][] dp = new int[n][capacity + 1];
	
		for(int i = 1; i <= n-1; i++) 
			{	for (int j = 1; j <= capacity; j++ )
				{ if (weight[i] <= j)
					{dp[i][j] = Math.max(dp[i-1][j], cost[i] + dp[i-1][j - weight[i]]);
					}
				else
					{dp[i][j] = dp[i-1][j];
					}
				}
		}
		
		for(int i = 0; i <= n-1; i++) 
		{	for (int j = 0; j <= capacity; j++ )
		{
			System.out.print(dp[i][j]);
			
		}System.out.println();
		}
		
		return dp[n-1][capacity];
	}
	
	public static void main(String[] args)
	{
		int[] cost = new int[]{0,1,2,3,4};
		int[] w = new int[] {0,1,2,3,4};
		int capacity = 8;
		System.out.println(kp(cost,w,capacity));
		
		
	}
	
}
