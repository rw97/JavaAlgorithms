package SearchingSorting;

public class MergeSort {
    public static void merge(int[] arr, int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1], R = new int[n2];  // creates temp arrays

        for (i = 0; i < n1; i ++) {
            L[i] = arr[l + i];
        }

        for (j = 0; j < n2; j ++) {
            R[j] = arr[m + 1 + j];
        }

        i = 0; j = 0; k = l;

        // Compares the elements of two subarrays and merges them
        while(i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copies the remaining elements of L[], if there are any
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copies the remaining elements of R[], if there are any
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }
    
    public static void main(String[] args) {
    	int[] a = { 3, 5, 8, 2, 1, 0, -3 };
		mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
    }
}
