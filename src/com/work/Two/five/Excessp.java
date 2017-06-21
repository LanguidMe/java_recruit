package com.work.Two.five;

import com.work.Two.firstSection.main.Token;
import com.work.Two.firstSection.main.Token.TokenType;
import com.work.Two.firstSection.main.TokenStream;
import com.work.Two.firstSection.main.YourTokenStream;

public class Excessp {
	private static TokenStream s;
	public static void main(String[] args) throws Exception {
		s = new YourTokenStream(System.in);
		System.out.println(expr());
	}
	
	
	public static int expr() throws Exception{
		int t = term();
		Token token = s.getToken();
		while(token.tokenType==TokenType.PLUS||token.tokenType==TokenType.MINUS){
			s.consumeToken();
			int t2 = term();
			if(token.tokenType==TokenType.PLUS){
				t+=t2;
			}else{
				t-=t2;
			}
			token = s.getToken();
		}
		return t;
	}
	
	public static int term() throws Exception{
		int f = factor();
		Token token = s.getToken();
		while(token.tokenType==TokenType.MULT||token.tokenType==TokenType.DIV){
			s.consumeToken();
			int f2 = factor();
			if(token.tokenType==TokenType.MULT){
				f*=f2;
			}else{
				f/=f2;
			}
			token = s.getToken();
		}
		return f;
	}
	
	public static int factor() throws Exception{
		Token token = s.getToken();
		if(token.tokenType==TokenType.INT){
			s.consumeToken();
			return (Integer)token.value;
		}else if(token.tokenType==TokenType.LPAR){
			s.consumeToken();
			int f = expr();
			if(s.getToken().tokenType==TokenType.RPAR){
				s.consumeToken();
				return f;
			}
		}else if(token.tokenType==TokenType.MINUS){
			s.consumeToken();
			return 0-factor();
		}
		return 0;
	}
}
