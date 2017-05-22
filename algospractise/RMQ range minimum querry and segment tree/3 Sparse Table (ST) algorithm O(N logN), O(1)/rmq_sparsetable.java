/*
https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/
Sparse Table (ST) algorithm <O(N logN), O(1)>.
A better approach is to preprocess RMQ for sub arrays of length 2k using dynamic programming.
We will keep an array M[0, N-1][0, logN] where M[i][j] is the index of the minimum value in the sub array starting at i having length 2^j. 
For computing M[i][j] we must search for the minimum value in the first and second half of the interval.

*/


class rmq_sparsetable{
static int m[][];
static int ar[]={2,-3,3,1,-1,7,8,9,1,1,10,14,1,7,35,75,34,7,23,765,20,77,-4,76,87,34,87,54,76,34,30,7,2,64,765,54,3,7,54,3,40,76,87,4,32,34};
public static void compute(int ar[]){
int l = ar.length;
int k = (int)Math.floor(Math.log(l)/Math.log(2)); //if l=4 , log[2](4) = 2. So colums = {0,1,2}=3
k++;
m=new int[l][k];
for(int i=0;i<l;i++)
{
	m[i][0]=i;
}
for(int j=1;j<k;j++)
{
	for(int i=0;i+(int)Math.pow(2,j-1)<l;i++)
	{
		if(ar[m[i][j-1]]<ar[m[i+(int)Math.pow(2,j-1)][j-1]])
				m[i][j]=m[i][j-1];
		else
				m[i][j]=m[i+(int)Math.pow(2,j-1)][j-1];
	}
}
for(int i=0;i<l;i++)
{
for(int j=0;j<k;j++)
{
	System.out.print(" "+m[i][j]);
}
System.out.println("");
}
}
// returns position between i and j that has minimum value
public static int querry(int i,int j){
int l = j-i+1;//lenght of interval [i,j]
int k = (int)Math.floor(Math.log(l)/Math.log(2));
if(i+Math.pow(2,k) -1 > j)
{
	System.out.println("floating error");
	k--;
}
if(ar[m[i][k]]<=ar[m[j-(int)Math.pow(2,k)+1][k]])
{
return m[i][k];
}
else
{
return m[j-(int)Math.pow(2,k)+1][k];
}
}

public static void main(String Args[]){

compute(ar);
System.out.println(querry(32,40));
System.out.println(querry(0,7));
System.out.println(querry(0,40));
System.out.println(querry(17,43));
}
}