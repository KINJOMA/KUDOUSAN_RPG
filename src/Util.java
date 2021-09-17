import java.text.SimpleDateFormat;
import java.util.Date;

// ユーティリティクラス
public class Util{
	
	  // 1～引数の乱数を返すメソッド
	  public static int Random(int num) {
		  
		  // 現在時刻（秒）で乱数を発生させる
		  Date date = new Date();// 現在日時を取得
		  SimpleDateFormat format1 = new SimpleDateFormat("ss");// 日付フォーマット指定（秒）
		  String ssStr = format1.format( date );// 現在時刻（秒）を文字列で取得
		  int second = Integer.parseInt(ssStr);// 文字列を整数に変換

		  // 乱数発生0～引数-1
		  int random =  second % (num + 1);
		  //System.out.println("現在の日時は" + date + "です。");
		  //System.out.println("現在時刻（秒）より発生した乱数は" + random + "です。");
		  
		  return random;
		  	  
	  }
}