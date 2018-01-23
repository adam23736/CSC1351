package prog10;
/* Alvarado, Elizabeth. 
 * Program 10, 
 * CSC-1350.
 */
import java.util.*;

public class Marbles2 {
	private int [] marbles = {1, 1, 0, 0, 0, 1, 0, 0, 1};

	public Marbles2(int[] inputMarbles){
        	marbles = new int[inputMarbles.length];
        	for(int i = 0; i < inputMarbles.length; i++)
        		marbles[i] = inputMarbles[i];
    }
    public Marbles2(){
    }
    
    private int posnRMWM(){
    	int i;
        for (i = marbles.length-1; i >= 0; i--)
            if (marbles[i] == 0) break;
        return (i);
    }
    
   private int posnLMBM(){
       int i;
       for (i = 0; i< marbles.length; i++)
           if (marbles [i] == 1)
               break;
       return i;
   }

   public static void main(String[] args) {
        int posnLMBM, posnRMWM, numMarblesLookedAtForLMBM, numMarblesLookedAtForRMWM;
        int[] inputMarbles = {1, 1, 0, 0, 0, 1, 0, 0, 1};
        //int[] inputMarbles = {0, 0, 0, 0};
        //int[] inputMarbles = {1, 1, 1, 1};
        Marbles2 m = new Marbles2(inputMarbles);
        //Marbles m = new Marbles();
        for ( ; true ; ) {
		    posnLMBM = m.posnLMBM();
		    posnRMWM = m.posnRMWM();
		    System.out.println("Marbles = " + Arrays.toString(m.marbles));
		    if (posnLMBM < m.marbles.length){
		    	numMarblesLookedAtForLMBM = posnLMBM + 1;
		    	if (posnRMWM >= 0){
		    		m.marbles[posnLMBM] = 0;
		    		m.marbles[posnRMWM] = 1;
		    		numMarblesLookedAtForRMWM = m.marbles.length - posnRMWM;
		    	}
		    	else numMarblesLookedAtForRMWM = m.marbles.length;
		    }
		    else { numMarblesLookedAtForLMBM = m.marbles.length;
		    	   numMarblesLookedAtForRMWM = 0;
		    }
		    System.out.println("posnLMBM = " + posnLMBM + ", posnRMWM = " + posnRMWM);
		    System.out.println("numMarblesLookedAt: " + numMarblesLookedAtForLMBM + " (for LMBM), " 
		    		+ numMarblesLookedAtForRMWM + " (for RMWM)");
		    if (posnRMWM < posnLMBM) break;
        }		    	
        System.out.println("*** no white marble found to the right of leftmost black marble");
    	}
}

/*

Marbles = [1, 1, 0, 0, 0, 1, 0, 0, 1]
posnLMBM = 0, posnRMWM = 7
numMarblesLookedAt: 1 (for LMBM), 2 (for RMWM)
Marbles = [0, 1, 0, 0, 0, 1, 0, 1, 1]
posnLMBM = 1, posnRMWM = 6
numMarblesLookedAt: 2 (for LMBM), 3 (for RMWM)
Marbles = [0, 0, 0, 0, 0, 1, 1, 1, 1]
posnLMBM = 5, posnRMWM = 4
numMarblesLookedAt: 6 (for LMBM), 5 (for RMWM)
*** no white marble found to the right of leftmost black marble
-----
Marbles = [0, 0, 0, 0]
posnLMBM = 4, posnRMWM = 3
numMarblesLookedAt: 4 (for LMBM), 0 (for RMWM)
*** no white marble found to the right of leftmost black marble
-----
Marbles = [1, 1, 1, 1]
posnLMBM = 0, posnRMWM = -1
numMarblesLookedAt: 1 (for LMBM), 4 (for RMWM)
*** no white marble found to the right of leftmost black marble

 */

