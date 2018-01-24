/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abba;

/**
 * This interface is part of a tool
 * to do A/B testing for the marketing
 * department of your company.
 *
 * Note: This class should have two
 * constructors. The first constructor
 * should be public. The second should
 * be private.
 *
 * Constructor 1: A default constructor,
 * which initializes the number of votes
 * for A and B to zero. This should count
 * as a new test (and should affect the
 * output of totalTests() below).
 *
 * Constructor 2: This constructor takes
 * two arguments. The first is the number
 * of votes for A, the second is the number
 * of votes for B. It is called by the
 * system when it's reading an old ABTesting
 * session from disk, and so this constructor
 * should <em>not</em> increase the count
 * reported by totalTests().
 */
public interface ABTesting {
  /**
   * Call this method when one of the
   * people in market testing votes for
   * product A.
   */
  void voteForA();
  /**
   * Call this method when one of the
   * people in market testing votes for
   * product B.
   */
  void voteForB();
  /**
   * The total number of ABTesting
   * objects created.
   */
  int totalTests();
  /**
   * The total number of votes
   * provided for this ABTesting
   * object.
   */
  int totalVotesInThisTest();
  /**
   * The total number of votes for
   * A in this test.
   */
  int votesForAinThisTest();
  /**
   * The total number of votes for
   * A in this test.
   */
  int votesForBinThisTest();
}