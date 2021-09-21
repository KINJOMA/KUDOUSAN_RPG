import java.util.ArrayList;
import java.util.List;

public class Main {
	
	  public static int turnCount = 0;     //メンバ変数なのでthisが使える
	  public static void main(String[] args) {
			
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
		  
		  for(int i = 0; i < 10; i++) {    //iが０から９の繰り返し
			  // ターン
			  turnCount++;
			  
			  // 味方チーム
			  for(Character ally :Allies) {
				  // 技の選択
				  // TODO:ユーザ入力できるようにする
				  int point = ally.selectRandam();
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

			  /* 元のコード
			   * キャラクター毎に、、
			   * 　・技の選択
			   *  ・攻撃（相手のHPが下がる）または回復（味方のHPがアップ） 
			  //m2.hp -= tarou.Attack();
			  int point = tarou.selectRandam();  //tarouの攻撃
			  if(point < 0) {					//hpについて-する＝攻撃
				  // 攻撃
				  int idx = Util.Random(Enemy.size()-1);   //size０から始まる 個数は５で返ってくる。listが持っている個数を返すメソッド
				  //Enemy.get(idx).hp += point;
				  Character c = Enemy.get(idx);  //Enemy 0にm1,1はm2。idxが０だったたらm1がとりだされる。
				  c.hp += point;                 //もしcにm1が入ってきたら攻撃される。　ポイントマイナスが加算＝攻撃される。
			  }
			  else {
				  // 回復
				  int idx = Util.Random(Allies.size()-1);
				  Allies.get(idx).hp += point;
			  }
			  
			  //jirou.hp -= m1.Poison();  //m1の攻撃
			  point = m1.selectRandam(); //m1の攻撃でpointが返ってくる
			  if(point<0) {
				  int idx = Util.Random(Allies.size()-1);
				  Allies.get(idx).hp += point;  //たす-の意味
			  }
			  else {
				  int idx = Util.Random(Enemy.size()-1);
				  Enemy.get(idx).hp += point;
			  }
			  
			  //tarou.hp -= m2.Attack();  //m2の攻撃でtarouに代入
			  point = m2.selectRandam();
			  if(point<0) {
				  int idx = Util.Random(Allies.size()-1);
				  Allies.get(idx).hp += point;  //たす-の意味
			  }
			  else {
				  int idx = Util.Random(Enemy.size()-1);
				  Enemy.get(idx).hp += point;
			  }
			  
			  point = jirou.selectRandam();
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
			  //ここまででランダム攻撃について 1ターン分
			  //m2.hp -= jirou.FireMagic();
			  for(Character c : Allies) {
				  if(c.hp < 1) {                    //cのhpが１より小さい条件
					  Allies.remove(c);    //Alliysからcをremoveで除外
				  }
					//this.line1 += c.name + " HP:" + c.hp;
				}
			  for(Character c : Enemy) {
				  if(c.hp < 1) {                    //cのhpが１より小さい条件
					  Enemy.remove(c); 
				  }
			  }
			  
			  */
			  dr.Output(Allies,Enemies);
			  
			  // TODO:判定を入れる
		  }
		   
	  }
}