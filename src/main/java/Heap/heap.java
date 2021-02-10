package Heap;

public class heap {
	private int[] a;  //数组下标从1开始
	private int n; //堆中可以存储的最多数据个数
	private int count; //堆中已有数据个数

	public heap(int capacity){
		a = new int[capacity+1];
		n = capacity;
		count = 0;
	}

	//新增元素
	public void insert(int data){
		if(count>=n) return; // 堆满了
		++count;
		a[count] = data;
		int i = count;
		while(i/2>=0&&a[i]>a[i/2]){  // 与根节点比较
			swap(a,i,i/2);
			i = i/2;
		}
	}

	//删除元素(删除最大元素堆顶)
	public void removeMax(){
		if(count==0){  // 堆中无元素
			return;
		}
		//将堆底元素换至堆顶从新开始堆化,避免数组空洞
		a[1] = a[count];
		count--;
		heapify(a,count,1);
	}

	//自上而下堆化 堆顶元素向下堆化，找到合适位置放进去
	public void heapify(int[] a,int n, int i){
		while(true){
			int maxPos = i;
			if(i*2<=n&&a[maxPos]<a[i*2]){
				maxPos = i*2;   //小于左节点
			}
			if(i*2+1<=n&&a[maxPos]<a[i*2+1]){
				maxPos = i*2+1; //小于右节点
			}
			if(maxPos==i){//未进行过交换
				break;
			}
			swap(a,i,maxPos);//换过后继续堆化
			i = maxPos;
		}
	}

	public void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
