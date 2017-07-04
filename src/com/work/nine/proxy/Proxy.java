package com.work.nine.proxy;

public class Proxy implements Subject{
	private Subject subject;
	
	private Object params;
	private Object returnObject;
	
	public Proxy(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public void request(int id) {
		subject.request(id);
	}

	@Override
	public int getId(int a) {
		params = a;
		Object result = subject.getId(a);
		returnObject = result;
		return (int) result;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}
}
