import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.script.ScriptEngine;

public class Program {

	public static void main(String[] args) throws IOException {

		English english = new English();
		Science science = new Science();
		Math math = new Math();
		List<Object> englishList = new ArrayList<Object>();
		List<Object> scienceList = new ArrayList<Object>();
		List<Object> mathList = new ArrayList<Object>();

		boolean exit = true;
		


			while(exit)
			{

			System.out.println("Select the option\n 1.Import file \n 2. Export files \n 3.Exit");
			Scanner sc = new Scanner(System.in);
			int value = sc.nextInt();

			

			switch (value) {
				case 1:
					Main(englishList, mathList, scienceList, english, science, math);
					break;

				case 2:
					Writer(englishList, mathList, scienceList);
					break;

				case 3:
					exit = false;
					break;

				default:
					break;

			}
		}


		System.out.println("Byeee :(");
		
		
	}

	public static void Main(List englishList, List mathList, List scienceList, English english, Science science,
			Math math) throws IOException {

		String fileName = "input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		int count = Integer.parseInt(reader.readLine());

		for (int i = 0; i < count; i++) {
			String name = reader.readLine();
			String[] data = name.split(",");

			String subject = reader.readLine();
			String[] data1 = subject.split(" ");

			if (data1[0].equals("English") && !data1[0].isEmpty()) {
				englishList.add(data[0]);
				englishList.add(data[1]);
				List<String> list = english.findGradeAvg(data1);
				englishList.addAll(list);
			} else if (data1[0].equals("Science") && !data1[0].isEmpty()) {
				scienceList.add(data[0]);
				scienceList.add(data[1]);
				List<String> list = science.findGradeAvg(data1);
				scienceList.addAll(list);
			} else if (data1[0].equals("Math") && !data1[0].isEmpty()) {
				mathList.add(data[0]);
				mathList.add(data[1]);
				List<String> list = math.findGradeAvg(data1);
				mathList.addAll(list);
			}
		}

		reader.close();
	}

	public static void Writer(List englishList, List mathList, List scienceList) throws IOException {

		int englishCountA = 0;
		int englishCountB = 0;
		int englishCountC = 0;
		int englishCountD = 0;
		int englishCountF = 0;

		int scienceCountA = 0;
		int scienceCountB = 0;
		int scienceCountC = 0;
		int scienceCountD = 0;
		int scienceCountF = 0;

		int mathCountA = 0;
		int mathCountB = 0;
		int mathCountC = 0;
		int mathCountD = 0;
		int mathCountF = 0;

		PrintWriter writer = new PrintWriter("output.txt");

		writer.println("English Student Grade Summary");
		writer.println("---------------------");
		writer.println();
		writer.println();
		writer.println("ENGLISH CLASS");
		writer.println();
		writer.println();
		writer.println("Student Final Final Letter");
		writer.println("Name    Exam  Avg   Grade");

		for (int i = 0; i < englishList.size(); i = i + 5) {
			writer.println(englishList.get(i) + " " + englishList.get(i + 1) + " " + englishList.get(i + 2) + " "
					+ englishList.get(i + 3) + " " + englishList.get(i + 4));
			if (englishList.get(i + 4).equals("A")) {
				englishCountA++;
			} else if (englishList.get(i + 4).equals("B")) {
				englishCountB++;
			} else if (englishList.get(i + 4).equals("C")) {
				englishCountC++;
			} else if (englishList.get(i + 4).equals("D")) {
				englishCountD++;
			} else if (englishList.get(i + 4).equals("F")) {
				englishCountF++;
			}
		}

		writer.println();
		writer.println("Number of students who received each grade:");
		writer.println("A: " + englishCountA);
		writer.println("B: " + englishCountB);
		writer.println("C: " + englishCountC);
		writer.println("D: " + englishCountD);
		writer.println("F: " + englishCountF);
		writer.println();

		writer.println("Science Student Grade Summary");
		writer.println("---------------------");
		writer.println();
		writer.println();
		writer.println("Science CLASS");
		writer.println();
		writer.println();
		writer.println("Student Final Final Letter");
		writer.println("Name    Exam  Avg   Grade");

		for (int i = 0; i < scienceList.size(); i = i + 5) {
			writer.println(scienceList.get(i) + " " + scienceList.get(i + 1) + " " + scienceList.get(i + 2) + " "
					+ scienceList.get(i + 3) + " " + scienceList.get(i + 4));
			if (scienceList.get(i + 4).equals("A")) {
				scienceCountA++;
			} else if (scienceList.get(i + 4).equals("B")) {
				scienceCountB++;
			} else if (scienceList.get(i + 4).equals("C")) {
				scienceCountC++;
			} else if (scienceList.get(i + 4).equals("D")) {
				scienceCountD++;
			} else if (scienceList.get(i + 4).equals("F")) {
				scienceCountF++;
			}
		}

		writer.println();
		writer.println("Number of students who received each grade:");
		writer.println("A: " + scienceCountA);
		writer.println("B: " + scienceCountB);
		writer.println("C: " + scienceCountC);
		writer.println("D: " + scienceCountD);
		writer.println("F: " + scienceCountF);
		writer.println();

		writer.println("Maths Student Grade Summary");
		writer.println("---------------------");
		writer.println();
		writer.println();
		writer.println("Math CLASS");
		writer.println();
		writer.println();
		writer.println("Student Final Final Letter");
		writer.println("Name Exam Avg Grade");

		for (int i = 0; i < mathList.size(); i = i + 5) {
			writer.println(mathList.get(i) + " " + mathList.get(i + 1) + " " + mathList.get(i + 2) + " "
					+ mathList.get(i + 3) + " " + mathList.get(i + 4));
			if (mathList.get(i + 4).equals("A")) {
				mathCountA++;
			} else if (mathList.get(i + 4).equals("B")) {
				mathCountB++;
			} else if (mathList.get(i + 4).equals("C")) {
				mathCountC++;
			} else if (mathList.get(i + 4).equals("D")) {
				mathCountD++;
			} else if (mathList.get(i + 4).equals("F")) {
				mathCountF++;
			}
		}

		writer.println();
		writer.println("Number of students who received each grade:");
		writer.println("A: " + mathCountA);
		writer.println("B: " + mathCountB);
		writer.println("C: " + mathCountC);
		writer.println("D: " + mathCountD);
		writer.println("F: " + mathCountF);
		writer.println();

		writer.println("---------------------");
		writer.println("Overall Student Summary ");
		writer.println("---------------------");
		writer.println("Overall A grade holders - " + (mathCountA + scienceCountA + englishCountA));
		writer.println("Overall B grade holders - " + (mathCountB + scienceCountB + englishCountB));
		writer.println("Overall C grade holders - " + (mathCountC + scienceCountC + englishCountC));
		writer.println("Overall D grade holders - " + (mathCountD + scienceCountD + englishCountD));
		writer.println("Overall F grade holders - " + (mathCountF + scienceCountF + englishCountF));

		writer.close();
	}

}
