package BasicAlgorithm;

public class InverseOrderDegree {
	public static void main(String args[]) {
		int[] s = {2,4,3,1,5,6};
		count(s,s.length);
	}
	
	private static int num = 0;

	public static int count(int[] a, int n) {
		num = 0;
		mergeSort(a, 0, n - 1);
		return num;
	}

	public static void mergeSort(int[] a, int p, int r) {
		if (p >= r) {
			return;
		}
		int q = (p + r) / 2;
		mergeSort(a, p, q);
		mergeSort(a, q + 1, r);
		merge(a, p, q, r);
	}

	public static void merge(int a[], int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int k = 0;
		int[] tmp = new int[r-p+1];
		while(i<=q&&j<=r) {
			//无逆序
			if(a[i]<=a[j]) {
				tmp[k++]=a[i++];
			}else {//有逆序
				tmp[k++]=a[j++];
				num+=(q-i+1);//p到q为有序的，所以可以直接加，而且分治递归从 两个数字开始合并
				//比如 4 3 2 1 第一次是 43 然后是 21 然后是 421 321 这样去理解
			}
		}
		while(i<=q) {
			tmp[k++] = a[i++];
		}
		while(k<=r) {
			tmp[k++] = a[j++];
		}
		for(int l =0;l<=r-p;l++) {
			a[p+l] = tmp[l];
		}
	}
}
