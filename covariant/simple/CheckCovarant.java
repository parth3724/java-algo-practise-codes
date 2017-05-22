public class CheckCovarant implements Cloneable{

	
	/**
	 * 
	 */
	public CheckCovarant(int i) {
		super();
		t = new Test();
		t.i = i;
	}

	Test t;
	public class Test implements Cloneable{
		int i;

		
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return (Test) super.clone();
		}
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
	CheckCovarant c1 = new CheckCovarant(1);
	CheckCovarant c2 = new CheckCovarant(2);
	c2.t=(Test)c1.t.clone();
	System.out.println(c2.t.i);
	}

}
