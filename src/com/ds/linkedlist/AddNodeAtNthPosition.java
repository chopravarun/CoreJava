package com.ds.linkedlist;

public class AddNodeAtNthPosition extends NodeCreateAndTraverse {
	public Node insertAt(Node head,int data,int position){
		Node tmp;
		if(head == null){
			Node n = new Node();
			n.data = data;
			n.next = null;
			head = n;
			return head;
		}else if(position ==0) {
			Node n =  new Node();
			n.data =data;
			n.next = head;
			head = n;
			return head;
		}else{
		
			tmp = head;
			while(position-1 > 0){
				tmp = tmp.next;		
				position--;
			}
			Node n = new Node();
			n.data = data;
			n.next = tmp.next;
			tmp.next = n;
		}
		return head;
	}	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6};
		AddNodeAtNthPosition obj = new AddNodeAtNthPosition();
		Node head = obj.createList(data);
		obj.traverse(head);
		head = obj.insertAt(head,30,3);
		obj.traverse(head);
	}
}
