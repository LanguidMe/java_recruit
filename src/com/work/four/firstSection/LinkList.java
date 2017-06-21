package com.work.four.firstSection;

/**
 * 一个单向链表，删除指定的结点
 */
public class LinkList {
	LinkNode first;
	LinkNode last;
	int size=0;
	
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.add(4);
		System.out.println(linkList.remove(3));
		System.out.println(linkList);
	}
	
	/**
	 * 添加
	 * @param a
	 */
	public void add(int a){
		LinkNode l = last;
		LinkNode node = new LinkNode(a);
		last=node;
		if(l==null){
			first = node;
		}else
			l.next = node;
		size++;
	}
	
	/**
	 * 获取(貌似没什么用~)
	 * @param a
	 * @return
	 */
	public int get(int a){
		return query(a).data;
	}
	
	public LinkNode query(int a){
		for(LinkNode f = first;f!=null;f=f.next){
			if(f.data==a){
				return f;
			}
		}
		return null;
	}
	
	/**
	 * 删除方法
	 * @param a 需要删除的对象
	 * @return
	 */
	public int remove(int a){
		boolean fig = false;
		for(LinkNode f = first;f!=null;f=f.next){
			if(f.next.data==a){
				f.next = f.next.next;
				fig = true;
				break;
			}
			if(f.equals(first)){
				if(f.data==a){
					first = f.next;
					fig = true;
					break;
				}
			}
		}
		if(fig){
			size--;
			return a;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "LinkList [first=" + first + ", last=" + last + ", size=" + size + "]";
	}

	private class LinkNode{
		int data;
	    LinkNode next;

	    public LinkNode(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}
}