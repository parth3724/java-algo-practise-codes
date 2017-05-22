/*
Node at index 0 in bit[] is a dummy node.
A node at index y is parent of a node at index x, iff y can be obtained by removing last set bit from binary representation of x.
A child x of a node y stores sum of elements from of y(exclusive y) and of x(inclusive x).
*/ 

class BinaryIndexedTreeToCalculateArrayIntervalSum{
 
static int input[]={0/*not using this*/,-2,4,3,1,-1,7,8,9,1,7};
static int ar[];
static int bit[];


// returns the bit element indices that includes ar[i] in sequence
//see http://codeforces.com/blog/entry/619 SET function.
public static int getNextBucket(int i){
	int r =  i+ ( i& (-i));
	if(r>=ar.length)
		return -1;
	return r;
}

public static int getParent(int i){
	return i-(i & (-i));
}
//get sum of ar[1],ar[1]....ar[i]
public static int getSum(int index){
	int sum=0;
	while(index!=0){
		sum=sum+bit[index];
		index=getParent(index);//getParent(0) will not be called .
	}
	return sum;
}

public static void set(int index,int newValue){
	int d = newValue-ar[index];
	ar[index]=newValue;
	while(index!=-1){
		bit[index]+=d;
		index=getNextBucket(index); 
	}
}
//This function is for testing
public static void takeinput(){
	for(int i=1;i<ar.length;i++)
	{
		set(i,input[i]);
	}
	System.out.println("bit made");
	for(int i=1;i<ar.length;i++)
	{
		System.out.print(bit[i]+" ");
	}
	System.out.println();
}
public static void takeinput2(){
	int bit2[] = new int[ar.length];
	for(int i=1;i<ar.length;i++){
		if(i%2==1){
			bit2[i]=ar[i];
		}
		else{
			int parent = i&(i-1);
			int current = i-1;
			int temsum=ar[i];
			while(current!=parent && current >0){
				temsum+=bit2[current];
				current=getParent(current);
			}
			bit2[i]=temsum;
		}
	}
		for(int i=1;i<ar.length;i++)
	{
		System.out.print(bit2[i]+" ");
	}
	System.out.println();
}
 
 
 public static void main(String args[]){
 ar = new int[input.length];
 bit = new int[ar.length];
 
 takeinput();
 takeinput2();
 System.out.println(getSum(4));
 set(2,3);
 System.out.println(getSum(4));
 }
 }
 
