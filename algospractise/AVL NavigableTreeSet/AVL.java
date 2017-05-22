import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/// This AVL tree supports unique integers only.
/// This is not just AVL tree, it also supports APIs of navigable Tree set
// each int can be inserted only once and can be removed only once.

public class AVL{
	private Node root;
	
	public static void main(String args[]){
		AVL tree = new AVL();
		for(int i=1;i<=19;i++)
			tree.avlInsert(i);
		tree.avlDelete(16);
		tree.printTree(null);
		System.out.println("value less than 14 "+tree.strictGreatestValueSmallerThan(14));
		System.out.println("value less than 15 "+tree.strictGreatestValueSmallerThan(15));
		System.out.println("value more than 14 "+tree.strictLeastValueGreaterThan(14));
		System.out.println("value more than 15 "+tree.strictLeastValueGreaterThan(15));
	}
	
	public void avlInsert(int value){
		root = insert(root,value);
	}
	
	public void avlDelete(int value){
		root = delete(root,value);
	}
	public boolean check(int value){
		return check(root,value);
	}
	public int strictGreatestValueSmallerThan(int value){
		return strictGreatestValueSmallerThan(root,value);
	}
	public int strictGreatestValueSmallerThan(Node r, int value){
		if(r.value >= value){
			if(r.l==null) return Integer.MIN_VALUE;
			else return strictGreatestValueSmallerThan(r.l,value);
		}
		else{ //r.value<value
			if(r.r == null) return r.value;
			int tem = strictGreatestValueSmallerThan(r.r,value);
			if(tem == Integer.MIN_VALUE || value-tem > value-r.value) return r.value;
			return tem;
		}		
	}
	public int greatestValueSmallerThanOrEqualTo(int value){
		return greatestValueSmallerThanOrEqualTo(root,value);
	}
	private int greatestValueSmallerThanOrEqualTo(Node r,int value){
		if(r.value == value) return r.value;
		if(r.value > value){
			if(r.l==null) return Integer.MIN_VALUE;//////////////////////////////////
			else return greatestValueSmallerThanOrEqualTo(r.l,value);
		}
		else{ //r.value<value
			if(r.r == null) return r.value;
			int tem = greatestValueSmallerThanOrEqualTo(r.r,value);
			if(tem == Integer.MIN_VALUE || value - tem > value-r.value) return r.value;
			return tem;
		}		
	}
	public int strictLeastValueGreaterThan(int value){
		return strictLeastValueGreaterThan(root,value);
	}
	private int strictLeastValueGreaterThan(Node r,int value){
		if(r.value <= value){
			if(r.r==null) return Integer.MAX_VALUE;////////////////////////////////
			else return strictLeastValueGreaterThan(r.r,value);
		}
		else {
			if(r.l == null) return r.value;
			int tem = strictLeastValueGreaterThan(r.l,value);
			if(tem == Integer.MAX_VALUE || tem - value > r.value -value ) return r.value;
			return tem;
		}
	}
	public int leastValueGreaterThanOrEqualTo(int value){		
		return leastValueGreaterThanOrEqualTo(root,value);
	}
	//greater than or equal to
	private int leastValueGreaterThanOrEqualTo(Node r,int value){
		if(r.value == value) return r.value;
		if(r.value < value){
			if(r.r==null) return Integer.MAX_VALUE;
			else return leastValueGreaterThanOrEqualTo(r.r,value);
		}
		else{ //r.value>value
			if(r.l == null) return r.value;
			int tem = leastValueGreaterThanOrEqualTo(r.l,value);
			if(tem == Integer.MAX_VALUE || tem - value > r.value -value ) return r.value;
			return tem;
		}		
	}
	private boolean check(Node r,int value){
		if(r==null) return false;
		else if(r.value==value) return true;
		else if(value<r.value) return check(r.l,value);
		else return check(r.r,value);
	}
	private Node insert(Node r,int value){
		if(r==null)
			return new Node(value);
		if(r.value>value){
			r.l = insert(r.l,value);
		}
		else if (r.value<value) {
			r.r = insert(r.r,value);
		}
		r.calculateH();
		if(r.needBalance()) return balance(r);
		else return r;
	}
	//will return balanced Node upto r.
	private Node delete(Node r,int value){
		if(r==null)
			return null;
		if(r.value>value) { 
			r.l = delete(r.l,value);r.calculateH();
			if(r.needBalance()) {return balance(r);}
			else return r;
		}
		else if(r.value<value) {
			r.r = delete(r.r,value);r.calculateH();
			if(r.needBalance()) return balance(r);
			else return r;
		}
		else {//delete this node and return a relacement.
			if(r.l==null)
				return r.r;
			if(r.r==null)
				return r.l;
			Node replacement= r.successor();
			r.r = delete(r.r,replacement.value);
			replacement.r = r.r;replacement.l=r.l;replacement.calculateH(); 
			if(replacement.needBalance()) return balance(replacement);
			else return replacement;
		}
	}
	private Node balance(Node r){
		if(r.getLeftHeight() > r.getRightHeight()){
			Node b = r.l;
			if(b.getLeftHeight()>=b.getRightHeight()){
				return rotateRight(r);
			}
			else{
				r.l = rotateLeft(r);
				return balance(r);
			}
		}
		else if(r.getRightHeight()>r.getLeftHeight()){
			Node b = r.r;
			if(b.getRightHeight()>=b.getLeftHeight()){
				return rotateLeft(r);
			}
			else{
				r.r = rotateRight(b);
				return balance(r);
			}
		}
		return r;
	}
	private Node rotateRight(Node r){
		Node b = r.l;Node tem = b.r;
		b.r=r;r.l=tem;
		r.calculateH();b.calculateH();
		return b;
	}
	private Node rotateLeft(Node r){
		Node b = r.r;Node tem = b.l;
		b.l=r;r.r=tem;
		r.calculateH();b.calculateH();
		return b;
	}
	
	private class Node{
		int value;
		Node l,r;
		int h;
		public Node(int i){
			value=i;
			h=1;
		}
		public boolean needBalance(){
			if(getRightHeight()-getLeftHeight()>=2 || getLeftHeight()-getRightHeight()>=2)
				return true;
			return false;
		}
		public int getLeftHeight(){
			if(l==null) return 0;
			return l.h;
		}
		public int getRightHeight(){
			if(r==null) return 0;
			return r.h;
		}
		public void calculateH(){			
			int lh = getLeftHeight();
			int rh = getRightHeight();
			if(rh > lh) h = rh+1;
			else h = lh+1;
		}
		public Node successor(){
			if(r==null)
				return null;
			Node b = r;
			while(b.l!=null) b=b.l;
			return b;
		}
	}
	PrintWriter out=null;
	int nullCounter;
	/*
            printing the Suffix Tree in a format understandable by graphviz. The output is written into
            st.dot file. In order to see the suffix tree as a PNG image, run the following command:
            dot -Tpng -O st.dot
         */
	public void printTree(String filename) {
		nullCounter=1;
		if(filename==null || filename.equals(""))
			filename = "avl";
		try {
			out = new PrintWriter(new FileWriter("C:\\AD\\softwares\\graphviz-2.38\\release\\bin\\"+filename+".dot"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.println("digraph {");
        //out.println("\trankdir = LR;");
        out.println("\tedge [arrowsize=0.4,fontsize=10]");
//        out.println("\tnode1 [label=\"\",style=filled,fillcolor=lightgrey,shape=circle,width=.1,height=.1];");
        out.println("//------leaves------");
        printNodes(root);
        out.println("//------edges------");
        printEdges(root);
        out.println("}");
        out.close();
    }

	private void printNodes(Node x) {
		if(x==null)	return;
		    out.println("\tnode"+x.value+" [label=\""+x.value+"\",style=filled,fillcolor=lightgrey,shape=circle,width=.07,height=.07]");
		printNodes(x.l);printNodes(x.r);
	}
/*	
    private void printLeaves(Node x) {
		if(x==null)	return;
        if (x.h == 1)
            out.println("\t"+"node"+x.value+" [label=\"\",shape=point]");
        else {			
              printLeaves(x.l);printLeaves(x.r);
        }
    }

    private void printInternalNodes(Node x) {
		if(x==null) return;
        if (x != root && x.h > 1)
            out.println("\t"+x.value+" [label=\"\",style=filled,fillcolor=lightgrey,shape=circle,width=.07,height=.07]");
    
        printInternalNodes(x.l);printInternalNodes(x.r);
    }
*/
    private void printEdges(Node x) {
		if(x==null) return;
		if(x.l!=null) {
			out.println("\tnode"+x.value+" -> node"+x.l.value+" [label=\""+"left "+x.getLeftHeight()+"\",weight=3]");
			printEdges(x.l);
		}
		else {
			out.println("\tnull"+nullCounter+" [label=\"\",shape=point]");
			out.println("\tnode"+x.value+" -> null"+nullCounter+" [label=\"\",weight=3]");
			nullCounter++;
		}
		if(x.r!=null) {
			out.println("\tnode"+x.value+" -> node"+x.r.value+" [label=\""+"right "+x.getRightHeight()+"\",weight=3]");
			printEdges(x.r);
		}        
		else {
			out.println("\tnull"+nullCounter+" [label=\"\",shape=point]");
			out.println("\tnode"+x.value+" -> null"+nullCounter+" [label=\"\",weight=3]");
			nullCounter++;
		}
    }
}