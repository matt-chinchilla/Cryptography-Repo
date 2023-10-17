import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Get Number of Iterations
        System.out.print("Enter the number of times to run the encryption: ");
        int numRuns = input.nextInt();
        input.nextLine();
        
        //Get Plaintext
        System.out.println("Enter the plaintext: ");
        String plainText = input.nextLine();
        
        // Ensure the plaintext length is even by padding, if necessary
        if (plainText.length() % 2 != 0) {
            plainText += " ";
        }
        String cipherResult = plainText;
        
        // Encryption phase
        for (int i = 0; i < numRuns; i++) {
            String cipherText = StringToBinary.matthewCipherTwo(cipherResult);
            String[] blocks = BinaryToBlock.splitIntoBlocks(cipherText);
            cipherResult = blockXOR.blockCipher(blocks[0], blocks[1], i == numRuns - 1);
            
            System.out.println("\nBlock Cipher Result " + (i+1) + ": " + cipherResult);  // Print the result of the round
            
            // Only convert back to ASCII if it's not the last iteration
            if (i < numRuns - 1) {
                cipherResult = BinaryToAscii.binaryToAscii(cipherResult);
            }
        }
        
        System.out.println("\nFinal Encrypted Text: " + cipherResult);
        
        String decryptedResult = cipherResult;
        
        // Decryption phase
        for (int i = 0; i < numRuns; i++) {
            decryptedResult = toOriginal.decrypt(decryptedResult, i == numRuns - 1);
        }
        
        System.out.println("\nFinal Decrypted Text: " + decryptedResult);
        
        input.close();
    }
}
