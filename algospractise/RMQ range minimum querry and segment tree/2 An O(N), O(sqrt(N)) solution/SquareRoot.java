/**
https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/
https://docs.google.com/document/d/12-Yeh5HzbC2ypBV0lBgudP2KHaqvh5k63jwW0UGwhoc/edit#
An <O(N), O(sqrt(N))> solution
An interesting idea is to split the vector in sqrt(N) pieces. We will keep in a vector M[0, sqrt(N)-1] 
the position for the minimum value for each section. M can be easily preprocessed in O(N). Here is an example:

The main advantages of this approach are that is to quick to code (a plus for TopCoder-style competitions) and 
that you can adapt it to the dynamic version of the problem (where you can change the elements of the array between queries).
**/

class SquareRoot{

static int memo[];
static int interval;
public static int querry(int i,int j,int ar[]){

int firstinterval = i/interval;
int lastinterval = j/interval;
int min=Integer.MAX_VALUE;
int minindex=-1;
for(int p=firstinterval+1;p<lastinterval;p++)
{
if(ar[memo[p]]<min){
	minindex=memo[p];
	min=ar[memo[p]];
}
}
for(int p=i;p<(firstinterval+1)*interval;p++){
if(ar[p]<min){
	minindex=p;
	min=ar[p];
}
}
for(int p=lastinterval*interval;p<=j;p++){
if(ar[p]<min){
	minindex=p;
	min=ar[p];
}
}
return minindex;
}

public static void compute(int ar[]){
int l= ar.length;
interval =(int) Math.sqrt(l);
int noInterval=(l/interval)+(l%interval);
memo = new int[noInterval];
int cur=-1;
int min=Integer.MAX_VALUE;
for(int i=0;i<ar.length;i++){
if(i%interval==0){
cur++;
min=Integer.MAX_VALUE;
}
if(ar[i]<min){
min=ar[i];
memo[cur]=i;
}
}
}

public static void main(String Args[]){
int ar[]={2,-2,3,1,-1,7,8,9,1,7};
compute(ar);
for(int i=0;i<memo.length;i++){
System.out.print(memo[i]+" ");
}
System.out.println("\n"+memo.length);
System.out.println(querry(1,7,ar));
}
}