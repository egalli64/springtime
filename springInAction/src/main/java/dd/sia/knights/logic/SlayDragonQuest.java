package dd.sia.knights.logic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quest")
public class SlayDragonQuest implements Quest {
    @Override
    public String embark() {
        return "Embarking on quest to slay the dragon!";
    }
}
