public class toOriginal {

    public static String decrypt(String blockCipherText, boolean convertToAscii) {

        // Divide the ciphertext into two blocks
        int mid = blockCipherText.length() / 2;
        String rightBlock2 = blockCipherText.substring(0, mid);
        String leftBlock2 = blockCipherText.substring(mid);


        // XOR leftBlock with rightBlock (or some other transformation f()), begin in revese order of encryption
        StringBuilder rightBlock = new StringBuilder();

        for (int i = 0; i < rightBlock2.length(); i++) {
            char c2a = rightBlock2.charAt(i);
            char c1 = leftBlock2.charAt(i);
            rightBlock.append(c2a == c1 ? '0' : '1');
        }

        // XOR leftBlock with rightBlock
        StringBuilder leftBlock = new StringBuilder();

        for (int i = 0; i < leftBlock2.length(); i++) {
            char c1a = leftBlock2.charAt(i);
            char c2a = rightBlock.charAt(i);
            leftBlock.append(c1a == c2a ? '0' : '1');
        }

        // Combine the blocks
        String combinedBlocks = leftBlock.toString() + rightBlock.toString();

        if (convertToAscii) {   // Convert Binary into ASCII for the final iteration when necessary
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < combinedBlocks.length(); i += 8) {
                String byteGroup = combinedBlocks.substring(i, i + 8);
                int asciiVal = Integer.parseInt(byteGroup, 2);
                result.append((char) asciiVal);
            }
            return result.toString();
        } 
        else {
            return combinedBlocks;
        }
    }
}
