package utils;

/**
 * This class is responsible for processing the user's input data and also for interacting with the user.
 */
public class Helper {

    /**
     * Default error message, when the input data is incorrect, or it is out of the set range
     */
    public static final String DEFAULT_ERROR_MESSAGE = "Введене невірне значення! Повторіть спробу.";

    /**
     * Reads user input data of Integer type
     * @param message Message shown in the console
     * @param errorMessage Message shown in the console in case of incorrect input data
     * @param minValue Minimal acceptable value
     * @param maxValue Maximal acceptable value
     * @return Value of Integer type
     */
    public static int askInteger(String message, String errorMessage, int minValue, int maxValue) {
        System.out.println();
        int choice;
        do {
            choice = DataInput.getInt(message);
            if (choice < minValue || choice > maxValue)
                System.out.println(errorMessage);
        } while (choice < minValue || choice > maxValue);
        return choice;
    }

    /**
     * Reads user input data of Long type
     * @param message Message shown in the console
     * @param errorMessage Message shown in the console in case of incorrect input data
     * @param minValue Minimal acceptable value
     * @param maxValue Maximal acceptable value
     * @return Value of Long type
     */
    public static long askLong(String message, String errorMessage, long minValue, long maxValue) {
        System.out.println();
        long choice;
        do {
            choice = DataInput.getLong(message);
            if (choice < minValue || choice > maxValue)
                System.out.println(errorMessage);
        } while (choice < minValue || choice > maxValue);
        return choice;
    }

    /**
     * Reads user input data of Boolean type
     * @param message Message shown in the console
     * @param errorMessage Message shown in the console in case of incorrect input data
     * @param trueValue Defined true value
     * @param falseValue Defined false value
     * @return Value of Boolean type
     */
    public static boolean askBoolean(String message, String errorMessage, int trueValue, int falseValue) {
        System.out.println();
        int choice;
        do {
            choice = DataInput.getInt(message);
            if (choice != falseValue && choice != trueValue)
                System.out.println(errorMessage);
        } while (choice != falseValue && choice != trueValue);
        return choice == trueValue;
    }

    /**
     * Reads user input data of Float type
     * @param message Message shown in the console
     * @param errorMessage Message shown in the console in case of incorrect input data
     * @param minValue Minimal acceptable value
     * @param maxValue Maximal acceptable value
     * @return Value of Float type
     */
    public static float askFloat(String message, String errorMessage, float minValue, float maxValue) {
        System.out.println();
        float choice;
        do {
            choice = DataInput.getFloat(message);
            if (choice < minValue || choice > maxValue)
                System.out.println(errorMessage);
        } while (choice < minValue || choice > maxValue);
        return choice;
    }

    /**
     * Reads user input data of Double type
     * @param message Message shown in the console
     * @param errorMessage Message shown in the console in case of incorrect input data
     * @param minValue Minimal acceptable value
     * @param maxValue Maximal acceptable value
     * @return Value of Double type
     */
    public static double askDouble(String message, String errorMessage, double minValue, double maxValue) {
        System.out.println();
        double choice;
        do {
            choice = DataInput.getDouble(message);
            if (choice < minValue || choice > maxValue)
                System.out.println(errorMessage);
        } while (choice < minValue || choice > maxValue);
        return choice;
    }

    /**
     * Reads user input data of String type
     * @param message Message shown in the console
     * @return Value of String type
     */
    public static String askString(String message) {
        System.out.println();
        return DataInput.getString(message);
    }
}
