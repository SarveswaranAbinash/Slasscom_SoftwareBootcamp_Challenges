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

	public static int romanToInt(String s) {
		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			int s1 = value(s.charAt(i));
			if (i + 1 < s.length()) {
				int s2 = value(s.charAt(i + 1));
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

	public static int roman_character_int(String string) {

		int length = string.length();

		string = string + " ";
		int result = 0;
		for (int i = 0; i < length; i++) {
			char ch = string.charAt(i);
			char next_char = string.charAt(i + 1);

			if (ch == 'M') {
				result += 1000;
			} else if (ch == 'C') {
				if (next_char == 'M') {
					result += 900;
					i++;
				} else if (next_char == 'D') {
					result += 400;
					i++;
				} else {
					result += 100;
				}
			} else if (ch == 'D') {
				result += 500;
			} else if (ch == 'X') {
				if (next_char == 'C') {
					result += 90;
					i++;
				} else if (next_char == 'L') {
					result += 40;
					i++;
				} else {
					result += 10;
				}
			} else if (ch == 'L') {
				result += 50;
			} else if (ch == 'I') {
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
		System.out.println("\nRoman Number: " + string);
		System.out.println("Equivalent Integer: " + result + "\n");

		return result;
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Roman to Integer Converter Menu:");
		System.out.println("Please Select The test case to continue:");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter roman Character :");
		String input = sc.nextLine();
		System.out.println("Numberals : " + roman_numeralToInteger(input));
		System.out.println("CASE 2 : " + romanToInt(input));
		roman_character_int(input);

	}
}
