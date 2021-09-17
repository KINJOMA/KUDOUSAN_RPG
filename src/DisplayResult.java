import java.util.List;

public class DisplayResult {
	  String line1 = "";
	  String line2 = "";
	  String line3 = "";
	  
	  public void Output(List<Character> Allies, List<Character> Enemy) {
		SetNameAndHP(Allies,Enemy);
		System.out.println(line1);
		System.out.println(line2);
		//System.out.println(line3);
	  }

	  public void SetNameAndHP(List<Character> Allies, List<Character> Enemy) {
		this.line1 = "ターン" + Main.turnCount;

		for(Character c : Allies) {
			this.line1 += c.name + " HP:" + c.hp;
		}
	
		for(Character c : Enemy) {
			this.line1 += c.name + " HP:" + c.hp;
		}
		
	  }
}
