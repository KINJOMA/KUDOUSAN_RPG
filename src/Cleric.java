public class Cleric extends Character{
	  
	  // コンストラクタ
	  public Cleric(String name, int level) {
		  this.name = name;
		  this.level = level;
	  }
	  
	  // エイド
	  public int Aid() {		  
		  System.out.println(this.name + "はエイドを発動した！");
		  return 10;
	  }
	  
	  // 祈り
	  public int Pray() {
		  System.out.println(this.name + "は祈りを発動した！");
		  int random =  Util.Random(3);
		  return Main.turnCount + random;
	  }

	  // 炎魔法
	  public int FireMagic() {
		  System.out.println(this.name + "は炎魔法を発動した！");
		  return 4 * this.level;
	  }
	  
	  public int selectRandam() {
		  switch(Util.Random(3)) {
		      case 1:
		    	  return Aid();
		      case 2:
		    	  return Pray();
		      case 3:
		      default:
		    	  return -FireMagic();
		  }
		  
	  }	  
}