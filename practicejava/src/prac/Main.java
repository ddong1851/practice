package src.prac;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


public class Main{
    public static void main(String[] args){
    	
    	String pattern = "[aeiou]";
    	boolean regex = Pattern.matches(pattern, "a");
    	// Pattern matches를 사용하며 2개의 클래스의 각 약 2개 정도의 메서드를 더 타고 들어가야 판단이 가능하다
    	
    	
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