/////These rules are for Auto...
class WandBNotPossible{  

  static void m(Long l){System.out.println("Long");}  //Widening and Boxing both at same time not possible. compiler error.
  
  //Below two are possible with equal priorities. So ambiguous. Compiler error if both are defined. for m(a);
 // static void m(Integer... l){System.out.println("Integer...");}  //Boxing and VarArgs possible
 // static void m(long... l){System.out.println("long...");}  //Widening and varargs possible.
  
  public static void main(String args[]){  
   int a=30;  
   m((long)a);//no problem. As this is equivalent to passing long as parameter ans which causes autoboxing
   m(a);   
   
 }   
}  