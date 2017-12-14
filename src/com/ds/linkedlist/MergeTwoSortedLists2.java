package com.ds.linkedlist;

public class MergeTwoSortedLists2 extends NodeCreateAndTraverse{
	public Node mergeTwoSortedLists(Node a,Node b){
		Node tmp =new Node();
		Node newList = tmp;
		while(true){
			
			if(a==null){
				tmp.next = b;
				break;
			}
			if(b==null){
				tmp.next = a;
				break;
			}
			
			if(a.data < b.data){
				tmp.next = a;
				a = a.next;
			}else{
				tmp.next = b;
				b = b.next;
			}
			tmp = tmp.next;
		}
		return newList.next;
		
	}
	
	
	public static void main(String[] args) {
		MergeTwoSortedLists2 ob = new MergeTwoSortedLists2();
		int[] d1 = {1,3,5,7};
		int[] d2 = {4,6,8};
		Node a = ob.createList(d1);
		Node b = ob.createList(d2);
		
		Node tmp = ob.mergeTwoSortedLists(a, b);
		ob.traverse(tmp);
		
	}
}
