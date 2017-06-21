package com.work.Two.five;

import java.util.List;

import com.work.Two.firstSection.main.Token.TokenType;
import com.work.Two.firstSection.main.TokenStream;
import com.work.Two.firstSection.main.YourTokenStream;
import com.work.Two.threeSection.Stack;

/**
 * 读取表达式计算结果
 */
public class StackExpress {
	public static void main(String[] args) throws Exception {
		TokenStream stream = new YourTokenStream(System.in);
		Stack<Integer> integers = new Stack<>(100);
		Stack<TokenType> types = new Stack<>(50);
		while(stream.getToken().tokenType!=TokenType.NONE){
			if(stream.getToken().tokenType == TokenType.INT){
				integers.push((Integer)stream.getToken().value);
			}else{
				if(types.getTop()==null||integers.getTop()==null){
					types.push(stream.getToken().tokenType);
				}else if(!IsPriority(types.getTop(),stream.getToken().tokenType)){
					types.push(stream.getToken().tokenType);
				}else{
					if(types.getTop()==TokenType.LPAR&&stream.getToken().tokenType==TokenType.RPAR){
						types.pop();
					}else{
						int a = integers.pop();
						int b = integers.pop();
						TokenType type = types.pop();
						int result = getResult(type,b,a);
						integers.push(result);
						if(stream.getToken().tokenType==TokenType.RPAR){//处理括号的情况
							while(types.getTop()!=TokenType.LPAR){
								a = integers.pop();
								b = integers.pop();
								type = types.pop();
								result = getResult(type,b,a);
								integers.push(result);
							}
							types.pop();
						}else{
							types.push(stream.getToken().tokenType);
						}
					}
					//((11 + 33) / 11 - 2 * 4) * (8 - 3)
				}
			}
			stream.consumeToken();
		}
		while(!types.isEmpty()){
			int a = integers.pop();
			int b = integers.pop();
			TokenType type = types.pop();
			int result = 0;
			if(!types.isEmpty()){
				if(types.getTop()==TokenType.MINUS&&type==TokenType.MINUS){//处理两减的情况
					result = getResult(TokenType.PLUS,b,a);
				}else{
					result = getResult(type,b,a);
				}
			}else{
				result = getResult(type,b,a);
			}
			integers.push(result);
			if(stream.getToken().tokenType==TokenType.RPAR){
				types.pop();
			}
		}
		
		List<Integer> list = integers.getList();
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	/**
	 * 判断是否进行计算 如果进行计算返回true  否则返回false
	 * @param left 左边的计算符
	 * @param right 右边的计算符
	 * @return
	 */
	public static boolean IsPriority(TokenType left,TokenType right){
		if(left == TokenType.LPAR){
			if(right == TokenType.RPAR){
				return true;
			}else
				return false;
		}
		if(left == TokenType.MULT||left == TokenType.DIV){
			if(right == TokenType.RPAR){
				return true;
			}
			if(right == TokenType.PLUS||right == TokenType.MINUS){
				return true;
			}
			if(right == TokenType.LPAR){
				return false;
			}
			if(right == TokenType.MULT||right == TokenType.DIV){
				return true;
			}
		}
		if(left == TokenType.PLUS||left == TokenType.MINUS){
			if(right == TokenType.RPAR){
				return true;
			}
			if(right == TokenType.MULT||right == TokenType.DIV){
				return false;
			}
			if(right == TokenType.LPAR){
				return false;
			}
			if(right == TokenType.PLUS||right == TokenType.MINUS){
				return true;
			}
		}
		if(left == TokenType.LPAR){
			if(right == TokenType.LPAR){
				return false;
			}
		}
		return false;
	}
	
	
	/**
	 * 根据两个数值 和计算符 得出结果
	 * @param tokenType 计算符
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getResult(TokenType tokenType,int a,int b){
		if(tokenType == TokenType.PLUS){
			return a+b;
		}else if(tokenType == TokenType.MINUS){
			return a-b;
		}else if(tokenType == TokenType.MULT){
			return a*b;
		}else if(tokenType == TokenType.DIV){
			return a/b;
		}
		return 0;
	}
}