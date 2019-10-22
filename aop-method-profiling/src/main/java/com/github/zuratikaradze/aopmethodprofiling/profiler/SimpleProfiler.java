package com.github.zuratikaradze.aopmethodprofiling.profiler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * Our profiler that
 * logs process time, and remark if process had exception.
 */
public class SimpleProfiler {

    /**
     * Spring AOP 'around' reference method signature is bounded like this, the
     * method name "profile" should be same as defined in spring.xml aop:around
     * section.
     **/
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(proceedingJoinPoint.toShortString());
        boolean isExceptionThrown = false;
        try {
            // execute the profiled method
            return proceedingJoinPoint.proceed();
        } catch (RuntimeException e) {
            isExceptionThrown = true;
            throw e;
        } finally {
            stopWatch.stop();
            StopWatch.TaskInfo taskInfo = stopWatch.getLastTaskInfo();
            // Log the method's profiler result
            String profileMessage = taskInfo.getTaskName() + ": " + taskInfo.getTimeMillis() + " ms" + (isExceptionThrown ? " (thrown Exception)" : "");
            System.out.println(profileMessage);
        }
    }

}