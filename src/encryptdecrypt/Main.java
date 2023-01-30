package encryptdecrypt;


import java.io.*;
import java.util.Scanner;

public class Main {
    /**
     * encrypting by shifting using a key
     *
     * @param inputText
     * @return
     */
    public static String EncrypterByShifting(String inputText, int key) {
        char[] listOfChars = new char[inputText.length()];
        for (int i = 0; i < inputText.length(); i++) {
            int step = inputText.charAt(i) + key;
            listOfChars[i] = (char) step;
        }
        return String.valueOf(listOfChars);
    }

    public static String DecrypterByShifting(String inputText, int key) {
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
        //args = new String[]{"-mode", "enc", "-in", "road_to_treasure.txt", "-out", "protected.txt", "-key", "5"};
        try {
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-mode")) {
                    mode = args[i + 1];
                } else if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                } else if (args[i].equals("-data")) {
                    data = args[i + 1];
                } else if (args[i].equals("-in")) {//"C:\\Users\\alahmm\\Downloads\\input.txt"
                    try (Scanner scanner = new Scanner(new File(args[i + 1]))) {
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
                    System.out.println(EncrypterByShifting(data, key));
                } else if (mode.equals("dec")) {
                    System.out.println(DecrypterByShifting(data, key));
                }
            }
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-out")) {
                    try (PrintWriter printWriter = new PrintWriter(args[i + 1])) {
                        if (mode.equals("enc")) {
                            printWriter.println(EncrypterByShifting(data, key));
                        } else if (mode.equals("dec")) {
                            printWriter.println(DecrypterByShifting(data, key));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }


    }
}
