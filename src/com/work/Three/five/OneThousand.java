package com.work.Three.five;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *1-1000中少了两个数，找出没有出现的两个数，数组是无序的
 */
public class OneThousand {
	public static void main(String[] args) {
		int max = 100;
		List<Integer> list = randomNumber(1,max,98);//获取随机值集合
		for (int in :list) {
			System.out.print(in+" ");
		}
		System.out.println();
		int a = 0;
		for (int in :list) {
			a^=in;
		}
		for(int i=1;i<=max;i++){
			a^=i;
		}
		int index = findFirstOne(a);
		int lackOneNum = 0;
		int lackTwoNum = 0;
		for (int in :list) {
			if(testBit(in,index)){
				lackOneNum^=in;
			}else{
				lackTwoNum^=in;
			}
		}
		for(int i=1;i<=max;i++){
			if(testBit(i,index)){
				lackOneNum^=i;
			}else{
				lackTwoNum^=i;
			}
		}
		System.out.println("缺少的两个数为:num1:"+lackOneNum+",num2:"+lackTwoNum);
	}
	
	/**
	 * 功能：产生1-1000中的900个不重复的随机数
	 * 
	 * min:产生随机数的其实位置 mab：产生随机数的最大位置 n: 所要产生多少个随机数
	 *
	 */
	public static List<Integer> randomNumber(int min, int max, int n) {
		Random rand =new Random();
		List<Integer> except = new ArrayList<>(max-n);
		for (int i = 0; i < max-n; i++) {
			int a = rand.nextInt(max);
			while(except.contains(a)){
				a = rand.nextInt(min)+(max-min);
			}
			except.add(a);
		}
		List<Integer> list = new ArrayList<>(n);
		boolean flg = true;
		for (int i = 1; i <= max; i++) {
			flg = true;
			for(int in :except){
				if(i==in){
					flg = false;
				}
			}
			if(flg){
				list.add(i);
			}
		}
		return list;
	}
	
	public static int findFirstOne(int value)  //取二进制中首个为1的位置
    {
        int pos=0;
        while((value&1)!=1)
        {
            value = value>>1;
            pos++;
        }
        return pos;
    }
	
	
	
	public static boolean testBit(int value,int pos) //测试某位置是否为1
    {
        return ((value>>pos)&1) != 0;
    }
}
