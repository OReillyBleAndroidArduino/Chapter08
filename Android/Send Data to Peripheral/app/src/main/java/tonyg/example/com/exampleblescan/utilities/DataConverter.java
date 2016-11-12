package tonyg.example.com.exampleblescan.utilities;


import java.nio.ByteBuffer;

/**
 * Convert data formats
 *
 * @author Tony Gaitatzis backupbrain@gmail.com
 * @date 2015-12-21
 */

public class DataConverter {

    /**
     * Convert bytes to a hexadecimal String
     *
     * @param bytes a byte array
     * @return hexadecimal string
     */
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 3];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 3] = hexArray[v >>> 4];
            hexChars[j * 3 + 1] = hexArray[v & 0x0F];
            hexChars[j * 3 + 2] = 0x20; // space
        }
        return new String(hexChars);
    }


    /**
     * convert bytes to an integer in Little Endian for debugging purposes
     *
     * @param bytes a byte array
     * @return integer integer representation of byte array
     */
    final protected static char[] decArray = "0123456789".toCharArray();
    public static int bytesToInt(byte[] bytes) {
        if (bytes.length <= 1) {
            return bytes[0];
        }
        return ByteBuffer.wrap(bytes).getInt();
    }
}
