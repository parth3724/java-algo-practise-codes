#include <iostream>
#include <stack>
#include <vector>
using namespace std;
/**
For building containers you obviously want to use one of the standard containers (such as a std::vector). 
If your object has a RAW pointer then you need to remember the the rule of 3 (now the rule of 5 in C++11).

Constructor
Destructor
Copy Constructor
Assignment Operator
Move Constructor (C++11)
Move Assignment (C++11)

This is because if not defined the compiler will generate its own version of these methods (see below).
The compiler generated versions are not always useful when dealing with RAW pointers.
The copy constructor is the hard one to get correct (it's non trivial if you want to 
provide the strong exception guarantee). 
The Assignment operator can be defined in terms of the Copy Constructor 
as you can use the copy and swap idiom internally.
*/
class graph{
  int no_vertex;
  int **a;
  public:
   graph()
  {
         no_vertex=0;
         a=NULL;
  }

  graph(int n)
  {
            no_vertex=n;
        a=new int*[n];
        for(int i=0;i<n;i++)
        {
            a[i]=new int[n];
        }
  }
  public:
  void allocatememory(int n)
  {
       no_vertex=n;
           a=new int*[n];
        for(int i=0;i<n;i++)
        {
            a[i]=new int[n];
        }
  }
  void undirectedinput()
  {
       for(int i=0;i<no_vertex;i++)
       for(int j=0;j<no_vertex;j++)
       cin>>a[i][j];
  }
  void show()
  {
       cout<<endl;
             for(int i=0;i<no_vertex;i++)
             {
             for(int j=0;j<no_vertex;j++)
             cout<<a[i][j]<<" ";
             cout<<endl;
             }
                    cout<<endl;
  }
  graph(graph &g1)
  {
      no_vertex=g1.no_vertex;
             a=new int*[no_vertex];
        for(int i=0;i<no_vertex;i++)
        {
            a[i]=new int[no_vertex];
        }
             for(int i=0;i<no_vertex;i++)
             for(int j=0;j<no_vertex;j++)
             a[i][j]=g1.a[i][j];
  }
  //or you can maintain original graph and return a mapping of matched vertices
void maximalmatching()
{
        int i,j;
      int *ismatched = new int[no_vertex](); 
      for(i=0;i<no_vertex;i++)
      ismatched[i]=0;
   
     for(i=0;i<no_vertex;i++)
     {
      if(ismatched[i]==1)
      continue;
      for(j=0;j<no_vertex;j++)
      {
       if(a[i][j]==1 && ismatched[j]==0)////assuming all in this row are either 0 or 1. NO 2s in this row
       {
          ismatched[i]=1;
          ismatched[j]=1;
          a[i][j]=2;
          a[j][i]=2;
          break;                   
       }                
      }                
     }     
     delete(ismatched);
}
      
};
class component
{
 int root;
 vector <stack<int> > v;
 component()
 {
  root=-1;           
 }       
};
int main()
{
freopen("maximal matching_sample.txt","r",stdin);
freopen("edmond_maximum_matching_output.txt","w",stdout);    
int t=1,n;
cin>>t;
graph *g;
g= new graph[t];

for(int i=0;i<t;i++)
{
  cin>>n;
 (g[i]).allocatememory(n);
  (g[i]).undirectedinput();
}
for(int i=0;i<t;i++)
{
        (g[i]).maximalmatching();
        (g[i]).show();
}
//system("pause");
 return 0;    
}
