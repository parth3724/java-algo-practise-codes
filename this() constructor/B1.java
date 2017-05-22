// this() can be used in place of a constructor classname().
// to use this() , there sould be a classname() constructor defined.
//  If defined constructor is classname(String s), then use this(String); to invoke that constructor.

class A{
int a,b;
String s;

A(){
a=0;b=0;
}

A(String s){
this();
this.s=s;
}
A(int p,int q){
this("hi");
a=p;b=q;
}

}

class B1{
public static void main(String args[]){
A a = new A(2,3);
A b =(A)a.clone();
}
}