package src.boj.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Main_����_14891_��Ϲ���_�ǹ�1_128ms*/
public class Main_����_14891_��Ϲ���_�ǹ�1_128ms {
	
	static String[] chains;
	static boolean[] rotated;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ��Ϲ��� ������ �ʱ�ȭ
		chains = new String[4];
		for(int i=0; i<4; i++) {
			chains[i] = br.readLine();
		}
		
		// ȸ�� Ƚ�� �ʱ�ȭ
		int K = Integer.parseInt(br.readLine());
		
		//K�� ȸ��
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int chain = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotated = new boolean[4];
			// ������ ��Ϲ����� ������ �������� ȸ��
			rotate(chain, dir, true, 0);
		}
		
		
		// ������ ���� ���ϰ� ���
		int count = 0;
		for(int i=0; i<4; i++) {
			count+=calc(i);
		}
		
		System.out.println(count);
	} // end of main

	private static int calc(int chain) {
		// 12�� ������ N���̶��
		if(chains[chain].charAt(0)=='0') {
			return 0;
		}
		// S���̸� 2�� i���� ��ȯ
		else {
			return (int) Math.pow(2, chain);
		}
	} // end of calc

	// ��������� ���� �����Ͽ� ȸ��
	private static void rotate(int chain, int dir, boolean first, int direction) {
		int ch = chain-1;
		// ���� Ȯ��
		if(ch<0 || ch>3) {
			return;
		}
		// �̹� ���ȴ� ������� 
		if(rotated[ch]) {
			return;
		}
		// �������� ���� �������� ���� 
		boolean right = false;
		boolean left = false;
		// ù��° ȸ���̶�� ������ ����
		if(first) {
			// ȸ�� ���� ���� �¿��� Ž�� ���� �˻�
			if(ch>=1) {
				if(chains[ch].charAt(6)!=chains[ch-1].charAt(2)) {
					left = true;
				}
			}
			if(ch<=2) {
				if(chains[ch].charAt(2)!=chains[ch+1].charAt(6)) {
					right = true;
				}
			}
		} // end of first Rotation
		
		// �Ļ��� ȸ���̶��
		else {
			// ù��° ���� �������� �������̶��
			if(direction==1) {
				// ���� ������ 2�� �ε����� ���� ������ 6�� �ε����� ��
				if(ch <= 2 && chains[ch].charAt(2)!=chains[ch+1].charAt(6)) {
					right = true;
				}
			}
			else {
				if(ch >= 1 && chains[ch].charAt(6)!=chains[ch-1].charAt(2)) {
					left = true;
				}
			}
		} // end of Rotation
		
		// ȸ�� ����
		changeString(ch, dir);
		rotated[ch] = true;
		
		// �¿� ȸ��
		if(right) {
			rotate(chain+1, dir*-1, false, 1);
		}
		if(left) {
			rotate(chain-1, dir*-1, false, -1);
		}
	} // end of rotate
	
	private static void changeString(int chain ,int dir) {
		StringBuilder sb = new StringBuilder();
		if(dir==1) {
			sb.append(chains[chain].charAt(7)).append(chains[chain].substring(0, 7));
		}
		else {
			sb.append(chains[chain].substring(1, 8)).append(chains[chain].charAt(0));
		}
		chains[chain] = sb.toString();
	} // end of changeString
} // end of class
