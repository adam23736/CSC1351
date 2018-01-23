public interface IntSequence {
    /**
     * This method will generate the remainder of the
     * sequence, putting commas bewteen each item and
     * square brackets on the start and end. Thus,
     * generate(1,3).toString() will produce "[1,2,3]".
     */
    String toString();

    /**
     * Returns the next int in the sequence. If the
     * sequence was, initially, [1,2,3,4] then 1 is
     * returned and the sequence becomes [2,3,4].
     */
    int nextInt();

    /**
     * Returns true if the sequence has more items.
     * Writing a loop of the form
     *
     * IntSequence is = ...
     * while(is.hasNextInt()) {
     *   System.out.println(is.nextInt();
     * }
     * 
     * Should print out the entire sequence.
     */
    boolean hasNextInt();

    /**
     * Generate an IntSequence object with integers in the
     * specified range. Thus, generateRandom(3,1,4) might
     * generate the sequence [1,4,2].
     */
    IntSequence generateRandom(int len,int minval,int maxval);

    /**
     * Generate an IntSequence obect with integers in the
     * specified start and end range. Thus, generate(2,9)
     * will generate the sequence [2,3,4,5,6,7,8,9] and
     * and generate(4,1) will generate the sequence [4,3,2,1].
     */
    IntSequence generate(int start,int end);

    /**
     * Generate an IntSequence from an array. Note that
     * the array must be copied to protect the sequence
     * object from being affected by changes to the input
     * array.
     */
    IntSequence generate(int[] data);

    /**
     * Generates a new IntSequence that is the reverse of
     * the existing one. If called on a sequence [1,2,3,4]
     * it returns [4,3,2,1].
     */
    IntSequence generateReverse();
}