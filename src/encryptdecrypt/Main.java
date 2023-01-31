package encryptdecrypt;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static String ShiftEncrypter(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        String regex = "[a-z]";
        String str = "";
        for (int i = 0; i < inputText.length(); i++) {
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

    /**
    /**
     * encrypting by shifting using a key
     *
     * @param inputText
     * @return
     */
    public static String UnicodeEncrypter(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        for (int i = 0; i < inputText.length(); i++) {
            int step = inputText.charAt(i) + key;
            listOfChars[i] = (char) step;
        }
        return String.valueOf(listOfChars);
    }

    public static String UnicodeDecrypter(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        for (int i = 0; i < inputText.length(); i++) {
            int step = inputText.charAt(i) - key;
            listOfChars[i] = (char) step;
        }
        return String.valueOf(listOfChars);
    }

    public static void main(String[] args) throws IOException {
        String mode = "enc";
        String data = "";
        int key = 0;
        String alg = "shift";
        //args = new String[]{"-mode", "enc", "-in", "road_to_treasure.txt", "-out", "protected.txt", "-key", "5"};
        try {
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-mode")) {
                    mode = args[i + 1];
                } else if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                } else if (args[i].equals("-data")) {
                    data = args[i + 1];
                } else if (args[i].equals("-alg")) {
                    alg = args[i + 1];
                } else if (args[i].equals("-in")) {//"C:\\Users\\alahmm\\Downloads\\input.txt"
                    try (Scanner scanner = new Scanner(new File("C:\\Users\\alahmm\\Downloads\\input.txt"))) {
                        while (scanner.hasNext()) {
                            if (data.equals("")) {
                                data = scanner.nextLine();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error: File not found");
                    }
                }
            }
            String str = "";
            for (String variable : args
            ) {
                str += variable;
            }
            if (!str.contains("-out")) {
                if (mode.equals("enc")) {
                    if (alg.equals("shift")) {
                        System.out.println(ShiftEncrypter(data, key));
                    } else if (alg.equals("unicode")){
                        System.out.println(UnicodeEncrypter(data, key));
                    }
                } else if (mode.equals("dec")) {
                    if (alg.equals("shift")) {
                        System.out.println(ShiftEncrypter(data, key));
                    } else if (alg.equals("unicode")){
                        System.out.println(UnicodeDecrypter(data, key));
                    }
                }
            }
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-out")) {
                    try (PrintWriter printWriter = new PrintWriter(args[i + 1])) {
                        if (mode.equals("enc")) {
                            if (alg.equals("shift")) {
                                System.out.println(ShiftEncrypter(data, key));
                            } else if (alg.equals("unicode")){
                                System.out.println(UnicodeEncrypter(data, key));
                            }
                        } else if (mode.equals("dec")) {
                            if (alg.equals("shift")) {
                                System.out.println(ShiftEncrypter(data, key));
                            } else if (alg.equals("unicode")){
                                System.out.println(UnicodeDecrypter(data, key));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }


    }
}
