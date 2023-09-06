package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}

/*
There is more than one implementation of this class so will throw an error.

Exception type:
NoUniqueBeanDefinitionException
UnsatisfiedDependencyException

Key take away in error message:
expected single matching bean but found 2: commentPushNotificationProxy,emailCommentNotificationProxy


 */
