package src.prac;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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
        
        Set<N> set1 = new HashSet<N>();
        set1.add(new N(1, 1));
        System.out.println(set.containsAll(set1));  // --> false
        System.out.println(set.contains(set1));
    }
}

class N implements Set{
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
		return row+col;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this.row == ((N)obj).row && this.col == ((N)obj).col) return true;
		return false;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		
		return false;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}