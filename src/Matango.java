public class Matango extends Character{
	  final String monstarName = "お化けキノコ";
	  
	  // コンストラクタ
	  public Matango(int hp, char suffix) {
		  this.hp = hp;
		  this.name = monstarName + suffix;
	  }
	  
	  // アタック攻撃
	  public int Attack() {
		  System.out.println( this.name + "はアタックした！");
		  return level * 3;
	  }
	  
	  // 毒攻撃
	  public int Poison() {
		  System.out.println( this.name + "は毒をはいた！");
		  return Main.turnCount * Util.Random(5);
	  }
	  public int selectRandam() {
		  switch(Util.Random(2)) {
		      case 1:
		    	  return -Attack();
		      case 2:
		    	  //return -();
		      //case 3:
		      default:
		    	  return -Poison();
		  }
		  
	  }	  
	  
}