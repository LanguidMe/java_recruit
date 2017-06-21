package com.work.four.fiveSection;

import java.util.LinkedList;
import java.util.List;

public class StackLinkedList<T> {
	private LinkedList<T> list;
	
	public StackLinkedList(){
		this.list = new LinkedList<>();
	}
	
	public void push(T t){
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
	
	public List<T> getList(){
		return list;
	}
}