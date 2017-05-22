/*
From Doc RMQ & Segment Tree of Drive
https://docs.google.com/document/d/12-Yeh5HzbC2ypBV0lBgudP2KHaqvh5k63jwW0UGwhoc/edit
Trivial algorithms for RMQ
For every pair of indices (i, j) store the value of RMQA(i, j) in a table M[0, N-1][0, N-1]. 
Trivial computation will lead us to an <O(N^3), O(1)> complexity. However, by using an easy 
dynamic programming approach we can reduce the complexity to <O(N^2), O(1)>. 
The preprocessing function will look something like this:
This trivial algorithm is quite slow and uses O(N^2) memory, so it won’t work for large cases. 
*/

class Trivial{

static int[][] compute(int ar[]){
int length = ar.length;
int memo[][]=new int[length][length];
for(int i=0;i<length;i++)
{
memo[i][i]=i;
}
for(int i=0;i<length;i++){

for(int j=i+1;j<length;j++){
if(ar[memo[i][j-1]]<ar[j]){
memo[i][j]=memo[i][j-1];
}
else{
memo[i][j]=j;
}
}

}
return memo;
}

public static void main(String Args[]){
int ar[]={2,4,3,1,-1,7,8,91,7};
int ans[][]=compute(ar);
///Querry 
System.out.println(ans[0][ar.length-1]);
}
}