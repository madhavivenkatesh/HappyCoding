package StacksQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree{
	int value;
	BinaryTree left;
	BinaryTree right;
	
	 public BinaryTree(int value,BinaryTree left,BinaryTree right){
		 this.value = value;
		 this.left = left;
		 this.right = right;
		 
	 }
}

public class IncreasingOrderDepth {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Queue<BinaryTree> currentqueue = new LinkedList<BinaryTree>();
	
	public  List<List<Integer>> createDepthList(BinaryTree root){
		currentqueue.add(root);
		while(!currentqueue.isEmpty()){
			Queue<BinaryTree> newqueue = new LinkedList<BinaryTree>();
			ArrayList<Integer> currlist = new ArrayList<Integer>();
			while(!currentqueue.isEmpty()){
				BinaryTree curr = currentqueue.poll();
				if(curr!=null){
					currlist.add(curr.value);
					newqueue.add(curr.left);
					newqueue.add(curr.right);
				}
			}
			if(!currlist.isEmpty())
				result.add(currlist);
			
			currentqueue = newqueue;
		}
		return result;
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(1,null,null);
		root.left = new BinaryTree(2,null,null);
		root.right = new BinaryTree(3,null,null);
		IncreasingOrderDepth obj = new IncreasingOrderDepth();
		List<List<Integer>> depthlist = obj.createDepthList(root);
		for(List<Integer> list:depthlist)
			System.out.println(list);
	}
}
