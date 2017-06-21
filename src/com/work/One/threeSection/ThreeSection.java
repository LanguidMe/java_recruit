package com.work.One.threeSection;

public class ThreeSection {
	
	private final long value;
	
	public ThreeSection(long value){
		this.value = value;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer a = new Integer(1);// 这里是直接new的对象 而==比对的是对象 所以a和下面的bcd都是false
		Integer b = Integer.valueOf(1);// 这里是直接从IntegerCache.cache中直接取的
		Integer c = inc(0);
		Integer d = 1;// 这里是直接装箱 也是从缓存里面取的 所以 bcd都相等
		System.out.println(new ThreeSection(1).equals(1));
	}

	public static Integer inc(Integer x) {
		// return这里的相加应该是先拆箱然后相加吧?(这里不确定)
		// 相加为1后又装箱到Integer里面 而装箱默认调用的是valueOf所以b和c == 为true
		return x + 1;
	}
	
	/**
	 * 第三题
	 * 修改Long.java，看看能不能改变equals的行为，使得下面的语句输出为true
	 *	System.out.println(new Long(1).equals(1));
	 * 这个是我目前能想到的 求老师解答
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Integer) {
			return value == Long.valueOf(((Integer)obj)).longValue();
		} else if (obj instanceof Double) {
			return value == Long.valueOf(((Double)obj).longValue()).longValue();
		} else if (obj instanceof Float) {
			return value == Long.valueOf(((Float)obj).longValue()).longValue();
		} else if (obj instanceof Long) {
			return value == ((Long) obj).longValue();
		}else if (obj instanceof Byte) {
			return value == Long.valueOf(((Byte)obj)).longValue();
		}else if (obj instanceof Short) {
			return value == Long.valueOf(((Short)obj)).longValue();
		}
		return false;
	}
}