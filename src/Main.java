import java.util.ArrayList;
import java.util.List;

public class Main {
	
	  public static int turnCount = 0;
	  public static void main(String[] args) {
			
		  Hero tarou = new Hero("太郎");	//インスタンスの生成
		  Cleric jirou = new Cleric("次郎");
		  
		  Matango m1 = new Matango(50, 'A');
		  Matango m2 = new Matango(48,'B');
		  
		  List<Character> Allies = new ArrayList<Character>();
		  Allies.add(tarou);
		  Allies.add(jirou);
		  
		  List<Character> Enemy = new ArrayList<Character>();
		  Enemy.add(m1);
		  Enemy.add(m2);
		  

		  DisplayResult dr = new DisplayResult();   
		  // ターン１
		  turnCount++;
		  //m2.hp -= tarou.Attack();
		  int point = tarou.selectRandam();
		  if(point < 0) {
			  // 攻撃
			  int idx = Util.Random(Enemy.size()-1);
			  Enemy.get(idx).hp += point;
		  }
		  else {
			  // 回復
			  int idx = Util.Random(Allies.size()-1);
			  Allies.get(idx).hp += point;
		  }
		  jirou.hp -= m1.Poison();
		  tarou.hp -= m2.Attack();
		  m2.hp -= jirou.FireMagic();
		  dr.Output(Allies,Enemy);
		  
/*		  // ターン２
		  turnCount++;
		  m1.hp -= tarou.Kick();
		  jirou.hp -= m1.Attack();
		  tarou.hp -= m2.Poison();
		  jirou.SelfAid();
		  dr.Output(Allies,Enemy);
		  
		  // ターン３
		  turnCount++;
		  m1.hp -= tarou.Kick();
		  jirou.hp -= m1.Attack();
		  tarou.hp -= m2.Poison();
		  tarou.hp += jirou.Pray();
		  dr.Output(Allies,Enemy);
*/
	  }
}