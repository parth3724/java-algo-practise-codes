#include<iostream>
using namespace std;
int main()
{
 int t,start_index;
 long n,p,tem,sum;
 int *a;
 cin>>t;
 while(t--)
 {
 start_index=0;
 sum=0;
 cin>>n>>p;
 a=new int[p];
// set all elements of a =0;
/* for(long i=0;i<n;i++)
 {
 cin>>tem;
 tem=tem%p;
 start_index=(start_index+tem)%p;
// index=tem-start_index;
//if (index < 0)
//index=index+p;
// a[index]++;
// index=0-start_index;
 //if (index < 0)
//index=index+p;
 sum=sum+a[index];
}
 cout<<"hello "<<sum<<"\n";
 */
 for(int i=0;i<p;i++)
 cout<<a[i]<<" ";
 cout<<"\n"<<(0-2)%7<<"\n";;
 delete(a);
}
system("pause");
 return 0;
    }
