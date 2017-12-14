package com.ds.linkedlist;

public class ReverseLinklistLoop extends NodeCreateAndTraverse{
	public void reverse(Node start){
		Node prev  = null;
		Node curr = start;
		Node next = null;
		
		while(curr!= null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node tmp = prev;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public Node reversePartOfLinklist(Node start,int n){
		Node curr = start;
		Node prev = null;
		Node next = null;;
		int count = 0;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;			
			if(count == n){
				break;
			}
		}
		if(next!=null){
			// start is used because start will always first of given list and last of reversed list
			start.next =reversePartOfLinklist(next,n); 
		}
			
		
		return prev;
		
	}
	public Node reverserAlternatePart(Node start,int part,boolean alter){
		Node curr = start;
		Node prev = null;
		Node next = null;;
		int count = 0;
				
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;			
			if(count == part){
				break;
			}
		}
		
		start.next = next;
		count = 1;
		while(count <= part &&  start!=null){
			start = start.next;
			count++;
		}
		if(start!=null){
			start.next = reverserAlternatePart(start.next,part,true);
		}
				
		
		return prev;
	}
	
	public static void main(String arg[]){
		int[] m = new int[]{1,2,3,4,5,6,7,8,9};
		ReverseLinklistLoop loop = new ReverseLinklistLoop();
		Node start = loop.createList(m);
		loop.reverse(start);
		//Node part = loop.reverserAlternatePart(start, 3,true);
		//loop.traverse(part);
		
	}
}
