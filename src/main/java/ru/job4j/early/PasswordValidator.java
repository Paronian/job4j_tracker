package ru.job4j.early;

public class PasswordValidator {
    static boolean containSubstringSubString(String password) {
        boolean rsl = false;
        String[] notValidString = {"qwerty", "12345", "password", "admin", "user"};
        password = password.toLowerCase();
        for (int i = 0; i < notValidString.length; i++) {
            if (password.contains(notValidString[i])) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static String validate(String password) {
        boolean rslUpperCase = false;
        boolean rslLowerCase = false;
        boolean rslDigit = false;
        boolean rslAlphabetic = false;
        int code = -1;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        char[] array = password.toCharArray();
        int arrayLength = password.toCharArray().length;

        if (arrayLength <= 8 || arrayLength >= 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (containSubstringSubString(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        for (int i = 0; i < array.length; i++) {
            code = Character.codePointAt(array, i);
            if (Character.isUpperCase(array[i])) {
                rslUpperCase = true;
            }
            if (Character.isLowerCase(array[i])) {
                rslLowerCase = true;
            }
            if (Character.isDigit(array[i])) {
                rslDigit = true;
            }
            if (!Character.isAlphabetic(code)
                    && !Character.isDigit(array[i])) {
                rslAlphabetic = true;
            }
            if (rslUpperCase
                    && rslLowerCase
                    && rslDigit
                    && rslAlphabetic) {
                break;
            }
        }
        if (!rslUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!rslLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!rslDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!rslAlphabetic) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}


