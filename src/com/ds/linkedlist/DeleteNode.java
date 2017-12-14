package com.ds.linkedlist;

public class DeleteNode extends NodeCreateAndTraverse{
	public Node deleteNode(Node head, int position){
		if(head.next ==null){
			return null;
		}else{
			Node tmp = head;
			while(position-1 > 0){
				tmp = tmp.next;
				position--;
			}
			tmp.next = tmp.next.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6};
		DeleteNode obj = new DeleteNode();
		Node head = obj.createList(data);
		obj.traverse(head);
		head = obj.deleteNode(head, 0);
		System.out.println();
		obj.traverse(head);
	}
}
