package cn.geekhalo.webtech.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * MD5加密工具类
 * 
 * @author 
 * 
 */
public class MD5Util {
	static Logger log = Logger.getLogger(MD5Util.class);
	public static void main(String[] args) {
		String s = "ffff";
		System.out.println(md5(s).toUpperCase());
		System.out.println(md5Low(s));
	}
	/**
	 * md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密大写
			return buf.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			log.error("",e);
			return null;
		}
	}
	//md5加密32位小写
	public static String md5Low(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密小写
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			log.error("",e);
			return null;
		}
	}
	public static String md5Sixteen(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密小写
			return buf.toString().substring(8, 24).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			log.error("",e);
			return null;
		}
	}
}
