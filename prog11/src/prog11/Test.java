package prog11;

/* Alvarado, Elizabeth. 
 * Program 11, 
 * CSC-1350.
 */
import java.util.*;

public class Test {
	public static void main(String[] args) {
		int[] inputMarbles1 = { 0, 0, 0, 0 }, inputMarbles2 = { 1, 1, 1, 1 };
		Marbles3 m = new Marbles3();
		m.moveAllWMtoLeft();
		System.out.println("-----"); // repeat twice for each m
		m = new Marbles3(inputMarbles1);
		m.moveAllWMtoLeft();
		System.out.println("-----"); // repeat twice for each m
		m = new Marbles3(inputMarbles2);
		m.moveAllWMtoLeft();
	}
}

class Marbles3 {
	private int[] marbles = { 1, 1, 0, 0, 0, 1, 0, 0, 1 };

	public Marbles3(int[] inputMarbles) {
		marbles = new int[inputMarbles.length];
		for (int i = 0; i < inputMarbles.length; i++)
			marbles[i] = inputMarbles[i];
	}

	public Marbles3() {
	}

	private int posnLMBMafter(int startPosn) {
		int i;
		for (i = startPosn + 1; i < marbles.length; i++)
			if (marbles[i] == 1)
				break;
		return i;
	}

	private int posnRMWMbefore(int startPosn) {
		int i;
		for (i = startPosn - 1; i >= 0; i--)
			if (marbles[i] == 0)
				break;
		return i;
	}

	public void moveAllWMtoLeft() {
		int posnLMBM, posnRMWM, oldPosnLMBM, oldPosnRMWM, numMarblesLookedAtForLMBM, numMarblesLookedAtForRMWM = 0;
		posnLMBM = -1;
		posnRMWM = marbles.length;
		for (; true;) {
			oldPosnLMBM = posnLMBM;
			oldPosnRMWM = posnRMWM;
			posnRMWM = posnRMWMbefore(posnRMWM);
			posnLMBM = posnLMBMafter(posnLMBM);
			System.out.println("Marbles = " + Arrays.toString(marbles));
			if (posnLMBM < marbles.length) {
				numMarblesLookedAtForLMBM = posnLMBM - oldPosnLMBM;
				if (posnRMWM >= 0) {
					marbles[posnLMBM] = 0;
					marbles[posnRMWM] = 1;
					numMarblesLookedAtForRMWM = oldPosnRMWM - posnRMWM;
				} else
					numMarblesLookedAtForRMWM = marbles.length;
			} else
				numMarblesLookedAtForLMBM = marbles.length;

			System.out.println("posnLMBM = " + posnLMBM + ", posnRMWM = "
					+ posnRMWM);
			System.out.println("numMarblesLookedAt: "
					+ numMarblesLookedAtForLMBM + " (for LMBM), "
					+ numMarblesLookedAtForRMWM + " (for RMWM)");
			if (posnRMWM < posnLMBM)
				break;
		}
	}
}

/*
 * Marbles = [1, 1, 0, 0, 0, 1, 0, 0, 1] posnLMBM = 0, posnRMWM = 7
 * numMarblesLookedAt: 1 (for LMBM), 2 (for RMWM) Marbles = [0, 1, 0, 0, 0, 1,
 * 0, 1, 1] posnLMBM = 1, posnRMWM = 6 numMarblesLookedAt: 1 (for LMBM), 1 (for
 * RMWM) Marbles = [0, 0, 0, 0, 0, 1, 1, 1, 1] posnLMBM = 5, posnRMWM = 4
 * numMarblesLookedAt: 4 (for LMBM), 2 (for RMWM) ----- Marbles = [0, 0, 0, 0]
 * posnLMBM = 4, posnRMWM = 3 numMarblesLookedAt: 4 (for LMBM), 0 (for RMWM)
 * ----- Marbles = [1, 1, 1, 1] posnLMBM = 0, posnRMWM = -1 numMarblesLookedAt:
 * 1 (for LMBM), 4 (for RMWM)
 */