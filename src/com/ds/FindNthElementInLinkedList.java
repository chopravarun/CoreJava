package com.ds;

public class FindNthElementInLinkedList {
	Node head;
	
	public Node create(int count)
	{
		Node tmp = head;
		while(count >= 0){
			if(tmp == null){
				Node n = new Node();
				n.n = count;
				n.next = null;
				tmp = n;
			}else{
				Node n = new Node();
				n.n = count;
				n.next = null;
				tmp.next = n;
			}
			tmp = tmp.next;
			count--;
		}		
		return head;
	}
	
	public static void main(String[] args) {
		FindNthElementInLinkedList obj = new FindNthElementInLinkedList();
		obj.create(5);
		
	}
}

class Node { 
	public int n;
	public Node next;
}