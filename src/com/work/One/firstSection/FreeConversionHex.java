package com.work.One.firstSection;

/**
 * 自由转换进制---不会处理负数  望老师解答
 */
public class FreeConversionHex {
	public static void main(String[] args) {
		System.out.println(transform("222",3,10));
	}
	
	/**
	 * 自由转换进制(只能是正数)
	 * @param s 原始进制字符串值
	 * @param radixSrc 原本进制
	 * @param radixTgt 需要转换的进制
	 * @return
	 */
	public static String transform(String s, int radixSrc, int radixTgt){
		return freeRadix(calculation(s,radixSrc),radixTgt);
	}
	
	/**
	 * 根据进制 计算出十进制数
	 * @param s 原始进制字符串值
	 * @param radixSrc 原本进制
	 * @return
	 */
	public static int calculation(String s,int radixSrc){
		int ten = 0;
		for(int i=s.length()-1;i>=0;i--){
			ten += Math.pow(radixSrc, s.length()-1-i)*Character.getNumericValue(s.charAt(i));
		}
		return ten;
	}
	
	/**
	 * 将值转换成进制
	 * @param ten 需要转换的值
	 * @param hex 需要转换的进制
	 * @return
	 */
	public static String freeRadix(int ten,int radixTgt){
		StringBuilder sb = new StringBuilder();
		String strFirst = "";
		String strTwo ="";
        while (ten !=1&&ten>0){
        	strFirst=String.valueOf(ten%radixTgt);
        	strTwo = sb.toString();
        	sb.setLength(0);
        	sb.append(strFirst).append(strTwo);
            if (ten%radixTgt==0){
                ten = ten/radixTgt;
            }else {
                ten = ten/radixTgt;
            }
        }
        strTwo = sb.toString();
        strFirst = String.valueOf(ten);
        sb.setLength(0);
    	sb.append(strFirst).append(strTwo);
    	int radix = Integer.parseInt(sb.toString());
    	sb.setLength(0);
    	sb.append(radix);
        return sb.toString();
    }
}