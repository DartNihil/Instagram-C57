package by.tms.instagram.service.validator;

public class RegistrationValidator {
    private static final String USERNAME_PATTERN = "[A-Za-z0-9]{3,15}";
    private static final String PASSWORD_PATTERN = "[A-Za-z0-9]{8,15}";
    private static final String EMAIL_PATTERN = "[\\w\\d-]+([\\\\.\\w\\d_-]+)*@[\\w\\d-]+(\\.([\\w\\d]+){0,})*";

    public boolean checkValidation(String nick, String name, String surname, String email, String password) {
        return (nick.matches(USERNAME_PATTERN)
                && !nick.isEmpty())
                && (name.matches(USERNAME_PATTERN)
                && !name.isEmpty())
                && (surname.matches(USERNAME_PATTERN)
                && !surname.isEmpty())
                && (email.matches(EMAIL_PATTERN)
                && !email.isEmpty())
                && (password.matches(PASSWORD_PATTERN)
                && !password.isEmpty());
    }
    public boolean loginValidation (String nick, String password){
        return (nick.matches(USERNAME_PATTERN) && (password.matches(PASSWORD_PATTERN)));
    }
}