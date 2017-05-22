enum day{MON,TUE;};
    class TryEnum
	{  
enum Season{   
WINTER(5), SPRING, SUMMER, FALL(20);   
  
private int value;  
private Season(int value){  
this.value=value;  
}  
private Season(){  
this.value=10;  
}  
}  
public static void main(String args[]){  
for (Season s : Season.values())  
System.out.println(s+" "+s.value);  
  
}}  