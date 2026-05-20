public class SonnetPrinterTest {

    private static final String[] sonnet1 = {
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

    public static void main(String[] args) {
        testAllCorrect();
        testAllWrong();
        testCaseInsensitive();
        testCommaStripping();
    }

    // Give the right word every time -> should win.
    private static void testAllCorrect() {
        sonnet_printer printer = new sonnet_printer(sonnet1);
        while (!printer.isDone() && printer.printUntilNextBlank()) {
            printer.submitGuess(expectedWord(printer));
        }
        report("testAllCorrect", printer.isWon());
    }

    // Give garbage every time -> should lose.
    private static void testAllWrong() {
        sonnet_printer printer = new sonnet_printer(sonnet1);
        while (!printer.isDone() && printer.printUntilNextBlank()) {
            printer.submitGuess("zzzz");
        }
        report("testAllWrong", !printer.isWon());
    }

    // Submit in ALL CAPS -> should still win.
    private static void testCaseInsensitive() {
        sonnet_printer printer = new sonnet_printer(sonnet1);
        while (!printer.isDone() && printer.printUntilNextBlank()) {
            printer.submitGuess(expectedWord(printer).toUpperCase());
        }
        report("testCaseInsensitive", printer.isWon());
    }

    // Submit without the trailing comma (e.g. "dignity" for "dignity,") -> should still win.
    private static void testCommaStripping() {
        sonnet_printer printer = new sonnet_printer(sonnet1);
        while (!printer.isDone() && printer.printUntilNextBlank()) {
            String raw = rawWord(printer);
            String stripped = raw.endsWith(",") ? raw.substring(0, raw.length() - 1) : raw;
            printer.submitGuess(stripped);
        }
        report("testCommaStripping", printer.isWon());
    }

    // --- helpers ------------------------------------------------------------

    private static void report(String name, boolean passed) {
        System.out.println((passed ? "PASS  " : "FAIL  ") + name);
    }

    // Peek at the printer's current word so we can hand back the right answer.
    private static String rawWord(sonnet_printer printer) {
        try {
            java.lang.reflect.Field pos = sonnet_printer.class.getDeclaredField("currentPosition");
            pos.setAccessible(true);
            java.lang.reflect.Field w = sonnet_printer.class.getDeclaredField("words");
            w.setAccessible(true);
            String[] words = (String[]) w.get(printer);
            return words[pos.getInt(printer)];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String expectedWord(sonnet_printer printer) {
        String raw = rawWord(printer);
        return raw.endsWith(",") ? raw.substring(0, raw.length() - 1) : raw;
    }
}