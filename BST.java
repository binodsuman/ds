package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int val;
	Node left;
	Node right;
	
	Node(int val){
		this.val = val;
		left = null;
		right = null;
	}
}

class BinaryTree{
	Node root;
	
	BinaryTree(){
		root = null;
	}
	public void insert(int val){
		//root = insert(root,val);
		root = insertAsSimpleBinaryTree(root,val);
	}
	
	private Node insert(Node node, int val){
		if(node == null){
			node = new Node(val);
		}else if(node.val > val){
			node.left = insert(node.left,val);
		}else if(node.val < val){
			node.right = insert(node.right,val);
		}
	   return node;	
	}

	private Node insertAsSimpleBinaryTree(Node node,int val){
		Queue<Node> q = new LinkedList<Node>();
		if(node == null){node = new Node(val);return node;}
		q.offer(node);
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp.left==null){temp.left = new Node(val);return node;}
			else{q.offer(temp.left);}
			
			if(temp.right==null){temp.right = new Node(val);return node;}
			else{q.offer(temp.right);}
		}
	  return node;	
	}
	
   public void inorder(){
	   System.out.println("Inorder");
	   inorder(root);
	   System.out.println();
   }
   
   private void inorder(Node node){
	   if(node != null){
		   inorder(node.left);
		   System.out.print(node.val+ " ");
		   inorder(node.right);
	   }
   }
   
   public void preorder(){
	   System.out.println("Preorder");
	   preorder(root);
	   System.out.println();
   }
   
   private void preorder(Node node){
	   if(node != null){
		   System.out.print(node.val+ " ");
		   preorder(node.left);
		   preorder(node.right);
	   }
   }
   
   public void postorder(){
	   System.out.println("Postorder");
	   postorder(root);
	   System.out.println();
   }
   
   private void postorder(Node node){
	   if(node != null){
		   postorder(node.left);
		   postorder(node.right);
		   System.out.print(node.val+ " ");
	   }
   }
   
   public void  levelOrder(){
	   System.out.println("Level order");
	   levelOrder(root);
	   System.out.println();
   }
   
   /*private void  levelOrder(Node node){
	   
	   Queue<Node> q = new LinkedList<Node>();
	   q.offer(node);
	  // q.offer(null);
	   while(!q.isEmpty()){
		   Node temp = q.poll();
		   System.out.print(temp.val+" ");
		   if(temp.left!=null)q.offer(temp.left);
		   if(temp.right!=null)q.offer(temp.right);
	   }
   }*/
   
   private void  levelOrder(Node node){
	   Queue<Node> q = new LinkedList<Node>();
	   q.offer(node);
	   while(!q.isEmpty()){
		   Node temp = q.poll();
		   System.out.print(temp.val+" ");
		   if(temp.left != null){q.offer(temp.left);}
		   if(temp.right != null){q.offer(temp.right);}
	   }
   }
}

public class BST {
  public static void main(String[] args) {
	  BinaryTree tree = new BinaryTree();
	  /*tree.insert(8);
	  tree.insert(3);
	  tree.insert(6);
	  tree.insert(10);
	  tree.insert(4);
	  tree.insert(7);
	  tree.insert(1);
	  tree.insert(14);
	  tree.insert(13);*/
	  
	  tree.insert(4);
	  tree.insert(5);
	  tree.insert(1);
	  tree.insert(2);
	  tree.insert(8);
	  tree.insert(7);
	  
	  
	  /*tree.insert(7);
	  tree.insert(1);
	  tree.insert(10);*/
	  
	 /* tree.insert(7);
	  tree.insert(1);
	  tree.insert(0);
	  tree.insert(3);
	  tree.insert(2);
	  tree.insert(5);
	  tree.insert(4);
	  tree.insert(6);
	  tree.insert(9);
	  tree.insert(8);
	  tree.insert(10);*/
	  
	  
	  tree.inorder();
	  tree.preorder();
	  tree.postorder();
	  tree.levelOrder();
	  
}
}
