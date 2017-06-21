package com.work.One.firstSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 转换二进制
 */
public class Binary {
	public static void main(String[] args) {
		System.out.println(otc2Bin(8));
	}
	
	
	/**
	 * 获取/2的次数
	 * @param ten
	 * @return
	 */
	public static int otc2(int ten){
        int index = 0;
        while (ten !=1&&ten>0){
            if (ten%2==0){
                ten = ten/2;
            }else {
                ten = ten/2;
            }
            index ++;
        }
        return index;
    }
	
	/**
	 * 获取转换后的字符串
	 * @param indexs 数组 如:{1,5}
	 * @param blean
	 * @return
	 */
    public static String to2String(Integer[] indexs,boolean blean) {
        StringBuilder sb = new StringBuilder();
        String str= "";
        String str2 = "";
        for (int i = 0; i < 32; i++) {//双重循环
            boolean fig = false;
            for (int j = 0; j < indexs.length; j++){
                int a = indexs[j];
                if (a==i){//如果等于则修改为1
                    str = "1";
                    //这里开始把目前的字符加到之前累加的前面   begin
                    sb.append(str).append(str2);
                    str2 = sb.toString();
                    sb.setLength(0);
                    fig = true;
                    //end
                    break;
                }
            }
            if (fig){//如果为true表示已经追加过了 则跳出循环
                continue;
            }
            if(i==31){
            	if(blean){//判断是否是负数
            		str = "1";
            	}else{
            		str = "0";
            	}
            }else{
            	str = "0";
            }
            sb.append(str).append(str2);
            str2 = sb.toString();
            sb.setLength(0);
        }
        if(blean){
        	return toFu(str2);
        }
        return str2;
    }
    
    /**
     * 把十进制转换成二进制
     * @param ten
     * @return
     */
    public static String otc2Bin(int ten){
    	boolean fig = ten>0?false:true;
    	ten = Math.abs(ten);
        int index = otc2(ten);
        List<Integer> integers = new ArrayList<Integer>();//为了记录/2的次数
        integers.add(index);
        while (ten  - (int) Math.pow(2,index) != 0){
            ten = ten - (int) Math.pow(2,index);
            index = otc2(ten);
            integers.add(index);
        }
        Integer[] indexs = integers.toArray(new Integer[integers.size()]);
        Arrays.sort(indexs);
        return to2String(indexs,fig);
    }
    
    /**
     * 如果为负数 取反
     * @param two
     * @return
     */
    public static String toFu(String two){
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i< two.length();i++){
    		if(i==0){
    			sb.append("1");
    			continue;
    		}
    		char c = two.charAt(i);
    		int a = Character.getNumericValue(c);
    		if(a==1){
    			sb.append("0");
    		}else if(a==0){
    			sb.append("1");
    		}
    	}
    	return oc(sb.toString());
    }
    
    /**
     * 取反后+1
     * @param reversal
     * @return
     */
    public static String oc(String reversal){
    	String str = "";
		String str2 = "";
    	StringBuilder sb = new StringBuilder();
    	if(Character.getNumericValue(reversal.charAt(reversal.length()-1))==0){
    		reversal = reversal.substring(0, reversal.length()-1);
    		sb.append(reversal).append("1");
    		return sb.toString();
    	}else if(Character.getNumericValue(reversal.charAt(reversal.length()-1))==1){
    		boolean f = false;
    		for(int i=reversal.length()-1;i>=0;i--){
    			if(!f){
    				if(Character.getNumericValue(reversal.charAt(i))==1){
    					str = "0";
    					sb.append(str).append(str2);
    		            str2 = sb.toString();
    		            sb.setLength(0);
        				continue;
        			}else{
        				str = "1";
        				sb.append(str).append(str2);
    		            str2 = sb.toString();
    		            sb.setLength(0);
        				f = true;
        				continue;
        			}
    			}
    			str = new String(new char[]{reversal.charAt(i)});
				sb.append(str).append(str2);
	            str2 = sb.toString();
	            sb.setLength(0);
    		}
    	}
    	return str2;
    }
}