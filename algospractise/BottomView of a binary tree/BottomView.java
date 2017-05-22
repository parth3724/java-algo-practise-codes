import java.util.*;

class Node{
int value;
Node left,right;
int column;

public Node(int n){
value=n;
left=null;
right=null;

}
public void print(){
System.out.print(value+" ");
}
}


class BottomView{
static HashMap<Integer,Node> myMap = new HashMap<Integer,Node>();

public static void calculate(Node n){
LinkedList<Node> list = new LinkedList<Node>();
int min=0,max=0;
n.column=0;
myMap.put(0,n);
list.add(n);
while(list.size()!=0){
	Node tem=list.pollFirst();
	if(tem.left!=null){
		(tem.left).column=tem.column-1;
		myMap.put((tem.left).column,tem.left);
		list.add(tem.left);
		if((tem.left).column < min)
		min=(tem.left).column;
	}
	if(tem.right!=null){
		(tem.right).column=tem.column+1;
		myMap.put((tem.right).column,tem.right);
		list.add(tem.right);
		if((tem.right).column > max)
		max=(tem.right).column;
	}
}
for(int i=min;i<=max;i++)
{
myMap.get(i).print();
}
}

public static void main(String args[]){
Node n=new Node(5);
n.left = new Node(3);
n.right = new Node(8);
n.right.left = new Node(88);
calculate(n);
}
}