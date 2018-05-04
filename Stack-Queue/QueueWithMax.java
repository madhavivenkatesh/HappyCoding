package StacksQueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueWithMax {
	
	private Queue<Integer> entries = new LinkedList<Integer>();
	private Deque<Integer> maxqueue = new LinkedList<Integer>();
	
	public void enque(Integer x){
		entries.add(x);
		while(!maxqueue.isEmpty() && maxqueue.peekLast().compareTo(x)<0){
			maxqueue.removeLast();
		}
		maxqueue.addLast(x);
	}
	
	public int deque(){
		if(!entries.isEmpty()){
			Integer x = entries.remove();
			if(x == maxqueue.peekFirst()){
				maxqueue.removeFirst();
			}
			return x;
		}else
			throw new IllegalStateException("queue is empty");
	}
	
	public int max(){
		if(!maxqueue.isEmpty())
			return maxqueue.peekFirst();
		else
			throw new NoSuchElementException();
	}
	
	public static void main(String[] args){
		QueueWithMax queobj = new QueueWithMax();
		queobj.enque(17);
		queobj.enque(8);
		queobj.enque(9);
		queobj.enque(2);
		queobj.enque(3);
		queobj.enque(10);
		System.out.println(queobj.max());
	}
	
}
