package com.ds.linkedlist;

public class MergeTwoSortedLists extends NodeCreateAndTraverse {
	
	public Node mergeTwoLists(Node a,Node b){
		Node temp = new Node();
		Node newStart = temp;
		while(true){
			if(a==null){
				temp.next = b;
				break;
			}
			if(b==null){
				temp.next = a;
				break;
			}
			if(a.data <= b.data){
				temp.next = a;
				a = a.next;
			}else{
				temp.next = b;
				b = b.next;
			}			
			temp = temp.next;
			System.out.println(newStart);
		}			
		return newStart;
	}
	
	public Node mergeSort(Node start){
		Node temp = start;
		int count = this.length(temp);
		for(int i = 0;i<count/2;i++)temp = temp.next;
		System.out.println(start.data +"-"+temp.data);		
		return null;
	}
	
	public int length(Node start){
		int count =0;
		while(true){
			if(start==null){
				break;
			}
			count++;
			if(start.next==null){
				break;
			}			
			start = start.next;
		}
		return count;
	}
	
	public static void main(String[] arg){
		int[] a = new int[]{ 2,10,15};
		int[] b = new int[]{3,7,8,9,16};
		MergeTwoSortedLists ob = new MergeTwoSortedLists();
		Node linka = ob.createList(a);
		Node linkb = ob.createList(b);
		Node nn = ob.mergeTwoLists(linka, linkb);
		ob.traverse(nn);
		//ob.mergeSort(linkb);
	}
}
