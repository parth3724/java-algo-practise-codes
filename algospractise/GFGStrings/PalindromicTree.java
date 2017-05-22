//http://www.geeksforgeeks.org/palindromic-tree-introduction-implementation/
import java.util.ArrayList;

class PalindromicTree{
	public static void main(String args[]){
		String s = "abcbab";
		makeTree(s);	
		for(int i=0;i<forPrinting.size();i++){
			Node n = forPrinting.get(i);
			System.out.println(s.substring(n.start,n.end+1));	
		//	System.out.println(n.start+" "+n.end);	
		}
	}
	
	public static void makeTree(String s){
	forPrinting.clear();
		root1=new Node(-2,-4);//start and end irrelevant for root1 and root2
		root1.suffix=root1;
		root2=new Node(-1,-2);
		root2.suffix=root1;
		current=root1;
		for(int i=0;i<s.length();i++){
			char c;
			c=s.charAt(i);		
			while(true){
				if(i-current.length-1>=0 && s.charAt(i-current.length-1)==c)
				    break;
				else 
					current=current.getSuffix();
			}
			if(current.getInsert(c)!=null){
				current=current.getInsert(c);
				continue;
			}
			Node temp = new Node(i-current.length-1,i);//do not use current.start || current.end. use only current.length and i
			current.addInsertNode(c,temp);
			if(temp.getLength()==1){
				temp.setSuffix(root2);
				current=temp;
				continue;
			}
			current=current.getSuffix();
			while(true){
				if(i-current.length-1>=0 && s.charAt(i-current.length-1)==c)
				    break;
				else 
					current=current.getSuffix();
			}
			temp.setSuffix(current.getInsert(c));
			current=temp;			
		}
	}
	static ArrayList<Node> forPrinting = new ArrayList<Node>();
	static Node root1,root2,current;//root1.length=-1, root2.length=0
	static class Node{
		int start,end;
		Node suffix;
		int length;
		Node insert[]=new Node[26];
		
		public Node(int s,int e){
			start=s;end=e;
			length=e-s+1;
			
		}
		public int getLength(){
			return length;
		}
		public void addInsertNode(char c,Node n){
			insert[c-'a']=n;
			forPrinting.add(n);
		}
		public Node getInsert(char c){
			return insert[c-'a'];
		}
		public void setSuffix(Node s){
			suffix=s;
		}
		public Node getSuffix(){
			return suffix;
		}
	}
}