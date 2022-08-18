package by.tms.instagram.entity;

public enum UserRole {
    ADMIN(1), USER(2);

    private final long roleID;

    UserRole(long roleID) {
        this.roleID = roleID;
    }

    public long getID() {
        return roleID;
    }
}