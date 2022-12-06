import java.util.Scanner;

public class romanToInteger
{


public static final int roman_numeralToInteger(String roman_numeral) {

  
	int integer = 0;
  
	for (int i = 0; i < roman_numeral.length(); i++) {
		char roman_character = roman_numeral.charAt(i);

      
        
		switch (roman_character) {

            
		case 'I':
			integer = (i != roman_numeral.length() - 1 && (roman_numeral.charAt(i + 1) == 'V' || roman_numeral.charAt(i + 1) == 'X'))
					? integer - 1
					: integer + 1;
			break;
		case 'V':
			integer += 5;
			break;
		case 'X':
			integer = (i != roman_numeral.length() - 1 && (roman_numeral.charAt(i + 1) == 'L' || roman_numeral.charAt(i + 1) == 'C'))
					? integer - 10
					: integer + 10;
			break;
		case 'L':
			integer += 50;
			break;
		case 'C':
			integer = (i != roman_numeral.length() - 1 && (roman_numeral.charAt(i + 1) == 'D' || roman_numeral.charAt(i + 1) == 'M'))
					? integer - 100
					: integer + 100;
			break;
		case 'D':
			integer += 500;
			break;
		case 'M':
			integer += 1000;
			break;
		}
    
	}
    
    
	return integer;

    
}




public static void main (String [] args)
{

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter roman Character :");

    String input = sc.nextLine();
    if(input.equals("IIII") || input.equals("XXXX")) 
    {
        System.out.println("error");
    }
    else
    {

   System.out.println( "Numberals : " +   roman_numeralToInteger(input));
    }
}
}