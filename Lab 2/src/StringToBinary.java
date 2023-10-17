public class StringToBinary {
    
    public static String matthewCipherTwo (String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            String binaryString = Integer.toBinaryString(c);    // Convert each char's ASCII value to its binary representation

        while (binaryString.length() < 8) {  // Pad the binary string with 0s until it's 8 bits long for even block-length
            binaryString = "0" + binaryString;
        }

        result.append(binaryString);    // Add the binary string (each letter) to the result

        if (i < input.length() - 1) {
            result.append(' ');     // Add a space between ASCII Values
        }
      }
        return result.toString();
    }
}
