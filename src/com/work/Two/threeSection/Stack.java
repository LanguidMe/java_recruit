package com.work.Two.threeSection;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	private ArrayList<T> list;
	private int size;
	
	public Stack(int size){
		this.size = size;
		this.list = new ArrayList<>(size);
	}
	
	public void push(T t) throws Exception{
		if(list.size()>=size)
			throw new Exception("添加上限");
		list.add(t);
	}
	
	public T pop() throws Exception{
		int a = list.size();
		if(a<=0)
			throw new Exception("已经没有数据");
		int b = a -1;
		T t = list.get(b);
		list.remove(b);
		return t;
	}
	
	public T getTop(){
		int a = list.size();
		if(a<=0)
			return null;
		T t = list.get(a-1);
		return t;
	}
	
	public boolean isEmpty(){
		return list.size()==0;
	}
	
	public List<T> getList(){
		return list;
	}
}