package com.work.nine.reflex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflexTask {
	public static void main(String[] args) {
		try {
			Test obj = Test.class.newInstance();
			BufferedReader br = obtainLine(obj);
			String methodName = br.readLine();
			Method method = Test.class.getDeclaredMethod(methodName,int.class,int.class);
			System.out.println(method.getReturnType().getName());
			Integer a = Integer.valueOf(br.readLine());
			Integer b = Integer.valueOf(br.readLine());
			System.out.println("调用了"+methodName+"方法,参数为:"+a+","+b);
			Object object = method.invoke(obj,a,b);
			System.out.println((int)object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedReader obtainLine(Test test) throws Exception{
		FileReader fileReader = new FileReader(new File(ReflexTask.class.getClassLoader().getResource("file.txt").getPath()));
		BufferedReader br = new BufferedReader(fileReader);
		return br;
	}
}
class Test{
	
	public static void main(String[] args) throws Exception {
		Test test = Test.class.newInstance();
		BufferedReader br = obtainLine();
		Field field = Test.class.getDeclaredField(br.readLine());
		field.set(test,Class.forName("com.work.nine."+br.readLine()).newInstance());
		test.sort();
	}
	
	public Soret soret;
	
	public void sort(){
		int[] a = {5, 7, 3, 1, 4, 6, 2};
		soret.sort(a);
        for(int i : a) {
            System.out.println(i);
        }
	}
	
	public void sayHello(){
		System.out.println("sayHello");
	}
	
	public void sayWord(){
		System.out.println("sayWord");
	}
	
	public int add(int a,int b){
		return a+b;
	}
	
	public static BufferedReader obtainLine() throws Exception{
		FileReader fileReader = new FileReader(new File(ReflexTask.class.getClassLoader().getResource("file.txt").getPath()));
		BufferedReader br = new BufferedReader(fileReader);
		return br;
	}
}
class Soret{
	public void sort(int[] a){
		Arrays.sort(a);
	}
}