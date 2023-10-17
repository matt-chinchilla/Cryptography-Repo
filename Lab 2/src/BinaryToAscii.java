public class BinaryToAscii {
    public static String binaryToAscii(String binaryData) {

        StringBuilder result = new StringBuilder();
        
        //  Convert Binary into ASCII
        for (int i = 0; i < binaryData.length(); i += 8) {  //  Increment by Bytes

            String byteGroup = binaryData.substring(i, i + 8);  //  Get the next 8 bits
            int asciiVal = Integer.parseInt(byteGroup, 2);
            result.append((char) asciiVal);
        }
        return result.toString();
    }
}
