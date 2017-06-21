package com.work.four.fiveSection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ArrayDeque根据&运算 快速的删除了元素 而LinkedList需要进行换位  需要把第一个删除掉  把第二个设置成第一个元素 其效率比ArrayDeque慢了很多
 * 
 * LinkedList在删除的时候 耗费的对象 要比ArrayDeque多的多 ArrayDeque用&运算 很快定位元素 并且清空即可
 */
public class Main {
	public static void main(String args[]) {
		//Deque<Integer> q = new ArrayDeque<>();//26175294 34177593
		Deque<Integer> q = new LinkedList<>();//56057573  44072499
        long begin = System.nanoTime();
        test(q);
        long end = System.nanoTime();
        System.out.println("took " + (end - begin) + "ns");
    }

    public static void test(Deque<Integer> q) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10_000; j++) {
                q.addLast(j);
            }

            for (int j = 0; j < 10_000; j++) {
                q.removeLast();
            }
        }
    }
}
