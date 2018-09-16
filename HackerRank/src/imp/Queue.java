package imp;

public class Queue {
	private static class Node{
		private int data;
		private Node next;
		private Node(int data){
			this.data = data;
		}
	}
	
	private Node head; // Remove from the head.
	private Node tail; // Add thing here.
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int peek(){
		return head.data;
	}
	
	/**
	 * Enqueue: add a new element to the end of the queue.
	 * @param data
	 */
	public void add(int data){
		Node node = new Node(data);
		
		if(tail != null){
			tail.next = node;
		}
		tail = node;
		if(head == null){
			head = node;
		}
	}
	
	/**
	 * Dequeue: remove the element from the front of the queue and return it.
	 * @return
	 */
	public int remove(){
		int data = head.data;
		head = head.next;
		if(head == null){
			tail = null;
		}
		return data;
	}
}
