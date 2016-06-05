package dd.sia.knights.logic;

import org.junit.Test;
import org.mockito.Mockito;

public class BraveKnightTest {
    @Test
    public void testDoQuest() {
        Quest quest = Mockito.mock(Quest.class);
        BraveKnight knight = new BraveKnight(quest);
        knight.doQuest();
        Mockito.verify(quest, Mockito.times(1)).embark();
    }
}
