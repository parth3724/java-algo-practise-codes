///Brute force complexity O(mn)
//where m=number of nodes in T and n= number of nodes in S

class Node{
String value;
int count;
int height;
Node left;
Node right;
Node(String n){
value=n;
count=1;
height=1;
}
public int difference(){
	int l = left==null?0:left.height;
	int r = right==null?0:right.height;
	return l-r;
}
public int calcHeight(){
	 int l=left ==null?0:left.height;
 int r=right==null?0:right.height;
 height=Math.max(l,r)+1;
 return height;
}
}

class AVL{

public static Node balance(Node root) {
	if(root==null) return null;
	 root.calcHeight();
 int d=root.difference();
 //l
 if(d>1) {
	int d2=root.left.difference();
	//lr
	if(d2 < -1) {
	   Node child = root.left;
	   Node grand = child.right;
	   root.left=grand;
	   child.right=grand.left;
	   grand.left=child;
	   child.calcHeight();
	   grand.calcHeight();
	   root.calcHeight();
	}
	//ll
	   Node child = root.left;
	   Node grand = child.left;
	   root.left=child.right;
	   child.right=root;
	   root.calcHeight();
	   child.calcHeight();
	   return child;
 }
 else if(d<-1) {
	 int d2=root.right.difference();
	 //rl
	if(d2 > 1) {
	   Node child = root.right;
	   Node grand = child.left;
	   root.right=grand;
	   child.left=grand.right;
	   grand.right=child;
	   child.calcHeight();
	   grand.calcHeight();
	   root.calcHeight();
	}//rr
	   Node child = root.right;
	   Node grand = child.right;
	   root.right=child.left;
	   child.left=root;
	   root.calcHeight();
	   child.calcHeight();
	   return child;
 }
 return root;
}
public static void print(Node root) {
	if(root.left!=null){
		print(root.left);
		System.out.print("/");
	}
	System.out.print(root.value);
	if(root.right!=null) {		
		System.out.print("\\");
			print(root.right);
	}
}
// one approach is to copy content of successor into current node. but it may have some side effect depending on code design.
//so we replace successor physicaly by above function

/*
	we are at that particular node
*/
public static Node deleteNode(Node n) {
 if(n.left==null)
 return n.right;
 if(n.right==null)
 return n.left;
 Node previous = n;
 Node current = n.right;
 while(current.left!=null) { previous=current;current=current.left;}
 n.right=deleteValue(n.right,current.value);
 current.right=n.right;
 current.left=n.left;
 return balance(current);
}
public static Node deleteValue(Node root,String value) {
   if(root==null)
   return null;
   if(root.value.compareTo(value) > 0) {
	 root.left=deleteValue(root.left,value);
 }
 else if(root.value.compareTo(value)<0) {
	 root.right=deleteValue(root.right,value);
 }
 else {	
		Node ans = deleteNode(root);
		ans=balance(ans);
		return ans;
 }
 return balance(root);
}
public static Node insert(Node root,String value){
	if(root==null)
	   return new Node(value);
 if(root.value.compareTo(value) > 0) {
	 root.left=insert(root.left,value);
 }
 else if(root.value.compareTo(value)<0) {
	 root.right=insert(root.right,value);
 }
 else {
	root.count++;
 }
 root.calcHeight();
 return balance(root);
}
public static Node tree=null;
public static void main(String args[]){
    tree = insert(tree,"zello");tree = insert(tree,"fsello");tree = insert(tree,"gtwgrfg");tree = insert(tree,"njj");tree = insert(tree,"wqzbv");
	//System.out.println(check(T,S));
	print(tree);
	System.out.println("");
	tree=deleteValue(tree,"njj");
	print(tree);
}

}