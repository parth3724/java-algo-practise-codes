class WhichValueWillBeReturned{
	public static void main(String argd[]){
		System.out.println(fun());
	}
	public static int fun(){
		try{
			int a = 5/1;
			return 1;
		} catch (Exception e) {
			return 2;
		}
		finally{
			return 3;//this will override the value returned from inside catch block & the value returned from inside try block.
		}

	}
}