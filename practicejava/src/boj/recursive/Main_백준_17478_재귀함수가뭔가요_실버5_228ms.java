package src.boj.recursive;

import java.util.Scanner;

/** Main_����_17478_����Լ���������?_�ǹ�5_228ms*/
public class Main_����_17478_����Լ���������_�ǹ�5_228ms {
	// ��� ������ underbar
	static String underbar="";
	// �߰��� ������ ���ڿ�
	final static String addbar ="____";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		// ù ���� ȣ�� �� ����Լ� ����
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recursion(n);
	}

	private static void recursion(int n) {
		// �̷��� �������� ������, ��� �亯�Ͽ��� �� lines�� staticNum�� ����Ǿ� �پ���� �ʴ´�
		String lines = underbar;
		// n�� 0�϶� ������ ��� �� ��� ����
		if(n==0) {
			System.out.println(lines+"\"����Լ��� ������?\"");
			System.out.println(lines+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(lines+"��� �亯�Ͽ���.");
			// �޼��� ����
			return;
		}
		// 0�� �ƴ� �� ����� �ϰ�, underbar�� ____�� �߰��ϰ�, ���� ��� ȣ��
		System.out.println(lines + "\"����Լ��� ������?\"");
		System.out.println(lines + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(lines + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println(lines + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		underbar += addbar;
		recursion(n - 1);
		System.out.println(lines+"��� �亯�Ͽ���.");
	}
}
