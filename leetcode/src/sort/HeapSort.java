package sort;

import util.Printer;

//由于从0开始则 节点i 父节点(i-1)/2  左子2*i+1 右子2*i+2
//如果从1开始则 节点i 父节点(i)/2  左子2*i 右子2*i+1
public class HeapSort {
	public static void main(String args[]){
		int[] a={3,4,6,1,2,9,8,7};
		sort(a);
	}

	public static void sort(int[] a){
		//建堆
		buildHeap(a,a.length-1);
		int k = a.length-1;
		//大顶堆，把大元素放到第最后一位k，然后k--剩下的位堆化，第二大的就到堆顶了，重复这一轮回
		while(k>0){
			swap(a,0,k);
			k--;
			buildHeap(a ,k);
		}
		System.out.print(Printer.printArray(a));
	}

	public static void buildHeap(int[]a , int n){
		for(int i = (n-1)/2;i>=0;--i){  //传进来的数组a，看成完全二叉树。从非叶节点开始进行堆化建堆
			heapify(a,n,i);
		}
	}

	//上至下堆化 建堆
	public static void heapify(int[] a,int n, int i){
		while(true){
			int maxPos = i;
			if(i*2+1<=n&&a[maxPos]<a[i*2+1]){
				maxPos = i*2+1;
			}
			if(i*2+2<=n&&a[maxPos]<a[i*2+2]){
				maxPos = i*2+2;
			}
			if(maxPos==i){
				break;
			}
			swap(a,i,maxPos);
			i = maxPos;
		}
	}

	public static void swap(int[] a,int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
