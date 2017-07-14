package com.ds.linkedlist;

public class NodeCreateAndTraverse {
	
	
	public Node createList(int[] data){
		Node start = null;
		for(int i=0;i<data.length;i++){
			start = createNode(start, data[i]);			
		}		
		return start;
	}
	
	private Node createNode(Node start,int data){
		Node newNode = new Node(data);
		if(start == null){
			start = newNode;
			return start;
		}else{
			Node temp = start;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newNode;			
		}
		return start;
	}
	
	public void traverse(Node start){
		while(true){
			System.out.print(start.data+"->");
			if(start.next == null){
				break;
			}
			start = start.next;
		}
	}
	
	public int length(Node start){
		if(start.next!=null){
			return 1+length(start.next);
		}else{
			return 1;
		}
	}
	
	public Node rev(Node start){
		Node curr= start;
		Node prev = null;
		Node next = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;			
		}
		return prev;
	}
	
	public static void main(String[] arg){
		NodeCreateAndTraverse ob = new NodeCreateAndTraverse();
		int[] i = new int[]{1,2,3,4,5,6,7,8,9,10};	
		ob.traverse(ob.createList(i));
		ob.rev(ob.createList(i));
		System.out.println("length : "+ob.length(ob.createList(i)));
	}
	
}
