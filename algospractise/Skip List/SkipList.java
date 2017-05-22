import java.util.*;
class SkipList{
	 
	 public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		 int ar[] = {4,7,23,56,34,766,3432,6,9,3,87,34,65,433,967,346,3445,374,2578,239,284,84,843,86,247,36,895,23,17,14,1567,23435,2346,5,673,7642,457};
		// addRandom(300);
		 for(int i=0;i<ar.length;i++)
		 insert(ar[i]);
		 print();
		 System.out.println(delete(34));
		 print();
	 }
	 static Node root;
	 public static void addRandom(int n){
	     Random r = new Random();
	     for(int i=0;i<n;i++){
    		 insert(r.nextInt());
	     }
	 }
	 public static void makepillarwithprobability(Node ref[],Node infant) { //just create a node and a trace of its previous elements in pillar including ground level
	  Random r = new Random();
	  int height =1;
	  for(int i=1;i<=ref.length;i++) {
	       int temp = r.nextInt();
		   if(temp%10 ==0){
			   height++;
		   }
		  else
		      break;
	  }
	  infant.next = new Node[height];
	  
	  for(int i=0;i<ref.length && height>0;i++) {
	      infant.next[i]=ref[i].next[i];
		  ref[i].next[i]=infant;
		  height--;
	  }
	  if(height>0) {
	     Node newrootnext[] = new Node[root.next.length+1];
		 for(int i=0;i<root.next.length;i++) {
			 newrootnext[i]=root.next[i];
		 }
		  newrootnext[root.next.length]=infant;
		  root.next = newrootnext;
	  }
	    
	 }
	 public static boolean find(int n) {
	 if(root.value > n)
	 return false;
	 if(root.value==n)
	 return true;
	 
	    int levels = root.next.length;
			Node reference[] = new Node[levels];
		Node current = root;
		Node future=null;
		while(levels>=1) {
			future = current.next[levels-1];
			while(future!=null && future.value < n) {
			current=future;
				future = current.next[levels-1];
			}
			if(future==null && levels==1)
			return false;
			reference[levels-1]=current;
			levels--;
		}
		if(future.value==n)
		return true;
		else
		return false;
	 }
	 public static boolean delete(int n) {
	 if(root.value > n)
	 return false;
	 if(root.value==n) {
	 for(int i=0;i<root.next[0].next.length;i++)
	 root.next[i]=root.next[0].next[i];
	 root.next[0].next=root.next;
	 root=root.next[0];	 
	 return true;
	 }
	 
	    int levels = root.next.length;
			Node reference[] = new Node[levels];
		Node current = root;
		Node future=null;
		while(levels>=1) {
			future = current.next[levels-1];
			while(future!=null && future.value < n) {
			current=future;
				future = current.next[levels-1];
			}
			if(future==null && levels==1)
			return false;
			reference[levels-1]=current;
			levels--;
		}
		if(future.value==n) {
		if(current.next.length>=future.next.length) {
		   for(int i=0;i<future.next.length;i++){
			   current.next[i]=future.next[i];
		   }
		}
		else {
		      for(int i=0;i<reference.length;i++){
			   if(reference[i]==future)
			       reference[i]=current;
		      }
			  current.next=future.next;
		}
		return true;
		}
		else
		return false;
	 }
	public static void insert(int n){ 
	    if(root==null) {
			root = new Node(n);
			return;
		}
		if(root.value > n) { // as this increase complexity of makepillarwithprobability
		    Node tem = new Node(n);
			Node going=root;
		    tem.next = root.next;//this step delets root			
			root=tem;
		    insert(going.value);	
			return;
		}
		Node current = root;
		int level = current.next.length;//last level = 1;
		Node reference[] = new Node[level];
		while(level>0){
		    Node future = current.next[level-1];
			while(future!=null && future.value<=n) {
			    current=future;
				future=current.next[level-1];
			}
			reference[level-1]=current;
			level--;
		}
		makepillarwithprobability(reference,new Node(n));
	}
	static void print() {
	int levels = root.next.length;
	for(int i=levels-1;i>=0;i--) {
	System.out.println("for level "+i);
	   Node current = root;	   
	   while(current!=null) {
		System.out.println("value = "+current.value+" pillar height = "+current.next.length);
		current=current.next[i];
	   }
	}
	}
	static class Node {
		int value;
		Node next[];
		public Node(int a){
			value=a;
			next=new Node[1];
		}
	}
 }