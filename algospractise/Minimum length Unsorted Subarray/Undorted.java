//http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

import java.util.*;

class Undorted{
static ArrayList<Integer> ar= new ArrayList<Integer>();

public static void takeinput(){
Scanner myScanner = new Scanner(System.in);
String line = myScanner.nextLine();
line = line.replaceAll("\\D"," ");
myScanner.close();
myScanner = new Scanner(line);
while(myScanner.hasNext()){
ar.add(myScanner.nextInt());
}
for(int i=0;i<ar.size();i++){
 System.out.print(ar.get(i)+" ");
}
}

public static void main(String args[]){
takeinput();
int left=1,right=0,max,min;
for(int i=0;i<ar.size()-1;i++){
if(ar.get(i) > ar.get(i+1))
{
left = i;
break;
}
}
for(int i=ar.size()-1;i>0;i--){
if(ar.get(i) < ar.get(i-1)){
right = i;
break;
}
}
max=min=ar.get(left);
for(int i=left;i<=right;i++)
{
 if(ar.get(i)>max){
 max=ar.get(i);
 }
 else if(ar.get(i) < min){
 min=ar.get(i);
 }
}
for(int i=ar.size()-1;i>right;i--){
if(ar.get(i)<max)
{
right=i;
break;
}
}
for(int i=0;i<left;i++){
if(ar.get(i) > min)
{left=i;
break;}
}
System.out.println(left+" "+right);
}
}