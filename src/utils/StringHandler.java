package utils;

/**
 * This class contains some additional methods for comfortable work with values of String type
 */
public class StringHandler {

    /**
     * Compare two strings
     * @param stringA String A
     * @param stringB String B
     * @return -1 - If strings are equal; 1 - If String A is less than String B; 0 - If String A is bigger than String B
     */
    public static int compareStrings(String stringA, String stringB) {
        for (int i = 0; i < Math.min(stringA.length(), stringB.length()); i++) {
            char letterA = stringA.charAt(i);
            char letterB = stringB.charAt(i);
            if (letterA != letterB) return compareLetters(letterA, letterB);
        }
        if (stringA.length() != stringB.length())
            return stringA.length() < stringB.length() ? 1 : 0;
        return -1;
    }

    /**
     * Compare two characters
     * @param letterA Letter A
     * @param letterB Letter B
     * @return 1 - If Letter A is less than Letter B; 0 - If Letter A is bigger than Letter B
     */
    public static int compareLetters(char letterA, char letterB) {
        return Alphabet.getLetterPriority(letterA) < Alphabet.getLetterPriority(letterB) ? 1 : 0;
    }
}
