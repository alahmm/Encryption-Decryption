package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        int key = scanner.nextInt();
        inputText = inputText.toLowerCase();
        System.out.println(Cipher.ShiferEncrypter(inputText, key));
    }
}
class Cipher {

    /**
     * Encryption by reflection of alphabets: a to z and z to a...
     * @param inputText
     * @return
     */
    public static String Encrypter(String inputText) {
        char[] listOfChars = new char[inputText.length()];
        String regex = "[a-z]";
        String str = "";
        for (int i = 0; i < inputText.length(); i++) {
            str += inputText.charAt(i);
            if (str.matches(regex)) {
                int step = inputText.charAt(i) - 97;
                int var = 122 - step;
                listOfChars[i] = (char) var;
                str = "";
            } else {
                listOfChars[i] = inputText.charAt(i);
                str = "";
            }
        }

        return String.valueOf(listOfChars);
    }

    /**
     * encrypting by shifting using a key
     * @param inputText
     * @return
     */
    public static String ShiferEncrypter(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        String regex = "[a-z]";
        String str = "";
        for (int i = 0; i < inputText.length(); i ++) {
            str += inputText.charAt(i);
            if (str.matches(regex)) {
                if (inputText.charAt(i) + key <= 122) {
                    int step = inputText.charAt(i) + key;
                    listOfChars[i] = (char) step;
                } else {
                    int step1 = inputText.charAt(i) + key - 122;
                    int step2 = 97 + step1 - 1;
                    listOfChars[i] = (char) step2;
                }
                str = "";
            } else {
                listOfChars[i] = inputText.charAt(i);
                str = "";
            }
        }

        return String.valueOf(listOfChars);
    }
}