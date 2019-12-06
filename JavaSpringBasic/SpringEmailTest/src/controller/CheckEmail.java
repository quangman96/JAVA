package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    private static Matcher matcher;
    private static Pattern pattern;
    private static final String EMAIL_REGEX = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
    public static boolean checkEmail (String email){
        pattern = pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.find();
    }
}
