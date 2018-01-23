package prog7;

/* Alvarado, Elizabeth. 
 * Program 06, 
 * CSC-1350.
 */
import java.util.*;
import java.io.*;

public class FillArrayAndFindAver2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of students (4 to 7): ");
		int numStudents = scan.nextInt();

		String restOfInputLine = scan.nextLine();
		int studentScores[] = new int[numStudents];

		System.out
				.println("Successively enter student scores (any integer between 0 and 100). \n----");
		int error = 0;
		int sum = 0;
		for (int i = 0; i < studentScores.length; i++) {
			System.out.print("Enter a score (" + (numStudents - i)
					+ " remaining): ");
			studentScores[i] = scan.nextInt();
			scan.nextLine();
			while ((0 > studentScores[i]) || (studentScores[i] > 100)) {
				error++;
				System.out.println("\nNumber of errors so far: " + error);
				System.out.print("Enter a score between 0 and 100: ");
				studentScores[i] = scan.nextInt();
				scan.nextLine();
			}
			System.out.println("studentScores[" + i + "] = " + studentScores[i]);
			sum += studentScores[i];
		}

		System.out.println("---- \nstudentScores: "
				+ Arrays.toString(studentScores));

		double averScore = 1.0 * sum / studentScores.length;
		System.out.printf("averageScore = %d/%d = %1.1f\n", sum,
				studentScores.length, averScore);
		int highGrades = 0;
		int count = 0;
		for (int i = 0; i < studentScores.length; i++) {
			if (studentScores[i] >= averScore) {
				highGrades += studentScores[i];
				count++;
			}
		}
		double averHiScore = 1.0 * highGrades / count;
		System.out.printf("averageScore (for scores >= %1.1f) = %d/%d = %1.1f\n",
				averScore, highGrades, count, averHiScore);

		/*
		 * //start of the "function" toString() String result = ""; if
		 * (studentScores.length > 0) { result = result +
		 * studentScores[studentScores.length-1]; for (int i =
		 * studentScores.length-2; i >= 0; i--) result = studentScores[i] + ", "
		 * + result; }
		 * 
		 * 
		 * result = "[" + result + "]";
		 * System.out.println("\n#6 toString result: \n" + result);
		 */
	}
}

/*
 * Enter number of students (4 to 7): 6 Successively enter student scores (any
 * integer between 0 and 100). ---- Enter a score (6 remaining): 70
 * studentScores[0] = 70 Enter a score (5 remaining): -95
 * 
 * Number of errors so far: 1 Enter a score between 0 and 100: 95
 * studentScores[1] = 95 Enter a score (4 remaining): 40 studentScores[2] = 40
 * Enter a score (3 remaining): -35
 * 
 * Number of errors so far: 2 Enter a score between 0 and 100: 101
 * 
 * Number of errors so far: 3 Enter a score between 0 and 100: 75
 * studentScores[3] = 75 Enter a score (2 remaining): 85 studentScores[4] = 85
 * Enter a score (1 remaining): 60 studentScores[5] = 60 ---- studentScores:
 * [70, 95, 40, 75, 85, 60] averageScore = 425/6 = 70.8 averageScore (for scores
 * >= 70.8) = 255/3 = 85.0
 */