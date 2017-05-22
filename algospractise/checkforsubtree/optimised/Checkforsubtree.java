///optimised complexity O(n)
//where m=number of nodes in T and n= number of nodes in S

/*
Following are detailed steps.

1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].

2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].

3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.

We can also use postorder traversal in place of preorder in the above algorithm.

EDIT

The above algorithm doesn't work for cases where a tree is present
in another tree, but not as a subtree. Consider the following example.
http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
The above algorithm can be extended to handle such cases by adding a special character whenever we encounter NULL in inorder and preorder traversals.
*/


class Node{
char value;
Node left;
Node right;
Node(char n){
value=n;
}
}

class Checkforsubtree{

static String pre(Node a){

if(a==null){
return "$$";
}
return(Character.toString(a.value)+pre(a.left)+pre(a.right));
}

static String in(Node a){
if(a==null){
return "$$";
}
return(in(a.left)+Character.toString(a.value)+in(a.right));
}

public static Boolean check(Node a,Node b){

  if(b==null)
  return true;
  if(a==null)
  return false;
  String ina=in(a);
  String inb=in(b);
  String prea=pre(a);
  String preb=pre(b);
  //System.out.println(ina+"\n"+inb+"\n"+prea+"\n"+preb+"\n");
  
  if(ina.contains(inb) && prea.contains(preb))
  //if(ina.indexOf(inb)>=0 && prea.indexOf(preb)>-1)
  return true;
 

   return false;
}

public static void main(String args[]){
   Node T = new Node('a');
   T.left=new Node('b');
    T.right = new Node('d');
    (T.left).left = new Node('c');
(T.right).right = new Node('e');
 
    Node S = new Node('a');
    S.left = new Node('b');
    (S.left).left = new Node('c');
    S.right = new Node('d');
	System.out.println(check(T,S));
}

}