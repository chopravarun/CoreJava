package com.ds.linkedlist;

public class NthElementFromEnd extends NodeCreateAndTraverse{
	public int getPosition(Node head,int n){
		Node tmp,value;
	    tmp = value = head;
	    int nn;
	    while(n>0){
	        tmp = tmp.next;
	        n--;
	    }
	    while(tmp.next!=null){	    	
	        value = value.next;	        
	        tmp = tmp.next;
	    }
	    return value.data;
	}
	public static void main(String[] args) {
		int[] n = {1,2,3,4,5,6,7,8};
		NthElementFromEnd ob = new NthElementFromEnd();
		Node head = ob.createList(n);
		int m = ob.getPosition(head, 3);
		System.out.println(m);
		
	}
}
