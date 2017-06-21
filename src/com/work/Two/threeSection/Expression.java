package com.work.Two.threeSection;

import java.io.IOException;

import com.work.Two.firstSection.main.Token;
import com.work.Two.firstSection.main.Token.TokenType;
import com.work.Two.firstSection.main.TokenStream;
import com.work.Two.firstSection.main.YourTokenStream;

public class Expression {
	public TokenStream ts;

    public static void main(String args[]) throws Exception {
//        Expression e = new Expression();
//        System.out.println(e.evalue());
    	System.out.println(expellOne(5));
    	Yhuo(13,15);
    }
    
    public static int expellOne(int a) {
        return a&(a-1);
    }
    
    public static void Yhuo(int a,int b){
    	a = a ^ b;
    	b = a ^ b;
    	a = a ^ b;
    	System.out.println(a+","+b);
    }

    public Expression() throws IOException {
        ts = new YourTokenStream(System.in);
    }

    public int evalue() {
        int t = term();
        Token op = null;

        try {
            op = ts.getToken();
            while (op.tokenType == TokenType.PLUS || op.tokenType == TokenType.MINUS) {
                ts.consumeToken();
                int t2 = term();
                if (op.tokenType == TokenType.PLUS) {
                    t += t2;
                } else {
                    t -= t2;
                }

                op = ts.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int term() {
        int t = factor();

        Token op = null;
        try {
            op = ts.getToken();

            while (op.tokenType == TokenType.MULT || op.tokenType == TokenType.DIV) {
                ts.consumeToken();
                int t2 = factor();
                if (op.tokenType == TokenType.MULT) {
                    t *= t2;
                } else {
                    t /= t2;
                }
                op = ts.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int factor() {
        Token t = null;
        try {
            t = ts.getToken();

            if (t.tokenType == TokenType.INT) {
                ts.consumeToken();
                return (((Integer) t.value).intValue());
            } else if (t.tokenType == TokenType.LPAR) {
                ts.consumeToken();
                int v = evalue();
                match(ts.getToken(), TokenType.RPAR);
                return v;
            }
            else if (t.tokenType == TokenType.MINUS) {
                ts.consumeToken();
                return 0 - factor();
            }
            else {
                throw new IOException("Illegal Expression!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // should not reach here
        return 0;
    }

    private void match(Token t, Token.TokenType tt) {
        assert t.tokenType == tt;
        ts.consumeToken();
    }
}
