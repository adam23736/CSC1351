/* Alvarado, Elizabeth. 
 * Program 09, 
 * CSC-1350.
 */
import java.util.*;

public class Marbles {
private int [] marbles = {0, 1, 0, 0, 0, 1, 1, 0, 0, 1};
    public static void main(String[] args) {
        int posnLMBM, posnNextLMWM, numMarblesLookedAtForLMBM, numMarblesLookedAtForNextLMWM;
        int[] inputMarbles = {0, 0, 0, 0};
        Marbles m = new Marbles(inputMarbles);
        //Marbles m = new Marbles();
        for ( ; true ; ) {
		    posnLMBM = m.posnLMBM();
		    System.out.println("Marbles = " + Arrays.toString(m.marbles));
		    numMarblesLookedAtForLMBM = posnLMBM + 1;
		    if (posnLMBM < m.marbles.length){
		    	posnNextLMWM = m.posnNextLMWM(posnLMBM);
		    	
		    	numMarblesLookedAtForLMBM = posnLMBM + 1;
		    	if(posnNextLMWM < m.marbles.length){
		    		m.marbles[posnLMBM] = 0;
		    		m.marbles[posnNextLMWM] = 1;
		    		numMarblesLookedAtForNextLMWM = posnNextLMWM-posnLMBM;

		    	}
		    	else numMarblesLookedAtForNextLMWM = posnNextLMWM - numMarblesLookedAtForLMBM;
		    }
		    else { posnNextLMWM = numMarblesLookedAtForLMBM = m.marbles.length;
		    	numMarblesLookedAtForNextLMWM = 0;
		    }
		    System.out.println( "posnLMBM = " + posnLMBM + ", posnNextLMWM = " + posnNextLMWM);
		    System.out.println("numMarblesLookedAt: " + numMarblesLookedAtForLMBM + " (for LMBM), " 
		    		+ numMarblesLookedAtForNextLMWM + " (for nextLMWM)");
		    if (posnNextLMWM == m.marbles.length){break;}
        }		    	
        System.out.println("*** no white marble found to the right of leftmost black marble");
    	}
    public Marbles(int[] inputMarbles){
        	int i;
        	marbles = new int[inputMarbles.length];
        	for(i = 0; i < inputMarbles.length; i++)
        		marbles[i] = inputMarbles[i];
        }
    public Marbles(){
        }
    
    public int posnNextLMWM(int startPosn){
        for (int i = startPosn+1; i<marbles.length; i++)
            if (marbles[i] == 0) return i;
        return (marbles.length);
    }
    
   public int posnLMBM(){
       int i;
       for (i = 0; i< marbles.length; i++)
           if (marbles [i] == 1)
               break;
       return i;
   }
           
}

/*
Marbles = [0, 1, 0, 0, 0, 1, 1, 0, 0, 1]
posnLMBM = 1, posnNextLMWM = 2
numMarblesLookedAt: 2 (for LMBM), 1 (for nextLMWM)
Marbles = [0, 0, 1, 0, 0, 1, 1, 0, 0, 1]
posnLMBM = 2, posnNextLMWM = 3
numMarblesLookedAt: 3 (for LMBM), 1 (for nextLMWM)
Marbles = [0, 0, 0, 1, 0, 1, 1, 0, 0, 1]
posnLMBM = 3, posnNextLMWM = 4
numMarblesLookedAt: 4 (for LMBM), 1 (for nextLMWM)
Marbles = [0, 0, 0, 0, 1, 1, 1, 0, 0, 1]
posnLMBM = 4, posnNextLMWM = 7
numMarblesLookedAt: 5 (for LMBM), 3 (for nextLMWM)
Marbles = [0, 0, 0, 0, 0, 1, 1, 1, 0, 1]
posnLMBM = 5, posnNextLMWM = 8
numMarblesLookedAt: 6 (for LMBM), 3 (for nextLMWM)
Marbles = [0, 0, 0, 0, 0, 0, 1, 1, 1, 1]
posnLMBM = 6, posnNextLMWM = 10
numMarblesLookedAt: 7 (for LMBM), 3 (for nextLMWM)
*** no white marble found to the right of leftmost black marble
*/

/*
Marbles = [0, 0, 0, 0]
posnLMBM = 4, posnNextLMWM = 4
numMarblesLookedAt: 4 (for LMBM), 0 (for nextLMWM)
*** no white marble found to the right of leftmost black marble
 */

