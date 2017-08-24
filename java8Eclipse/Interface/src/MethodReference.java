    public class MethodReference {  
        public static void ThreadStatus(){  
            System.out.println("Thread is running...");  
        }  
        
        public static void localmain(String[] args) {  
            Thread t2=new Thread(MethodReference::ThreadStatus);  //static method reference ***************
            t2.start();       
            Thread t3=new Thread(new MethodReference()::instanceMethod);  //instance method reference **************
            t3.start();       
            Messageable hello = Message::new;//method referring to constructor as both returns Message object ************
            Message temp = hello.getMessage("");
            System.out.println(temp.s);
        }  
        public void instanceMethod(){
        	
        	System.out.println("Thread is running instance method...");
        }
    }  
    interface Messageable{  
        Message getMessage(String msg);  
    }  
    class Message{  
    	public String s ;
        public Message(String msg){  
            s=msg;  
        }
        
    }  