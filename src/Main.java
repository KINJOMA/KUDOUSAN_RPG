import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	  public static int turnCount = 0;     //メンバ変数なのでthisが使える
	  public static void main(String[] args) {
			
		  boolean WIN = true;
		  Hero tarou = new Hero("太郎",1);	//インスタンスの生成
		  Cleric jirou = new Cleric("次郎",1);
		  
		  Matango m1 = new Matango(50, 'A');
		  Matango m2 = new Matango(48, 'B');
		  
		  List<Character> Allies = new ArrayList<Character>();
		  Allies.add(tarou);
		  Allies.add(jirou);
		  
		  List<Character> Enemies = new ArrayList<Character>();
		  Enemies.add(m1);
		  Enemies.add(m2);
		  
		  DisplayResult dr = new DisplayResult();   
		  
		  for(int i = 0; i < 100; i++) {    //iが０から９の繰り返し
			  // ターン
			  turnCount++;
			  int  deathCountAllies = 0;
			  int  deathCountEnemies = 0;
			  // 味方チーム
			  for(Character ally :Allies) {
				  if(ally.hp == 0 ) {
					  deathCountAllies++;
					  continue;               //HPが０なら攻撃しないようにfor文から抜ける
				  }
				  // 技の選択
				  // TODO:ユーザ入力できるようにする
				  System.out.println("1または２または３を入力してください");
			        Scanner scan = new Scanner(System.in);     
			        String str = scan.next();      //入力を受け付ける  入力した文字を代入
			        
			        
				  int point = ally.Select(Integer.parseInt(str));
				  if(point < 0) {
					  // 攻撃
					  int idx = Util.Random(Enemies.size()-1);
					  Character e = Enemies.get(idx);
					  e.hp += Math.max(e.minHp - e.hp, point); // 最小HPを下回らないようにmax()を使用する           
				  }
				  else {
					  // 回復
					  int idx = Util.Random(Allies.size()-1);
					  Character a = Allies.get(idx);
					  a.hp += Math.min(a.maxHp - a.hp, point); // MaxHPを上回らないようにmin()を使用する
				  }
				  
			  }
			  
			  // 敵チーム
			  for(Character enemy :Enemies) {
				  if(enemy.hp == 0) {
					  deathCountAllies++;
					  continue;
				  }
				  // 技の選択
				  int point = enemy.selectRandam();
				  if(point < 0) {
					  // 攻撃
					  int idx = Util.Random(Allies.size()-1);
					  Character a = Allies.get(idx);
					  a.hp += Math.max(a.minHp - a.hp, point); // 最小HPを上回らないようにmax()を使用する
				  }
				  else {
					  // 回復
					  int idx = Util.Random(Enemies.size()-1);
					  Character e = Enemies.get(idx);
					  e.hp += Math.min(e.maxHp - e.hp, point); // 最大HPを上回らないようにmin()を使用する 
				  }
				  
			  }

			  dr.Output(Allies,Enemies);
			  
			  if(deathCountAllies ==  Allies.size()) {   
				  WIN = false;
				  break;  
			  }
			  else if(deathCountEnemies == Enemies.size()) {
				  WIN = true;
				  break;
			  }
			  // TODO:判定を入れる
		  }
		  if(WIN == true) {
			  System.out.println("戦いに勝ちました");
			
		  }  
		  else {
			  System.out.println("負けてしまいました");
		  }
	  }
}