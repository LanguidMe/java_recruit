package com.work.five.firstSection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import com.work.Two.firstSection.main.Token;
import com.work.Two.firstSection.main.Token.TokenType;

public class BinarySearchTree2<T extends Comparable<T>> {
	public Node2<T> root;
	int size = 0;
	public Deque<Object> deque = new ArrayDeque<>();
	
	/**
	 * 添加方法
	 * @param t
	 * @return
	 */
	public boolean insert(T t){
		if(t==null){
			return false;
		}
		if(root==null){
			root = new Node2<T>(t);
			size++;
			return true;
		}
		Node2<T> n = root;
		while(true){
			if(t.compareTo(n.data)<0){
				if(n.left==null){
					n.left = new Node2<T>(t);
					n.left.parent = n;
					size++;
					break;
				}else{
					n = n.left;
				}
			}else{
				if(n.right==null){
					n.right = new Node2<T>(t);
					n.right.parent = n;
					size++;
					break;
				}else{
					n = n.right;
				}
			}
		}
		return true;
	}
	
	/**
	 * 不用递归去遍历(前序遍历)
	 * @param node
	 */
	public void traverseByLevelFromTop(Node2<T> node){
		if(node==null){
			return;
		}
		Deque<Node2<T>> deque = new ArrayDeque<>();
		deque.addLast(node);
		Deque<Object> objects = new ArrayDeque<>();
		while(!deque.isEmpty()){
			Node2<T> first = deque.pollLast();
			if(first.left != null){
				deque.addLast(first.left);
			}
			//System.err.println(first.data);
			if(first.right != null){
				deque.addLast(first.right);
			}
			/*if(first.data instanceof Token){
				Token token = (Token)first.data;
				if(token.tokenType != TokenType.INT){
					Node2<Token> one = (Node2<Token>)objects.getLast();
					Node2<Token> two = (Node2<Token>)objects.getLast();
					int result = getResult(token.tokenType,(Integer)two.data.value,(Integer)one.data.value);
					Node2<Token> re = new Node2<Token>(new Token(TokenType.INT, result));
					objects.addLast(re);
				}else{
					objects.push(first.data);
				}
			}*/
			objects.push(first.data);
			System.out.println(((Token)first.data).value);
		}
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
	
	/**
	 * 递归遍历
	 * @param node
	 * @param list
	 * @return
	 */
	public void ergodic(Node2<T> node){
		//System.out.println(node.data);//前序遍历
		if(node.left!=null){
			ergodic(node.left);
		}
		//System.out.println(node.data);//中序遍历
		if(node.right!=null){
			ergodic(node.right);
		}
		//deque.push(node.data);
		if(node.data instanceof Token){
			Token token = (Token)node.data;
			if(token.tokenType != TokenType.INT){
				Token one = (Token)deque.pollFirst();
				Token two = (Token)deque.pollFirst();
				int result = getResult(token.tokenType,(Integer)two.value,(Integer)one.value);
				deque.push(new Token(TokenType.INT, result));
			}else{
				deque.push(node.data);
			}
		}
		//System.out.println(((Token)node.data).value);//后序遍历
	}
	
	public Node2<T> successor(Node2<T> next){
		if (next == null)
            return null;
        Node2<T> p;
        if (next.right != null) {
            p = next.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        else {
            p = next.parent;
            while (p != null && p.left != next) {
                next = p;
                p = next.parent;
            }
            return p;
        }
	}
	
	public Iterator<T> iterator(){
		return new BinaryIterator();
	}
	
	public static void main(String[] args) throws Exception {
		int[] arr = new int[]{5,3,1,6,4,7,8};
		BinarySearchTree2<Integer> tree = new BinarySearchTree2<>();
		for (int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}
		Iterator<Integer> iterator = tree.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	class BinaryIterator implements Iterator<T>{
		Node2<T> next;
		
		BinaryIterator() {
			if(root==null){
				next=null;
				return;
			}
			Node2<T> n = root;
			while(n.left!=null){
				n = n.left;
			}
			next = n;
		}

		@Override
		public boolean hasNext() {
			return next!=null;
		}

		@Override
		public T next() {
			T d = next.data;
			next = successor(next);
			return d;
		}
		
	}
}
class Node2<T extends Comparable<T>>{
	public T data;
	public Node2<T> left;
	public Node2<T> right;
	public Node2<T> parent;
	public int state;
	
	public Node2(T data) {
		this.data = data;
	}
}