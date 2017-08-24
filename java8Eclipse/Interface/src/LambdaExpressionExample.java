import java.util.ArrayList;
import java.util.List;
//Java lambda expression is treated as a function, so compiler does not create .class file.
    public class LambdaExpressionExample{  
        public static void localmain(String[] args) {  
          
            //Thread Example without lambda  
            Runnable r1=new Runnable(){  
                public void run(){  
                    System.out.println("Thread1 is running...");  
                }  
            };  
            Thread t1=new Thread(r1);  
            t1.start();  
            //Thread Example with lambda  
            Runnable r2=()->{  
                    System.out.println("Thread2 is running...");  
            };  
            Thread t2=new Thread(r2);  
            t2.start();  
            Thread t3  = new Thread(()->{
            	System.out.println("Thread3 is running...");
            });
            t3.start();
            List<String> list=new ArrayList<String>();  
            list.add("ankit");  
            list.add("mayank");  
            list.add("irfan");  
            list.add("jai");  
//Foreach Loop ******************************************************
// // Lambda expression with single parameter.  You can omit function parentheses             
            list.forEach(  
                n->System.out.println(n)  
            );  
        }  
    }  