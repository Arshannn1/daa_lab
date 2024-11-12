package popo2;

import java.util.*;


class Node
{ int key;
Node left,right;

public Node(int t)
{key = t;
left = null;
right = null;

}
}


public class BinarySearchTree
{
	Node root;
	
	public BinarySearchTree()
			{
					root = null;
			}
	
	void insert(int item)
			{
		      root = insertrec(root,item);
			}	
	
	Node insertrec(Node root, int k)
	{
		if (root == null)
		{
			Node n = new Node(k);
			return n;
		}
		
		else if (root.key > k)
		{
			root.left = insertrec(root.left,k);
		}
		
		else if(root.key < k)
		{
			root.right = insertrec(root.right,k);
		}
		
		
		return root;
	}
	
	int find_min(Node root)
	{
		while(root.left != null)
		{
			root = root.left;
		}
		return root.key;
	}
	
	void delete(int item)
		{
			root = deleterec(root, item);
		}
	
	Node deleterec(Node root, int k)
		{
		 if (root == null)
		 {
			 return root;
		 }
		 
		 else if (root.key < k)
		 {
			 root.right  = deleterec(root.right,k);
		 }
		 
		 else if (root.key > k)
		 {
			 root.left = deleterec(root.left,k);
		 }
		 
		 else
		 {
			 if (root.left == null)
			 {
				 return root.right;
			 }
			 else if(root.right == null)
			 {
				return root.left; 
			 }
			 
			 else
			 {
				 int min_val = find_min(root.right);
				 root.key = min_val;
				 root.right  = deleterec(root.right,min_val); 
			 }
			 
		 }
		 return root;
	 
	}
	
	
	void inorder()
		{
			inordermove(root);
		}
	
	void inordermove(Node root)
		{
			if (root!=null)
			{
				inordermove(root.left);
				System.out.println(root.key);
				inordermove(root.right);
			}
		}
	
	
	
	
	
	
	public static void main (String[] args)
	{
		BinarySearchTree abc = new BinarySearchTree();
		abc.insert(1117);
		abc.insert(9);
		abc.insert(88);
		abc.inorder();}
	
	}