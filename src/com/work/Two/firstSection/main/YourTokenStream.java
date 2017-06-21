package com.work.Two.firstSection.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.work.Two.firstSection.main.Token.TokenType;

public class YourTokenStream implements TokenStream{
	/**
	 * 对应的TokenType
	 */
	private String[] type = new String[]{"(",")","+","-","*","/"," "};
	private final InputStream in;
	/**
	 * 把读取的字符串解析后保存到list中
	 */
	private List<Token> tokens = new ArrayList<>();
	/**
	 * 下标
	 */
	private int i = 0;
	
	public YourTokenStream(InputStream in) throws IOException {
		this.in = in;
		setTokens();
	}
	
	
	@SuppressWarnings("unused")
	public void setTokens() throws IOException{
		byte[] buf = new byte[1024];
		int b = 0;
		String tzt =null;
		Token token = null;
		TokenType[] types = TokenType.values();
		int a;
		while((b = in.read(buf))!=-1){
			tzt = new String(buf, "utf-8").replace("\r\n", "").trim();
			for(int i=0;i<tzt.length();i++){
				String str= String.valueOf(tzt.charAt(i));
				if(StringUtils.isBlank(str)){
					continue;
				}else if(StringUtils.isNumeric(str)){
					a = i+1;
					if(a<tzt.length()){//判断是否超过了字符串的总长度
						while(StringUtils.isNumeric(String.valueOf(tzt.charAt(a)))){//判断下一个如果还是数字  那么表示这不是一个单数字
							str+=String.valueOf(tzt.charAt(a));
							i++;
							if(a==tzt.length()-1)
								break;
							a++;
						}
					}
					token = new Token(TokenType.INT, Integer.valueOf(str));
					tokens.add(token);
				}else{
					token = new Token(types[getIndex(str)], str);
					tokens.add(token);
				}
			}
			tokens.add(new Token(TokenType.NONE, null));
			System.in.close();
			break;
		}
	}
	
	public int getIndex(String str){
		for (int i = 0; i < type.length; i++) {
			if(str.equals(type[i])){
				return i;
			}
		}
		return -1;
	}

	@Override
	public Token getToken() throws IOException {
		return tokens.get(i);
	}

	@Override
	public void consumeToken() {
		i++;
	}

}
