import java.util.*;
public class HeapSort {
	public void heapSort(int arr[], int n) {
		for(int i = n/2-1;i>=0;i--)
			heapify(arr,n,i);
		for(int i = n-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,i,0);
		}
	}
	public void heapify(int arr[], int n ,int m) {
		int largest = m;
		int l = 2*m+1;
		int r = 2*m+2;
		if(l<n && arr[l]>arr[largest])
			largest = l;
		if(r<n && arr[r]>arr[largest])
			largest = r;
		if(largest!=m) {
			int temp = arr[m];
			arr[m] = arr[largest];
			arr[largest] = temp;
			heapify(arr,n,largest);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i = 0; i < n ; i++ )
			arr[i] = sc.nextInt();
		HeapSort heap = new HeapSort();
		heap.heapSort(arr, n);
		for(int i = 0; i < n ; i++ )
			System.out.print(arr[i]+" ");
		sc.close();
	}
}