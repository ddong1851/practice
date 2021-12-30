package src.book;

public class binary_search {
    /**
     * 이진 탐색 = 이분 탐색
     * 이진 탐색의 시간 복잡도는 O(log n)
     * 정렬된 배열 또는 리스트에 적합한 고속 탐색 방법이다.
     * 배열의 중앙에 있는 값을 기준으로 왼쪽인지 오른쪽인지 알아내어
     * 범위를 반으로 줄이며 탐색하는 기법
     * 3-1. key > mid :  구하고자 하는 값이 중간값보다 높다면 low를 mid +1로 만들어 줌 (왼쪽 반을 버림)
     * 3-2. key < mid : 구하고자하는 값이 중간값 보다 낮다면 high를 mid-1로 만들어 줌 (오른쪽 반을 버림)
     * 3-3. key == mid : 구하고자 하는 값을 찾음 중간값 리턴 (index를 반환)
     */
    
     static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};
     public static void main(String[] args) {
        System.out.println("1. 순환 호출을 이용한 이진 탐색");
        System.out.println(binarySearch(5, 0, arr.length-1));

        System.out.println("---------------------------------");

        System.out.println("2. 반복 구조를 이용한 이진 탐색");
        System.out.println(binarySearch2(35, 0, arr.length-1));
     }

     //순환 호출 사용(재귀적)
     static int binarySearch(int key, int low, int high){
        int mid;
        if(low<=high){
            mid = (low + high) / 2;
            if(key == arr[mid]){
                return mid;
            }
            else if(key<arr[mid]) return binarySearch(key, low, mid-1);
            else return binarySearch(key, mid+1, high);
        }
        //탐색 실패
        return -1;
     }
     // 반복 구조를 사용한 이분 탐색
     static int binarySearch2(int key, int low, int high){
         int mid;

         while(low<=high){
             mid = (low + high)/2;
             if(key == arr[mid])
                return mid;
             else if(key < arr[mid]) high = mid - 1;
             else low = mid + 1;
         }
         //탐색 실패
         return -1;
     }
}
