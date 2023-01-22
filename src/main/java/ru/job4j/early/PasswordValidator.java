package ru.job4j.early;

public class PasswordValidator {

    static boolean containsUpperCaseLetter(String password) {
        boolean rsl = false;
        for (int i = 0; i < array(password).length; i++) {
            if (Character.isUpperCase(array(password)[i])) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    static boolean containsLowerCase(String password) {
        boolean rsl = false;
        for (int i = 0; i < array(password).length; i++) {
            if (Character.isLowerCase(array(password)[i])) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    static boolean containsFigure(String password) {
        boolean rsl = false;
        for (int i = 0; i < array(password).length; i++) {
            if (Character.isDigit(array(password)[i])) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    static boolean containSpecialSymbol(String password) {
        int code = -1;
        boolean rsl = false;
        for (int i = 0; i < array(password).length; i++) {
            code = Character.codePointAt(array(password), i);
            if (!Character.isAlphabetic(code)
                    && !Character.isDigit(array(password)[i])) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    static boolean containSubstringSubString(String password) {
        password = password.toLowerCase();
        return password.contains("qwerty")
                || password.contains("12345")
                || password.contains("password")
                || password.contains("admin")
                || password.contains("user");
    }

    static char[] array(String password) {
        return password.toCharArray();
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        int arrayLength = array(password).length;
        if (arrayLength <= 8 || arrayLength >= 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!containsUpperCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!containsLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!containsFigure(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!containSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containSubstringSubString(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}

