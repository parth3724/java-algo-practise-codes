#include<iostream>
#include<fstream>
#include<set>
#include<stack>
//#include "maximal matching.cpp"
using namespace std;
int n;
int a[100][100];
int ismatched[100];

void showpath(stack<int> path)
{
 
 stack<int> tem;
 cout<<"\nshowing path below in order it was found\n";
 while(!path.empty())
 {
  tem.push(path.top());
  path.pop();                    
 }
 while(!tem.empty())
 {
  path.push(tem.top());
  cout<<tem.top()<<" ";
  tem.pop();                   
 }
 cout<<endl;
}

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
void showmatched()
{
     int i;
cout<<"\n show matched \n";
 for(i=0;i<n;i++)
 cout<<ismatched[i]<<" ";     
 cout<<endl;
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
       if(a[i][j]==1 && ismatched[j]==0)////assuming all in this row are either 0 or 1. NO 2s in this row
       {
//         if(ismatched[j]==0)
  //       {
          ismatched[i]=1;
          ismatched[j]=1;
          a[i][j]=2;
          a[j][i]=2;
          break;                   
 //        }
       }                
      }                
     }     
 //    showmatched();
}
//Fiinds path from current node to either matched edge(2) or unmatched edge(1)
//s is set of nodes in path and path is stack order of path
int findpath(int current_node,int to_edge,set<int> s,stack<int> &path)
{
    int i,j;
  if(ismatched[current_node]==0 && !s.empty())
  {
   path.push(current_node);
   s.insert(current_node);
   return 1;                              
  }  
 for(j=0;j<n;j++)
 {
  if(a[current_node][j]==to_edge && s.count(j)==0)
  {
 //   include currnet_node in the path
    s.insert(current_node);
    path.push(current_node);
    if(findpath(j,(to_edge%2)+1,s,path)==0)
    {
     s.erase(current_node);
     path.pop();
    }                        
    else
    return 1;
  }                
 }    
 return 0;
}
void exor(stack<int> &path)
{
 int current=2,p,q;    
 while(path.size() > 1)
 {
   p=path.top();
   ismatched[p]=1;
   path.pop();
   q=path.top();
   ismatched[q]=1;
   a[p][q]=current;
   a[q][p]=current;
   current=(current%2)+1;
 }     
}
void maximummatch()
{
  int i,flag;   
 set<int> s;
 stack<int> path;    
 maximalmatch();     
 for(i=0;i<n;i++)
 {
  flag=0;               
 s.clear();
  while(!path.empty())
 path.pop();
// path.clear();
  if(ismatched[i]==0)
  {
   flag=findpath(i,1,s,path);                   
  }                
  if(flag==1)
  {

   exor(path);        
  }
 }
}
int main()
{
 int t;
 int i,j;
 
 freopen("maximal matching_sample.txt","r",stdin);
  freopen("maximum_matching_output.txt","w",stdout);
// cin=in;
 cin>>t;
 while(t--)
 {
  cin>>n;
  for(i=0;i<n;i++)
  for(j=0;j<n;j++)
  cin>>a[i][j];
  maximummatch();
   show();
   cout<<"\n";
   for(i=0;i<100;i++)
   ismatched[i]=0;        
 }   
 
// system("pause");
 return 0;    
}
