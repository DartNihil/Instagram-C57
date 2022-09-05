package by.tms.instagram.service.validator;

public class SettingsValidator {
    private static final String NAME_PATTERN ="^([A-Z]{1}[a-z]{1,14})$";
    private static final String SURNAME_PATTERN = "^([A-Z]{1}[a-z]{1,14})$";
    private static final String NICKNAME_PATTERN = "[A-Za-z0-9]{3,15}";
    private static final String EMAIL_PATTERN = "[\\w\\d-]+([\\\\.\\w\\d_-]+)*@[\\w\\d-]+(\\.([\\w\\d]+){0,})*";

    public boolean allUserFieldsAreValid(String name, String surname, String nickname, String email) {
        return (name.matches(NAME_PATTERN) & !name.isEmpty())
                && (surname.matches(SURNAME_PATTERN) & !surname.isEmpty())
                && (nickname.matches(NICKNAME_PATTERN) & !nickname.isEmpty()
                && (email.matches(EMAIL_PATTERN) & !email.isEmpty()));
    }
}
