package src.book;

class insertion_sort{
    
    static int[] data = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    
    public static void main(String[] args) {
        
        //삽입 정렬은 두 번째 데이터부터 시작한다. 첫째는 그 자체로 정렬되었다고 판단
        for(int i=1; i<data.length; i++){
            //정렬할 데이터를 선택
            int target = data[i];
            //선택된 데이터의 왼쪽부터 탐색(이미 정렬되어 있기 때문에, 효율적이다)
            int j = i-1;

            //탐색할 순번이 0보다 크고, target보다 큰 데이터가 있을 때 자리 바꿈
            while(j>=0 && target < data[j]){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = target;
        }

        for(int i : data)
            System.out.println(i);
    }
}