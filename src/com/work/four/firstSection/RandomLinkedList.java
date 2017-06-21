package com.work.four.firstSection;

/**
 * 有一个复杂链表，结点包含next指针和sibling指针，其中next指针指向下一个结点，而sibling指针指向链内的某一个不确定位置的结点。复制这个链表
 * 这个本来没有思路的  是百度了下才有的思路  按照自己的思路写的(脑子真不怎么滴 哎~)
 */
public class RandomLinkedList {
	public static void main(String[] args) {
		RandomLinkedNode head = new RandomLinkedNode(1);
		RandomLinkedNode p1 = new RandomLinkedNode(2);
		RandomLinkedNode p2 = new RandomLinkedNode(3);
		RandomLinkedNode p3 = new RandomLinkedNode(4);
		RandomLinkedNode p4 = new RandomLinkedNode(5);
		
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;
          
        head.sibling = p2;
        p1.sibling = p4;
        p3.sibling = p1;
        p2.sibling = null;
        p4.sibling = null;
        
        cloneList(head);
        sibling(head);
        split(head);
	}
	
	/**
	 * 复制next
	 * @param head
	 */
	public static void cloneList(RandomLinkedNode head){
		RandomLinkedNode headp = head;
		while(headp!=null){
			RandomLinkedNode node = new RandomLinkedNode(headp.data,headp.sibling);
			node.next = headp.next;
			headp.next = node;
			headp= node.next;
		}
		System.out.println(head);
	}
	
	/**
	 * 复制sibling
	 * @param head
	 */
	public static void sibling(RandomLinkedNode head){
		RandomLinkedNode headp2 = head;
		while(headp2!=null){
			RandomLinkedNode headp3 = headp2.next;
			if(headp2.sibling!=null){
				headp2.sibling = headp3.sibling;
			}
			headp2 = headp3.next;
		}
		System.out.println(head);
	}
	
	/**
	 * 分隔
	 * @param head
	 * @return
	 */
	public static RandomLinkedNode split(RandomLinkedNode head){
		RandomLinkedNode one =null,two=null;
		RandomLinkedNode first =null,second=null;
		for(int i=1;head!=null;i++){
			if(i%2!=0){
				if(first==null){
					one = new RandomLinkedNode(head.data,head.sibling);
					first = one;
				}else{
					first.next = new RandomLinkedNode(head.data,head.sibling);
					first = first.next;
				}
			}else{
				if(second==null){
					two = new RandomLinkedNode(head.data,head.sibling);
					second = two;
				}else{
					second.next = new RandomLinkedNode(head.data,head.sibling);
					second = second.next;
				}
			}
			head = head.next;
		}
		return two;
	}
}

class RandomLinkedNode{
	int data;
	RandomLinkedNode next;
	RandomLinkedNode sibling;
	
	RandomLinkedNode(int data,RandomLinkedNode sibling) {
		this.data = data;
		this.sibling = sibling;
	}
	
	RandomLinkedNode(int data) {
		this.data = data;
	}
}