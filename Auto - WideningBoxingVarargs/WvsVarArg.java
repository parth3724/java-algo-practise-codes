//http://www.javatpoint.com/autoboxing-and-unboxing
/////These rules are for Auto...
class WvsVarArg{  
  static void m(int i, int i2){System.out.println("int int");}  //Widening beats var Args. So if it were short short then obviously this will be called.
  static void m(short... i){System.out.println("short...");}  
  
  
  public static void main(String args[]){  
   short s1=30,s2=40;  
   m(s1,s2);  
 }   
}  
      