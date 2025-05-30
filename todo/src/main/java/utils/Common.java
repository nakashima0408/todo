package utils;

public class Common {
	
	public static double calcBmi(double h , double w) {
		return w / (h * h);
	}
	
	public static String getBmiResult(double bmi) {
		
		if (bmi < 18.5) {
			return "やせ気味";
		} else if (bmi < 25) {
			return "標準";
		} else {
			return "肥満気味";
		}
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
