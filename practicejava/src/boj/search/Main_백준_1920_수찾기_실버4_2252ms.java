package src.boj.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main_����_1920_��ã��_�ǹ�4_2252ms
 * @author HD
 *
 */
public class Main_����_1920_��ã��_�ǹ�4_2252ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ���� �迭, �����ؾ� �Ѵ�
		int n = sc.nextInt();
		int [] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		// ã�ƾ��ϴ� ���ڵ�
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int find = sc.nextInt();
			System.out.println(binarySearch(nums, find, 0, n-1));
		}
		sc.close();
	}

	private static int binarySearch(int[] nums, int find, int low, int high) {
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==find) {
				return 1;
			}
			if(find<nums[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return 0;
	}
}
