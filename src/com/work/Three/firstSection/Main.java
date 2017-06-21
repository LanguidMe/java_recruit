package com.work.Three.firstSection;

/**
 * 分析以下代码的函数栈的情况，并说出代码的输出是什么，解释为什么
 */
public class Main {
	public static void main(String[] args) {
		int a =1,b=2;
		swap(a, b);
		System.out.println("a is"+a+",b is"+b);
	}
	
	public static void swap(int a,int b){//这里是把数值拷贝了一份,所以这里的赋值不会影响main方法中的a b
		int t = a;
		a = b;
		b = t;
	}
	/**老师这是我按照网上教的理解写的 
	 * 我不太明白的是  0 2行已经入栈了  为什么还要弹出? 
	 * 还要 4 5行取出元素压入栈  那么局部变量还有值吗? 这里不是太明白
	*/
	/* public static void main(java.lang.String[]);
	    Code:
	       0: iconst_1 把常量int类型1入栈
	       1: istore_1 弹出栈顶层元素存入位置1的局部变量中
	       2: iconst_2 把常量int类型2入栈
	       3: istore_2 弹出栈顶层元素存入位置2的局部变量中
	       4: iload_1 从位置1的局部变量中取出元素int 1压入栈
	       5: iload_2 从位置2的局部变量中取出元素int 2压入栈
	       6: invokestatic  #2            这里调用swap函数  需要两个参数,所以 1 2 出栈  栈中的元素不影响局部变量  所以结果还是  1 2
	       9: return

	  public static void swap(int, int);
	    Code:
	       0: iload_0
	       1: istore_2
	       2: iload_1
	       3: istore_0
	       4: iload_2
	       5: istore_1
	       6: return
	}*/
}
