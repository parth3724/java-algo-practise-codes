#include<iostream>
#define N 5
#define RIGHT 1
#define LEFT 0


using namespace std;

int total=0;

void swap1(char array[],int first,int last)
{
 char tem=array[first];
 array[first]=array[last];
 array[last]=tem;     
}
void shiftleft(char array[],int first,int last)
{
 //for(int     
}
void permutation1(char array[],int first,int last)
{
     if(first==last)
     {
      cout<<array<<"\n";
      total++;
      }
     for(int i=first ; i <=last ; i++) {
             swap1(array,first,i);
             permutation1(array,first+1,last);
             swap1(array,first,i);
     }

}

void permutation2(char array[N+1])
{
  int shift[N-2]={RIGHT,RIGHT,RIGHT};
  int t=N;
  while(t--)
  {
      cout<<array<<"\n";
      swap1(array,N-1,N-2);
      cout<<array<<"\n";
  } 
     
}
int main()
{
    char array[N+1] = {'A','B','C','D','E','\0'};
    permutation1(array,0,N-1);
    cout<<"\n"<<total<<"\n";
    system("pause");
    return 0;
    }
