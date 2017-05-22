#include<iostream>
using namespace std;

void setPie(char *p,int pie[],int n)
{
      int q=-1;
      pie[0]=-1;
      for(int i = 1; i<n;i++)
      {
              while(q>=0 && p[q+1]!=p[i])
                 q=pie[q];           
              if(p[q+1]==p[i])
              {
               q=q+1;
              }          
              pie[i]=q;             
      }
}
int main()
{
 string pattern = "abc";
 string text = "ababfcabc";
 int pie[4];
 char *p = new char[pattern.length()+1];
 
 strcpy(p,pattern.c_str());   
 cout<<p<<" "<<pattern.length()<<"\n";
 char *t = new char[text.length()+1];
 strcpy(t,text.c_str());
 cout<<t<<" "<<text.length()<<"\n";
 setPie(p,pie,pattern.length());
 int q=-1;
    for(int i = 0; i<text.length();i++)
    {
              while(q>=0 && p[q+1]!=t[i])
                 q=pie[q];           
              if(p[q+1]==t[i])
              {
               q=q+1;
              }          
              if(q==pattern.length()-1)
              {
              cout<<"pattern found at "<<i-pattern.length()+1<<" end at "<<i<<"\n"; 
              q=pie[q];
              }
    }
 system("pause");
 return 0;
}
