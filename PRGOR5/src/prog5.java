
/* Alvarado, Elizabeth. 
 * Program 05, 
 * CSC-1350.
 */

import java.util.*;
import java.io.*; @SuppressWarnings("unused")

public class prog5
{
	public static void main(String args[])
	{
	int numMinsPerQtr, numMinsPerDms, numMinsPerNis, numQrtsUsed, 
	numDmsUsed, numNisUsed, numPenniesAvailable, numRemainingPennies, numPennysUsed, 
	numMins2Park;

	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	
	System.out.print("Enter number of parking minutes per quarter, dime, and nickel: ");
	numMinsPerQtr = scan.nextInt();
	numMinsPerDms = scan.nextInt();
	numMinsPerNis = scan.nextInt();
	String restOfInputLine = scan.nextLine();
	
	for (int i = 0; i < 7; i++)
	{ 	
	System.out.print("\nEnter number of pennies available (>=0): ");
	numPenniesAvailable = scan.nextInt();
	restOfInputLine = scan.nextLine();
	
	numQrtsUsed = numPenniesAvailable/25;
	numRemainingPennies = (numPenniesAvailable - (numQrtsUsed*25));
	
	numDmsUsed = numRemainingPennies/10;
	numRemainingPennies -= (numDmsUsed*10);
	
	numNisUsed = numRemainingPennies/5;
	numRemainingPennies -= (numNisUsed*5);
	
	numPennysUsed = (25*numQrtsUsed) + (10*numDmsUsed) + (5*numNisUsed);

	System.out.print("Number of pennies used = ");

	if (numQrtsUsed > 0)
	System.out.print(numQrtsUsed + "x25");

	if (numDmsUsed > 0)
		if (numQrtsUsed > 0)
		   System.out.print(" + " + numDmsUsed + "x10");
		else System.out.print(numDmsUsed + "x10");

	if (numNisUsed > 0)
		if ((numQrtsUsed > 0) || (numDmsUsed > 0))
		    System.out.print(" + " + numNisUsed + "x5");
		else System.out.print(numNisUsed + "x5");

	if ((numQrtsUsed > 0) || (numDmsUsed > 0) || (numNisUsed > 0))
		System.out.println(" = " + numPennysUsed);
	else System.out.println(0);
	

	numMins2Park = (numQrtsUsed*numMinsPerQtr) + (numDmsUsed*numMinsPerDms) + (numNisUsed*numMinsPerNis);

	System.out.print("Maximum number of minutes to park = ");

	if (numQrtsUsed > 0)
	System.out.print(numQrtsUsed + "x30");

	if (numDmsUsed > 0)
		if (numQrtsUsed > 0)
		   System.out.print(" + " + numDmsUsed + "x11");
		else System.out.print(numDmsUsed + "x11");

	if (numNisUsed > 0)
		if ((numQrtsUsed > 0) || (numDmsUsed > 0))
		    System.out.print(" + " + numNisUsed + "x5");
		else System.out.print(numNisUsed + "x5");

	if ((numQrtsUsed > 0) || (numDmsUsed > 0) || (numNisUsed > 0))
		System.out.println(" = " + numMins2Park);
	else System.out.println(0);
	}	
	}
}

/*
 
Enter number of parking minutes per quarter, dime, and nickel: 30 11 5 2

Enter number of pennies available (>=0): 2
Number of pennies used = 0
Maximum number of minutes to park = 0

Enter number of pennies available (>=0): 7
Number of pennies used = 1x5 = 5
Maximum number of minutes to park = 1x5 = 5

Enter number of pennies available (>=0): 22
Number of pennies used = 2x10 = 20
Maximum number of minutes to park = 2x11 = 22

Enter number of pennies available (>=0): 52
Number of pennies used = 2x25 = 50
Maximum number of minutes to park = 2x30 = 60

Enter number of pennies available (>=0): 57
Number of pennies used = 2x25 + 1x5 = 55
Maximum number of minutes to park = 2x30 + 1x5 = 65

Enter number of pennies available (>=0): 17
Number of pennies used = 1x10 + 1x5 = 15
Maximum number of minutes to park = 1x11 + 1x5 = 16

Enter number of pennies available (>=0): 62
Number of pennies used = 2x25 + 1x10 = 60
Maximum number of minutes to park = 2x30 + 1x11 = 71

*/