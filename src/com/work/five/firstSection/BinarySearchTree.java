package com.work.five.firstSection;

import java.util.ArrayDeque;
import java.util.Deque;

import com.work.Two.threeSection.Stack;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node root;
	int size = 0;
	
	/**
	 * 添加方法
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean insert(T t){
		if(root == null){
			root = new Node(t);
			size=1;
			return true;
		}
		Node r = root;
		while(true){
			if(t.compareTo((T) r.data)<0){
				if(r.left==null){
					r.left = new Node(t);
					size++;
					break;
				}else{
					r = r.left;
				}
			}else{
				if(r.right == null){
					r.right = new Node(t);
					size++;
					break;
				}else{
					r = r.right;
				}
			}
		}
		return true;
	}
	
	/**
	 * 判断一个元素是否在此树中
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(T t){
		if(root==null){
			return false;
		}
		Node r = root;
		while(true){
			if(t.compareTo((T) r.data)==0){
				return true;
			}else if(t.compareTo((T) r.data)<0){
				if(r.left == null){
					return false;
				}else
					r = r.left;
			}else{
				if(r.right == null){
					return false;
				}else
					r = r.right;
			}
		}
	}
	
	/**
	 * 不用递归去遍历(前序遍历)
	 * @param node
	 */
	public void traverseByLevelFromTop(Node node){
		if(node==null){
			return;
		}
		Deque<Node> deque = new ArrayDeque<>();
		deque.addLast(node);
		while(!deque.isEmpty()){
			Node first = deque.pollLast();
			System.err.print(first.data);
			if(first.left != null){
				deque.addLast(first.left);
			}
			if(first.right != null){
				deque.addLast(first.right);
			}
		}
	}
	
	/**
	 * 按层遍历
	 * @param node
	 */
	public void byLayer(Node node){
		if(node==null){
			return;
		}
		Deque<Node> deque = new ArrayDeque<>();
		deque.addLast(node);
		while(!deque.isEmpty()){
			Node first = deque.pollFirst();
			System.err.print(first.data);
			if(first.left != null){
				deque.addLast(first.left);
			}
			if(first.right != null){
				deque.addLast(first.right);
			}
		}
	}
	
	/**
	 * 递归遍历
	 * @param node
	 * @param list
	 * @return
	 */
	public void ergodic(Node node){
		System.out.println(node.data);//前序遍历
		if(node.left!=null){
			ergodic(node.left);
		}
		//System.out.println(node.data);//中序遍历
		if(node.right!=null){
			ergodic(node.right);
		}
		//System.out.println(node.data);//后序遍历
	}
	
	/**
	 * 中序遍历
	 * @throws Exception
	 */
	public void midOrderWithoutRecurs() throws Exception {
        if (root == null)
            return;
        Stack<Node> s = new Stack<>(64);
        Node current;
        s.push(root);
        while (! s.isEmpty()) {
            current = s.getTop();
            if (current.state == 0) {
                if (current.left != null)
                    s.push(current.left);
                current.state = 1;
                //System.out.println(current.data);//前序遍历
            }
            else if (current.state == 1) {
                current.state = 2;
                System.out.println(current.data);//中序遍历
            }
            else if (current.state == 2) {
                if (current.right != null)
                    s.push(current.right);
                current.state = 3;
            }
            else if (current.state == 3) {
                s.pop();
                current.state = 0;
                //System.out.println(current.data);//后序遍历
            }
        }
    }
	
	
	public static void main(String[] args) throws Exception {
		int[] arr = new int[]{5,3,6,4,8};
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		for (int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}
		//tree.midOrderWithoutRecurs();
		//tree.traverseByLevelFromTop(tree.root);
		//tree.visitByLayer();
		//tree.ergodic(tree.root);
		tree.byLayer(tree.root);
	}
}
class Node{
	public Object data;
	public Node left;
	public Node right;
	public int state;
	
	public Node(Object data) {
		this.data = data;
	}
}