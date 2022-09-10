package by.tms.instagram.web.facade;

import by.tms.instagram.entity.message.Comment;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;

public class HelperLikesClass {
    private User user;
    private Post post;
    private Comment comment;

    public HelperLikesClass() {
    }

    public HelperLikesClass(User user, Post post, Comment comment) {
        this.user = user;
        this.post = post;
        this.comment = comment;
    }

    public HelperLikesClass(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
