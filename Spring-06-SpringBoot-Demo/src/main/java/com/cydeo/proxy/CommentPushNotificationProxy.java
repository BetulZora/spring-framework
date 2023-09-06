package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// Automatic bean name is commentPushNotificationProxy
// this can be changed with @Qualifier
@Qualifier ("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment : " + comment.getText()
        + "\nBy " + comment.getAuthor());

    }
}
