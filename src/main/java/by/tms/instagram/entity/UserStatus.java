package by.tms.instagram.entity;

public enum UserStatus {
    ACTIVE(1), BLOCKED(2);

    private final long statusID;

    UserStatus(long statusID) {
        this.statusID = statusID;
    }

    public long getID() {
        return statusID;
    }
}