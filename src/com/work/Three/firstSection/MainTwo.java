package com.work.Three.firstSection;

public class MainTwo {
	public static void main(String[] args) {
		int n = 10;
		int t = fact(n);
		System.out.println(t);
	}
	
	public static int fact(int n){
		if(n==0){
			return 1;
		}else
			return n*fact(n-1);
	}
	/**不知道我这样的理解对不对   还有老师  局部变量存在在哪里?*/
	 /*public static void main(java.lang.String[]);
	   Code:
	      0: bipush        10  把byte类型转成int类型然后入栈
	      2: istore_1                     弹出顶层元素存入到位置为1的局部变量中
	      3: iload_1		把局部变量位置为1的元素压入栈
	      4: invokestatic  #2  调用fact方法
	      7: istore_2		弹出顶层元素存入到位置为2的局部变量中
	      8: return

	 public static int fact(int);
	   Code:
	      0: iload_0     将n入栈顶
	      1: ifne          6 当栈顶int型数值不等于0时跳转到第6行 
	      4: iconst_1  把int类型1入栈顶
	      5: ireturn 
	      6: iload_0   把局部变量位置为0的压入栈
	      7: iload_0   把局部变量位置为0的压入栈
	      8: iconst_1 把int类型1入栈顶
	      9: isub 将栈顶两int型数值相减并将结果压入栈顶
	     10: invokestatic  #2       调用fact方法           // Method fact:(I)I
	     13: imul 将栈顶两int型数值相乘并将结果压入栈顶
	     14: ireturn*/
}
