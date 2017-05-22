///Brute force complexity O(mn)
//where m=number of nodes in T and n= number of nodes in S

class Node{
char value;
Node left;
Node right;
Node(char n){
value=n;
}
}

class Checkforsubtree{

static Boolean checkequal(Node a, Node b){

if(a==null && b==null){
return true;
}

else if(a==null || b==null){
return false;
}

else if(a.value==b.value && checkequal(a.left,b.left) && checkequal(a.right,b.right)){
return true;
}
else{
return false;
}
}

public static Boolean check(Node a,Node b){

  if(b==null)
  return true;
  if(a==null)
  return false;

  if(checkequal(a,b))
  {
  return true;
  }
  else if(check(a.left,b) || check(a.right,b)){
  return true;
  }
 
else
   return false;
}

public static void main(String args[]){
   Node T = new Node('a');
   T.left=new Node('b');
    T.right = new Node('d');
    (T.left).left = new Node('c');
//    (T.right).right = new Node('e');
 
    Node S = new Node('a');
    S.left = new Node('b');
    (S.left).left = new Node('c');
    S.right = new Node('d');
	System.out.println(check(T,S));
}

}