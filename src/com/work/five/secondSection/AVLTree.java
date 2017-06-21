package com.work.five.secondSection;

public class AVLTree {
	public AVLNode root;
	public static void main(String[] args) {
		int[] arr = new int[]{5,3,6,2,4,1};
		AVLTree tree = new AVLTree();
		//AVLNode node = new AVLNode(5);
		for (int i : arr) {
			//tree.insert(node,i);
			tree.add(i);
		}
		tree.remove(1);
		tree.remove(2);
		System.out.println(tree.root);
	}
	
	public boolean delete(AVLNode p){
		if(p==null){
			return false;
		}
		AVLNode node = root;
		AVLNode child;
		while(node.parent!=null){
			node = node.parent;
		}
		AVLNode parent = p.parent;
		if(p.right==null&&p.left==null){
			if(p == node){
				node=null;
				return true;
			}
			if(parent.right == p){
				parent.right =null;
			}else{
				parent.left = null;
			}
		}else if(p.right!=null&&p.left!=null){
			AVLNode n = successor(node.left);
			node.left.data = n.data;
			if(n.parent.left == n){
				n.parent.left =null;
			}else{
				n.parent.right=null;
			}
		}else{
			if(p.left !=null){
				child = p.left;
			}else{
				child = p.right;
			}
			if(p==node){
				child.parent = null;
				node = child;
			}
			if(p.parent !=null){
				child.parent = p.parent;
				if(p.parent.left==p){
					p.parent.left = child;
				}else{
					p.parent.right = child;
				}
			}
		}
		return true;
	}
	
	public boolean remove(int data){
		if(root ==null){
			return false;
		}
		AVLNode node = root;
		while(node.parent!=null){
			node = node.parent;
		}
		while(true){
			if(node.data == data){
				root = null;
				return true;
			}
			if(data<node.data){
				if(node.left!=null){
					if(node.left.data == data){
						AVLNode pr = node.parent;
						node.depth = node.depth -1;
						delete(node.left);
						while(true){
							if(pr!=null){
								updateDepth(pr);
								pr = pr.parent;
							}else
								break;
						}
						return true;
					}else{
						node = node.left;
					}
				}else{
					return false;
				}
			}else{
				if(node.right!=null){
					if(node.right.data == data){
						AVLNode pr = node.parent;
						node.depth = node.depth -1;
						delete(node.right);
						while(true){
							if(pr!=null){
								updateDepth(pr);
								pr = pr.parent;
							}else
								break;
						}
						return true;
					}else{
						node = node.right;
					}
				}else{
					return false;
				}
			}
		}
	}
	
	/**
	 * 根据节点获取它的中序后继
	 * @param avlNode
	 * @return
	 */
	public AVLNode successor(AVLNode avlNode){
		if(avlNode == null){
			return null;
		}
		if(avlNode.right!=null){
			AVLNode n = avlNode.right;
			while(n.left!=null){
				n = n.left;
			}
			return n;
		}else{
			AVLNode p = avlNode.parent;
			while(p!=null&&p.left!=avlNode){
				p = p.parent;
			}
			return p;
		}
	}
	
	public void add(int data){
		if(root==null){
			root = new AVLNode(data);
		}else{
			AVLNode n = root;
			AVLNode avlNode = null;
			while(true){
				if(data<n.data){
					if(n.left!=null){
						n = n.left;
					}else{
						avlNode = new AVLNode(data);
						n.left = avlNode;
						avlNode.parent = n;
						AVLNode p = n;
						while(true){
							if(p!=null){
								updateDepth(p);
								p = p.parent;
							}else
								break;
						}
						break;
					}
				}else{
					if(n.right != null){
						n= n.right;
					}else{
						avlNode = new AVLNode(data);
						n.right = avlNode;
						avlNode.parent = n;
						AVLNode p = n;
						while(true){
							if(p!=null){
								updateDepth(p);
								p = p.parent;
							}else
								break;
						}
						break;
					}
				}
			}
		}
	}
	
	public void updateDepth(AVLNode node){
			node.balance = calcBalance(node);
			if(node.balance>=2){
				if(node.left.balance==-1){
					//进行左转
					left_rotate(node.left);
				}
				//进行右转
				right_rotate(node);
			}
		if(node.balance <=-2){
			if(node.right.balance==1){
				//进行右转
				right_rotate(node.right);
			}
			//进行左转
			left_rotate(node);
		}
		node.balance = calcBalance(node);
		node.depth = calcDepth(node);
	}
	
	public void insert(AVLNode r,int data){
		if (data < r.data) {
            if (r.left != null)
                insert(r.left, data);
            else {
                r.left = new AVLNode(data);
                r.left.parent = r;
            }
        }
        else {
            if (r.right != null)
                insert(r.right, data);
            else {
                r.right = new AVLNode(data);
                r.right.parent = r;
            }
        }
		r.balance = calcBalance(r);
		
		//左子树高 右转
		if(r.balance >=2){
			//右孙高  左转
			if(r.left.balance==-1){
				//进行左转
				left_rotate(r.left);
			}
			//进行右转
			right_rotate(r);
		}
		
		if(r.balance <=-2){
			if(r.right.balance==1){
				//进行右转
				right_rotate(r.right);
			}
			//进行左转
			left_rotate(r);
		}
		
		r.balance = calcBalance(r);
		r.depth = calcDepth(r);
	}
	
	public void left_rotate(AVLNode p){
		AVLNode pp = p.parent;
		AVLNode pr = p.right;
		p.parent = pr;
		p.right = null;
		pr.parent = pp;
		pr.left = p;
		if(p == pp.left){
			pp.left = pr;
		}else if(p == pp.right){
			pp.right = pr;
		}
		/* 重新计算平衡因子 */
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);

        pr.depth = calcDepth(pr);
        pr.balance = calcBalance(pr);
        
	}
	
	 private void right_rotate(AVLNode p) {
		    /* 一次旋转涉及到的结点包括祖父，父亲，右儿子 */
	        AVLNode pParent = p.parent, pRightSon = p.left;
	        AVLNode pLeftGrandSon = pRightSon.right;

		    /* 左子僭为父 */
	        pRightSon.parent = pParent;
	        if (pParent != null) {
	            if (p == pParent.left)
	                pParent.left = pRightSon;
	            else if (p == pParent.right)
	                pParent.right = pRightSon;
	        }

	        pRightSon.right = p;
	        p.parent = pRightSon;

		    /* 右孙变左孙 */
	        p.left = pLeftGrandSon;
	        if (pLeftGrandSon != null)
	            pLeftGrandSon.parent = p;

		    /* 重新计算平衡因子 */
	        p.depth = calcDepth(p);
	        p.balance = calcBalance(p);

	        pRightSon.depth = calcDepth(pRightSon);
	        pRightSon.balance = calcBalance(pRightSon);
	    }
	
	private int calcBalance(AVLNode p){
		int left_depth;
		int right_depth;
		
		if(p.left!=null){
			left_depth = p.left.depth;
		}else
			left_depth = 0;
		
		if(p.right !=null){
			right_depth = p.right.depth;
		}else
			right_depth = 0;
		
		return left_depth - right_depth;
	}
	
	private int calcDepth(AVLNode p){
		int depth = 0;
		if(p.left != null){
			depth = p.left.depth;
		}
		if(p.right!=null&&depth<p.right.depth){
			depth = p.right.depth;
		}
		depth++;
		return depth;
	}
}
class AVLNode {
    public int data;
    public int depth;//当前子树深度
    public int balance;//左右子树高度之差
    public AVLNode parent;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int data) {
        this.data = data;
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }
}