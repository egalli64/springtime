package dd.sia.knights.logic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Minstrel {
    private final Log log = LogFactory.getLog(Minstrel.class);

    @Before("execution(public String Knight.doQuest())")
    public void singBeforeQuest() {
        log.info("Fa la la, the knight is so brave!");
    }

    @After("execution(public String Knight.doQuest())")
    public void singAfterQuest() {
        log.info("Tee hee hee, the brave knight did embark on a quest!");
    }
}
