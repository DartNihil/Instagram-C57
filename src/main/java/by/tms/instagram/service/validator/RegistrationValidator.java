package by.tms.instagram.service.validator;

public class RegistrationValidator {
    private static final String USERNAME_PATTERN = "[A-Za-z0-9]{3,15}";
    private static final String EMAIL_PATTERN = "[\\w\\d-]+([\\\\.\\w\\d_-]+)*@[\\w\\d-]+([\\\\.\\w]+)*";

    public boolean checkValidation(String nick, String name, String surname, String email) {
        if ((!nick.matches(USERNAME_PATTERN)
                || nick.isEmpty())
                || (!name.matches(USERNAME_PATTERN)
                || name.isEmpty())
                || (!surname.matches(USERNAME_PATTERN)
                || surname.isEmpty())
                || (!email.matches(EMAIL_PATTERN)
                || email.isEmpty())) {
            return false;
        } else return true;
    }
}



