package StacksQueues;

import java.util.Arrays;
import java.util.Collections;

public class CircularQueue {
	
	public  int head=0,tail=0,numofelements=0;
	private static final int scalefactor =2;
	public Integer[] queue;
	
	public CircularQueue(int capacity){
		queue = new Integer[capacity];
	}
	
	public  void enqueue(Integer x){
		if(numofelements == queue.length){
			Collections.rotate(Arrays.asList(queue),-head);
			head = 0;
			tail = numofelements;
			queue = Arrays.copyOf(queue, numofelements * scalefactor);
		}
		queue[tail] = x;
		tail = (tail+1)%queue.length;
		++numofelements;
	}
	
	public  int dequeue(){
		if(numofelements!=0){
			--numofelements;
			int x = queue[head];
			head = (head+1)%queue.length;
			return x;
		}else
			throw new IllegalArgumentException();
	}
	
	public static void main(String[] args){
		CircularQueue queue = new CircularQueue(4);
		queue.enqueue(4);
		queue.enqueue(2);
		queue.enqueue(1);
		queue.enqueue(5);
		queue.enqueue(6);
	}
 
}
