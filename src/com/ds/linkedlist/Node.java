package com.ds.linkedlist;


public class Node{
	int data;
	Node next;
	Node(){}
	Node (int data){
		this.data = data;
		this.next = null;
	}
	Node(Node n){
		this.data = n.data;
		this.next = n.next;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
}