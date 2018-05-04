import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class MaxWithCount{
	int value;
	int count;
	
	public MaxWithCount(int value,int count){
		this.value=value;
		this.count=count;
	}
}

public class StackWithMax {
	Deque<Integer> stack = new LinkedList<Integer>();
	Deque<MaxWithCount> maxstack = new LinkedList<MaxWithCount>();
	
	public void push(Integer x){
		stack.addFirst(x);
		if(!maxstack.isEmpty()){
			if (maxstack.peekFirst().value==x){
				maxstack.peekFirst().count = maxstack.peekFirst().count+1;
			}else if (x>maxstack.peekFirst().value)
				maxstack.addFirst( new MaxWithCount(x,1));
		}else
			maxstack.addFirst( new MaxWithCount(x,1));
	}
	
	public Integer pop(){
		Integer element = stack.removeFirst();
		if(!maxstack.isEmpty() && maxstack.peekFirst().value==element){
			maxstack.peekFirst().count = maxstack.peekFirst().count-1;
			if(maxstack.peekFirst().count<=0)
				maxstack.removeFirst();
		}
		return element;
	}
	
	public Integer max(){
		if(!maxstack.isEmpty())
			return maxstack.peekFirst().value;
		else
			throw new NoSuchElementException("Stack might be empty");
	}
	
	public void printstack(){
		for(Integer i:stack)
			System.out.println(i);
	}
	
	public static void main(String[] args){
		StackWithMax obj = new StackWithMax();
		obj.push(3);
		obj.push(4);
		obj.push(7);
		obj.push(5);
		obj.push(4);
		obj.printstack();
		System.out.println(obj.max());
		
	}

}
