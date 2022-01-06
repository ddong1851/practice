package src.book.dynamic;

public class pibo {
    public static long[] d = new long[100];

    public static long fibo(int x){
        //종료조건 일 때
        if(x==1||x==2) return 1;
        //이미 계산한 적이 있는 문제라면, 그대로 반환
        if(d[x] != 0) return d[x];
        //아직 계산하지 않은 문제에 대하여 점화식에 따라 피보나치 결과 반환
        d[x] = fibo(x-1) + fibo(x-2);
        return d[x];
    }

    public static void main(String[] args) {
        System.out.println(fibo(50));
        // 50부터 작아지는 형태인 탑 다운
    }

}
