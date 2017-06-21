package com.work.Two.threeSection;

import java.io.IOException;

/**
 *  数据结构(栈)一	第二题
 */
public class Brackets {
	public static void main(String[] args) throws IOException {
		byte[] buff = new byte[100];
		System.in.read(buff);
		Stack<String> stack = new Stack<>(100);
		try {
			String buf = new String(buff,"utf-8");
			for (int i = 0; i < buf.length(); i++) {
				String s = Character.toString(buf.charAt(i));
				if(s.equals("(")||s.equals("{")||s.equals("[")){
					stack.push(s);
				}else if(s.equals(")")){
					if(stack.getTop().equals("(")){
						stack.pop();
					}else{
						System.out.println("1个不匹配");
						System.exit(1);
					}
				}else if(s.equals("}")){
					if(stack.getTop().equals("{")){
						stack.pop();
					}else{
						System.out.println("2个不匹配");
						System.exit(1);
					}
				}else if(s.equals("]")){
					if(stack.getTop().equals("[")){
						stack.pop();
					}else{
						System.out.println("3个不匹配");
						System.exit(1);
					}
				}
			}
			if(stack.isEmpty()){
				System.out.println("全匹配");
			}else{
				System.out.println("4个不匹配");
			}
		} catch (Exception e) {
			System.out.println("括号不匹配");
		}
	}
}
