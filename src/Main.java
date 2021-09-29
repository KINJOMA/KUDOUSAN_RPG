import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	  public static int turnCount = 0;     //メンバ変数なのでthisが使える
	  public static void main(String[] args) {
			
		  boolean WIN = true;        //WINをtrueとする。自動的にfalseならLOSE
		  
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
		  
		  for(int i = 0; i < 100; i++) {    //iが０から９の繰り返し   for無限として100以下に
			  // ターン
			  turnCount++;
			  int  deathCountAllies = 0;    //味方チーム二人の生き残り数
			  int  deathCountEnemies = 0;
			  // 味方チーム
			  for(Character ally :Allies) {
				  if(ally.hp == 0 ) {           //敵のHPが0になれば、さっきつくっておいたdeathCountAlliesが1追加
					  deathCountAllies++;      
					  continue;               //HPが０なら攻撃しないようにfor文から抜ける break;だとfor文から抜け出してまた攻撃してしまう。
				  }                        
				  // 技の選択
				  // TODO:ユーザ入力できるようにする
				  
			        int num = 0;
		            
		            while(num == 0 ) {
		            	System.out.println("1または２または３を入力してください");
				        Scanner scan = new Scanner(System.in);     //scanという名前でインスタンス作成
				        String str = scan.next();      //入力を受け付ける  入力した文字をstrに代入
				        
			            try
			            {
			            	num = Integer.parseInt(str);
			            }
			            catch (Exception e)
			            {
			            	System.out.println("整数値以外が入力されました");
			               num = 0;
			            }
		            }
		            
		            int point = ally.Select(num);  
				 
				  if(point < 0) {
					  // 攻撃
					  int idx = Util.Random(Enemies.size()-1);       //敵のsize()は１か２
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
			  for(Character enemy :Enemies) {       //拡張for文で、
				  if(enemy.hp == 0) {               //敵のHPが0になると、死者の数を増やす。continue
					  deathCountAllies++;           //breakだとチームがゼロになっても攻撃する
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
			  
			  if(deathCountAllies ==  Allies.size()) {     //味方tの死者が、味方のコマンド選択数１、２と同じになったら
				  WIN = false;                     //勝てなかったら、breakする。for文から抜ける。抜けると攻撃できなくなる
				  break;  
			  }
			  else if(deathCountEnemies == Enemies.size()) {   //elseはダメ。敵の、死者が敵の選択数（size）と同じになれば・・・
				  WIN = true;                             //勝ちで、for文から抜ける。
				  break;
			  }
			  // TODO:判定を入れる
		  }
		  if(WIN == true) {
			  System.out.println("戦いに勝ちました");      //もし勝ったら、この文面（printメソッド）を出すif文
			
		  }  
		  else {
			  System.out.println("負けてしまいました");
		  }
	  }
}