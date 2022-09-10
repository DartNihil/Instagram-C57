package by.tms.instagram.entity;

import by.tms.instagram.entity.message.Comment;

import java.time.LocalDateTime;

public class Like {
    private LocalDateTime likeDate;
    private User author;
    private Post post;
    private Comment comment;
    private Post commentPost;

    public Like() {
    }

    public Like(LocalDateTime likeDate, User author, Post post) {
        this.likeDate = likeDate;
        this.author = author;
        this.post = post;
    }

    public Like(LocalDateTime likeDate, User author, Comment comment, Post commentPost) {
        this.likeDate = likeDate;
        this.author = author;
        this.comment = comment;
        this.commentPost = commentPost;
    }

    public LocalDateTime getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(LocalDateTime likeDate) {
        this.likeDate = likeDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public Post getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(Post commentPost) {
        this.commentPost = commentPost;
    }
}
