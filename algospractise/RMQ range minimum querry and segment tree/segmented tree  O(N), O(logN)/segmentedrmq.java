/*
https://docs.google.com/document/d/12-Yeh5HzbC2ypBV0lBgudP2KHaqvh5k63jwW0UGwhoc/edit
https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/
http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
For a full binary tree (each node has 0 or 2 children) , if number of leaf nodes = n, then number of internal nodes = n-1, And total number of nodes = 2n-1.

Segmented tree will be a full binary tree. So actual nodes = 2n-1 where n= number of elements (leaf node).
But since we will be using array to store segmented tree, relation between parent and child indexes must be maintained . So Height of the segment tree will be
roof(log N). Where height of root = 0 and n= number of elements.
hence actual number of leaf nodes = 2^roof(log N).
so actual number of nodes created will be 2*2^roof(log N) -1 .
Time Complexity:
Time Complexity for tree construction is O(n). There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.
Time complexity to query is O(Logn). To query , we process at most four nodes at every level and number of levels is O(Logn).
The time complexity of update is also O(Logn). To update a leaf value, we process one node at every level and number of levels is O(Logn).
*/

class Segmentedrmq{
static int ar[]={-2,4,3,1,-1,7,8,9,1,7};
static int n = ar.length;
static int m[];
static int l;

//returns index i in ar[] , such that ar[i] is less than ar[j] for all qLeft<=j<=qRight && cLeft <=j<=cRight
public static int querry(int node,int cLeft,int cRight,int qLeft,int qRight){
System.out.println("node : "+node+" cLeft: "+cLeft+" cRight: "+cRight+" qLeft: "+qLeft+" qRight: "+qRight);
//if(node >= l)
//return -1;
if(cRight<qLeft){
return -1;
}
if(qRight<cLeft){
return -1;
}
if(qLeft<=cLeft && cRight<=qRight){
	return m[node];
}
int p1 = querry(node*2+1,cLeft,(cLeft+cRight)/2,qLeft,qRight);
int p2 = querry(node*2+2,(cLeft+cRight)/2+1,cRight,qLeft,qRight);
int c1,c2;
if(p1 != -1){
	c1 = ar[p1];
}
else
	c1 = Integer.MAX_VALUE;
if(p2 != -1){
	c2 = ar[p2];
}
else 
	c2 = Integer.MAX_VALUE;
return c1<c2? p1:p2;

}

public static void fun(int node,int first,int last){
System.out.println("node : "+node+" first: "+first+" last: "+last);
if(first==last){
	m[node]=first;
}
else{
	fun(node*2+1,first,(first+last)/2);
	fun(node*2+2,(first+last)/2+1,last);
	//This Segmented tree is for Range minimum querry. So below check.
	if(ar[m[node*2+1]] < ar[m[node*2+2]]){
		m[node]=m[node*2+1];
	}
	else{
		m[node]=m[node*2+2];
	}
}
}
public static void compute(){
l = (int)Math.ceil(Math.log(n)/Math.log(2)); //if l=4 or 3 , log[2](4) = 2
l=(int)Math.pow(2,l);
l=2*l-1;
m= new int[l];
for(int i = 0;i<l;i++)
{m[i]=-1;}
fun(0,0,n-1);
}
public static void main(String args[])
{
	compute();
	System.out.println("hello");
	System.out.println(l);
	System.out.println(querry(0,0,ar.length-1,0,5));
}
}