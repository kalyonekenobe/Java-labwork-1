package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is for reading and checking input data from the console
 */
public final class DataInput {

    /**
     * Get the value of Long type
     * @param message Information for user
     * @return The value of Long type
     */
    public static Long getLong(String message) {
        String s = getString(message);
        Long longValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            longValue = getLong(message);
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                longValue = getLong(message);
            } else {
                boolean matches = true;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    longValue = getLong(message);
                } else
                    longValue = Long.valueOf(value);
            }
        }
        return longValue;
    }

    /**
     * Get the value of Long type
     * @return The value of Long type
     */
    public static Long getLong() {
        String s = getString();
        Long longValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            longValue = getLong();
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                longValue = getLong();
            } else {
                boolean matches = true;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    longValue = getLong();
                } else
                    longValue = Long.valueOf(value);
            }
        }
        return longValue;
    }

    /**
     * Get the value of Character type
     * @param message Information for user
     * @return The value of Character type
     */
    public static char getChar(String message) {
        String s = getString(message);
        char ch;
        if (s == null || s.length() != 1) {
            System.out.println("Невірний формат введення!");
            ch = getChar(message);
        } else
            ch = s.charAt(0);
        return ch;
    }

    /**
     * Get the value of Character type
     * @return The value of Character type
     */
    public static char getChar() {
        String s = getString();
        char ch;
        if (s == null || s.length() != 1) {
            System.out.println("Невірний формат введення!");
            ch = getChar();
        } else
            ch = s.charAt(0);
        return ch;
    }

    /**
     * Get the value of Integer type
     * @param message Information for user
     * @return The value of Integer type
     */
    public static Integer getInt(String message) {
        String s = getString(message);
        Integer integerValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            integerValue = getInt(message);
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                integerValue = getInt(message);
            } else {
                boolean matches = true;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    integerValue = getInt(message);
                } else
                    integerValue = Integer.valueOf(value);
            }
        }
        return integerValue;
    }

    /**
     * Get the value of Integer type
     * @return The value of Integer type
     */
    public static Integer getInt() {
        String s = getString();
        Integer integerValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            integerValue = getInt();
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                integerValue = getInt();
            } else {
                boolean matches = true;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    integerValue = getInt();
                } else
                    integerValue = Integer.valueOf(value);
            }
        }
        return integerValue;
    }

    /**
     * Get the value of Float type
     * @param message Information for user
     * @return The value of Float type
     */
    public static Float getFloat(String message) {
        String s = getString(message);
        Float floatValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            floatValue = getFloat(message);
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                floatValue = getFloat(message);
            } else {
                boolean matches = true;
                int dots = 0;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '.') {
                        dots++;
                        if (i == 0 || i == value.length() - 1 || dots > 1) matches = false;
                        if (i == 1) {
                            if (value.charAt(i - 1) == '-') matches = false;
                        }
                    }
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-' && value.charAt(i) != '.') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    floatValue = getFloat(message);
                } else
                    floatValue = Float.valueOf(value);
            }
        }
        return floatValue;
    }

    /**
     * Get the value of Float type
     * @return The value of Float type
     */
    public static Float getFloat() {
        String s = getString();
        Float floatValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            floatValue = getFloat();
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                floatValue = getFloat();
            } else {
                boolean matches = true;
                int dots = 0;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '.') {
                        dots++;
                        if (i == 0 || i == value.length() - 1 || dots > 1) matches = false;
                        if (i == 1){
                            if (value.charAt(i - 1) == '-') matches = false;
                        }
                    }
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-' && value.charAt(i) != '.') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    floatValue = getFloat();
                } else
                    floatValue = Float.valueOf(value);
            }
        }
        return floatValue;
    }

    /**
     * Get the value of Double type
     * @param message Information for user
     * @return The value of Double type
     */
    public static Double getDouble(String message) {
        String s = getString(message);
        Double doubleValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            doubleValue = getDouble(message);
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                doubleValue = getDouble(message);
            } else {
                boolean matches = true;
                int dots = 0;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '.') {
                        dots++;
                        if (i == 0 || i == value.length() - 1 || dots > 1) matches = false;
                        if (i == 1){
                            if (value.charAt(i - 1) == '-') matches = false;
                        }
                    }
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-' && value.charAt(i) != '.') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    doubleValue = getDouble(message);
                } else
                    doubleValue = Double.valueOf(value);
            }
        }
        return doubleValue;
    }

    /**
     * Get the value of Double type
     * @return The value of Double type
     */
    public static Double getDouble() {
        String s = getString();
        Double doubleValue;
        if (s == null || s.length() == 0) {
            System.out.println("Невірний формат введення!");
            doubleValue = getDouble();
        } else {
            String value = "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                start = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                end = i;
                if (s.charAt(i) != ' ') break;
            }
            for (int i = start; i <= end; i++) {
                value += s.charAt(i);
            }
            if (value.length() == 0) {
                System.out.println("Невірний формат введення!");
                doubleValue = getDouble();
            } else {
                boolean matches = true;
                int dots = 0;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '.') {
                        dots++;
                        if (i == 0 || i == value.length() - 1 || dots > 1) matches = false;
                        if (i == 1){
                            if (value.charAt(i - 1) == '-') matches = false;
                        }
                    }
                    if (value.charAt(i) == '-' && i > 0) matches = false;
                    if ((value.charAt(i) < '0' || value.charAt(i) > '9') && value.charAt(i) != '-' && value.charAt(i) != '.') matches = false;
                }
                if (!matches) {
                    System.out.println("Невірний формат введення!");
                    doubleValue = getDouble();
                } else
                    doubleValue = Double.valueOf(value);
            }
        }
        return doubleValue;
    }

    /**
     * Get the value of String type
     * @param message Information for user
     * @return The value of String type
     */
    public static String getString(String message) {
        System.out.print(message);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * Get the value of String type
     * @return - The value of String type
     */
    public static String getString() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}