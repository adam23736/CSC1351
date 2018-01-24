/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abba;

/**
 *
 * @author Mikhail
 */
public class ABBA implements ABTesting {
    int votesA; int votesB;
    static int numTest = 0;
    
    public ABBA() {
       votesA = 0;
       votesB = 0;
       numTest++;
    }

    private ABBA(int a, int b) {
        votesA = a;
        votesB = b;
        }

    @Override
    public void voteForA() {
        votesA++;
    }

    @Override
    public void voteForB() {
        votesB++;
    }

    @Override
    public int totalTests() {
        return numTest;    
    }

    @Override
    public int totalVotesInThisTest() {
        return votesA + votesB;
    }

    @Override
    public int votesForAinThisTest() {
        return votesA;
    }

    @Override
    public int votesForBinThisTest() {
        return votesB;
    }

}
