package src.boj.math;

public class Main {
	
	public static void main(String[] args){
		
		StringBuilder sb = new StringBuilder();
		
		// 0. 전체 가지수
//		52C6   // 20358520
		int total = nCr(52, 6);
		// 1. 탑 
		
		// 2. 원 페어
		int onepair = (nCr(13, 1)*nCr(4, 2)*nCr(12, 4)*nCr(4, 1)*nCr(4, 1)*nCr(4, 1)*nCr(4, 1));
		System.out.println(onepair+"/"+total);
		// 3. 투 페어
		int twopair = (nCr(13, 2)*nCr(4, 2)*nCr(4, 2)*nCr(44, 2));
		System.out.println(twopair+"/"+total);
		// 4. 트리플
		
		// 5. 스트레이트
		
		// 6. 백스트레이트
		
		// 7. 마운틴
		
		// 8. 플러쉬
		
		// 9. 풀하우스
		int full = nCr(13, 1)*nCr(4, 3)*nCr(12, 1)*nCr(4, 2)*nCr(44, 1);
		System.out.println(full+"/"+total);
		// 10. 포카드
		int four = nCr(13, 1)*nCr(4, 4)*nCr(48, 2);
		System.out.println(four+"/"+total);
		// 12. 로얄 스트레이트 를러쉬
		int royal = nCr(4, 1)*nCr(47, 1);
		System.out.println(royal+"/"+total);
		// 11. 스트레이트 플러쉬
		int SF = nCr(4, 1)*10*nCr(47,1)-royal;
		System.out.println(SF+"/"+total);
		
		
	} // end of main
	
	private static int nCr(int n, int r) {
		long top, bottom;
		top = bottom = 1;
		for(int i=0; i<r; i++) {
			top*=(n-i);
			bottom*=(r-i);
		}
		return (int)(top/bottom);
	}
	
} // end of class 
