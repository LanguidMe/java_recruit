package com.work.four.firstSection;

/**
 * 1. 实现一个完整的双向链表类
 */
public class DoubleLinkList<E> {
	
	public static void main(String[] args) {
		DoubleLinkList<String> list = new DoubleLinkList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		System.out.println(list.queryNode(2));
		list.deleteNode("ccc");
		list.insertNode("bbb", "ddd");
		System.out.println(list.queryNode(2));
		
	}
	
	DoubleLinkNode<E> head;//头
	DoubleLinkNode<E> tail;//尾
	int size=0;
	
	/**
	 * 添加
	 * @param e
	 */
	public void add(E e){
		DoubleLinkNode<E> f = tail;
		DoubleLinkNode<E> newNode = new DoubleLinkNode<E>(f, e, null);
		tail = newNode;
		if(f==null){
			head = newNode;
		}else
			f.next = newNode;
		size++;
	}
	
	/**
	 * 查询
	 * @param index
	 * @return
	 */
	public E queryNode(int index){// 查询第 index 项的内容
		judegLength(index);
		return get(index).item;
	}
	
	private DoubleLinkNode<E> get(int index){
		judegLength(index);
		if(index<(size>>1)){//if index < size/2
			DoubleLinkNode<E> x= head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		}else{
			DoubleLinkNode<E> x= tail;
			for (int i = size-1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}
	
	private DoubleLinkNode<E> get(E e){
		for (DoubleLinkNode<E> x = head;x!=null;x= x.next) {
			if(e.equals(x.item)){//相等 就删除
				return x;
			}
		}
		return null;
	}
	
	private void judegLength(int index){
		if(index<0||index>=size)
			throw new RuntimeException("超出长度");
	}
	
	/**
	 * 删除
	 * @param toBeDelete
	 */
	public void deleteNode(E toBeDelete){// 将 toBeDelete 从链表中删除
		for (DoubleLinkNode<E> x = head;x!=null;x= x.next) {
			if(toBeDelete.equals(x.item)){//相等 就删除
				delete(x);
			}
		}
	}
	
	void delete(DoubleLinkNode<E> x){
		DoubleLinkNode<E> prev = x.prev;
		DoubleLinkNode<E> next = x.next;
		
		if(prev==null){
			head = next;
		}else{
			prev.next = next;
			x.prev = null;
		}
		if(next == null){
			tail = prev;
		}else{
			next.prev = prev;
			x.next = null;
		}
		x.item = null;
		size--;
	}
	
	/**
	 * 将toBeInsert插入到pos结点后面
	 * @param pos
	 * @param toBeInsert
	 */
	public void insertNode(E pos, E toBeInsert){// 将toBeInsert插入到pos结点后面
		DoubleLinkNode<E> node = get(pos);
		DoubleLinkNode<E> linkNode = new DoubleLinkNode<E>(node, toBeInsert, null);
		if(node.next == null){
			tail = linkNode;
		}else{
			DoubleLinkNode<E> old = node.next;
			old.prev = linkNode;
			linkNode.next = node.next;
		}
		node.next = linkNode;
		size++;
	}
	
	private class DoubleLinkNode<T>{
		T item;
		DoubleLinkNode<T> prev;
		DoubleLinkNode<T> next;
		
		DoubleLinkNode(DoubleLinkNode<T> prev,T item,DoubleLinkNode<T> next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}
}