package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    // NOTE:
    // It is better to use these as final fields

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    // This constructor will use the @Qualifier name, which overrides the @Primary identification)
    // If a custom name isn't assigned could be @Qualifier("commentPushNotification")
    // but we renamed it as PUSH
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
