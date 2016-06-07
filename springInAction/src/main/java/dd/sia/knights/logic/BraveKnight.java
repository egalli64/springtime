package dd.sia.knights.logic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("knight")
public class BraveKnight implements Knight {
    private Log log = LogFactory.getLog(BraveKnight.class);
    private Quest quest;

    @Autowired
    public BraveKnight(@Qualifier("quest") Quest quest) {
        this.quest = quest;
    }

    public String doQuest() {
        log.info("BraveKnight is embarking his quest");
        return quest.embark();
    }
}