package by.tms.instagram.service;

import by.tms.instagram.entity.Comment;
import by.tms.instagram.entity.Like;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;

import java.time.LocalDateTime;

public class CommentService {
    private UserService userService = UserService.getInstance();
    private static CommentService instance;

    private CommentService() {
    }

    public static CommentService getInstance() {
        if (instance == null) {
            instance = new CommentService();
        }
        return instance;
    }

    public Comment findComment(Post post, String commentDate) {
        Comment comment = new Comment();
        for (Comment c : post.getComments()) {
            if (c.getDateTime().toString().equals(commentDate)) {
                comment = c;
            }
        }
        return comment;
    }

    public Comment likeComment(Post post, User currentUser, Comment comment, String commentDate) {
        if (!comment.getLikes().contains(currentUser)) {
            for (Comment c : post.getComments()) {
                if (c.getDateTime().toString().equals(commentDate)) {
                    c.getLikes().add(currentUser);
                    userService.addLikeInHistory(comment.getAuthor(), new Like(LocalDateTime.now(), currentUser, comment, post));
                    comment = c;
                }
            }
        } else {
            for (Comment c : post.getComments()) {
                if (c.getDateTime().toString().equals(commentDate)) {
                    c.getLikes().remove(currentUser);
                    comment = c;
                }
            }
        }
        return comment;
    }
}
