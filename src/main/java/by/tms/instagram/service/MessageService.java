package by.tms.instagram.service;

import by.tms.instagram.entity.message.Comment;
import by.tms.instagram.entity.Like;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.entity.message.Message;
import by.tms.instagram.entity.message.PrivateMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {
    private UserService userService = UserService.getInstance();
    private static MessageService instance;

    private MessageService() {
    }

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
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

    public List<PrivateMessage> setIsReadMessage(List<PrivateMessage> privateMessages, User user) {
        if (privateMessages != null){
            for (PrivateMessage message:privateMessages) {
                if(message.getAuthor().equals(user) && !message.isRead()) {
                    message.setRead(true);
                }
            }
        }
        return privateMessages;
    }

}
