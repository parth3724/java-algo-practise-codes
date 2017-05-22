import package1.Super;
import package2.Sub;


public class Root {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Sub sub = new Sub();
Super sup = new Super();
sub.method2(sup);
Sub s = sub.clone();
s.method2(sup);
//sub.method(sup);
//sup.method();
	}

}
