package com.work.five.secondSection;

import java.util.HashMap;

public class TestCast {
	public static void main(String[] args){
		/*TreeMap<Integer, Object> treeMap = new TreeMap<>();
		for(int i=1;i<=10;i++){
			treeMap.put(i, i);
		}
		for(int i=1;i<=10;i++){
			treeMap.remove(i, i);
		}*/
		//solve(1,2,3,4,5);
		System.out.println(chinaToUnicode(""));//26446--24314--24191
	}
	
	public static String chinaToUnicode(String str){
        String result="";  
        for (int i = 0; i < str.length(); i++){  
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
                result+="" + chr1;  
            }else{
                result+=chr1;  
            }
        }  
        return result;  
    }
	
	static int hash(Object key) {
		System.out.println("keyHashCode:"+key.hashCode());
		System.out.println("key>>>:"+((key.hashCode())>>> 16));
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	 public static void solve(int a1, int a2, int a3, int a4, int a5) {
	        HashMap<Integer, Integer> m = new HashMap<>();
	        for (int i = -50; i < 50; i++) {
	            for (int j = - 50; j < 50; j++) {
	                for (int k = -50; k < 50; k++) {
	                    int t = a1 * i * i * i + a2 * j * j * j + a3 * k * k * k;
	                    Integer p = m.get(t);
	                    if (p == null)
	                        m.put(t, 1);
	                    else
	                        m.put(t, p + 1);
	                }
	            }
	        }

	        int sum = 0;
	        for (int i = -50; i < 50; i++) {
	            for (int j = -50; j < 50; j++) {
	                int t = a4 * i * i * i +  a5 * j * j * j;
	                Integer p = m.get(-t);

	                if (p != null){
	                	System.out.println(p);
	                    sum += p;
	                }
	            }
	        }

	        System.out.print(sum);
	    }
}