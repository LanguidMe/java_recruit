package com.work.five.firstSection;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.work.Two.firstSection.main.Token;
import com.work.Two.firstSection.main.Token.TokenType;
import com.work.Two.firstSection.main.TokenStream;
import com.work.Two.firstSection.main.YourTokenStream;

public class BinaryTreeExpression {
	public TokenStream ts;
	
	public static void main(String[] args) throws IOException {
		BinaryTreeExpression expression = new BinaryTreeExpression();
		BinarySearchTree2<Token> searchTree = new BinarySearchTree2<>();
		searchTree.root = expression.evalue();
		//System.out.println(searchTree.root);
		searchTree.ergodic(searchTree.root);
		System.out.println(((Token)searchTree.deque.getFirst()).value);
	}
	
	public BinaryTreeExpression() throws IOException {
		ts = new YourTokenStream(new BufferedInputStream(System.in));
	}
	
	public Node2<Token> evalue() throws IOException {
		Node2<Token> left = trem();
		if(ts.getToken().tokenType==TokenType.PLUS){
			ts.consumeToken();
			Node2<Token> p = new Node2<Token>(new Token(TokenType.PLUS, "+"));
			p.left = left;
			p.right = evalue();
			return p;
		}
		if(ts.getToken().tokenType==TokenType.MINUS){
			ts.consumeToken();
			Node2<Token> p = new Node2<Token>(new Token(TokenType.MINUS, "-"));
			p.left = left;
			p.right = evalue();
			return p;
		}
		return left;
	}
	
	public Node2<Token> trem() throws IOException{
		Node2<Token> left = factor();
		if(ts.getToken().tokenType==TokenType.MULT){//如果是乘于
			ts.consumeToken();
			Node2<Token> p = new Node2<Token>(new Token(TokenType.MULT, "*"));
			p.left = left;
			p.right = trem();
			return p;
		}
		if(ts.getToken().tokenType==TokenType.DIV){
			ts.consumeToken();
			Node2<Token> p = new Node2<Token>(new Token(TokenType.DIV, "/"));
			p.left = left;
			p.right = trem();
			return p;
		}
		
		return left;
	}
	
	public Node2<Token> factor() throws IOException{
		Token token = ts.getToken();
		if(token.tokenType == TokenType.INT){
			ts.consumeToken();
			return new Node2<Token>(token);
		}
		if(token.tokenType == TokenType.LPAR){
			ts.consumeToken();
			Node2<Token> node = evalue();
			if(!match(TokenType.RPAR)){
				assert false;
			}
			return node;
		}
		if(match(TokenType.MINUS)){//处理负数
			Node2<Token> p = new Node2<Token>(new Token(TokenType.MINUS, "-"));
			p.left = new Node2<Token>(new Token(TokenType.INT, 0));
			p.right = factor();
			return p;
		}
		return null;
	}
	
	private boolean match(Token.TokenType tt) throws IOException {
        if (ts.getToken().tokenType == tt) {
            ts.consumeToken();
            return true;
        }
        return false;
    }
}
