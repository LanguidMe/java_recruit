package com.work.five.secondSection;

public class BinarySearhTree<T extends Comparable<T>> {
	public Node<T> root;
	
	public boolean add(T data){
		if(root == null){
			root = new Node<T>(data);
			return true;
		}
		Node<T> r = root;
		while(true){
			if(data.compareTo(r.data)<0){
				if(r.left!=null){
					r = r.left;
				}else{
					Node<T> n = new Node<T>(data);
					r.left = n;
					n.parent = r;
					break;
				}
			}else{
				if(r.right != null){
					r = r.right;
				}else{
					Node<T> n = new Node<T>(data);
					r.right = n;
					n.parent = r;
					break;
				}
			}
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public void refresh(){
		if(root == null){
			return;
		}
		Node<T> n = root;
		Node<T> left = n.left;
		Node<T> right = n.right;
		int lnum=0;int rnum=0;
		if(left!=null){
			while(true){
				if(left.left!=null){
					left = left.left;
					lnum++;
				}else
					break;
			}
			while(true){
				if(right.right!=null){
					right = right.right;
					rnum++;
				}else
					break;
			}
		}
		//if(lnum-rnum>=2){
			int l =0,r = 0;
			Node<T> ln = root.left;
			if(ln!=null){
				Node<T> le = ln;
				Node<T> ri = ln;
				while(le.left!=null){
					le = le.left;
					l++;
				}
				while(ri.right!=null){
					ri = ri.right;
					r++;
				}
			}
			if(l>r){//左子树的左边大
				//进行右转
				Node<T> node = root;//赋值顶层
				Node<T> leftNode = root.left;//获取左子
				Node<T> suns = node.left.right;//获取右孙
				node.left.right = null;//右孙设置为null
				root = leftNode;//左子做父
				root.right = node;//父作右子
				node.parent = root;
				root.parent = null;
				root.right.left = suns;
				suns.parent = root.right;
			}
			if(r>l){//左子树的右边大
				//对左子进行左转   然后对整个树进行右转
				Node<T> node = root;
				if(node.left.right!=null&&node.left.left!=null){
					Node<T> sunsR = node.left.right;
					Node<T> sunsL = node.left;
					sunsL.parent = sunsR;
					sunsL.right = null;
					sunsR.parent = node;
					sunsR.left = sunsL;
					node.left = sunsR;
					root = node;
					
					//进行右转
					Node<T> node2= root;//赋值顶层
					Node<T> leftNode = root.left;//获取左子
					Node<T> suns = node2.left.right;//获取右孙
					node2.left.right = null;//右孙设置为null
					root = leftNode;//左子做父
					root.right = node2;//父作右子
					node2.parent = root;
					root.parent = null;
					root.right.left = suns;
					suns.parent = root.right;
				}
			}
		//}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,6,1,3,4};
		BinarySearhTree<Integer> tree = new BinarySearhTree<>();
		for (int i : arr) {
			tree.add(i);
		}
		tree.refresh();
		System.out.println(tree.root);
	}
}
class Node<T extends Comparable<T>>{
	public T data;
	public Node<T> left;
	public Node<T> right;
	public Node<T> parent;
	
	public Node(T data) {
		this.data = data;
	}
} 
