package src.boj.graph_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_����_5639_�����˻�Ʈ��_���5_*/
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �� ��Ʈ ��� ����
		Node root = new Node(0);
		/* ���� ����
		 * 
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
		 * --> �����͸� ���� ��ȸ�� ���
		 */
		// �Էµ� �����Ͱ� ���� ��
		while(true) {
			
			try{
				int val = Integer.parseInt(br.readLine());
				Node node = new Node(val);
				addNode(root, node);
			} catch (Exception e) {
				break;
			}
			
			
		} // end of while
	} // end of main

	// root�� �񱳴�� ���, node�� �߰��Ϸ��� ���
	private static void addNode(Node root, Node node) {
		// �񱳴�� ��尡 ���� �����Ͱ� ���� ��
		if(root.val==0) {
			root = node;
			System.out.println("Node "+node.val+"�߰�");
		}
		else {
			// �������� ������, ���� ���� ��
			if(root.val > node.val) {
				addNode(root.left, node);
			}
			// �������� ������
			else {
				addNode(root.right, node);
			}
		}
	}
	
	
} // end of Main

/** Ʈ���� �̷�� ����� ������ �����ϴ� ������ Ÿ��*/
class Node{
	// ���� 
	Node left;
	// ������
	Node right;
	// ��
	public int val;
	// ���� ��带 ���� �� ���� �ְ� Ȧ�� �� �ְ� ���� ���� ���δ� null��
	public Node(int val) {
		super();
		this.val = val;
		setLeft(null);
		setRight(null);
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}
