#include <iostream>
#include<fstream>
#include<set>
#include<stack>
using namespace std;

int main()
{
    //dynamic 2d allocation
    int **a;
    int *b;
    a=new int*[5];
        for(int i=0;i<5;i++)
        {
         
                a[i]=new int[5];
        }
        for(int i=0;i<5;i++)
        for(int j=0;j<5;j++)
        a[i][j]=i*5+j;
    
    for(int i=0;i<5;i++)
    {
    for(int j=0;j<5;j++)
    cout<<a[i][j]<<" ";
    cout<<"\n";
    }
 system("pause");
 return 0;    
}
