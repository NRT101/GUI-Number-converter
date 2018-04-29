
public class numConverter {
	private String number="";

	/*
	 * Define and retrieve number value from outside class
	 */
	public String getNumber(){
		return number;
	}
	public void setNumber(String val){
		number=val;
	}

	/*
	 * Checks number is binary, decimal, or hexadecimal
	 */
	private boolean isBinary(){
		boolean answer=false;
		answer=number.matches("^[01]+$");
		return answer;
	}
	private boolean isDecimal(){
		boolean answer=false;
		answer=number.matches("^[1-9][0-9]+$");
		return answer;
	}
	private boolean isHexaDecimal(){
		boolean answer=false;
		answer=number.matches("^[0-9A-Fa-f]+$");
		return answer;
	}

	/*
	 * Checks that the input type is correct based off of type chosen by radio button
	 */
	private boolean typeCheck(String type){
		boolean isCorrect=false;
		switch (type) {
		case "Binary": 
			if(!isBinary()){
				number="Input is not binary";
				isCorrect=false;
			}
			else{
				isCorrect=true;
			}
			break;
		case "Decimal": 
			if(!isDecimal()){
				number="Input is not decimal";
				isCorrect=false;
			}
			else{
				isCorrect=true;
			}
			break;
		case "Hexadecimal": 
			if(!isHexaDecimal()){
				number="Input is not hexadecimal";
				isCorrect=false;
			}
			else{
				isCorrect=true;
			}
			break;
		default: number="Input format is invalid";
		}
		return isCorrect;
	}


	/*
	 * Main functions that perform the conversions
	 */
	public void getBinary(String type){
		if(typeCheck(type)){
			// hexadecimal to binary
			if(type.equals("Hexadecimal")){
				String[] split=number.split("");
				int length=split.length;
				number="";
				for(int x=0;x<length;x++){
					switch (split[x].toLowerCase()){
					case "0": number=number+"0000 ";
					break;
					case "1": number=number+"0001 ";
					break;
					case "2": number=number+"0010 ";
					break;
					case "3": number=number+"0011 ";
					break;
					case "4": number=number+"0100 ";
					break;
					case "5": number=number+"0101 ";
					break;
					case "6": number=number+"0110 ";
					break;
					case "7": number=number+"0111 ";
					break;
					case "8": number=number+"1000 ";
					break;
					case "9": number=number+"1001 ";
					break;
					case "a": number=number+"1010 ";
					break;
					case "b": number=number+"1011 ";
					break;
					case "c": number=number+"1100 ";
					break;
					case "d": number=number+"1101 ";
					break;
					case "e": number=number+"1110 ";
					break;
					case "f": number=number+"1111 ";
					break;
					default: number="error on input";
					break;
					}
				}
				number=number.trim();
			}
			// Decimal to binary
			else if(type.equals("Decimal")){
				int value=Integer.parseInt(number);
				number=Integer.toBinaryString(value);		
			}
		}
	}
	public void getDecimal(String type){
		if(typeCheck(type)){
			// Hexadecimal to decimal
			if(type.equals("Hexadecimal")){
				number=Integer.decode("0x"+number).toString();
			}
			// Binary to decimal
			else if(type.equals("Binary")){
				int value=0;
				String[] split=number.split("");
				int length=split.length;
				for(int x=0;x<length;x++){
					if(split[x].equals("1")){
						value=(int) (value+Math.pow(2, x));
					}
				}
				number=Integer.toString(value);
			}
		}
	}
	public void getHexadecimal(String type){
		if(typeCheck(type)){
			// Decimal to hexadecimal
			if(type.equals("Decimal")){
				int value=Integer.parseInt(number);
				number=Integer.toHexString(value);	
			}
			// Binary to hexadecimal
			else if(type.equals("Binary")){
				int value=Integer.parseInt(number,2);
				number=Integer.toHexString(value);
				
			}
		}
	}
}
