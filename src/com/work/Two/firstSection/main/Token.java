package com.work.Two.firstSection.main;

import org.jetbrains.annotations.NotNull;

public class Token implements Comparable<Token>{
	public enum TokenType {
		LPAR, RPAR, PLUS, MINUS, MULT, DIV, INT, NONE,
	}

	public TokenType tokenType;
	public Object value;

	public Token(TokenType tt, Object v) {
		this.tokenType = tt;
		this.value = v;
	}

	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", value=" + value + "]";
	}

	@Override
	public int compareTo(@NotNull Token o) {
		return 0;
	}
}
