package by.tms.instagram.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String surname;
    private String nickname;
    private String email;
    private String password;
    private long userRoleID;
    private long userStatusID;

    private User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(long userRoleID) {
        this.userRoleID = userRoleID;
    }

    public long getUserStatusID() {
        return userStatusID;
    }

    public void setUserStatusID(long userStatusID) {
        this.userStatusID = userStatusID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && userRoleID == user.userRoleID && userStatusID == user.userStatusID &&
                Objects.equals(name, user.name) && Objects.equals(surname, user.surname) &&
                Objects.equals(nickname, user.nickname) && Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nickname, email, password, userRoleID, userStatusID);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRoleID=" + userRoleID +
                ", userStatusID=" + userStatusID +
                "; ";
    }

    public static class Builder {
        private final User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setId(long id) {
            newUser.id = id;
            return this;
        }

        public Builder setName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public Builder setNickname(String nickname) {
            newUser.nickname = nickname;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder setUserRoleID(long userRoleID) {
            newUser.userRoleID = userRoleID;
            return this;
        }

        public Builder setUserStatusID(long userStatusID) {
            newUser.userStatusID = userStatusID;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}