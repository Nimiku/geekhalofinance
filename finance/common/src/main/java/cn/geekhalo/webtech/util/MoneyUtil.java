package cn.geekhalo.webtech.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneyUtil {
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;
	// 这个类不能实例化
	private MoneyUtil() {}
	/**
	 * 提供精确的加法运算。
	 * @param v1被加数
	 * @param v2加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
	
	public static BigDecimal add(BigDecimal v1,BigDecimal v2){
		return v1.add(v2);
	}
	/**
	 * 提供精确的减法运算。
	 * 有正负
	 * @param v1被减数
	 * @param v2减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	
	public static BigDecimal sub(BigDecimal v1,BigDecimal v2){
		return v1.subtract(v2);
	}
	/**
	 * 提供精确的乘法运算。
	 * @param v1被乘数
	 * @param v2  乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 小数点以后10位，以后的数字四舍五入。
	 * @param v1被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}
	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 定精度，以后的数字四舍五入。
	 * @param v1被除数
	 * @param v2 除数
	 * @param scale 表示表示需要精确到小数点以后几位
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
			"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v需要四舍五入的数字
	 * @param scale小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
			"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}
	
	public static String formatToMoneyDisplay(double value){
		BigDecimal bg = new BigDecimal(String.valueOf(value));
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(bg.setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	public static String formatToMoneyCommaDisplay(double value){
		BigDecimal bg = new BigDecimal(String.valueOf(value));
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(bg.setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	public static String formatToMoneyCommaDisplay(String value){
		BigDecimal bg = new BigDecimal(value);
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(bg.setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	public static String formatMoneyToThree(BigDecimal b){
		DecimalFormat df1=(DecimalFormat) DecimalFormat.getInstance(); 
		df1.setGroupingSize(3); 
		return df1.format(b.doubleValue());
	}
	//返回类型-1 小于 0 等于 1 大于 （前后关系)
	 public static int compareTwoDigit(BigDecimal v1,BigDecimal v2){
		 return v1.compareTo(v2);
	 }
	 //把元变成分，满足中金支付的要求
	public static long changeMoneyToFen(BigDecimal money){
		long a = new BigDecimal(MoneyUtil.mul(money.doubleValue(), 100)).longValue();
		return a;
	}
	public static String changeFenToYuan(Long money){
		double a = new BigDecimal(MoneyUtil.div(Double.valueOf(String.valueOf(money)), 100)).doubleValue();
		return formatToMoneyDisplay(a);
	}
	//改变利率格式()
	public static int changeRate(BigDecimal rate){
		int a = new BigDecimal(MoneyUtil.mul(rate.doubleValue(), 100)).intValue();
		return a;
	}
	public static void main(String[] args) {
		System.out.println(changeFenToYuan(10000234L));
		System.out.println(formatMoneyToThree(new BigDecimal(32023000)));
		System.out.println(changeMoneyToFen(new BigDecimal(0.00d)));
	}
}
