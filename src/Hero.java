public class Hero extends Character{
	  
	  // コンストラクタ
	  public Hero(String name, int level) {
		  this.name = name;
		  this.level = level;
	  }
	  
	  // アタック攻撃
	  public int Attack() {
		  System.out.println( this.name + "はアタックした！");
		  return 5 * this.level;
	  }
	  
	  // キック攻撃
	  public int Kick() {
		  System.out.println( this.name + "はキックした！");
		  return 3 * Main.turnCount;
	  }
	  
	  // エイド
	  public int Aid() {
	    System.out.println(this.name + "はエイドを発動した！");
	    return 10;
	  }
	  
	  public int SelectRandam() {
		  switch(Util.Random(3)) {
		      case 1:
		    	  return -Attack();
		      case 2:
		    	  return -Kick();
		      case 3:
		      default:
		    	  return Aid();
		  }
		  
	  }	 
	  public int Select(int num) {     //攻撃や回復のコマンド1,2,3を選択する。
		  switch(num) {
		      case 1:
		    	  return -Attack();    //ここにattack関数を書くのはダメか？別で作ってreturnのが簡単？
		      case 2:
		    	  return -Kick();
		      case 3:
		      default:               //それ以外だったら
		    	  return Aid();
		  }
		  
	  }	  
}