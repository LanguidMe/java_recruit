package com.work.nine.proxy;

public class RealSubject implements Subject {

	@Override
	public void request(int id) {
		System.out.println("RealSubject request method");
	}

	@Override
	public int getId(int a) {
		return a+1;
	}

}
