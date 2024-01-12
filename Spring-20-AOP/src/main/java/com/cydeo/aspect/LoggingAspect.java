package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect // this annotation defines this as a source of aspects. No bean from this class.
@Configuration
public class LoggingAspect {

    //Task: log all activity of the CourseController

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


/*
     //this is an example of using an execution designator to define a PointCut
    // "execution(* {path to CourseController}.{which method? or * for all}(..))"
    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
    private void pointcut(){}


    // This advice by writing @Before("designatorMethodName()") will inform the pointCut
    @Before("pointcut()") // this is an example of an Advice
    public void log(){
       logger.info("Logger info ------");
   }

     */

    /*

    // This is an example of unifying pointcut and advice
    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Logger info ------");
    }

     */



    /*
    // an example of pointcutting inside a respository.
    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    private void anyProductRepositoryFindById(){}
    //This is the matching advice
    @Before("anyProductRepositoryFindById()")
    public void beforeCourseRepoOperation(JoinPoint joinPoint){
        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

     */


    // These are examples of using the within designator for point cuts.
    // Within is preferred for matching methods of classes with certain types.
    @Pointcut("within(com.cydeo.controller..*)") // will get all classes under the controller package
    private void anyControllerOperation(){}

    @Pointcut("@within(org.springframework.stereotype.Service)") // will get class level annotations massed by @Service
    private void anyServiceOperation(){
    }


    // pointcuts for an advice can be combined using logical operators && || !
    @Before("anyControllerOperation() || anyServiceOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }


    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteCourseOperation(){}



    @Before("anyDeleteCourseOperation()")
    public void beforeControllerAdviceA(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){}

    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result){
        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }

    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
        logger.info("After returning(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }

    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @After("anyGetCourseOperation()")
    public void afterControllerAdvice(JoinPoint joinPoint) {
        logger.info("After finally -> Method : {}", joinPoint.getSignature().toShortString());
    }

    @Pointcut("@annotation(com.cydeo.annotation.Loggable)")
    private void anyLoggableMethodOperation(){}

    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before () -> Method : {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object results = null;
        try {
            results =proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}", proceedingJoinPoint.getSignature().toShortString(),results.toString());
        return results;
    }

}