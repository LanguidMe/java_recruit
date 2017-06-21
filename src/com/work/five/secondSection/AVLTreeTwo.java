package com.work.five.secondSection;

public class AVLTreeTwo {
	public AVLNode root;
	public static void main(String[] args) {
		int[] arr = new int[]{3,6,2,4,1};
		AVLTreeTwo tree = new AVLTreeTwo();
		AVLNode node = new AVLNode(5);
		for (int i : arr) {
			tree.insert(node,i);
		}
		while(node.parent!=null){
			node = node.parent;
		}
		tree.root = node;
		tree.remove(1);
		tree.remove(2);
		System.out.println(node);
	}
	
	public AVLNode getEntry(int data){
		AVLNode r = root;
		if(r == null){
			return null;
		}
		while(true){
			if(r.data == data){
				return r;
			}
			if(data<r.data){
				if(r.left != null){
					r = r.left;
				}else{
					return null;
				}
			}else{
				if(r.right != null){
					r = r.right;
				}else{
					return null;
				}
			}
		}
	}
	
	public void removeOverried(AVLNode delete){
		if(delete.right ==null&& delete.left == null){
			if(delete == root){
				delete = null;
			}else{
				if(delete == delete.parent.right){
					delete.parent.balance = delete.parent.balance+1;
				}else if(delete == delete.parent.left){
					delete.parent.balance = delete.parent.balance-1;
				}
			}
			AVLNode p = delete.parent;
			if(delete.parent.right == delete){
				delete.parent.right = null;
			}else if(delete.parent.left == delete){
				delete.parent.left = null;
			}
			delete.parent = null;
			delete = null;
			isBacl(p);
		}else if(delete.right !=null&& delete.left != null){
			AVLNode inorder = successor(delete);
			delete.balance = delete.balance+1;
			delete.data = inorder.data;
			removeOverried(inorder);
		}
	}
	
	public void remove(int data){
		AVLNode delete = getEntry(data);
		removeOverried(delete);
	}
	
	public AVLNode successor(AVLNode waitDel){
		if(waitDel==null){
			return null;
		}
		if(waitDel.right!=null){
			AVLNode p = waitDel.right;
			while(p.left!=null){
				p = p.left;
			}
			return p;
		}else{
			AVLNode p = waitDel.parent;
			AVLNode eh = waitDel;
			while(p!=null&&eh == p.right){
				eh = p;
				p = p.parent;
			}
			return p;
		}
	}
	
	public void isBacl(AVLNode r){
		//计算左右子树高度之差
		r.balance = calculationLR(r);
		
		//如果高度之差>=2表示左边深度比较大  右边深度小  需要进行右转
		if(r.balance>=2){
			if(r.left.balance==-1){
				//左子的子树的右边深度大 左转
				leftRotate(r);
			}
			//右转
			rightRotate(r);
		}
		if(r.balance<=-2){
			if(r.right.balance==1){
				//右子的子树左边深度大  右转
				rightRotate(r);
			}
			//如果右孙高 则左转
			leftRotate(r);
		}
		//重新计算高度数
		r.balance = calculationLR(r);
		r.depth = calcuDepth(r);
		if(r.parent != null){
			isBacl(r.parent);
		}
	}
	
	public void insert(AVLNode root,int data){
		if(root==null){
			return;
		}else{
			if(data<root.data){
				if(root.left!=null){
					insert(root.left,data);
				}else{
					AVLNode node = new AVLNode(data);
					node.parent = root;
					root.left = node;
				}
			}else{
				if(root.right!= null){
					insert(root.right,data);
				}else{
					AVLNode node = new AVLNode(data);
					node.parent = root;
					root.right = node;
				}
			}
			//计算左右子树高度之差
			root.balance = calculationLR(root);
			
			//如果高度之差>=2表示左边深度比较大  右边深度小  需要进行右转
			if(root.balance>=2){
				if(root.left.balance==-1){
					//左子的子树的右边深度大 左转
					leftRotate(root);
				}
				//右转
				rightRotate(root);
			}
			if(root.balance<=-2){
				if(root.right.balance==1){
					//右子的子树左边深度大  右转
					rightRotate(root);
				}
				//如果右孙高 则左转
				leftRotate(root);
			}
			//重新计算高度数
			root.balance = calculationLR(root);
			root.depth = calcuDepth(root);
		}
	}
	
	/**
	 * 右转
	 * @param p
	 */
	public void rightRotate(AVLNode p){
		//父级
		AVLNode parent = p.parent;
		//左子
		AVLNode leftNode = p.left;
		//右孙
		AVLNode rightSon = leftNode.right;
		
		leftNode.parent = parent;//左子做父
		if(parent!=null){
			if(parent.left==p){
				parent.left = leftNode;
			}else if(parent.right == p){
				parent.right = leftNode;
			}
		}
		if(rightSon != null){
			p.left = rightSon;//右孙变左孙
			rightSon.parent = p;
		}else{
			p.left = null;
		}
		leftNode.right = p;//父作右子
		p.parent = leftNode;
	}
	
	/**
	 * 左转
	 * @param p
	 */
	public void leftRotate(AVLNode p){
		AVLNode parent = p.parent;
		AVLNode right = p.right;
		AVLNode leftSon = right.left;
		
		right.parent = parent;//右子做父
		right.left = p;//父作左子
		p.parent = right;
		if(leftSon!=null){
			p.right = leftSon;//左孙变右孙
			leftSon.parent = p;
		}else{
			p.right = null;
		}
		if(parent != null){
			if(parent.left == p){
				parent.left = right;
			}else if(parent.right == p){
				parent.right = right;
			}
		}
	}
	
	/**
	 * 计算左右子树高度之差
	 * @param node
	 * @return
	 */
	public int calculationLR(AVLNode node){
		int left = 0;
		int right = 0;
		if(node.left!=null){
			left = node.left.depth;
		}
		if(node.right!=null){
			right = node.right.depth;
		}
		return left - right;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int calcuDepth(AVLNode node){
		int depth = 0;
		if(node.left != null){
			depth = node.left.depth;
		}
		if(node.right!=null&&depth<node.right.depth){
			depth = node.right.depth;
		}
		depth++;
		return depth;
	}
}