package src.prac;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


public class Main{
    public static void main(String[] args){
    	
    	String pattern = "[aeiou]";
    	boolean regex = Pattern.matches(pattern, "a");
    	// Pattern matches�� ����ϸ� 2���� Ŭ������ �� �� 2�� ������ �޼��带 �� Ÿ�� ���� �Ǵ��� �����ϴ�
    	
    	
        Set<N> set = new HashSet<N>();
        set.add(new N(1, 1));
        set.add(new N(1, 1));
        set.add(new N(1, 1));
        set.add(new N(1, 1));
        System.out.println(set.size());
    }
}

class N{
	public int row;
	public int col;
	public N(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof N) {
			if(this.hashCode()==obj.hashCode() && 
					(this.row ==((N) obj).row && this.col == ((N)obj).col)){
				return true;
			}
			
		}
		return false;
	}
}