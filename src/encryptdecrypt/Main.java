package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String function = scanner.nextLine();
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        if (function.equals("enc")) {
            System.out.println(Cipher.EncrypterByShifting(message, key));
        } else if (function.equals("dec")) {
            System.out.println(Cipher.DecrypterByShifting(message, key));
        }

    }
}
class Cipher {
    
    /**
     * encrypting by shifting using a key
     * @param inputText
     * @return
     */
    public static String EncrypterByShifting(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        for (int i = 0; i < inputText.length(); i ++) {
                    int step = inputText.charAt(i) + key;
                    listOfChars[i] = (char) step;
                }
        return String.valueOf(listOfChars);
    }
    public static String DecrypterByShifting(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        for (int i = 0; i < inputText.length(); i ++) {
            int step = inputText.charAt(i) - key;
            listOfChars[i] = (char) step;
        }
        return String.valueOf(listOfChars);
    }
}