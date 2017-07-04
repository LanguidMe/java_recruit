package com.work.nine.proxy;

public class Client {
	public static void main(String[] args) {
		Subject s = new RealSubject();
		Proxy proxy = new Proxy(s);
		proxy.getId(1);
		System.out.println(proxy.getParams()+","+proxy.getReturnObject());
	}
}
