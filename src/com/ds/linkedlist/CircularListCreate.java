package com.ds.linkedlist;

public class CircularListCreate extends NodeCreateAndTraverse{
	
	/**
	 * n is place from where circle starts
	 * @param n
	 * @return
	 */
	public Node createCircle(Node node,int n){
		int st = 0;
		Node circleStart = null;
		Node listEnd;
		Node start = node;
		while(true){
			if(st == n){
				circleStart = node;
			}
			if(node.next == null ){
				listEnd = node;
				break;
			}
			st++;
			node = node.next;
		}
		System.out.println("Loop created at : "+circleStart.data);
		listEnd.next = circleStart;
		return start;
		
	}
	
	public Node isLooped(Node start){
		
		Node fastPointer = start;
		Node slowPointer = start;
		
		while(true){
			
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if(fastPointer == slowPointer){
				System.out.println(slowPointer.data);
				break;
			}
			if(fastPointer.next == null){
				break;
			}
			if(slowPointer.next == null){
				break;
			}
			
		}
		return slowPointer;		
	}
	
	/**
	 * Loop variable will be one of the node in cycle. Keep rotaing in cycle and on every 
	 * move check if cycle next is not equal to regular list traverse. after one cycle complte 
	 * reset loop variable to starting point and increment traverse by one.
	 * @param start
	 * @param loop
	 */
	public void removeLoop(Node start,Node loop){
		Node ptr1 = start;
		Node ptr2 = loop;
		while(true){
			
			ptr2=loop;
			while(ptr2.next != ptr1 && ptr2.next!=loop  ){				
				ptr2 = ptr2.next;				
			}								
			if(ptr2.next == ptr1){
				break;
			}
			
			ptr1 = ptr1.next;
			
		}
		ptr2.next = null;
		
		System.out.println(start);
		
	}

	public static void main(String arg[]){
		int[] data = new int[]{1,2,3,4,5,6};
		CircularListCreate obj = new CircularListCreate();
		Node start = obj.createList(data);
		start = obj.createCircle(start, 2);
		Node loop = obj.isLooped(start);
		obj.removeLoop(start, loop);
		//obj.traverse(start);
	}
}
