/*
 * We can use default and static keyword to create interfaces with method implementation. 
 * An interface and an abstract class is almost similar except that you can create 
 * constructor in the abstract class whereas you can't do this in interface.
 * Also we can only create public static final variable in interface BUT
 * we in abstract class, there is no restriction on creating variable. 
 */
    interface Sayable{  
        // Default method   *********************************************************
        default void say(){  //but  default variable not allowed
            System.out.println("Hello, this is default method");  
        }
        // Static method ********************************************************
        static void listen(){
        	System.out.println(i);
        }
//        default int j = 0;
//but  default variable not allowed.. would it have killed them ??
        
        int i=0;//by default public static final
        // Abstract method  
        void sayMore(String msg);  // by default public abstract
    }  
    public class DefaultMethods implements Sayable{  
        public void sayMore(String msg){        // implementing abstract method   
            System.out.println(msg);  
        }  
      /*  public void say(){
        	System.out.println("default method can be overriden");
        }*/
        public static void localmain(String[] args) {  
            DefaultMethods dm = new DefaultMethods();  
            dm.say();   // calling default method  
            dm.sayMore("Work is worship");  // calling abstract method  
            Sayable.listen();
   //        dm.listen();
        }  
    }  
