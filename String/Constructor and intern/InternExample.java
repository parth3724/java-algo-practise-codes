public class InternExample{  
	 final String finalfield;
	  static final String finalstaticfield;
	  static {
	  finalstaticfield="hello";
	  }
	public InternExample(){
	      finalfield = "hi";
	//	  finalstaticfield="hello"; //error: cannot assign a value to final variable finalstaticfield
	//	  finalfield = "hello"; //error: variable finalfield might already have been assigned
	}
public static void main(String args[]){  
String s2="hello";  
String s1=new String("hello");  
String s3=s1.intern();//returns string from pool, now it will be same as s2  
System.out.println(s1==s2);//false because reference is different  
System.out.println(s2==s3);//true because reference is same  
String p1=new String("Parth");
String p2=new String("Parth");
String p3=p1.intern();
String p4=p2.intern();
System.out.println(p3==p4);
}}  