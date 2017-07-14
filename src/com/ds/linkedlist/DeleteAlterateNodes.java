package com.ds.linkedlist;

public class DeleteAlterateNodes extends NodeCreateAndTraverse{
	public void deleteAlternateNodes(Node start){
		Node temp = start;
		while(true){
			System.out.println(temp.data);
			temp.next = (temp.next!=null)?temp.next.next: null;
			temp = temp.next;
			if(temp==null){
				break;
			}
		}
		System.out.println(start);
	}
	public void splitAlternateNodes(Node start){
		Node temp = start;
		Node isol = start.next;
		Node prev = isol;
		while(true){				
			temp.next = (temp.next!=null)?temp.next.next: null;
			temp = temp.next;
			if(isol !=null){
				isol.next = (temp==null)?null:temp.next;
				isol = isol.next;
			}
			if(temp==null){
				break;
			}
		}
		System.out.println(start);
		System.out.println(prev);
	}
	
	public static void main(String[] args) {
		DeleteAlterateNodes ob = new DeleteAlterateNodes();
		int[] m = new int[]{1,2,3,4,5,6,7};
		Node start = ob.createList(m);
		ob.splitAlternateNodes(start);
	}
}
