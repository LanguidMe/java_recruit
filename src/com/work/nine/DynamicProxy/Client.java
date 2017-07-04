package com.work.nine.DynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		SubjectInvocationHandler handler = new SubjectInvocationHandler(subject);
		Subject s = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
		s.protectGetName();
		s.request(2);
	}
}
