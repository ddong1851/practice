package src.boj.graph_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Main_백준_5639_이진검색트리_골드5_*/
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 빈 루트 노드 생성
		Node root = new Node(0);
		/* 문제 접근
		 * 
		 * --> 루트 노드보다 크면 오른쪽, 작으면 왼쪽
		 * 서브 트리도 마찬가지
		 * 
		 * 전위 순회로 방문된 데이터를 입력받아
		 * 트리를 구성하여
		 * 이를 후위 순회로 반환한하.
		 * 
		 * + 노드의 수는 10000개 이하, 키 값은 100000보다 작은 양수
		 * --> 데이터 관리는 Int 형으로 할 수 있다.
		 * 
		 * 1. 이진 트리를 구현하자
		 * --> add로 트리의 데이터를 초기화
		 * --> 데이터를 후위 순회로 출력
		 */
		// 입력된 데이터가 있을 때
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

	// root는 비교대상 노드, node는 추가하려는 노드
	private static void addNode(Node root, Node node) {
		// 비교대상 노드가 아직 데이터가 없을 때
		if(root.val==0) {
			root = node;
			System.out.println("Node "+node.val+"추가");
		}
		else {
			// 좌측으로 보내기, 좌측 노드와 비교
			if(root.val > node.val) {
				addNode(root.left, node);
			}
			// 우측으로 보내기
			else {
				addNode(root.right, node);
			}
		}
	}
	
	
} // end of Main

/** 트리를 이루는 노드의 정보를 저장하는 데이터 타입*/
class Node{
	// 왼쪽 
	Node left;
	// 오른쪽
	Node right;
	// 값
	public int val;
	// 이진 노드를 만들 때 값을 넣고 홀로 서 있게 양쪽 연결 여부는 null로
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
