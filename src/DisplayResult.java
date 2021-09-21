import java.util.List;

public class DisplayResult {
	  String line1 = "";
	  String line2 = "";
	  String line3 = "";
	  
	  public void Output(List<Character> Allies, List<Character> Enemy) {
		SetNameAndHP(Allies,Enemy);
		// 各キャラクターのHP
		System.out.println(line1);
		// 空行
		System.out.println(line2);
		//System.out.println(line3);
	  }

	  public void SetNameAndHP(List<Character> Allies, List<Character> Enemies) {
		this.line1 = "ターン" + Main.turnCount;

		for(Character ally : Allies) {
			this.line1 += " " + ally.name + " HP:" + ally.hp + " ";
		}
	
		for(Character enemy : Enemies) {
			this.line1 += " " + enemy.name + " HP:" + enemy.hp + " ";
		}
		
	  }
}
