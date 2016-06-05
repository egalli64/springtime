package dd.sia.knights.logic;
  
public class BraveKnight implements Knight {
  private Quest quest;

  public BraveKnight(Quest quest) {
    this.quest = quest;
  }

  public String doQuest() {
    return quest.embark();
  }
}
