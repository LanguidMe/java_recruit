package com.work.eight;

import java.io.IOException;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws IOException {
		/*BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(kReader.readLine());*/
		String str1 = "192.168.1.100:8080-100";
		String str2 = "192.168.1.101:8080-100";
		System.out.println(hash(str1));
		System.out.println(hash(str2));
		
		Random random = new Random();
		long a= Math.abs(random.nextLong())%100;
		System.out.println(a+","+(a<30));
		
	}
	
	static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
