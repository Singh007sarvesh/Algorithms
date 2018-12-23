import java.util.*;
public class QuickSort {
	public void quickSort(int arr[], int l, int h) {
		if(l<h) {
			int pi = partition(arr,l,h);
			quickSort(arr,l,pi-1);
			quickSort(arr,pi+1,h);
		}
	}
	public int partition(int arr[], int l, int h) {
		int pivot = arr[h];
		int i = l-1;
		for(int j = l;j<=h-1;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		return i+1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i = 0;i<n; i++ ) {
			arr[i] = sc.nextInt();
		}
		QuickSort quick = new QuickSort();
		quick.quickSort(arr, 0, n-1);
		for(int i = 0;i<n;i++)
			System.out.print(arr[i]+" ");
		sc.close();
	}
}
