package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Joe");
        comment.setText("Please talk to Boss");

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService cs1 = context.getBean(CommentService.class);
       // CommentService cs2 = context.getBean(CommentService.class);


        // notice that these have the same memory address
        //System.out.println(cs1);
       // System.out.println(cs2);

       // System.out.println(cs1==cs2);

        // Singleton is used by Default
        // To have different objects for the reference, need to use Prototype Scope

        // when the service is marked with @Scope("prototype") they are different objects


        // after the hello line has been added to constructor, notice that with prototype, the constructor is called twice

        // When you return back to singleton and create the context and disable everything else,
        // the constructor of CommentService is called when context is created
        // this is EAGER INSTANTIATION

        // Turn it lazy with Prototype or with @Lazy
        // It doesn't call the constructor at context creation, but when the bean is referred to.

    }
}
