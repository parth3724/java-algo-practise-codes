//http://www.javatpoint.com/autoboxing-and-unboxing
/////These rules are for Auto...

class BvsVarArg{  
  static void m(Integer i){System.out.println("Integer");}//Boxing beats VarArgs. This will be called.  
  static void m(int... i){System.out.println("int...");}  
  static void m(Integer... i){System.out.println("Integer...");}  
  
  public static void main(String args[]){  
   int a=30;  
   m(a);  
 }   
}  