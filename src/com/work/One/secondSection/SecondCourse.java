package com.work.One.secondSection;

public class SecondCourse {
	public static void main(String[] args) {
		String[] str = solev(3);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	public static String[] solev(int x) {
		int a;
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		int b = 1;
		while (x > 0) {
			a = x % 5;
			if (a == 4) {
				left.append(b).append(" ");
				x = x / 5 + 1;
			} else if (a == 3) {
				left.append(b).append(" ").append(b);
				x = x / 5 + 1;
			} else if (a == 2) {
				right.append(b).append(" ").append(b);
				x = x / 5;
			} else if (a == 1) {
				right.append(b).append("");
				x = x / 5;
			} else {
				x = x / 5;
			}
			b *= 5;
		}
		return new String[] { left.toString(), right.toString() };
	}
}
