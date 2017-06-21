package com.work.four.fiveSection;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackArrayDeque<T> {
	private ArrayDeque<T> list;
	private int size;
	
	public StackArrayDeque(int size){
		this.size = size;
		this.list = new ArrayDeque<>(size);
	}
	
	public void push(T t) throws Exception{
		if(list.size()>=size)
			throw new Exception("添加上限");
		list.add(t);
	}
	
	public T pop(){
		T t = list.getLast();
		list.removeLast();
		return t;
	}
	
	public T getTop(){
		return list.getLast();
	}
	
	public boolean isEmpty(){
		return list.size()<=0;
	}
	
	public Deque<T> getList(){
		return list;
	}
}
