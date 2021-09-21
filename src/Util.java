import java.util.Calendar;
import java.util.Random;

// ユーティリティクラス
public class Util{
	
	  // 1～引数numの乱数を返すメソッド
	  public static int Random(int num) {
		  
		  Random r = new java.util.Random();
		  
		  return r.nextInt(num + 1);
		  	  
	  }
	  
	  // 1～引数numの乱数を返すメソッド
	  public static int customRandom(int num) {
		  
		  // 現在時刻（秒）で乱数を発生させる
		  //Date date = new Date();// 現在日時を取得
		  //SimpleDateFormat format1 = new SimpleDateFormat("ss");// 日付フォーマット指定（秒）
		  //String ssStr = format1.format( date );// 現在時刻（秒）を文字列で取得
		  //int second = Integer.parseInt(ssStr);// 文字列を整数に変換
		  
		  // 現在時刻（秒）で乱数を発生させる
		  Calendar cTime = Calendar.getInstance();	//[1]
		  int milliSecond = cTime.get(Calendar.MILLISECOND);

		  // 乱数発生0～引数-1
		  int random =  milliSecond % (num + 1);
		  //System.out.println("num:" + num);
		  //System.out.println("random:" + random);
		  
		  return random;
		  	  
	  }
}