package Search;

public class BinarySearch {
	public static void main(String args[]){
		int nums[]={2,4,6,7,7,7,7,7,7,7};
		int target = 7;
		
		int start = 0;
		int end = nums.length-1;
		int middle = (start+end)/2;		
		while(start<=end){
			if(nums[middle]==target){
				System.out.println(middle);
				break;
			}else if(nums[middle]<target){
				//这个地方mid+1防止死循环
				start = middle+1;
				middle = (start+end)/2;
			}else if(nums[middle]>target){
				//这个地方mid-1防止死循环
				end = middle-1;
				middle = (start+end)/2;
			}
		}
		System.out.println(-1);
	}
}
