package by.tms.instagram.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String surname;
    private String nickname;
    private String email;
    private String password;
    private String userPhoto;
    private final List<Post> userPosts = new ArrayList<>();
    private final List<User> userFollowers = new ArrayList<>();
    private final List<User> userSubscriptions = new ArrayList<>();
    private final List<Like> likesHistory = new ArrayList<>();
    private long userRoleID;
    private long userStatusID;

    private User() {
    }

    public User(long id, String name, String surname, String nickname, String email, String password, long userRoleID, long userStatusID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.userRoleID = userRoleID;
        this.userStatusID = userStatusID;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
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

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public List<User> getUserFollowers() {
        return userFollowers;
    }

    public List<User> getUserSubscriptions() {
        return userSubscriptions;
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

    public List<Like> getLikesHistory() {
        return likesHistory;
    }

    public List<Like> getReverseLikesHistory() {
        Collections.reverse(likesHistory);
        return likesHistory;
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

    public static class UserBuilder {
        private long id;
        private String name;
        private String surname;
        private String nickname;
        private String email;
        private String password;
        private long userRoleID;
        private long userStatusID;

        UserBuilder() {
        }

        public UserBuilder id(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder userRoleID(long userRoleID) {
            this.userRoleID = userRoleID;
            return this;
        }

        public UserBuilder userStatusID(long userStatusID) {
            this.userStatusID = userStatusID;
            return this;
        }

        public User build() {
            return new User(this.id, this.name, this.surname, this.nickname, this.email, this.password, this.userRoleID, this.userStatusID);
        }
    }
}