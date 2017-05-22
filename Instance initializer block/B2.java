class A{  
A(){ 
 System.out.println("parent class constructor invoked");  
}
static void fnstaticA(){
System.out.println("fnstaticA");
}  
void fnA(){
System.out.println("fnA");
}
}  
class B2 extends A{  
{System.out.println("instance initializer block 0 is invoked");}  
B2(){  
super();  
System.out.println("child class constructor invoked");  
}  
static void fnstaticA(){
System.out.println("fnstaticB");
}  
void fnA(){
System.out.println("fnB");
}
void fnBonly(){
System.out.println("fnBonly");
}
{System.out.println("instance initializer block 1 is invoked");}  
  
public static void main(String args[]){  
A a=new B2();  
a.fnstaticA();
B2 b = new B2();
int aa;
//System.out.println("aa="+aa);
b.fnstaticA();
a.fnA();
b.fnA();
//a.fnBonly();
b.fnBonly();
}  
}  