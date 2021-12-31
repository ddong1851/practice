package src.book;

public class quick_sort {

    static int[] a = {5, 7, 9, 0 ,3, 1, 6, 2, 4, 8};
    public static void main(String[] args) {
        int s = 0;
        int e = a.length-1;
        quickSort(a, s, e);

        for(int i : a){
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;
        while(left <= right){
            while(left <= end && a[left] <= a[pivot])
                left++;
            while(right > start && a[right] >= a[pivot])
                right--;
            if(left > right){
                int temp = a[right];
                a[right] = a[pivot];
                a[pivot] = temp;
            }
            else{
                int temp = a[left];
                a[left] = a[right];
                a[pivot] = temp;
            }
        }
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }
}
