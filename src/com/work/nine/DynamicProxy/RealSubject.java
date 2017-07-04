package com.work.nine.DynamicProxy;

public class RealSubject implements Subject {

	@Override
	public int request(int a) {
		return a+1;
	}

	@Override
	public String protectGetName() {
		return "protectGetName";
	}

}
