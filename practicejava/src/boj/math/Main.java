package src.boj.math;

public class Main {
	
	public static void main(String[] args){
		
		StringBuilder sb = new StringBuilder();
		
		// 0. ��ü ������
//		52C6   // 20358520
		int total = nCr(52, 6);
		// 1. ž 
		
		// 2. �� ���
		int onepair = (nCr(13, 1)*nCr(4, 2)*nCr(12, 4)*nCr(4, 1)*nCr(4, 1)*nCr(4, 1)*nCr(4, 1));
		System.out.println(onepair+"/"+total);
		// 3. �� ���
		int twopair = (nCr(13, 2)*nCr(4, 2)*nCr(4, 2)*nCr(44, 2));
		System.out.println(twopair+"/"+total);
		// 4. Ʈ����
		
		// 5. ��Ʈ����Ʈ
		
		// 6. �齺Ʈ����Ʈ
		
		// 7. ����ƾ
		
		// 8. �÷���
		
		// 9. Ǯ�Ͽ콺
		int full = nCr(13, 1)*nCr(4, 3)*nCr(12, 1)*nCr(4, 2)*nCr(44, 1);
		System.out.println(full+"/"+total);
		// 10. ��ī��
		int four = nCr(13, 1)*nCr(4, 4)*nCr(48, 2);
		System.out.println(four+"/"+total);
		// 12. �ξ� ��Ʈ����Ʈ ������
		int royal = nCr(4, 1)*nCr(47, 1);
		System.out.println(royal+"/"+total);
		// 11. ��Ʈ����Ʈ �÷���
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
