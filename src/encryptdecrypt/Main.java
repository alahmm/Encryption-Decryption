package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        inputText = inputText.toLowerCase();
        System.out.println(Cipher.Converter(inputText));
    }
}
class Cipher {
    public static String Converter(String inputText) {
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
}