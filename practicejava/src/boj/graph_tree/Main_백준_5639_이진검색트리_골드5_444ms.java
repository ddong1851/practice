package src.boj.graph_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_����_5639_�����˻�Ʈ��_���5_444ms*/
public class Main_����_5639_�����˻�Ʈ��_���5_444ms {
	
	static StringBuilder sb = new StringBuilder();
	// �� ��Ʈ ��� ����
	static Node root = null;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/* ���� ����
		 * --> ��Ʈ ��庸�� ũ�� ������, ������ ����
		 * ���� Ʈ���� ��������
		 * 
		 * ���� ��ȸ�� �湮�� �����͸� �Է¹޾�
		 * Ʈ���� �����Ͽ�
		 * �̸� ���� ��ȸ�� ��ȯ����.
		 * 
		 * + ����� ���� 10000�� ����, Ű ���� 100000���� ���� ���
		 * --> ������ ������ Int ������ �� �� �ִ�.
		 * 
		 * 1. ���� Ʈ���� ��������
		 * --> add�� Ʈ���� �����͸� �ʱ�ȭ
		 * --> root�� �ʱ�ȭ���� �ʾҴٸ� root �ʱ�ȭ
		 * --> �ʱ�ȭ �Ǿ��ٸ� value ���Ͽ� �������� ����, �������� ���� ��
		 * --> ��尡 ����ٸ� �ش� �ڸ��� ����
		 * --> �����͸� ���� ��ȸ�� ���
		 */
		
		// �Էµ� �����Ͱ� ���� �� ���� Ʈ�� �ʱ�ȭ
		while(true) {
			try{
				int val = Integer.parseInt(br.readLine());
				addNode(val);
			} catch (Exception e) {
				break;
			}
		} // end of while
		// ���� ��ȸ ����� sb�� ����
		PostPrintTree(root);
		// ������ȸ ������ ���
		System.out.println(sb.toString());
		
	} // end of main

	
	private static void PostPrintTree(Node root) {
		// L -> R -> Root
		if(root==null) return;
		PostPrintTree(root.left);
		PostPrintTree(root.right);
		
		sb.append(root.val).append("\n");
	}

//	ȥ�� © �� curr.left = new Node(val);
//	�� �κ��� curr = new Node(val) �� �ϸ鼭 ��带 �ʱ�ȭ �߾��µ�
//	�̷��� �ϸ� left right�� �ʱ�ȭ���� �ʴ´�.
//	�ݺ������� �ذ�
	private static void addNode(int val) {
		// root�� null �̸� �ʱ�ȭ
		if(root==null) {
			root = new Node(val);
		}
		// root�� null�� �ƴ� ���
		else {
			// ��Ʈ ��� �������� �� ������ ����, �� ũ�� ������
			Node top = root;
			Node curr;
			// �������� ������ �ϴ� ���
			while(true) {
				// �񱳴�� ���
				curr = top;
				// ���� ��� ���� ��, ���� ��尪�� �� ũ�� ��������
				if(top.val > val) {
					top = top.left;
					// �� ��带 ������ �ȴٸ� �ʱ�ȭ
					if(top==null) {
						curr.left = new Node(val);
						break;
					}
				}
				// ���� ��� ���� �� �۴ٸ� ����������
				else {
					top = top.right;
					if(top==null) {
						curr.right = new Node(val);
						break;
					}
				}
			} // end of while
		} // end of else
	} // end of addNode
	
} // end of Main

/** Ʈ���� �̷�� ����� ������ �����ϴ� ������ Ÿ��*/
class Node{
	// ���� 
	public Node left;
	// ������
	public Node right;
	// ��
	public int val;
	// ���� ��带 ���� �� ���� �ְ� Ȧ�� �� �ְ� ���� ���� ���δ� null��
	public Node(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
