package dd.sia.knights.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("knight")
public class BraveKnight implements Knight {
    private Quest quest;

    @Autowired
    public BraveKnight(@Qualifier("quest") Quest quest) {
        this.quest = quest;
    }

    public String doQuest() {
        return quest.embark();
    }
}
