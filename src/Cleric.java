public class Cleric extends Character{
	  
	  // コンストラクタ
	  public Cleric(String name){
		  this.name = name;
	  }
	  
	  // セルフエイド
	  public void SelfAid() {		  
		  System.out.println(this.name + "はセルフエイドを発動した！");
		  // HPを回復
		  this.hp +=  10;
	  }
	  
	  // 祈り
	  public int Pray() {
		  System.out.println(this.name + "は祈りを発動した！");
		  int random =  Util.Random(3);// 乱数0~2を取得
		  return Main.turnCount + random;
	  }

	  // 炎魔法
	  public int FireMagic() {
		  System.out.println(this.name + "は炎魔法を発動した！");
		  return 4 * this.level;
	  }
}