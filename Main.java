//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

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

    sonnet_printer printer = new sonnet_printer();

    if (printer.printList(sonnet1)) {
        System.out.println("Nice job");

    } else {
        System.out.println("You got 3 wrong dumbass");
    }


    }
}
