package ge.zura.task.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduler {
    @Scheduled(fixedRate = 2000)
    public void task(){
        System.out.println("*****************xoooaaar gadaoooob ?");
    }
}
