#include<iostream>
#include<cmath>
using namespace std;

float cal_simple_amount(float p,float r,float t)
{
 return (p+(p*r*t/100));      
}
float cal_simple_interest(float amount,float time,float principal)
{
 float tem;
 tem=amount-(principal*time);
 return tem*200/principal/time/(time+1);
}

float cal_compound_interest_from_amount(float amount,float time,float principal)
{
 float tem= amount/principal;
 tem=pow(tem,1/time);
 tem=(tem-1)*100;
 return tem;
}
float binary(float current,float min,float max,float amount,float time)
{
 if(max<min)
 return current;
 if(max-min < 0.01)
 return current;
float tem_amount= ( pow(current,time+1)-1)/(current -1);
if(tem_amount > amount)
return binary(min+(current-min)/2,min,current,amount,time);
if(tem_amount < amount)
return binary(current+(max-current)/2,current,max,amount,time);
return current;
       
}
float cal_compound_interest_lic(float amount,float time,float principal)
{
 float tem=amount/principal;      
 float rate=binary(10,0,20,tem,time);
 return (rate-1)*100;
}
int main()
{
    float a,t,p,r;
    cout<<"enter annual premium , no of premiums (years) , maturity amount .\n";
    cin>>p>>t>>a;
    r=cal_simple_interest(a,t,p);
    cout<<"\nthis is equilant to simple interest "<<r<<endl;
    r=cal_compound_interest_lic(a,t,p);
    cout<<"\nthis is equilant to compound interest "<<r<<endl;
    system("pause");
    return 0;
    }
