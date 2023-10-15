package Lap4;

public class DivideAndConquerApproach {
	// Merge hai mảng con của arr[].
    // Mảng con thứ nhất là arr[first..middle]
    // Mảng con thứ hai là arr[middle+1..last]
    private static void merge(int arr[], int first, int middle, int last) {

        // Tìm kích thước của 2 mảng con để merged
        int n1 = middle - first + 1;
        int n2 = last - middle;

        // Tạo mảng tạm
        int f[] = new int[n1];
        int l[] = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; ++i)
            f[i] = arr[first + i];
        for (int j = 0; j < n2; ++j)
            l[j] = arr[middle + 1 + j];

        // Merge các mảng tạm lại

        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int k = first;
        while (i < n1 && j < n2) {
            if (f[i] >= l[j]) {
                arr[k] = f[i];
                i++;
            } else {
                arr[k] = l[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của f[] nếu có
        while (i < n1) {
            arr[k] = f[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của l[] nếu có
        while (j < n2) {
            arr[k] = l[j];
            j++;
            k++;
        }
    }

     private static void sort(int arr[], int first, int last) {
    	
        if (first < last) {

            // Tìm điểm chính giữa
            int middle = (first + last) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            sort(arr, first, middle);
            sort(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
     }
     
     public static void mergeSort(int[] array) {
    	 sort(array, 0, array.length-1);
     }
     
     
     // Hàm nhận phần tử cuối cùng làm chốt,
     // đặt các phần tử nhỏ hơn chốt ở trước
     // và lớn hơn ở sau nó
     private static int partition(int arr[], int low, int high) {
         int pivot = arr[high];
         int i = (low - 1); // index of smaller element
         for (int j = low; j < high; j++) {

             // Nếu phần tử hiện tại nhỏ hơn chốt
             if (arr[j] < pivot) {
                 i++;

                 // swap arr[i] và arr[j]
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
             }
         }

         // swap arr[i+1] và arr[high] (hoặc pivot)
         int temp = arr[i + 1];
         arr[i + 1] = arr[high];
         arr[high] = temp;

         return i + 1;
     }

     // arr[] --> Mảng cần được sắp xếp,
     // low --> chỉ mục bắt đầu,
     // high --> chỉ mục kết thúc
     public static void quickSort(int arr[], int low, int high) {
         if (low < high) {

             // pi là chỉ mục của chốt, arr[pi] vị trí của chốt
             int pi = partition(arr, low, high);

             // Sắp xếp đệ quy các phần tử
             // trướcphân vùng và sau phân vùng
             quickSort(arr, low, pi - 1);
             quickSort(arr, pi + 1, high);
         }
     }
    // in mang ra mang hinh
 	private static void display(int[] array) {
 		if (array.length == 0) System.out.print("null");
 		else
 			for (int i = 0; i< array.length; i++)
 				System.out.print(array[i] + "\t");
 	}
 	
     public static void main(String[] args) {
    	 int[] arr1 = {10, 6, 4, 8, 2, 1};
    	 mergeSort(arr1);
    	 display(arr1);
    	 System.out.println();
    	 
    	 int[] arr2 = {10, 6, 4, 8, 2, 1};
    	 quickSort(arr2, 0, arr2.length-1);
    	 display(arr2);
	}
}
