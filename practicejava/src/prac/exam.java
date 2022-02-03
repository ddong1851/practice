package src.prac;

import java.util.Scanner;

class Parent {
	int a;
	int b;
	public Parent(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public int getA() {
		System.out.println(a);
		// 이 경우는 재귀에 빠지게 되어 본인의 a인 1만 출력하다가 끝난다 --> 런타입 에러가 된다.
//		this.getA();
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
}

public class exam extends Parent{
    public exam(int a, int b) {
		super(a, b);
	}
    
    public exam() {
    	super(1, 2);
    }
    
    public int getA() {
    	super.getA();
		return 100;
    }

	public static void main(String[] args) {
  
    	Scanner sc = new Scanner(System.in);
    	int n =sc.nextInt();
    	switch(n) {
    	case 1:
    		break;
    		
    	}
    	for (int i = 0; i < args.length; i++) {
			String string = args[i];
		}

        Parent p = new exam();
        System.out.println(p.getB());
        System.out.println(p.getA());
        System.out.println();
    }
}
