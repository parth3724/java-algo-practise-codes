import java.lang.IllegalStateException;
import java.util.LinkedList;

class SuffixTree{
	static String s;
	static Node root;
	////////////////////active point
	static Node activeN;
	static int activeCharIndex;	
	static int activeL=1;
	//////////////////////////////
	static int reminder;
	/////////////////check activeL <= reminder
	public static void main(String args[]){
		root=new Node();
		activeN=root;activeL=0;activeCharIndex=-1;
		reminder=0;
		s="abcabxabcd$";
		for(int i=0;i<s.length();i++){
			reminder++;
			insert(i,null);
		}
		print();
	}
	public static void print(){
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		int level=0;
		while(list.size()>0){
			int l = list.size();
			level++;
			System.out.println("Nodes at level "+level);
			for(int i=0;i<l;i++){				
				Node n = list.remove();
				System.out.println("Node: "+i);
				n.print();
				n.addChildren(list);
			}
		}
	}
	public static char getActiveChar(){
		if(activeCharIndex<0)
			return Character.MIN_VALUE;
		return s.charAt(activeCharIndex);
	}
	public static void insert(int index,Node calledFrom){
	    Node waiting=calledFrom;
		if(getActiveChar()==Character.MIN_VALUE || activeL<=0){//AP is at node
			if(activeN.contains(index)){//char next to AP is same as new character to be inserted
				activeL=1;activeCharIndex=index;//reminder++;
				if(waiting!=null){//#observation3 for both root and non-root
					System.out.println("surprise surprise 1!! this is possible and hence required.");
					waiting.suffix=activeN;
				}
				//move foreward
			}
			else{//add new charEdge to activeN				
				activeN.addEdge(index);
				reminder--;
				if(activeN==root){//#Rule2 not for root					
					if(reminder>0){
					   System.out.println("index = "+index+" reminder = "+reminder);
					   print();
					  throw new IllegalStateException("not possible!! if reminder > 0 then either AL!=0 or AN!=root.");
					}//insert remaining characters
				}
				else{
					if(waiting!=null){//#Rule2 only for internal node
						waiting.suffix=activeN;
						System.out.println("surprise surprise 2!! this is possible and hence required.");
					}
					if(reminder>0){
						Node tem=activeN;
						activeN=activeN.suffix;
						if(activeN==null)
							activeN=root;
						insert(index,tem);//insert same character for all Nodes on suffix path
					}
					else
						System.out.println("surprise surprise 2.5!! added an edge to internal node and reminder becomes zero!! As per me reminder becomes zero only on root.");
				}	
			}
		}
		else{//AP is on Edge
			Edge e = activeN.getEdge(getActiveChar());
			if(e.getCharAtLength(activeL)==s.charAt(index)){//char next to AP is same as new character to be inserted
				activeL++;//reminder++;
				if(e.start+activeL>e.end){
					activeN=e.dest;activeCharIndex=-1;activeL=0;
					if(activeN==null){
						System.out.println("error is here");
					}
				}
				if(waiting!=null){
					waiting.suffix=activeN;
					System.out.println("surprise surprise 3!! this is possible and hence required.");
				}
				//move foreward
			}
			else{
				Node newNode = e.split(activeL,index);				
				reminder--;
				if(activeN==root){//#Rule1					
					activeCharIndex++;
					activeL--;					
				}
				else{					
					if(waiting!=null){//#Rule 2 only for internal nodes.
						waiting.suffix = newNode;					
					}
					if(reminder>0){
						Node tem=activeN;
						activeN=activeN.suffix;
						if(activeN==null)
							activeN=root;
						insert(index,newNode);
					}
					else{
						System.out.println("surprise surprise 4!! reminder becomes zero when split and edge from internal node. As per me reminder becomes zero only on root.");
					}
				}
			}
		}
	}
	static char getActivePointChar(){
		Edge e = activeN.getEdge(getActiveChar());
		return e.getCharAtLength(activeL);
	}
	static class Node{
		Edge ar[] = new Edge[27];
		Node suffix;
		public Edge addEdge(int index){			
			Edge e = new Edge(index);
			addEdge(e);
			return e;			
		}
		public void print(){
			for(int i=0;i<ar.length;i++){
				if(ar[i]!=null)
					ar[i].print();
			}
		}
		public void addChildren(LinkedList<Node> list){
			for(int i=0;i<ar.length;i++){
				if(ar[i]!=null && ar[i].dest!=null)
					list.add(ar[i].dest);
			}
		}
		public boolean contains(int index){
			return contains(s.charAt(index));
		}
		public boolean contains(char c){
			int i=c-'a';
			if(i<0)
				i=26;
			if(ar[i]!=null)
				return true;
			return false;
		}
		public void addEdge(Edge e){
			int i=s.charAt(e.start)-'a';
			if(i<0)
				i=26;
			if(ar[i]==null){
				ar[i]=e;
			}
			else
				throw new IllegalStateException("trying to replace an Edge !!! not allowed.");
		}
		public Edge getEdge(char c){
			int i=c-'a';
			if(i<0)
				i=26;
			return ar[i];
		}
		
	}
	static class Edge{
		int start,end;
		Node dest;
		public Edge(int st){
			start=st;
			end=s.length()-1;
		}
		public void print(){
			String tem = s.substring(start,end+1);
			System.out.println(tem);
		}
		public Edge(int s,int e){
			start=s;end=e;
		}
		public Edge(int s,int e,Node n){
			start=s;end=e;dest=n;
		}
		public Node split(int length,int index){
			Node n = new Node();
			Edge e = new Edge(start+length,end,dest);
			dest=n;
			end=start+length-1;
			n.addEdge(e);
			n.addEdge(index);
			return n;
		}
		public char getCharAtLength(int l){
			return s.charAt(start+l);
		}		
	}
	
}