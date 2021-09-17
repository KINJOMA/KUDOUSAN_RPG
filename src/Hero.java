public class Hero extends Character{
	  
	  // コンストラクタ
	  public Hero(String name) {
		  this.name = name;
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
	  
	  // 眠る
	  public int sleep() {
	    System.out.println(this.name + "は眠って回復した！");
	    return 100;
	  }
	  
	  public int selectRandam() {
		  switch(Util.Random(3)) {
		      case 1:
		    	  return -Attack();
		      case 2:
		    	  return -Kick();
		      case 3:
		      default:
		    	  return sleep();
		  }
		  
	  }	  
}