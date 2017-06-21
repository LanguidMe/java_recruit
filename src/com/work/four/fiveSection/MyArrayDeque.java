package com.work.four.fiveSection;

public class MyArrayDeque<E> {
	int head = 0;
	int tail = 0;
	Object[] eletems;
	
	public MyArrayDeque(){
		eletems = new Object[16];
	}
	
	public static void main(String[] args) {
		System.out.println(16&15);
	}
	
	public void addFirst(E e){
		if(e==null)
			throw new NullPointerException();
		eletems[(head = head-1)&(eletems.length-1)] = e;
		if(head == tail)
			capacity();
	}
	
	public void removeFirst(){
		eletems[head] = null;
		head = (head+1)&(eletems.length-1);
	}
	
	public void removeLast(){
		eletems[tail] = null;
		tail = (tail-1)&(eletems.length-1);
	}
	
	private void capacity(){
		assert head == tail;
		int p = head;
		int n = eletems.length;
		int r = n-p;
		int newLength = n<<1;
		if(newLength<0){
			throw new IllegalStateException("Sorry, deque too big");
		}
		Object[] newEletems = new Object[newLength];
		System.arraycopy(eletems, p, newEletems, 0, r); 
	    System.arraycopy(eletems, 0, newEletems, r, p);
	    eletems = newEletems;
	    head = 0;
	    tail = n;
	}
	
	public void addLast(E e){
		if(e==null)
			throw new NullPointerException();
		eletems[tail] =e;
		if(((tail=tail+1)&(eletems.length-1))==head)
			capacity();
	}
}