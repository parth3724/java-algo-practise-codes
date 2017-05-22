import java.util.*;
public class InputDuringContest {
public static void main(String args[]){
Scanner myScanner = new Scanner(System.in);
//one method is use String.replaceAll and replace unrequired characters with blank space
//then pass new string into a scanner and scann integer
String line = myScanner.next();
String line2=line.replaceAll("\\D"," ");
Scanner s2 = new Scanner(line2);
while(true){
   if(s2.hasNext()){
   int tem=s2.nextInt();
   System.out.println(tem);
   }
   else{
   break;
   }
}

}
}