package com.work.nine.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler {
	private Subject subject;
	
	public SubjectInvocationHandler(Subject subject) {
		this.subject = subject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("protectGetName".equals(method.getName())){
			System.out.println("不能调用");
			return null;
		}
		for (Object object : args) {
			if(Integer.class.getName().equals(object.getClass().getTypeName())){
				if(((Integer)object).intValue()!=1){
					System.out.println("不合法");
					return null;
				}
			}
		}
		return method.invoke(subject, args);
	}

}
