package sort;

public class MergeSort {
	public static void main(String args[]){
		int[] nums = {4,5,6,3,2,1,7};
		int[] temp = new int[nums.length];
		mergeSort(nums,0,nums.length-1,temp);
		System.out.println(temp);
		System.out.println(nums);
	}
	
	
	public static void mergeSort(int[] nums,int start,int end,int[] temp){
		if(start>=end){
			return ;
		}
		int mid = (start+end)/2;
		mergeSort(nums,start,mid,temp);
		mergeSort(nums,mid+1,end,temp);
		merge(nums,start,mid,end,temp);
	}
	
	//left mid right
	public static void merge(int[] nums,int left,int mid,int right,int[] temp){
		int i = left;
		int j = mid+1;
		int t = 0;
		while(i<=mid&&j<=right){
			if(nums[i]<nums[j]){
				temp[t] = nums[i];
				i++;
				t++;
			}else{
				temp[t] = nums[j];
				j++;
				t++;
			}
		}
		while(i<=mid){
			temp[t] = nums[i];
			i++;
			t++;
		}
		while(j<=right){
			temp[t] = nums[j];
			j++;
			t++;
		}
		t = 0;
		while(left<=right){
			  nums[left++] = temp[t++];
		}
	}
}
