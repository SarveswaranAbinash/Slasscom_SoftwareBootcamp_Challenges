import java.util.Scanner;

public class romanToInteger {

	public static final int roman_numeralToInteger(String roman_numeral) {

		int integer = 0;

		for (int i = 0; i < roman_numeral.length(); i++) {
			char roman_character = roman_numeral.charAt(i);

			switch (roman_character) {

				case 'I':
					integer = (i != roman_numeral.length() - 1
							&& (roman_numeral.charAt(i + 1) == 'V' || roman_numeral.charAt(i + 1) == 'X'))
									? integer - 1
									: integer + 1;
					break;
				case 'V':
					integer += 5;
					break;
				case 'X':
					integer = (i != roman_numeral.length() - 1
							&& (roman_numeral.charAt(i + 1) == 'L' || roman_numeral.charAt(i + 1) == 'C'))
									? integer - 10
									: integer + 10;
					break;
				case 'L':
					integer += 50;
					break;
				case 'C':
					integer = (i != roman_numeral.length() - 1
							&& (roman_numeral.charAt(i + 1) == 'D' || roman_numeral.charAt(i + 1) == 'M'))
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

	public static int value(char roman_character) {
		int numbers = 0;
		if (roman_character == 'I')
			numbers = 1;
		if (roman_character == 'V')
			numbers = 5;
		if (roman_character == 'X')
			numbers = 10;
		if (roman_character == 'L')
			numbers = 50;
		if (roman_character == 'C')
			numbers = 100;
		if (roman_character == 'D')
			numbers = 500;
		if (roman_character == 'M')
			numbers = 1000;

		return numbers;
	}

	public static int romanToInt(String Roman_char) {
		int total = 0;
		for (int i = 0; i < Roman_char.length(); i++) {
			int s1 = value(Roman_char.charAt(i));
			if (i + 1 < Roman_char.length()) {
				int s2 = value(Roman_char.charAt(i + 1));
				if (s1 >= s2) {
					total = total + s1;
				} else {
					total = total - s1;
				}
			} else {
				total = total + s1;
			}
		}
		return total;
	}

	public static int romant(String Roman) {
		int result = 0;
		String Integer_value = Roman;

		for (int i = 0; i < Roman.length() - 1; i++) {
			int value1 = getValue(Roman.charAt(i));
			int value2 = getValue(Roman.charAt(i + 1));

			if (value1 < value2) {
				result += (value2 - value1);

				Integer_value = Integer_value.replace(Roman.substring(i, i + 2), "");
			}
		}

		for (int i = 0; i < Integer_value.length(); i++)
			result += getValue(Integer_value.charAt(i));

		return result;
	}

	public static int getValue(char roman_character) {
		char[] roman_characters = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] integer_values = { 1, 5, 10, 50, 100, 500, 1000 };
		int result = 0;

		for (int i = 0; i < roman_characters.length; i++) {
			if (roman_character == roman_characters[i]) {
				result = integer_values[i];
				break;
			}
		}

		return result;
	}

	public static int roman_character_int(String Integer) {

		int length = Integer.length();

		Integer = Integer + " ";
		int result = 0;
		for (int i = 0; i < length; i++) {
			char roman_Converter = Integer.charAt(i);
			char next_char = Integer.charAt(i + 1);

			if (roman_Converter == 'M') {
				result += 1000;
			} else if (roman_Converter == 'C') {
				if (next_char == 'M') {
					result += 900;
					i++;
				} else if (next_char == 'D') {
					result += 400;
					i++;
				} else {
					result += 100;
				}
			} else if (roman_Converter == 'D') {
				result += 500;
			} else if (roman_Converter == 'X') {
				if (next_char == 'C') {
					result += 90;
					i++;
				} else if (next_char == 'L') {
					result += 40;
					i++;
				} else {
					result += 10;
				}
			} else if (roman_Converter == 'L') {
				result += 50;
			} else if (roman_Converter == 'I') {
				if (next_char == 'X') {
					result += 9;
					i++;
				} else if (next_char == 'V') {
					result += 4;
					i++;
				} else {
					result++;
				}
			} else { // if (ch == 'V')
				result += 5;
			}
		}
		System.out.println("\nRoman Number: " + Integer);
		System.out.println("Equivalent Integer: " + result + "\n");

		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Roman to Integer Converter Menu:");
		System.out.println("Menu : \n 1) Solution 1 \n 2) Solution 2 \n 3) Solution 3 \n 4) Solution 4");
		System.out.println("Please Select The test case to continue:");
		int character = sc.nextInt();
		switch (character) {
			case 1:
				System.out.println("Enter roman Character :");
				String value = sc.next();
				System.out.println("Numberals : " + roman_numeralToInteger(value));
				break;

			case 2:
				System.out.println("Enter roman Character :");
				String input = sc.next();
				System.out.println("CASE 2 : " + romanToInt(input));
				break;

			case 3:
				System.out.println("Enter roman character");
				String input2 = sc.next();
				roman_character_int(input2);
				break;

			case 4:
				System.out.println("Enter roman character");
				String input3 = sc.next();
				System.out.println("answer : " + romant(input3));
				break;

			default:
				System.out.println("Enter proper input");

		}

	}
}

