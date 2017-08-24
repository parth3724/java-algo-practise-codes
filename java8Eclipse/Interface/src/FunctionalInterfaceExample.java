//https://www.javatpoint.com/java-8-functional-interfaces
//Java provides predefined functional interfaces to deal with functional programming by using lambda and method references.
//An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, 
//static methods but can contain only one abstract method. It can also declare methods of object class.
//A functional interface can have methods of object class.
//A functional interface can extends to other interface only when that does not have any abstract method.
@FunctionalInterface //this optional annotation asserts that interface has exactly one abstract method. 
    interface sayable2{  
        void say(String msg);
     // It can contain any number of methods of Object class.  
        int hashCode();  
        String toString();  
    }  
    public class FunctionalInterfaceExample implements sayable2{  
        public void say(String msg){  
            System.out.println(msg);  
        }  
        public static void localmain(String[] args) {  
            FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
            fie.say("Hello there");
            sayable2 temp = (msg)->{
            	System.out.println(msg+" lambda");
            };
            temp.say("using lambda");
        }  
        
        
    }  