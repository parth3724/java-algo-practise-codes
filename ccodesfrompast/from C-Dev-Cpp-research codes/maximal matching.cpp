#include<iostream>
#include<set>
using namespace std;
int n;
int a[100][100];
int ismatched[100];
void show()
{
 int i,j;    
 for(i=0;i<n;i++)
 {
  for(j=0;j<n;j++)
  cout<<a[i][j]<<" ";
  cout<<"\n";
 }     
}
void maximalmatch()
{
     int i,j;
     for(i=0;i<n;i++)
     {
      if(ismatched[i]==1)
      continue;
      for(j=0;j<n;j++)
      {
       if(a[i][j]==1)////assuming all in this row are either 0 or 1. NO 2s in this row
       {
         if(ismatched[j]==0)
         {
          ismatched[i]=1;
          ismatched[j]=1;
          a[i][j]=2;
          a[j][i]=2;
          break;                   
         }
       }                
      }                
     }     
}
int main()
{
    freopen("maximal matching_sample.txt","r",stdin);
  freopen("maximal_matching_output.txt","w",stdout);
 int t;
 int i,j;
 cin>>t;
 while(t--)
 {
  cin>>n;
  for(i=0;i<n;i++)
  for(j=0;j<n;j++)
  cin>>a[i][j];
  maximalmatch();
   show();
   for(i=0;i<100;i++)
   ismatched[i]=0;        
 }   
 system("pause");
 return 0;    
}
