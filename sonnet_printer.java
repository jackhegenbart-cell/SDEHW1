

import java.util.Scanner;
public class sonnet_printer {
    public static boolean printList(String[] words) {
        Scanner input = new Scanner(System.in);

        int Number_corect = 0, Number_incorrect = 0;
        int max = (words.length);
        int[] numbers = new int[6];
        int z = 0;
        while (z < 6) {
            int randomNum = (int) (Math.random() * words.length);
            boolean alreadyUsed = false;
            for (int i = 0; i < z; i++) {
                if (numbers[i] == randomNum) {
                    alreadyUsed = true;
                    break;
                }
            }
            if (!alreadyUsed) {
                numbers[z] = randomNum;
                z++;
            }
        }
        while (Number_corect < 3 && Number_incorrect < 3) {
            for (int i = 0; i < max; i++) {
                int wordNumber = i + 1;
                boolean in_list = false;
                for (int number : numbers) {
                    if (i == number) {

                        in_list = true;
                    }
                }


                if (in_list == true) {

                    if (words[i].endsWith(",")) {
                        String cleanWord=words[i].substring(0, words[i].length() - 1);;
                        System.out.print("_".repeat(cleanWord.length()) + " ");

                        String guess = input.nextLine().toLowerCase();

                        if (guess.equals(cleanWord.toLowerCase())) {
                            Number_corect++;
                        } else {
                            Number_incorrect++;
                        }

                        if (Number_corect == 3 || Number_incorrect == 3) {
                            break;
                        }
                    }

                    else {
                        System.out.print("_".repeat(words[i].length()) + " ");
                        String guess = input.nextLine().toLowerCase();
                        if (guess.equals(words[i].toLowerCase())) {
                            Number_corect++;
                        } else {
                            Number_incorrect++;
                        }
                        if (Number_corect == 3 || Number_incorrect == 3) {
                            break;
                        }

                    }
                } else {
                    System.out.print(words[i] + " ");
                }
                if (
                        wordNumber == 6 || wordNumber == 14 || wordNumber == 21 || wordNumber == 28 ||
                                wordNumber == 37 || wordNumber == 45 || wordNumber == 49 || wordNumber == 57 ||
                                wordNumber == 64 || wordNumber == 71 || wordNumber == 79 || wordNumber == 88 ||
                                wordNumber == 96 || wordNumber == 106
                ) {
                    System.out.println();
                }
            }
        }
        input.close();
        if (Number_corect == 3) {
            return true;
        } else {
            return false;
        }
    }
}


