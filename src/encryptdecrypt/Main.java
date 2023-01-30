package encryptdecrypt;


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

    public static void main(String[] args) {
        String mode = "enc";
        String data = "";
        int key = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            }
        }
            if (mode.equals("enc")) {
                System.out.println(EncrypterByShifting(data, key));
            } else if (mode.equals("dec")) {
                System.out.println(DecrypterByShifting(data, key));
            }

        }
}
