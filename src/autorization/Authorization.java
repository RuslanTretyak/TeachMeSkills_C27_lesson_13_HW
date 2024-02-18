package autorization;

import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authorization {
    private static final int LOGIN_LENGTH = 20;
    private static final int PASSWORD_LENGTH = 20;
    public static boolean registerFirstWay(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() >= LOGIN_LENGTH) {
            throw new WrongLoginException("Длина login должна быть меньше 20 символов");
        } else if (login.contains(" ")) {
            throw new WrongLoginException("login не должен содержать пробелы");
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(password);
        if (password.length() >= PASSWORD_LENGTH) {
            throw new WrongPasswordException("Длина password должна быть меньше 20 символов");
        } else if (password.contains(" ")) {
            throw new WrongPasswordException("password не должен содержать пробелы");
        } else if (!matcher.find()) {
            throw new WrongPasswordException("password должен содержать хотя бы одну цифру");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password и confirmPassword не должны отличаться");
        }
        return true;
    }
    public static boolean registerSecondWay(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (checkStringForLength(login, LOGIN_LENGTH)) {
            throw new WrongLoginException("Длина login должна быть меньше 20 символов");
        } else if (checkStringForChar(login, " ")) {
            throw new WrongLoginException("login не должен содержать пробелы");
        }
        if (checkStringForLength(password, PASSWORD_LENGTH)) {
            throw new WrongPasswordException("Длина password должна быть меньше 20 символов");
        } else if (checkStringForChar(password, " ")) {
            throw new WrongPasswordException("password не должен содержать пробелы");
        } else if (!checkStringForChar(password, "0123456789")) {
            throw new WrongPasswordException("password должен содержать хотя бы одну цифру");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password и confirmPassword не должны отличаться");
        }
        return true;
    }
    private static boolean checkStringForChar(String string, String characters) {
        for (char ch1 : string.toCharArray()) {
            for (char ch2 : characters.toCharArray()) {
                if (ch1 == ch2) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkStringForLength(String string, int length) {
        return string.length() >= length;
    }
}
