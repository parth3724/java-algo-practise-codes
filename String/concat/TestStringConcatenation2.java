class TestStringConcatenation2{  
 public static void main(String args[]){  
   
   String s=50+30+"Sachin"+40+40;  
   System.out.println(s);//80Sachin4040  
   String s2=Integer.toString(50+30);
   System.out.println(s2);//80Sachin4040  
 }  
}  