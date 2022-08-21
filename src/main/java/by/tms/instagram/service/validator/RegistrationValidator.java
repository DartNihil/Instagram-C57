package by.tms.instagram.service.validator;

public class RegistrationValidator {
    private static final String USERNAME_PATTERN = "[A-Za-z0-9]{3,15}";
    private static final String EMAIL_PATTERN = "[\\w.]*@[\\w]*.[\\w]{1,8}";
    private static final String PASSWORD_PATTERN = "[\\w\\d]{5,10}";

    public boolean checkValidation(String nick, String name, String surname, String email, String password) {
        if ((!nick.matches(USERNAME_PATTERN)
                || nick.isEmpty())
                || (!name.matches(USERNAME_PATTERN)
                || name.isEmpty())
                || (!surname.matches(USERNAME_PATTERN)
                || surname.isEmpty())
                || (!email.matches(EMAIL_PATTERN)
                || email.isEmpty())
                || (!password.matches(PASSWORD_PATTERN)
                || password.isEmpty())) {
            return false;
        } else return true;
    }
}
