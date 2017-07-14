package com.ds.linkedlist;

public class SwapElementsLikedList {
	public Node start;
	public void createList(){		
		int[] data = new int[]{10,15,12,13,20,14};
		for(int i=0;i<data.length;i++){
			createNode(start, data[i]);			
		}
	}
	public Node createNode(Node start,int n){
		Node node = new Node(n);
		Node temp = start;
		if(start == null){
			this.start = node;
			return node;
		}else{
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
			node.next = null;
		}
		return this.start;
		
	}
	public void traverse(){
		Node head = start;
		
		while(true){
			System.out.println(head.data +"->");
			if(head.next == null){
				break;
			}
			head = head.next;
		}		
	}
	
	public Node getNodeBeforeFound(Node element){
		Node head = start;
		boolean isFound = false;
		do{			
			if(head.next.data == element.data){
				isFound = true;
				break;
			}else{
				head = head.next;
			}
		}while(head.next != null);

		
		if(isFound){
			return head;
		}
		return null;		
	}
	
	public void swapElements(Node n,Node m){
		Node head = start;
		Node currX = null,prevX = null,currY =null,prevY = null,prev= null;;
		currX = head ;
		currY = head;
		
		while(head.next!=null){
			
			if(head.data == n.data){
				prevX = prev;
				currX = head;
			}
			
			if(head.data == m.data){
				prevY = prev;
				currY = head;
			}			
			prev = head;
			head = head.next;
		}
		
		System.out.println(prevX);
		System.out.println(currX);
		System.out.println(prevY);
		System.out.println(currY);
		
		if(prevX != null){
			prevX.next = currY;
		}else{
			start = currY;
		}
		
		if(prevY != null){
			prevY.next = currX;
		}else{
			start = currX;
		}
		
		
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		
		// fuddu code
		/*if(n.data == start.data){
			Node mPrev = this.getNodeBeforeFound(m);
			Node temp = mPrev.next;
			
			n.next = mPrev.next.next;
			mPrev.next = n;
			temp.next = start.next;
			start = temp;
		}else if (m.data == start.data){
			Node mPrev = this.getNodeBeforeFound(n);
			Node temp = mPrev.next;
			
			m.next = mPrev.next.next;
			mPrev.next = m;
			temp.next = start.next;
			start = temp;
		}else{
			
			Node nPrev = getNodeBeforeFound(n);
			Node mPrev = getNodeBeforeFound(m);
			
			Node tempN = new Node(nPrev.next);
			Node tempM = new Node(mPrev.next);
			
			tempN.next = mPrev.next.next;
			mPrev.next = tempN;
			nPrev.next = nPrev.next.next;
			
			tempM.next = nPrev.next;
			nPrev.next = tempM;
			
			
		}*/				
	}
	
		
	
	public void replaceNode(Node n,Node mPrev){
		Node nPrev = getNodeBeforeFound(n);
		nPrev.next = nPrev.next.next;
		n.next = mPrev.next.next;
		mPrev.next = n;
	}
	
	public static void main(String[] arg){
		SwapElementsLikedList swap =  new SwapElementsLikedList();
		swap.createList();
		Node temp = new Node();
		//{10,15,12,13,20,14};
		Node n  = new Node();
		n.data = 10;
		
		Node m = new Node();
		m.data = 12;
		
		swap.swapElements(n, m);
		swap.traverse();
		
	}
}

