import java.util.*;
public class MergeSort {
	public void mergeSort(int arr[], int l, int h) {
		if(l<h) {
			int m = l+(h-l)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,h);
			merge(arr,l,m,h);
		}
	}
	public void merge(int arr[], int l, int m, int h) {
		int len1 = m-l+1;
		int len2 = h-m;
		int a[] = new int[len1+1];
		int b[] = new int[len2+1];
		for(int i = 0;i<len1;i++)
			a[i] = arr[l+i];
		for(int i = 0;i<len2;i++)
			b[i] = arr[m+1+i];
		int i = 0, j = 0, k= l;
		while(i<len1 && j < len2) {
			if(a[i]<b[j])
				arr[k++] = a[i++];
			else
				arr[k++] = b[j++];
		}
		while(i<len1)
			arr[k++] = a[i++];
		while(j<len2)
			arr[k++] = b[j++];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i= 0; i < n ; i++)
			arr[i] = sc.nextInt();
		MergeSort merge = new MergeSort();
		merge.mergeSort(arr, 0, n-1);
		for(int i =0 ; i < n; i++)
			System.out.print(arr[i]+" ");
	}
}
