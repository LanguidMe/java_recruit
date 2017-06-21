package com.work.four.fiveSection.test;

import com.work.Two.threeSection.Stack;
import com.work.four.fiveSection.StackArrayDeque;
import com.work.four.fiveSection.StackLinkedList;

/**
 * 当数量小的时候 三个效率差不多(前提是arrayList和arrayDeque需要提前给好大小)  数量小时 相对linkedList和arrayDeque整体比较效率高点
 * 当数量大的时候 arrayDeque效率最高,其次是arrayList(前提是arrayList和arrayDeque需要提前给好大小)
 */
public class StackTest {
	public static void main(String[] args) throws Exception {
		int size = 1000000;
		Stack<String> stack = new Stack<>(size);
		long start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			stack.push(String.valueOf(i));
		}
		long end = System.nanoTime();
		System.out.println("ArrayList添加耗费时间:"+ (end - start));
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			stack.pop();
		}
		end = System.nanoTime();
		System.out.println("ArrayList取出耗费时间:"+ (end - start));
		
		StackLinkedList<String> stackLinkedList = new StackLinkedList<>();
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			stackLinkedList.push(String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("LinkedList添加耗费时间:"+ (end - start));
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			stackLinkedList.pop();
		}
		end = System.nanoTime();
		System.out.println("LinkedList取出耗费时间:"+ (end - start));
		
		StackArrayDeque<String> stackArrayDeque = new StackArrayDeque<>(size);
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			stackArrayDeque.push(String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("ArrayDeque添加耗费时间:"+ (end - start));
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			stackArrayDeque.pop();
		}
		end = System.nanoTime();
		System.out.println("ArrayDeque取出耗费时间:"+ (end - start));
		
		
	}
}