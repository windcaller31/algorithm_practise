package Queue;

//leetcode 622
public class MyCircularQueue {
	private Integer[] container = null;
	private int top;
	private int rear;
	private int len;
	
	public static void main(String args[]){
		MyCircularQueue queue = new MyCircularQueue(6);
		queue.enQueue(6);
		queue.Rear();
		queue.Rear();
		queue.deQueue();
		queue.enQueue(5);
		queue.Rear();
		queue.deQueue();
		System.out.println(queue.Front());
	}
	
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
    	container = new Integer[k+1];
    	len = k+1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if((rear+1)%len!=top){
        	container[rear] = value;
        	rear = (rear+1)%len;
        	return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(rear!=top){
//        	container[top] = null;
        	top = (top+1)%len;
        	return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(rear==top){
    		return -1;
    	}
        return container[top];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(rear==top){
    		return -1;
    	}else if(rear-1<0){
    		return container[container.length-1];	
    	}else{
    		return container[rear-1];
    	}
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear==top;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1)%len==top;
    }
}
