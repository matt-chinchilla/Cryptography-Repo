public class BinaryToBlock {
    
    public static String[] splitIntoBlocks(String cipherText) {
        String noSpaces = cipherText.replaceAll(" ", "");
    
        // Find the middle index of ciphertext for division
        int mid = noSpaces.length() / 2;
    
        // Define Blocks
        String block1 = noSpaces.substring(0, mid);
        String block2 = noSpaces.substring(mid);
    
        return new String[] {block1, block2};
    }    
}
