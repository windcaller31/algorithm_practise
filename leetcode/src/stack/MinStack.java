package stack;
//minstackarray
public class MinStack {
	private int[] nums;
	int top;
	int bottom;
	// 0 top  nums.length-1 bottom
	
//	public static void main(String args[]){
//		MinStack minStack = new MinStack();
//		minStack.push(-2);
//		minStack.push(-0);
//		minStack.push(-3);
//		minStack.pop();
//		minStack.top();
//		System.out.println(minStack.getMin());
//	}
	
	/** initialize your data structure here. */
    public MinStack() {
    	nums = new int[10];
    	top = 0;
    	bottom = 0;
    }
    
    public void push(int x) {
    	if(bottom!=nums.length-1){
    		nums[bottom]=x;
    		bottom++;
    	}else{
    		int[] new_nums = new int[nums.length*2];
    		for(int index=0;index<nums.length;index++){
    			new_nums[index] = nums[index];
    		}
    		nums = new_nums;
    		nums[bottom]=x;
    		bottom++;
    	}
    }
    
    public void pop() {
    	if(top==0&&top==bottom){
			
		}
		nums[bottom-1] = nums[bottom]; 
		bottom--;
    }
    
    public int top() {
    	return nums[bottom-1];
    }
    
    public int getMin() {
        int min = nums[top];
        for(int index=top;index<bottom;index++){
        	min = Math.min(nums[index], min);
        }
        return min;
    }	
}
