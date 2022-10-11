package by.tms.instagram.web.facade.likesFacade;

import by.tms.instagram.entity.message.Comment;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.MessageService;
import by.tms.instagram.service.PostService;
import by.tms.instagram.service.UserService;

import java.util.Optional;

public class LikesFacade {
    private final UserService userService = UserService.getInstance();
    private final PostService postService = PostService.getInstance();
    private final MessageService messageService = MessageService.getInstance();

    public HelperLikesClass getLikedObject(User currentUser, String email, String postDate, String commentDate) {
        Optional<User> userByEmail = userService.findByNickNameAndEmail(email, "");
        User userInBase = null;
        if (userByEmail.isPresent()) {
            userInBase = userByEmail.get();
        }
        assert userInBase != null;
        Post post = postService.findPost(userInBase, postDate);
        Comment comment = messageService.findComment(post, commentDate);
        comment = messageService.likeComment(post, currentUser, comment, commentDate);
        return new HelperLikesClass(userInBase, post, comment);
    }


    public HelperLikesClass getLikedObject(User currentUser, String email, String postDate) {
        Optional<User> userByEmail = userService.findByNickNameAndEmail(email, "");
        User userInBase = null;
        if (userByEmail.isPresent()) {
            userInBase = userByEmail.get();
        }
        assert userInBase != null;
        Post post = postService.findPost(userInBase, postDate);
        post = postService.likePost(userInBase, currentUser, post, postDate);
        return new HelperLikesClass(userInBase, post);
    }
}
