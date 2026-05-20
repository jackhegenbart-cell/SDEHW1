public class sonnet_printer {
    private String[] words;
    private int[] blankIndices;
    private int currentPosition = 0;
    private int numberCorrect = 0;
    private int numberIncorrect = 0;

    public sonnet_printer(String[] words) {
        this.words = words;
        this.blankIndices = pickRandomIndices(words.length, 6);
    }

    private int[] pickRandomIndices(int max, int count) {
        int[] result = new int[count];
        int z = 0;
        while (z < count) {
            int randomNum = (int) (Math.random() * max);
            boolean alreadyUsed = false;
            for (int i = 0; i < z; i++) {
                if (result[i] == randomNum) {
                    alreadyUsed = true;
                    break;
                }
            }
            if (!alreadyUsed) {
                result[z] = randomNum;
                z++;
            }
        }
        return result;
    }

    // Prints from currentPosition until it hits a blank.
    // Returns true if a blank is waiting for a guess; false if we ran out of words.
    public boolean printUntilNextBlank() {
        while (currentPosition < words.length) {
            int wordNumber = currentPosition + 1;

            if (isBlank(currentPosition)) {
                String cleanWord = stripComma(words[currentPosition]);
                System.out.print("_".repeat(cleanWord.length()) + " ");
                return true; // pause here, waiting on main for a guess
            }

            System.out.print(words[currentPosition] + " ");
            if (isLineBreak(wordNumber)) {
                System.out.println();
            }
            currentPosition++;
        }
        return false;
    }

    // Processes one guess for the current blank and advances.
    public void submitGuess(String guess) {
        String cleanWord = stripComma(words[currentPosition]);
        if (guess.toLowerCase().equals(cleanWord.toLowerCase())) {
            numberCorrect++;
        } else {
            numberIncorrect++;
        }
        int wordNumber = currentPosition + 1;
        if (isLineBreak(wordNumber)) {
            System.out.println();
        }
        currentPosition++;
    }

    public boolean isDone() {
        return numberCorrect >= 3 || numberIncorrect >= 3 || currentPosition >= words.length;
    }

    public boolean isWon() {
        return numberCorrect >= 3;
    }

    private boolean isBlank(int index) {
        for (int b : blankIndices) {
            if (b == index) return true;
        }
        return false;
    }

    private String stripComma(String word) {
        if (word.endsWith(",")) {
            return word.substring(0, word.length() - 1);
        }
        return word;
    }

    private boolean isLineBreak(int wordNumber) {
        return wordNumber == 6  || wordNumber == 14 || wordNumber == 21 || wordNumber == 28 ||
                wordNumber == 37 || wordNumber == 45 || wordNumber == 49 || wordNumber == 57 ||
                wordNumber == 64 || wordNumber == 71 || wordNumber == 79 || wordNumber == 88 ||
                wordNumber == 96 || wordNumber == 106;
    }
}