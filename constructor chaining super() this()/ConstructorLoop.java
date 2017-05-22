class ConstructorLoop {

ConstructorLoop(){
this(1);/// shows recursive constructor invpcation. error is thrown.
 System.out.println("blank");
}
ConstructorLoop(int a){
this();// if this is first statement super will not be called from this. it will be called from the other constructor.
 System.out.println(a);
}
public static void main(String args[]){
ConstructorLoop tem = new ConstructorLoop();
tem =new ConstructorLoop(5);
}
}