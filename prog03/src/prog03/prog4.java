package prog03;

/* Alvarado, Elizabeth. 
 * Program 04, 
 * CSC-1350.
 */
import java.util.*;
import java.io.*;

public class prog4 
{ 
	public static void main(String args[])
	{
		int med, max = 0, numCompMax = 0, numCompMed = 0, first, second, third; 
		Scanner scan = new Scanner(System.in);
		String comparisonsMax = null;
		String comparisonsMed = null;
		
		for (int i = 0; i < 6; i++)
		{ System.out.print("\nEnter three distinct integers: ");
		  first = scan.nextInt();
		  second = scan.nextInt();
		  third = scan.nextInt();
		  scan.nextLine();
		  numCompMax = 0;
		  numCompMed = 0;
		  numCompMax++;
		  numCompMed++;
		if (first < second) 
		{ numCompMax++;
		  numCompMed++;
			if (second < third)
			{ max = third;
			  med = second;
			  comparisonsMax = comparisonsMed = first + "<" + second + "(T), " + second + "<" + third + "(T)";
			}
			else if (first < third)
			  { max = second; // I cannot figure out a way to do this more efficiently, as it causes errors in the program and throws the counter off.
			    med = third;
			  	numCompMed++;
			    comparisonsMax = first + "<" + second + "(T), " + second + "<" + third + "(F)";
				comparisonsMed = first + "<" + second + "(T), " + second + "<" + third + "(F), " + first + "<" + third + "(T)";
			  }
			else { max = second;
				   med = first; 
				   numCompMed++;
				   comparisonsMax = first + "<" + second + "(T), " + second + "<" + third + "(F)";
				   comparisonsMed = first + "<" + second + "(T), " + second + "<" + third + "(F), " + first + "<" + third + "(F)";
				 }
		}
		else if (second < third)
			 { numCompMax++;
			   numCompMed++;
				if (first < third)
				{ med = first;
				  max = third;
				  comparisonsMax = comparisonsMed = second + "<" + third + "(T), " + first + "<" + third + "(T)";
				}
				else { numCompMed++;
					   med = third;
					   max = first;
					   comparisonsMax = second + "<" + third + "(T), " + first + "<" + third + "(F)";
					   comparisonsMed = first + "<" + second + "(F), " + second + "<" + third + "(T), " + first + "<" + third + "(F)";
					 }	
		}
		else { max = first;
			   med = second;
			   numCompMax++;
			   numCompMed++;
			   comparisonsMax = first + "<" + second + "(F), " + second + "<" + third + "(F)";
			   comparisonsMed = first + "<" + second + "(F), " + second + "<" + third + "(F)";
			 }
			
		System.out.println("\nFor the inputs " + first + ", " + second + ", and " + third + ": max = " + max + "\nComparisons: " + comparisonsMax + "; numComparisons = " + numCompMax);
		System.out.println("For the inputs " + first + ", " + second + ", and " + third + ": median = " + med + "\nComparisons: " + comparisonsMed + "; numComparisons = " + numCompMed);
		}	
	}
}


/* 
Enter three distinct integers: 5 10 13

For the inputs 5, 10, and 13: max = 13
Comparisons: 5<10(T), 10<13(T); numComparisons = 2
For the inputs 5, 10, and 13: median = 10
Comparisons: 5<10(T), 10<13(T); numComparisons = 2

Enter three distinct integers: 5 13 10

For the inputs 5, 13, and 10: max = 13
Comparisons: 5<13(T), 13<10(F); numComparisons = 2
For the inputs 5, 13, and 10: median = 10
Comparisons: 5<13(T), 13<10(F), 5<10(T); numComparisons = 3

Enter three distinct integers: 10 5 13

For the inputs 10, 5, and 13: max = 13
Comparisons: 5<13(T), 10<13(T); numComparisons = 2
For the inputs 10, 5, and 13: median = 10
Comparisons: 5<13(T), 10<13(T); numComparisons = 2

Enter three distinct integers: 10 13 5

For the inputs 10, 13, and 5: max = 13
Comparisons: 10<13(T), 13<5(F); numComparisons = 2
For the inputs 10, 13, and 5: median = 10
Comparisons: 10<13(T), 13<5(F), 10<5(F); numComparisons = 3

Enter three distinct integers: 13 5 10

For the inputs 13, 5, and 10: max = 13
Comparisons: 5<10(T), 13<10(F); numComparisons = 2
For the inputs 13, 5, and 10: median = 10
Comparisons: 13<5(F), 5<10(T), 13<10(F); numComparisons = 3

Enter three distinct integers: 13 10 5

For the inputs 13, 10, and 5: max = 13
Comparisons: 13<10(F), 10<5(F); numComparisons = 2
For the inputs 13, 10, and 5: median = 10
Comparisons: 13<10(F), 10<5(F); numComparisons = 2
*/