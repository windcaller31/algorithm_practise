package sort;

//leetcod 641
public class MyCircularDeque {	
	private static int[] queue = null;
	private static int front = 0;
	private static int rear = 0;
	private static int count = 0;

	/**
	 * Initialize your data structure here. Set the size of the deque to be k.
	 */
	public MyCircularDeque(int k) {
		queue = new int[k];
	}

	/**
	 * Adds an item at the front of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean insertFront(int value) {
		 if (isFull())
	            return false;
	        front = front == 0 ? queue.length - 1 : front - 1;
	        queue[front] = value;
	        count++;
	        return true;

	}

	/**
	 * Adds an item at the rear of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}else{
			queue[rear] = value;
			rear=(rear+1)%queue.length;
			count++;
			return true;			
		}
	}

	/**
	 * Deletes an item from the front of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean deleteFront() {
		if(isEmpty()){
			return false;
		}else{
			front = (front+1)%queue.length;
			count--;
			return true;
		}
	}

	/**
	 * Deletes an item from the rear of Deque. Return true if the operation is
	 * successful.
	 */
	public boolean deleteLast() {
		if(isEmpty()){
			return false;
		}else{
			if(rear==0){				
				rear = queue.length-1;
			}else{
				rear = rear-1;
			}
			count--;
			return true;
		}
	}

	/** Get the front item from the deque. */
	public int getFront() {
		if (isEmpty())
            return -1;
		return queue[front];
	}

	/** Get the last item from the deque. */
	public int getRear() {
		 if (isEmpty())
	            return -1;
		 if(rear==0){
			 return queue[queue.length-1];
		 }else{
			 return queue[rear-1];
		 }
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		if(count==0){
			return true;
		}else{
			return false;
		}
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		if(count==queue.length){
			return true;
		}else{
			return false;
		}
	}
}
