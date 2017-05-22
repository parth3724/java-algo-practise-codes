
public class MyHash {
	static class Node {
	int key;
	String value;
	Node next=null;
	public Node (int n,String s) { key = n;value=s;}
	public void print(){ System.out.println(key+" "+value);}
	}
	static class MyHashMap {
	float maxLoad=0.4f;
	int size=0;
	float currentLoad=0f;
	Node ar[] = new Node[16];
	public void print(){
	 	for(int i=0;i<ar.length;i++){
			 Node current=ar[i];
			 while(current!=null){ current.print();current=current.next;}
		}			
	}
	public void adjustLoad(){
	    currentLoad = size/ar.length;
		if(currentLoad > maxLoad){
		    Node tem[] = ar;
			Node ar[] = new Node[tem.length*2];
			size=0;
			for(int i=0;i<tem.length;i++){
			 Node current=tem[i];
			 while(current!=null){put(current.key,current.value);current=current.next;}
			}			
		}
	}
	public boolean put(int n,String value){
	 int cost=0;
	 int i=n%ar.length;
	 if(ar[i]==null){
	   ar[i]=new Node(n,value);
		size++;
		return true;
	 }
	 Node previous=null;
	 Node current=ar[i];
	 while(current!=null){
	 cost++;
	  if(current.key==n) {
		  return false;
	  }
	  previous=current;
	  current=current.next;
	 }
	 previous.next=new Node(n,value);
	 size++;
	 adjustLoad();
	 return true;		
	}
	}
	
	public static void main(String args[]) {
	   	MyHashMap map = new MyHashMap();
		map.put(23,"fds");
		map.put(2543,"frefs");
		map.put(2333,"qwehm");
		map.put(233,"plmeq");
		map.put(283,"ytwvn");
		map.put(123,"fds");
		map.put(21543,"frefs");
		map.put(23133,"qwehm");
		map.put(2313,"plmeq");
		map.put(2813,"ytwvn");
		map.print();
	}
	
}