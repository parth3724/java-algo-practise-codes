public class Conversions{
	public static void main(String args[]){
		String Hex = "010";
		int n = (int) Long.parseLong(Hex, 2);
		System.out.println(n);
		System.out.println(binaryToHex("1111"));
		//System.out.println(convertFromRadixToRadix("1171",2,8));//throws number format exception.
		System.out.println(convertToRadix(2573,2));
		System.out.println(convertToNumber("0x8573"));
		
	}
	//special case of below function
	public static String binaryToHex(String string){
		long  mLong = Long.parseLong(string, 2);
		return Long.toString(mLong,16);
	}
	//converts a number give in radix fromR as string input, to the number in radix toR and outputs as String
	public static String convertFromRadixToRadix(String s,int fromR, int toR){
		long l = Long.parseLong(s,fromR);
		return Long.toString(l,toR);
	}
	//takes a number and converts it to given radix and outputs it as string
	public static String convertToRadix(long l,int radix){
		return Long.toString(l,radix);
	}
	//takes a string and radix and converts it to a number considering string was represented as number in radix
	public static long convertToNumber(String s, int radix){
		return Long.parseLong(s,radix);
	}
	//converts a string to number default way. Ex : 0x8573 -> 34163
	public static long convertToNumber(String s){
		return Long.decode(s);/*ecodableString:
    Signopt DecimalNumeral 
    Signopt 0x HexDigits 
    Signopt 0X HexDigits 
    Signopt # HexDigits 
    Signopt 0 OctalDigits

Sign: + , - */

	}
}