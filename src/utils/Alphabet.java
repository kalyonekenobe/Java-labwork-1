package utils;

/**
 * This class is created to redefine the order of letters
 * Latin letters are easy to compare, because their key codes have the same order as in the alphabet
 * But some of cyrillic letters have key code order different from order in the alphabet
 */
public class Alphabet {

    /**
     * The array of letters priorities
     */
    private static final int[] letters = new int[70000];

    /**
     * Initialize own alphabet
     */
    public static void initialize(){
        int priority = 0;
        for (char ch = '0'; ch <= '9'; ch++) {
            letters[ch] = priority++;
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            letters[ch] = priority++;
            letters[Character.toLowerCase(ch)] = priority++;
        }
        for (char ch = 'А'; ch <= 'Г'; ch++) {
            letters[ch] = priority++;
            letters[Character.toLowerCase(ch)] = priority++;
        }
        letters['Ґ'] = priority++;
        letters['ґ'] = priority++;
        letters['Д'] = priority++;
        letters['д'] = priority++;
        letters['Е'] = priority++;
        letters['е'] = priority++;
        letters['Є'] = priority++;
        letters['є'] = priority++;
        for (char ch = 'Ж'; ch <= 'И'; ch++) {
            letters[ch] = priority++;
            letters[Character.toLowerCase(ch)] = priority++;
        }
        letters['І'] = priority++;
        letters['Ї'] = priority++;
        letters['і'] = priority++;
        letters['ї'] = priority++;
        for (char ch = 'Й'; ch <= 'Я'; ch++) {
            letters[ch] = priority++;
            letters[Character.toLowerCase(ch)] = priority++;
        }
        letters['.'] = priority++;
        letters[','] = priority++;
        letters[':'] = priority++;
        letters['-'] = priority++;
        letters[';'] = priority++;
        letters['!'] = priority++;
        letters['?'] = priority;
    }

    /**
     * Get letter priority
     * @param letter Letter
     * @return Letter priority value of Integer type
     */
    public static int getLetterPriority(char letter){
        return letters[letter];
    }
}
