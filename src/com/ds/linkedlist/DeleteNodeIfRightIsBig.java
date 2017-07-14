package com.ds.linkedlist;

public class DeleteNodeIfRightIsBig extends NodeCreateAndTraverse{
	public void deleteBigOnRight(Node start){
		Node temp = start;
		Node prev = null;
		Node head = start;
		while(temp.next!=null){
			prev = temp;
			temp = temp.next;
			while(prev.data < temp.data){
				temp = temp.next;
			}
			if(prev == start){
				prev = temp;
			}else{
				prev = prev.next;
			}
		}
		System.out.println(start);
	}
	public static void main(String[] args) {
		/*DeleteNodeIfRightIsBig ob = new DeleteNodeIfRightIsBig();
		int[] m = new int[]{1,2,3,4,5,6,7};
		Node start = ob.createList(m);
		ob.deleteBigOnRight(start);*/
	}
}

