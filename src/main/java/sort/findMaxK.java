package sort;

public class findMaxK {
	public static void main(String args[]){
		int[] nums = {4,7,3,2,5,9,1};
		System.out.println(findK(nums,0,6,2));
	}
	
	public static int findK(int[] a,int left,int right,int k){
		int p = partition(a,left,right);
		if(a.length-p-1==k){
			return a[p];
		}else if(a.length-p-1>k){
			return findK(a,p+1,right,k);
		}else if(a.length-p-1<k){
			return findK(a,left,p-1,k);
		}else{
			return -1;
		}
	}
	
	public static int partition(int[] a,int left,int right){
		int pivot = a[right];
		int i = left;
		for(int j = i+1;j<right;j++){
			if(a[j]<pivot){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		a[right] = a[i];
		a[i] = pivot;
		return i;
	}
	
	
//	public static int partition(int[] a,int left,int right){
//		int pivot = a[right];
//		int i = left;
//		for(int j =i+1;j<right;j++){
//			if(a[j]<pivot){
//				int temp = a[i];
//				a[i] = a[j];
//				a[j] = temp;
//				i++;
//			}
//		}
//		int temp = a[i];
//		a[i] = a[right];
//		a[right] = temp;
//		return i;
//	}
	
}
