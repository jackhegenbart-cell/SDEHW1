import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* sonnet in a string I used chat to get it in this format so i could copy and paste*/
        String[] sonnet1 = {
                "Two", "households,", "both", "alike", "in", "dignity,",
                "In", "fair", "Verona,", "where", "we", "lay", "our", "scene,",
                "From", "ancient", "grudge", "break", "to", "new", "mutiny,",
                "Where", "civil", "blood", "makes", "civil", "hands", "unclean.",
                "From", "forth", "the", "fatal", "loins", "of", "these", "two", "foes",
                "A", "pair", "of", "star-cross’d", "lovers", "take", "their", "life;",
                "Whose", "misadventured", "piteous", "overthrows",
                "Do", "with", "their", "death", "bury", "their", "parents’", "strife.",
                "The", "fearful", "passage", "of", "their", "death-mark’d", "love,",
                "And", "the", "continuance", "of", "their", "parents’", "rage,",
                "Which,", "but", "their", "children’s", "end,", "nought", "could", "remove,",
                "Is", "now", "the", "two", "hours’", "traffic", "of", "our", "stage;",
                "The", "which", "if", "you", "with", "patient", "ears", "attend,",
                "What", "here", "shall", "miss,", "our", "toil", "shall", "strive", "to", "mend."
        };

        Scanner input = new Scanner(System.in);
        sonnet_printer printer = new sonnet_printer(sonnet1); // 6 blanks chosen here

        while (!printer.isDone() && printer.printUntilNextBlank()) {
            String guess = input.nextLine();
            printer.submitGuess(guess);
        }

        if (printer.isWon()) {
            System.out.println("\nNice job");
        } else {
            System.out.println("\nYou got 3 wrong dumbass");
        }

        input.close();
    }
}