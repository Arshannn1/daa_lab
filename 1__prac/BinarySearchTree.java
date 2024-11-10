package popo2;

import java.util.*;

class Node
{
	int key;
	Node left; Node right;
	
	public Node(int item)
	{
		key = item;
		left = right = null;

	}
}

public class BinarySearchTree {
	
Node root;

	public BinarySearchTree()
		{root = null;
		}
	
	void insert(int key ) {
		root = insertfunc(root,key);
	}
	
	Node insertfunc(Node root,int key)
	{
		
		if (root == null)
		{
			Node a = new Node(key);
			return a;
			
		}
		if (key < root.key)
		{
			root.left = insertfunc(root.left,key);
		}
		else
		{
			root.right = insertfunc(root.right,key);
		}
		
		return root;
	}
	
	
	void inorder()
	{  
		inordertraversal(root);
	}
	
	void inordertraversal(Node root)
	{
		if (root != null)
		{
			inordertraversal(root.left);
			System.out.print(root.key+ " ");
			inordertraversal(root.right);
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(10);
		bt.insert(77);
		bt.insert(8);
		bt.inorder();
	}
	
	}
	
	

