package com.work.five.firstSection;

public class TestFib {
	
	public int state;

	public static int fib(int n){
		if (n < 2)
	        return 1;
	    else
	        return fib(n - 1) + fib(n - 2);
	}
	
	public static int fib(int a, int b, int n) {
	    if (n == 0)
	        return a;
	    else
	        return fib(b,a+ b, n - 1);
	}
	
	public static double power1(double m, int n) {
	    /*double result = 1.0;
	    double t = m;

	    for (int i = 1; i <= n; i <<= 1) {
	        if ((n & i) > 0)
	            result *= t;
	        t *= t;
	    }*/
//	    return result;
		return power2(1.0,m,n,1);
	}
	
	public static double power2(double result,double t,int n,int i) {
	    if(i>n){
	    	return result;
	    }
	    if((n&i)>0){
	    	return power2(result*t,t*t,n,i<<1);
	    }else{
	    	return power2(result,t*t,n,i<<1);
	    }
	}
	
	
	public static void main(String[] args) {
		TestFib fib = new TestFib();
		System.out.println(fib.state);
	}
}