package imp;

import java.util.Stack;

/**
 * 
 * Queue Class implemented using two stacks. to be used in the TaleOfTwoStacks problem on HackerRank.
 * 
 * @author Mohamed Sherif.
 *
 * @param <E>
 */

public class MyQueue<E> {

	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();
	
	public void enqueue(E item){
		inbox.push(item);
	}
	
	public E dequeue(){
		if(outbox.isEmpty()){
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
	
	public E peek(){
		if(outbox.isEmpty()){
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.peek();
	}
	
}
