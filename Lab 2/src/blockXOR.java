public class blockXOR {
    public static String blockCipher(String leftBlock, String rightBlock, boolean isFinalRound) {

        // Catch to Ensure that the blocks are equal length
        if (leftBlock.length() != rightBlock.length()) {
            System.out.println("Error: Blocks are not equal length.");
            return null;
        }

        String temp = rightBlock;

        //  XOR leftBlock with rightBlock (or some other transformation f())
        StringBuilder transformedRight = new StringBuilder();

        for (int i = 0; i < leftBlock.length(); i++) {  // This will XOR the left block with the right block

            char c1 = leftBlock.charAt(i);
            char c2 = rightBlock.charAt(i);
            transformedRight.append(c1 == c2 ? '0' : '1');
        }

        if (isFinalRound) {
            return transformedRight.toString() + temp;  // This combines the modified right block with the original right block for the final round
        } 
        
        else {
            return temp + transformedRight.toString();  // This will make the modified right block the new left block for the next round
        }
    }
}
